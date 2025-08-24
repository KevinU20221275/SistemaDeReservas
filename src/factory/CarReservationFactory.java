package factory;

import reservations.CarReservation;
import reservations.Reservation;

/**
 * Fábrica concreta para crear reservas de Vehículo.
 *
 * Implementa el patrón Factory Method, permitiendo la creación
 * de objetos {@link CarReservation} sin que el cliente conozca
 * la clase concreta.
 *
 * @see ReservationFactory
 */
public class CarReservationFactory implements ReservationFactory {
    /**
     * Crea una reserva de tipo Vehículo y configura su tipo.
     *
     * @return Instancia de {@link CarReservation} configurada.
     */
    @Override
    public Reservation createReservation() {
        return new CarReservation();
    }
}
