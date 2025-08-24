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
                // muestra el menu principal y obtener opcion seleccionada
                Menu.mainMenu();
                mainOption = Menu.getValidatedOption(scanner, 1, 3);

                if (mainOption == 1){
                    // menu de reservas disponibles (Hotel, Vuelo, Auto)
                    Menu.reservationMenu();
                    int reservationOption = Menu.getValidatedOption(scanner, 1, 3);

                    // Factory - crea una intancia del tipo de reserva seleccionado
                    ReservationFactory factory = GetFactoryReservation.getFactoryReservation(reservationOption);
                    Reservation service = factory.createReservation();

                    // Adapter - Pide los datos adicionales
                    ReservationInputAdapter adapter = null;
                    switch (reservationOption){
                        case 1 -> adapter = new HotelReservationAdapter(); // clases intermedias que piden información según el tipo de reserva
                        case 2 -> adapter = new FlightReservationAdapter();
                        case 3 -> adapter = new CarReservationAdapter();
                    }

                    if (adapter != null){
                        adapter.configureReservation(scanner, service);
                    }

                    // Observer - crea un cliente y suscribe a notificaciones de cambios en la reserva
                    ReservationObservable observable = new ReservationObservable();
                    // solicita los datos del cliente (Nombre, Dui)
                    String clientName = ReservationFields.getName(scanner);
                    String dui  = ReservationFields.getDui(scanner);
                    Client cliente = new Client(clientName, dui); // crea el cliente
                    observable.addObserver(cliente); // agrega el cliente al observer
                    // solicita la fecha
                    String reservationDate = ReservationFields.getDate(scanner);

                    // Decoratos - agrega servicios adicionales (Seguro, Spa)
                    // clase intermedia para agregar extras al servicio
                    AddExtraServices addExtraService = new AddExtraServices(service);
                    // pregunta si desea agregar seguro
                    service = addExtraService.addInsurance(scanner);
                    if (reservationOption == 1){
                        // pregunta si desea agregar acceso al spa (opcion 1 es por reserva de hotel)
                        service = addExtraService.addSpaAccess(scanner);
                    }

                    if (reservationOption != 3){
                        // pregunta si quiere agregar desayuno
                        service = addExtraService.addBreakfast(scanner); // aplica para Hotel y vuelo
                    }

                    // Strategy - Seleccionar el metodo de pago(Taregeta o Paypa)
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

                    // Facade + Command - Ejecuta el flujo completo de reserva atraves de comandos
                    /**
                     * Facade construira finalmente la reserva, pero se pasa como dependecia al constructor
                     * de command para implementar los 2 patrones, por dentro command ejecutara el metodo makeReservation()
                     * del facade para procesar el pago y la constrccion de la reserva.
                    * */
                    ReservationFacade facade = new ReservationFacade(finalReservation, paidMethod);

                    // Command
                    ReservationCommand command = new ReservationCommand(facade);
                    Invoker invoker = new Invoker();
                    invoker.setCommand(command);
                    // por dentro ejecuta makeReservation() del facade
                    invoker.executeReservation(); // crea finalmente la reservacion

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

