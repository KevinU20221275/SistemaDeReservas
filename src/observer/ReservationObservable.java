package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa al sujeto (Observable) en el patrón Observer.
 *
 * Gestiona una lista de observadores ({@link Observer}) que serán notificados
 * cada vez que el estado de la reserva cambie.
 *
 * @see Observer
 * @see Client
 */
public class ReservationObservable {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    /**
     * Suscribe un nuevo observador a la lista.
     *
     * @param observer Observador que se desea registrar.
     */
    public void addObserver(Observer observer){
        observers.add(observer);
    }

    /**
     * Cambia el estado de la reserva y notifica a todos los observadores.
     *
     * @param newStete Nuevo estado de la reserva.
     */
    public void changeState(String newStete){
        this.state = newStete;
        notifyState();
    }

    /**
     * Notifica a todos los observadores registrados sobre el cambio de estado.
     */
    public void notifyState(){
        for(Observer observer: observers){
            observer.update(state);
        }
    }
}
