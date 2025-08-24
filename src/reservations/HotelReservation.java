package reservations;

/**
 * Clase concreta que representa una reserva de hotel.
 * Extiende de {@link ReservationAbstract} e incluye datos específicos como
 * nombre del hotel y número de habitación.
 */
public class HotelReservation extends ReservationAbstract {
    private String hotelName;
    private String room;

    public HotelReservation(){
        setType("Hotel");
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * Muestra los detalles completos de la reserva, incluyendo datos generales
     * y datos específicos del hotel.
     */
    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Hotel: " + hotelName);
        System.out.println("Habitacion: " + room);
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
}
