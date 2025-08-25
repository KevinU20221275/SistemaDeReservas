package reservations;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta que representa la estructura base de una reserva.
 *
 * Contiene atributos y métodos comunes a todas las reservas, como cliente, DUI,
 * fecha, precio, tipo de reserva y servicios extras.
 * Implementa la interfaz {@link Reservation}.
 */
public abstract class ReservationAbstract implements Reservation {
    private String clientName;
    private String state;
    private String clientDui;
    private String date;
    private double price;
    private String type;
    private List<String> extraSevices;

    public ReservationAbstract(){
        this.extraSevices = new ArrayList<>();
    }

    public String getClientName() {
        return clientName;
    }

    @Override
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getState() {
        return state;
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }

    public String getClientDui() {
        return clientDui;
    }

    @Override
    public void setClientDui(String clientDui) {
        this.clientDui = clientDui;
    }

    public String getDate() {
        return date;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getExtraSevices() {
        return extraSevices;
    }

    public void addExtraSevice(String extraSevices) {
        this.extraSevices.add(extraSevices);
    }

    /**
     * Muestra los detalles generales de la reserva, incluyendo datos del cliente,
     * precio, fecha y servicios extras.
     */
    @Override
    public void showDetails() {
        System.out.println("===== DATOS DE LA RESERVA =====");
        System.out.println("Reserva de " + type);
        System.out.println("Estado: " + state);
        System.out.println("Cliente: " + clientName);
        System.out.println("Numero de dui: " + clientDui);
        System.out.println("Fecha: " + date);
        System.out.println("Precio: $" + price);
        if (!this.extraSevices.isEmpty()){
            System.out.println("Extras: ");
            this.extraSevices.forEach(s -> System.out.println("- " + s));
        }
    }

    /**
     * Aplica un cargo adicional al precio total de la reserva.
     *
     * @param charge Monto adicional a cobrar.
     * @param description Descripcion del servicio extra por el cual se está realizando el cargo extra
     */
    @Override
    public void extraServiceCharge(float charge, String description) {
        this.price += charge;
        System.out.println("Se ha agregado el servicio extra: " + description);
        System.out.println("Cargo adicional aplicado: $" + charge);
        System.out.println("Nuevo precio total: " + price);
    }

    /**
     * Método que simula la acción de realizar la reserva.
     */
    @Override
    public void reserve() {
        this.state = "Confirmada";
        System.out.println("Reserva " + type + " realizada correctamente.");
    }
}
