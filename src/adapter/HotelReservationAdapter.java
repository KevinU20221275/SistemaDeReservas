package adapter;

import reservations.Reservation;
import ui.Menu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Adaptador para configurar reservas de Hotel.
 */
public class HotelReservationAdapter implements ReservationInputAdapter{
    private String[] hotelList = {"El Marito, 4 Estrellas, $150", "El canopi, 4 Estrellas, $300", "El luxor, 5 Estrellas, $450"};

    @Override
    public void configureReservation(Scanner scanner, Reservation reservation) {
        System.out.println("===== Hoteles Disponibles ===");
        for (int i = 0; i < hotelList.length; i++) {
            System.out.println(i+1 + ". " + hotelList[i]);
        }

        System.out.print("Seleccione su hotel: ");
        int hotelOption = Menu.getValidatedOption(scanner, 1, hotelList.length); // válida la entrada del usuario

        reservation.setPrice(hotelOption * 150);

        if (reservation instanceof reservations.HotelReservation hotelReservation) {
            int randomRoom = (int) (Math.random() * 200) + 1;
            hotelReservation.setHotelName(this.hotelList[hotelOption - 1]);
            hotelReservation.setRoom("HC" + randomRoom);
        }
    }
}
