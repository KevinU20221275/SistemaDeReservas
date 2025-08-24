package reservations;


/**
 * Clase concreta que representa una reserva de vuelo.
 * Extiende de {@link ReservationAbstract} e incluye datos específicos como
 * número de vuelo y asiento.
 */
public class FlightReservation extends ReservationAbstract {
    private String flightNumber;
    private String flightDestination;
    private String seat;

    public FlightReservation() {
        setType("Vuelo");
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightDestination() {
        return flightDestination;
    }

    public void setFlightDestination(String flightDestination) {
        this.flightDestination = flightDestination;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    @Override
    public void reserve() {
        super.reserve();
    }

    @Override
    public void addExtraService(String extraService) {
        super.addExtraSevice(extraService);
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    /**
     * Muestra los detalles completos de la reserva, incluyendo datos generales
     * y datos específicos del vuelo.
     */
    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Numero de vuelo: " + flightNumber);
        System.out.println("Destino: " + flightDestination);
        System.out.println("Asiento: " + seat);
    }
}
