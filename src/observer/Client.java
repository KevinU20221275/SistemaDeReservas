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
public class Client implements Observer {
    private String name;
    private String dui;

    /**
     * Constructor que inicializa el cliente con su nombre y DUI.
     *
     * @param name Nombre del cliente.
     * @param dui Número de DUI del cliente.
     */
    public Client(String name, String dui){
        this.name = name;
        this.dui = dui;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
     * @param state Nuevo estado de la reserva.
     */
    @Override
    public void update(String state) {
        System.out.println("Hola " + name + ", el estado de su reserva ha cambiado a: " + state);
    }
}
