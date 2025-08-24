package factory;

import reservations.Reservation;

/**
 * Interfaz que define el método fábrica para crear objetos de tipo {@link Reservation}.
 *
 * Implementa el patrón de diseño Factory Method, permitiendo delegar la instanciación
 * de diferentes tipos de reservas (Hotel, Vuelo, Auto) a subclases específicas.
 *
 * De esta forma, el código cliente puede crear reservas de manera flexible
 * sin acoplarse a clases concretas.
 *
 * @see factory.HotelReservationFactory
 * @see factory.FlightReservationFactory
 * @see factory.CarReservationFactory
 */
public interface ReservationFactory {
    Reservation createReservation();
}
