package utils;

import strategy.PagoPaypal;
import strategy.PagoStrategy;
import strategy.PagoTarjeta;

import java.util.Scanner;

/**
 * Clase utilitaria para obtener la PagoStrategy segun la opcion.
 */
public class GetPagoStrategy {
    /**
     * Obtiene la estrategia de pago correspondiente según la opción seleccionada.
     *
     * @param paidOption la opción de método de pago seleccionada (1: Tarjeta, 2: Paypal)
     * @param scanner el objeto Scanner para capturar datos adicionales si son necesarios
     * @return la estrategia de pago seleccionada (PagoStrategy)
     */
    public static PagoStrategy getPagoStrategy(int paidOption, Scanner scanner){
        PagoStrategy paymentMethod = null;

        switch (paidOption){
            case 1:
                String cardNumber = ReservationFields.getValidCardNumber(scanner);
                paymentMethod = new PagoTarjeta(cardNumber);
                break;
            case 2:
                String payPalAccount = ReservationFields.getPaypalAccount(scanner);
                paymentMethod = new PagoPaypal(payPalAccount);
                break;
            default:
                System.out.println("Metodo de pago no soportado");
                break;
        }

        return paymentMethod;
    }
}
