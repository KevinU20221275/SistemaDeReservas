package utils;

import factory.CarReservationFactory;
import factory.FlightReservationFactory;
import factory.HotelReservationFactory;
import factory.ReservationFactory;

/**
 * Clase utilitaria para obtener la factory de la reserva.
 */
public class GetFactoryReservation {
    /**
     * Obtiene la ReservationFactory de la reserva correspondiente según la opción seleccionada.
     *
     * @param option la opción de reserva seleccionada (1: Hotel, 2: Vuelo, 3: Auto)
     * @return la factory de reserva seleccionada (ReservationFactory)
     */
    public static ReservationFactory getFactoryReservation(int option){
        ReservationFactory factory = null;

        switch (option) {
            case 1 -> factory = new HotelReservationFactory();
            case 2 -> factory = new FlightReservationFactory();
            case 3 -> factory = new CarReservationFactory();
            default -> System.out.println("Opción inválida.");
        }

        return factory;
    }
}
