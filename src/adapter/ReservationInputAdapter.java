package adapter;

import reservations.Reservation;

import java.util.Scanner;

/**
 * Adapter para unificar la entrada de datos en la configuración de reservas.
 */
public interface ReservationInputAdapter {
    void configureReservation(Scanner scanner, Reservation reservation);
}
