package factory;

import reservations.FlightReservation;
import reservations.Reservation;

/**
 * Fábrica concreta para crear reservas de Vuelo.
 *
 * Encapsula la creación de objetos {@link FlightReservation}
 * aplicando el patrón Factory Method.
 *
 * @see ReservationFactory
 */
public class FlightReservationFactory implements ReservationFactory {
    /**
     * Crea una reserva de tipo Vuelo y configura su tipo.
     *
     * @return Instancia de {@link FlightReservation} configurada.
     */
    @Override
    public Reservation createReservation() {
        return new FlightReservation();
    }
}
