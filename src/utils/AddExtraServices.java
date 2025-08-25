package utils;

import decorator.BreakfastDecorator;
import decorator.InsuranceDecorator;
import decorator.SpaDecorator;
import reservations.Reservation;

import java.util.Scanner;

/**
 * Clase utilitaria que gestiona la adición de servicios extra a una reserva utilizando el patrón Decorator.
 * Permite agregar servicios como seguro o acceso al spa de manera dinámica según la elección del cliente.
 */
public class AddExtraServices {
    private Reservation service;

    /**
     * Constructor que recibe la reserva base sobre la cual se agregarán los servicios extra.
     *
     * @param service Reserva base (Hotel, Vuelo, Auto) a la que se le podrán añadir decoradores.
     */
    public AddExtraServices(Reservation service){
        this.service = service;
    }

    /**
     * Pregunta al usuario si desea agregar un seguro a la reserva.
     * Si la respuesta es afirmativa, envuelve la reserva con el decorador {@link InsuranceDecorator}.
     *
     * @param scanner Scanner utilizado para la entrada del usuario.
     * @return La reserva con o sin el decorador de seguro, según la elección del cliente.
     */
    public Reservation addInsurance(Scanner scanner){
        System.out.print("¿Desea agregar seguro por $100? (s/n): ");
        String addInsurance = scanner.nextLine().toLowerCase();

        if (addInsurance.equalsIgnoreCase("s")){
            service = new InsuranceDecorator(service);
        }

        return service;
    }

    /**
     * Pregunta al usuario si desea agregar acceso al spa a la reserva.
     * Si la respuesta es afirmativa, envuelve la reserva con el decorador {@link SpaDecorator}.
     *
     * @param scanner Scanner utilizado para la entrada del usuario.
     * @return La reserva con o sin el decorador de acceso al spa, según la elección del cliente.
     */
    public Reservation addSpaAccess(Scanner scanner){
        System.out.print("¿Desea agregar acceso al spa por $100? (s/n): ");
        String addSpa = scanner.nextLine().toLowerCase();

        if (addSpa.equalsIgnoreCase("s")){
            service = new SpaDecorator(service);
        }

        return service;
    }

    /**
     * Pregunta al usuario si desea agregar desayuno a la reserva.
     * Si la respuesta es afirmativa, envuelve la reserva con el decorador {@link BreakfastDecorator}.
     *
     * @param scanner Scanner utilizado para la entrada del usuario.
     * @return La reserva con o sin el decorador de acceso a desayuno, según la elección del cliente.
     */
    public Reservation addBreakfast(Scanner scanner){
        System.out.print("¿Desea agregar desayuno por $50? (s/n): ");
        String addBrekfast = scanner.nextLine().toLowerCase();

        if (addBrekfast.equalsIgnoreCase("s")){
            service = new BreakfastDecorator(service);
        }

        return service;
    }

    /**
     * Aplica todos los servicios extra disponibles a la reserva según el tipo de reserva.
     *
     * Pregunta al usuario por seguro, spa (solo hotel) y desayuno (hotel y vuelo),
     * aplicando los decoradores correspondientes.
     *
     * @param scanner Scanner para la entrada del usuario
     * @param reservationOption Tipo de reserva: 1-Hotel, 2-Vuelo, 3-Auto
     * @return La reserva con los servicios extra aplicados
     */
    public Reservation applyAllExtras(Scanner scanner, int reservationOption) {
        // Seguro siempre
        service = addInsurance(scanner);

        // Spa solo para hotel
        if (reservationOption == 1) {
            service = addSpaAccess(scanner);
        }

        // Desayuno para hotel y vuelo
        if (reservationOption != 3) {
            service = addBreakfast(scanner);
        }

        return service;
    }
}
