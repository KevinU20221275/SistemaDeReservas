package adapter;

import data.ReservationData;
import data.ReservationData.Car;
import reservations.Reservation;
import ui.Menu;

import java.util.Scanner;

/**
 * Adaptador para configurar reservas de vehículos.
 */
public class CarReservationAdapter implements ReservationInputAdapter {
    private Car[] carsList = ReservationData.cars;

    @Override
    public void configureReservation(Scanner scanner, Reservation reservation) {
        System.out.println("===== Vehiculos Disponibles ===");
        for (int i = 0; i < this.carsList.length; i++) {
            System.out.println(i+1 + ". " + this.carsList[i]);
        }

        System.out.print("Seleccione su vehiculo: ");
        int carOption = Menu.getValidatedOption(scanner, 1, carsList.length);
        Car selectedCar = carsList[carOption - 1];

        reservation.setPrice(selectedCar.price);

        if (reservation instanceof reservations.CarReservation carReservation) {
            carReservation.setCarType(selectedCar.type);
        }
    }
}
