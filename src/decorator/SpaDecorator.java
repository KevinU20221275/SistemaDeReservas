package decorator;

import reservations.Reservation;

/**
 * Decorador concreto que añade el servicio adicional de acceso al Spa
 * a una reserva existente.
 *
 * Aplica un cargo extra al precio de la reserva y agrega la descripción del servicio como extra.
 *
 * Forma parte del patrón de diseño Decorator.
 *
 */
public class SpaDecorator extends ReservationDecorator {
    public SpaDecorator(Reservation baseReservation) {
        super(baseReservation);
    }

    @Override
    public void showDetails() {
        super.showDetails();
    }

    /**
     * Añade el cargo adicional del servicio Spa y agrega el extra correspondiente.
     */
    @Override
    public void reserve() {
        baseReservation.reserve();
        baseReservation.extraServiceCharge(100F, "Acceso al Spa");
        baseReservation.addExtraService("Acceso al Spa");;
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public void setState(String state) {
        baseReservation.setState(state);
    }
}
