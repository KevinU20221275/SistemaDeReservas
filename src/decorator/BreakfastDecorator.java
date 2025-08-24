package decorator;

import reservations.Reservation;

/**
 * Decorador concreto que añade el servicio adicional de seguro a una reserva existente.
 *
 * Aplica un cargo extra al precio de la reserva y agrega la descripción del servicio como extra.
 *
 * Forma parte del patrón de diseño Decorator.
 */
public class BreakfastDecorator extends ReservationDecorator {
    public BreakfastDecorator(Reservation baseReservation) {
        super(baseReservation);
    }

    /**
     * Añade el cargo adicional del Desayuno y agrega el extra correspondiente.
     */
    @Override
    public void reserve() {
        super.baseReservation.reserve();
        super.baseReservation.extraServiceCharge(50F, "Desayuno Incluido"); // cargo por desayuno
        super.baseReservation.addExtraService("Desayuno");
    }

    @Override
    public void showDetails() {
        super.showDetails();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public void setState(String estado) {
        baseReservation.setState(estado);
    }
}
