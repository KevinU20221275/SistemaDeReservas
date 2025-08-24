package decorator;

import reservations.Reservation;

/**
 * Decorador concreto que añade el servicio adicional de seguro a una reserva existente.
 *
 * Aplica un cargo extra al precio de la reserva y agrega la descripción del servicio como extra.
 *
 * Forma parte del patrón de diseño Decorator.
 */
public class InsuranceDecorator extends ReservationDecorator {
    public InsuranceDecorator(Reservation baseReservation){
        super(baseReservation);
    }

    /**
     * Añade el cargo adicional del seguro y agrega el extra correspondiente.
     */
    @Override
    public void reserve(){
        baseReservation.reserve();
        baseReservation.extraServiceCharge(100F, "Seguro");
        baseReservation.addExtraService("Seguro");
    }

    @Override
    public void showDetails(){
        super.showDetails();;
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
