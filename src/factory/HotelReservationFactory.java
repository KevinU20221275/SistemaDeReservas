package factory;

import reservations.HotelReservation;
import reservations.Reservation;

/**
 * Fábrica concreta para crear reservas de Hotel.
 *
 * Implementa el patrón Factory Method, encapsulando la lógica
 * de creación de objetos de tipo {@link HotelReservation}.
 *
 * @see ReservationFactory
 */
public class HotelReservationFactory implements ReservationFactory {
    @Override
    public Reservation createReservation() {
        return new HotelReservation();
    }
}
