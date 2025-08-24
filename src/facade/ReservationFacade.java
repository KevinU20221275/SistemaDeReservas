package facade;

import reservations.Reservation;
import strategy.PagoStrategy;

/**
 * Clase que implementa el patrón de diseño Facade.
 *
 * Simplifica y centraliza el proceso completo de realizar una reserva,
 * ocultando la complejidad de múltiples subsistemas como:
 * - Confirmación de la reserva.
 * - Procesamiento del pago.
 * - Visualización de los detalles de la reserva.
 *
 * Al utilizar esta fachada, el cliente puede realizar todo el flujo de reserva
 * mediante una única llamada al método makeReservation(),
 * sin preocuparse de la lógica interna.
 *
 * Relacionado con los patrones:
 * - Strategy: método de pago.
 * - Decorator: servicios adicionales en la reserva.
 *
 */
public class ReservationFacade {
    private Reservation reservation;
    private PagoStrategy paymentMethod;

    /**
     * Constructor que inicializa la reserva y la estrategia de pago.
     *
     * @param reservation Objeto de tipo Reservation que representa la reserva a procesar.
     * @param paymentMethod Estrategia de pago implementada mediante el patrón Strategy.
     */
    public ReservationFacade(Reservation reservation, PagoStrategy paymentMethod){
        this.reservation = reservation;
        this.paymentMethod = paymentMethod;
    }

    /**
     * Ejecuta todo el flujo de reserva:
     * 1. Realiza la reserva (confirma y aplica extras si existen).
     * 2. Procesa el pago utilizando la estrategia seleccionada.
     * 3. Muestra los detalles completos de la reserva.
     */
    public void makeReservation(){
        reservation.reserve();
        paymentMethod.paid(reservation.getPrice());
        System.out.println("Procesando reserva....");
        reservation.showDetails();
    }
}
