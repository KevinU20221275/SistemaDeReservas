package builder;

import reservations.Reservation;

public interface ReservationBuilder {
    ReservationBuilder setCliente(String clientName);
    ReservationBuilder setDate(String date);
    ReservationBuilder setDui(String dui);
    Reservation build();
}

