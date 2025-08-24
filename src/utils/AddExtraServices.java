package utils;

import decorator.InsuranceDecorator;
import decorator.SpaDecorator;
import reservations.Reservation;

import java.util.Scanner;

/**
 * Clase utilitaria que gestiona la adición de servicios extra a una reserva utilizando el patrón Decorator.
 * Permite agregar servicios como seguro o acceso al spa de manera dinámica según la elección del cliente.
 */
public class AddServices {
    private Reservation servicio;

    /**
     * Constructor que recibe la reserva base sobre la cual se agregarán los servicios extra.
     *
     * @param servicio Reserva base (Hotel, Vuelo, Auto) a la que se le podrán añadir decoradores.
     */
    public AddServices(Reservation servicio){
        this.servicio = servicio;
    }

    /**
     * Pregunta al usuario si desea agregar un seguro a la reserva.
     * Si la respuesta es afirmativa, envuelve la reserva con el decorador {@link InsuranceDecorator}.
     *
     * @param scanner Scanner utilizado para la entrada del usuario.
     * @return La reserva con o sin el decorador de seguro, según la elección del cliente.
     */
    public Reservation addInsurance(Scanner scanner){
        System.out.print("¿Desea agregar seguro? (s/n):");
        String agregarSeguro = scanner.nextLine().toLowerCase();

        if (agregarSeguro.equalsIgnoreCase("s")){
            servicio = new InsuranceDecorator(servicio);
        }

        return servicio;
    }

    /**
     * Pregunta al usuario si desea agregar acceso al spa a la reserva.
     * Si la respuesta es afirmativa, envuelve la reserva con el decorador {@link SpaDecorator}.
     *
     * @param scanner Scanner utilizado para la entrada del usuario.
     * @return La reserva con o sin el decorador de acceso al spa, según la elección del cliente.
     */
    public Reservation addSpaAccess(Scanner scanner){
        System.out.print("¿Desea agregar acceso al spa? (s/n):");
        String agregarSpa = scanner.nextLine().toLowerCase();

        if (agregarSpa.equalsIgnoreCase("s")){
            servicio = new SpaDecorator(servicio);
        }

        return servicio;
    }
}
