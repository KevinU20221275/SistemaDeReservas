package adapter;

import reservations.Reservation;
import ui.Menu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Adaptador para configurar reservas de vehículos.
 */
public class CarReservationAdapter implements ReservationInputAdapter {
    private String[] carsList = {"Familiar 4 puertas, $75", "2 Puertas, $150", "Camioneta todo Terreno, $225"};

    @Override
    public void configureReservation(Scanner scanner, Reservation reservation) {
        System.out.println("===== Vehiculos Disponibles ===");
        for (int i = 0; i < this.carsList.length; i++) {
            System.out.println(i+1 + ". " + this.carsList[i]);
        }

        System.out.print("Seleccione su vehiculo: ");
        int carOption = Menu.getValidatedOption(scanner, 1, carsList.length);

        reservation.setPrice(carOption * 75);

        if (reservation instanceof reservations.CarReservation carReservation) {
            carReservation.setCarType(this.carsList[carOption - 1]);
        }
    }
}
