package builder;

import reservations.Reservation;
/**
 * Clase concreta que implementa la interfaz ReservationBuilder.
 * Se encarga de construir y configurar una instancia de Reservation
 * asignando los datos del cliente, fecha y número de DUI de manera escalonada.
 *
 * Forma parte del patrón de diseño Builder, facilitando la creación de objetos complejos
 * mediante un proceso controlado paso a paso.
 */
public class ConcreteReservationBuilder implements ReservationBuilder {
    private Reservation reservation;

    /**
     * Constructor que recibe la instancia de Reservation a configurar.
     *
     * @param reservation Objeto de tipo Reservation que se desea construir/configurar.
     */
    public ConcreteReservationBuilder(Reservation reservation) {
        this.reservation = reservation;
    }

    /**
     * Asigna el nombre del cliente a la reserva.
     *
     * @param clientName Nombre del cliente.
     * @return Retorna la instancia actual de ConcreteReservationBuilder para permitir el encadenamiento de métodos.
     */
    @Override
    public ReservationBuilder setCliente(String clientName) {
        System.out.println("agregando el nombre del cliente....");
        reservation.setClientName(clientName);
        return this;
    }

    /**
     * Asigna la fecha de la reserva.
     *
     * @param date Fecha de la reserva en formato YYYY-MM-DD.
     * @return Retorna la instancia actual de ConcreteReservationBuilder para permitir el encadenamiento de métodos.
     */
    @Override
    public ReservationBuilder setDate(String date) {
        System.out.println("agregando la fecha de la reserva....");
        reservation.setDate(date);
        return this;
    }

    /**
     * Asigna el número de DUI del cliente a la reserva.
     *
     * @param dui Número de DUI del cliente.
     * @return Retorna la instancia actual de ConcreteReservationBuilder para permitir el encadenamiento de métodos.
     */
    @Override
    public ReservationBuilder setDui(String dui) {
        System.out.println("agregando el dui del cliente...");
        reservation.setClientDui(dui);
        return this;
    }

    /**
     * Finaliza el proceso de construcción y retorna la instancia de Reservation completamente configurada.
     *
     * @return Objeto Reservation construido.
     */
    @Override
    public Reservation build() {
        System.out.println("realizando la reserva...");
        return reservation;
    }
}
