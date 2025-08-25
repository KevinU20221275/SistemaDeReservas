package adapter;

import data.ReservationData;
import data.ReservationData.Flight;
import reservations.Reservation;
import ui.Menu;

import java.util.Scanner;

/**
 * Adaptador para configurar reservas de Vuelo.
 */
public class FlightReservationAdapter implements ReservationInputAdapter {
    private Flight[] flightList = ReservationData.flights;

    @Override
    public void configureReservation(Scanner scanner, Reservation reservation) {
        System.out.println("===== Vuelos Disponibles ===");
        for (int i = 0; i < this.flightList.length; i++) {
            System.out.println(i+1 + ". " + this.flightList[i]);
        }

        System.out.print("Seleccione su vuelo: ");
        int flightOption = Menu.getValidatedOption(scanner, 1, flightList.length);
        Flight selectedFlight = flightList[flightOption - 1];

        reservation.setPrice(selectedFlight.price);

        if (reservation instanceof reservations.FlightReservation flightReservation) {
            int flightNumber = (int) (Math.random() * 1000) + 1;

            System.out.print("Asiento al lado de la ventana s/n: ");
            String windowSeat = scanner.nextLine();

            int randomSeat = (int) (Math.random() * 60) + 1;
            flightReservation.setFlightNumber("V" + flightNumber);
            flightReservation.setFlightDestination(selectedFlight.destination);
            flightReservation.setSeat(windowSeat.equalsIgnoreCase("s") ? "A" + randomSeat : "C" + randomSeat);
        }
    }
}
