package observer;


/**
 * Clase que representa a un cliente suscrito a las notificaciones de reserva.
 *
 * Implementa la interfaz {@link Observer} y define la acción a realizar cuando
 * se le notifica de un cambio de estado en la reserva.
 *
 * @see Observer
 * @see ReservationObservable
 */
public class Cliente implements Observer {
    private String nombre;
    private String dui;

    /**
     * Constructor que inicializa el cliente con su nombre y DUI.
     *
     * @param nombre Nombre del cliente.
     * @param dui Número de DUI del cliente.
     */
    public Cliente(String nombre, String dui){
        this.nombre = nombre;
        this.dui = dui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    /**
     * Método que se ejecuta cuando el Observable notifica un cambio de estado.
     * Muestra un mensaje personalizado al cliente.
     *
     * @param estado Nuevo estado de la reserva.
     */
    @Override
    public void update(String estado) {
        System.out.println("Hola " + nombre + ", el estado de su reserva ha cambiado a: " + estado);
    }
}
