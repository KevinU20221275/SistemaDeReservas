package decorator;

import reservations.Reservation;

/**
 * Clase abstracta base para los decoradores de reservas.
 * Implementa la interfaz Reservation y actúa como wrapper que delega las llamadas
 * al objeto reservaBase.
 *
 * Forma parte del patrón de diseño Decorator, permitiendo extender funcionalidades
 * adicionales (extras) a las reservas de forma dinámica sin modificar las clases existentes.
 *
 * Las clases concretas deben extender esta clase para implementar nuevos servicios adicionales.
 */
public abstract class ReservationDecorator implements Reservation {
    /**
     * Referencia al objeto Reservation que se desea decorar.
     */
    protected Reservation baseReservation;

    /**
     * Constructor que recibe la reserva base sobre la que se aplicarán las decoraciones.
     *
     * @param baseReservation Objeto de tipo Reservation a decorar.
     */
    public ReservationDecorator(Reservation baseReservation){
        this.baseReservation = baseReservation;
    }

    @Override
    public void showDetails() {
        baseReservation.showDetails();
    }

    @Override
    public void reserve() {
        baseReservation.reserve();
    }

    /**
     * Delegación del método extraServiceCharge() al objeto base.
     *
     * @param charge Monto adicional a agregar.
     */
    @Override
    public void extraServiceCharge(float charge, String description) {
        baseReservation.extraServiceCharge(charge, description);
    }

    // Métodos delegados para malpular datos

    @Override
    public void setClientName(String clientName) {
        baseReservation.setClientName(clientName);
    }

    @Override
    public void setClientDui(String clientDui) {
        baseReservation.setClientDui(clientDui);
    }

    @Override
    public void setDate(String date) {
        baseReservation.setDate(date);
    }

    @Override
    public void setPrice(double price) {
        baseReservation.setPrice(price);
    }

    @Override
    public void addExtraService(String extra) {
        baseReservation.addExtraService(extra);
    }

    @Override
    public double getPrice() {
        return baseReservation.getPrice();
    }
}

