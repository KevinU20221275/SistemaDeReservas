package reservations;

/**
 * Clase concreta que representa una reserva de vehículo.
 * Extiende de {@link ReservationAbstract} e incluye datos específicos como
 * tipo de vehículo.
 */
public class CarReservation extends ReservationAbstract {
    private String carType;

    public CarReservation(){
        setType("Vehiculo");
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    /**
     * Muestra los detalles completos de la reserva, incluyendo datos generales
     * y datos específicos del vehículo.
     */
    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Vehiculo: " + carType);
    }

    @Override
    public void addExtraService(String extraService) {
        super.addExtraSevice(extraService);
    }

    @Override
    public void reserve() {
        super.reserve();
    }
}
