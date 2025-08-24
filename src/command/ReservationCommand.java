package command;

import facade.ReservationFacade;

/**
 * Clase concreta que implementa la interfaz Command.
 * Encapsula la acción de realizar una reserva, delegando la operación
 * a la clase ReservationFacade para simplificar la ejecución del proceso.
 *
 * Forma parte del patrón de diseño Command.
 *
 */
public class ReservationCommand implements Command {
    private ReservationFacade reservation;

    /**
     * Constructor de la clase.
     *
     * @param reservation Instancia de ReservationFacade que ejecutará la reserva.
     */
    public ReservationCommand(ReservationFacade reservation) {
        this.reservation = reservation;
    }

    /**
     * Ejecuta el comando, llamando al método makeReservation() del Facade.
     */
    @Override
    public void execute() {
        System.out.println("Ejecutando comando para reserva....");
        this.reservation.makeReservation();
    }
}
