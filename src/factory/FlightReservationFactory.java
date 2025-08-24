package factory;

import reservations.Reservation;

public class FlightReservation implements ReservationFactory {
    @Override
    public Reservation createReservation() {
        return Re;
    }
}
