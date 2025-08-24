package strategy;


/**
 * Clase concreta que implementa la estrategia de pago mediante PayPal.
 *
 * Implementa la interfaz {@link PagoStrategy} para definir el comportamiento de pago.
 */
public class PagoPaypal implements PagoStrategy {
    private String payPalAccount ;

    /**
     * Constructor que recibe la cuenta de PayPal.
     *
     * @param payPalAccount Dirección de correo asociada a la cuenta PayPal.
     */
    public PagoPaypal(String payPalAccount) {
        this.payPalAccount = payPalAccount;
    }

    /**
     * Método que realiza el pago utilizando PayPal.
     *
     * @param amount Monto total a pagar.
     */
    @Override
    public void paid(Double amount) {
        System.out.println("Pagando por payal: $" + amount);
        System.out.println("Correo: " + payPalAccount);
    }
}
