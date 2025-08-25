import adapter.CarReservationAdapter;
import adapter.FlightReservationAdapter;
import adapter.HotelReservationAdapter;
import adapter.ReservationInputAdapter;
import builder.*;
import command.*;
import facade.ReservationFacade;
import factory.ReservationFactory;
import observer.*;
import reservations.Reservation;
import singleton.ReservationSystem;
import strategy.*;
import ui.Menu;
import utils.*;

import java.util.Scanner;

/**
 * Clase Main
 * Sistema de Reservas en Línea.
 *
 * Este es el punto de entrada de la aplicación, donde se controla el flujo principal
 * del sistema de reservas. Aquí se implementan e integran los diferentes patrones
 * de diseño (Singleton, Factory Method, Builder, Decorator, Strategy, Facade, Command, Observer)
 * a través de la interacción con el usuario mediante consola.
 *
 * Flujo principal:
 * 1. Mostrar menú principal (Realizar reserva / Ver reservas / Salir)
 * 2. Según la opción seleccionada:
 *    - Crear una nueva reserva aplicando los patrones de diseño.
 *    - Visualizar historial de reservas.
 *    - Salir del sistema.
 *
 * Pruebas:
 * La aplicación permite realizar pruebas manuales de cada flujo, verificando que
 * los patrones de diseño se comporten como se espera.
 */
public class Main {
    public static void main(String[] args) {
        ReservationSystem system = ReservationSystem.getInstance();
        Scanner scanner = new Scanner(System.in);

        int mainOption = 0;

        while (mainOption != 3) {
            try {
                // muestra el menu principal y obtener opción seleccionada
                Menu.mainMenu();
                mainOption = Menu.getValidatedOption(scanner, 1, 3);

                if (mainOption == 1){
                    // menu de reservas disponibles (Hotel, Vuelo, Auto)
                    Menu.reservationMenu();
                    int reservationOption = Menu.getValidatedOption(scanner, 1, 3);

                    // Factory - crea una instancia del tipo de reserva seleccionado
                    ReservationFactory factory = GetFactoryReservation.getFactoryReservation(reservationOption);
                    Reservation service = factory.createReservation();

                    /**
                     *  Uso de Adapter + Factory para configurar la reserva.
                     *
                     * Dependiendo de la opción seleccionada por el usuario, se obtiene un adaptador específico
                     * mediante {@link ReservationAdapterFactory#createAdapter(int)} y se configura la reserva
                     * llamando a {@link ReservationInputAdapter#configureReservation(java.util.Scanner, Reservation)}.
                     */
                    try {
                        // Obtener el adaptador correcto según la opción
                        ReservationInputAdapter adapter = ReservationAdapterFactory.createdAdapter(reservationOption);

                        // Configurar la reserva usando el adaptador
                        adapter.configureReservation(scanner, service);
                    } catch (IllegalArgumentException e){
                        // Mensaje claro si la opción no es válida
                        System.out.println(e.getMessage());
                    }

                    // Observer - crea un cliente y subscribe a notificaciones de cambios en la reserva
                    ReservationObservable observable = new ReservationObservable();

                    // solicita los datos del cliente (Nombre, Dui)
                    String clientName = ReservationFields.getName(scanner);
                    String dui  = ReservationFields.getDui(scanner);
                    Client cliente = new Client(clientName, dui); // crea el cliente

                    observable.addObserver(cliente); // agrega el cliente al observer

                    // solicita la fecha
                    String reservationDate = ReservationFields.getDate(scanner);

                    /**
                     * Decorators - Aplica los servicios adicionales a la reserva seleccionada por el usuario.
                     *
                     * Se utiliza la clase {@link AddExtraServices} para encapsular toda la lógica de
                     * preguntar al usuario por servicios extra y aplicar los decoradores correspondientes.
                     * Esto incluye seguro, acceso al spa (solo para hoteles) y desayuno (para hotel y vuelo).
                     *
                     */
                    AddExtraServices extraServices = new AddExtraServices(service);
                    service = extraServices.applyAllExtras(scanner, reservationOption);

                    // Strategy - Seleccionar el método de pago(Tarjeta o Paypal)
                    Menu.paidMethodMenu();
                    int pagoOpcion = Menu.getValidatedOption(scanner, 1, 2);
                    PagoStrategy paidMethod = GetPagoStrategy.getPagoStrategy(pagoOpcion, scanner);

                    System.out.println();

                    // builder - Construye el objeto Reserva de forma progresiva paso a paso
                    ConcreteReservationBuilder builder = new ConcreteReservationBuilder(service);
                    builder.setCliente(cliente.getName()).setDui(cliente.getDui()).setDate(reservationDate);
                    Reservation finalReservation = builder.build(); // retorna la reserva

                    // Singleton - Almacena la reserva en la lista centralizada
                    system.addReservartion(finalReservation);

                    // Facade + Command - Ejecuta el flujo completo de reserva a través de comandos
                    /*
                     * Facade construirá finalmente la reserva, pero se pasa como dependencia al constructor
                     * de command para implementar los 2 patrones, por dentro command ejecutara el método makeReservation()
                     * del facade para procesar el pago y la construcción de la reserva.
                    */
                    ReservationFacade facade = new ReservationFacade(finalReservation, paidMethod);

                    // Command
                    ReservationCommand command = new ReservationCommand(facade);
                    Invoker invoker = new Invoker();
                    invoker.setCommand(command);
                    // por dentro ejecuta makeReservation() del facade
                    invoker.executeReservation(); // crea finalmente la reservación

                    // Observer - Notifica al cliente el estado de su reserva.
                    System.out.println();
                    System.out.println("=================   NOTIFICACION   ==================");
                    observable.changeState("Confirmada");
                    System.out.println();
                } else if (mainOption == 2) {
                    // lista las reservas
                    system.showReservations();
                } else {
                    System.out.println("Saliendo del sistema....");
                }
            } catch (Exception e){
                System.out.println("error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }
}

