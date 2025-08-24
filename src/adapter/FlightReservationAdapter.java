package adapter;

import reservations.Reservation;
import ui.Menu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Adaptador para configurar reservas de Vuelo.
 */
public class FlightReservationAdapter implements ReservationInputAdapter {
    private String[] flightList = {"Madrid, $100", "Londres, $200", "Miami, $300"};

    @Override
    public void configureReservation(Scanner scanner, Reservation reservation) {
        System.out.println("===== Vuelos Disponibles ===");
        for (int i = 0; i < this.flightList.length; i++) {
            System.out.println(i+1 + ". " + this.flightList[i]);
        }

        System.out.print("Seleccione su vuelo: ");
        int flightOption = Menu.getValidatedOption(scanner, 1, flightList.length);

        reservation.setPrice(flightOption * 100);

        if (reservation instanceof reservations.FlightReservation flightReservation) {
            int flightNumber = (int) (Math.random() * 1000) + 1;

            System.out.print("Asiento al lado de la ventana s/n: ");
            String windowSeat = scanner.nextLine();

            int randomSeat = (int) (Math.random() * 60) + 1;
            flightReservation.setFlightNumber("V" + flightNumber);
            flightReservation.setFlightDestination(this.flightList[flightOption - 1]);
            flightReservation.setSeat(windowSeat.equalsIgnoreCase("s") ? "A" + randomSeat : "C" + randomSeat);
        }
    }
}
