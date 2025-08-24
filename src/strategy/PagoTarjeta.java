package strategy;

/**
 * Estrategia concreta para realizar el pago mediante tarjeta de crédito.
 * Implementa la interfaz {@link PagoStrategy}.
 */
public class PagoTarjeta implements PagoStrategy {
    private String cardNumber;

    /**
     * Constructor que recibe el número de tarjeta.
     *
     * @param cardNumber Número de tarjeta de crédito (en formato String).
     */
    public PagoTarjeta(String cardNumber){
        this.cardNumber = cardNumber;
    }

    /**
     * Formatea el número de tarjeta ocultando los últimos 6 dígitos por razones de seguridad.
     *
     * @return Número de tarjeta formateado (ej: 1234567XXXXXX).
     */
    public String formatCardNumber(){
        int lenght = cardNumber.length();

        String formatNumber = cardNumber.substring(0, lenght - 6);
        return formatNumber + "XXXXXX";
    }

    /**
     * Realiza el pago mostrando el monto y el número de tarjeta formateado.
     *
     * @param amount Monto a pagar.
     */
    @Override
    public void paid(Double amount) {
        System.out.println("Pagando con targeta: $" + amount);
        System.out.println("Targeta: " + formatCardNumber());
    }
}
