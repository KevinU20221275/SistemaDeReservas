package utils;

import adapter.CarReservationAdapter;
import adapter.FlightReservationAdapter;
import adapter.HotelReservationAdapter;
import adapter.ReservationInputAdapter;

/**
 * Factory para crear adaptadores de reserva según el tipo de opción seleccionada.
 * Esta clase sigue el principio de responsabilidad única (SRP): se encarga únicamente
 * de instanciar el adaptador correcto sin que el cliente tenga que conocer los tipos concretos.
 * También facilita la extensión futura cumpliendo con el principio abierto/cerrado (OCP).
 */
public class ReservationAdapterFactory {
    /**
     * Crea un adaptador de reserva correspondiente a la opción indicada.
     *
     * @param reservationOption el tipo de reserva seleccionado:
     *                          <ul>
     *                              <li>1 - Hotel</li>
     *                              <li>2 - Vuelo</li>
     *                              <li>3 - Auto</li>
     *                          </ul>
     * @return una instancia de {@link ReservationInputAdapter} correspondiente al tipo de reserva.
     * @throws IllegalArgumentException si la opción de reserva no es válida.
     */
    public static ReservationInputAdapter createdAdapter(int reservationOption){
         return switch (reservationOption){
            case 1 ->  new HotelReservationAdapter(); // clases intermedias que piden información según el tipo de reserva
            case 2 ->  new FlightReservationAdapter();
            case 3 ->  new CarReservationAdapter();
            default -> throw new IllegalArgumentException("Opción de reserva inválida: " + reservationOption);
        };
    }
}
