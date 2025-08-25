package adapter;

import data.ReservationData;
import data.ReservationData.Hotel;
import reservations.Reservation;
import ui.Menu;

import java.util.Scanner;

/**
 * Adaptador para configurar reservas de Hotel.
 */
public class HotelReservationAdapter implements ReservationInputAdapter{
    private Hotel[] hotelList = ReservationData.hotels;

    @Override
    public void configureReservation(Scanner scanner, Reservation reservation) {
        System.out.println("===== Hoteles Disponibles ===");
        for (int i = 0; i < hotelList.length; i++) {
            System.out.println(i+1 + ". " + hotelList[i]);
        }

        System.out.print("Seleccione su hotel: ");
        int hotelOption = Menu.getValidatedOption(scanner, 1, hotelList.length); // válida la entrada del usuario
        Hotel selectedHotel = hotelList[hotelOption - 1];

        reservation.setPrice(selectedHotel.price);

        if (reservation instanceof reservations.HotelReservation hotelReservation) {
            int randomRoom = (int) (Math.random() * 200) + 1;
            hotelReservation.setHotelName(selectedHotel.name);
            hotelReservation.setRoom("HC" + randomRoom);
        }
    }
}
