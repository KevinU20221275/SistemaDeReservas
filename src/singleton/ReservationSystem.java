package singleton;

import reservations.Reservation;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Singleton que representa el sistema de gestión de reservas en línea.
 *
 * Esta clase centraliza el almacenamiento y visualización de todas las reservas realizadas.
 * Se asegura que solo exista una única instancia activa durante la ejecución del programa.
 */
public class ReservationSystem {
    private static ReservationSystem reservationSystem;
    private List<Reservation> reservationsList;

    /**
     * Constructor privado para garantizar la implementación del patrón Singleton.
     * Inicializa la lista de reservas y muestra un mensaje de bienvenida.
     */
    private ReservationSystem(){
        System.out.println("Bienvenido al sistema de Reservas en linea");
        this.reservationsList = new ArrayList<>();
    }

    /**
     * Método estático que devuelve la única instancia de {@link ReservationSystem}.
     * Si la instancia no existe, la crea.
     *
     * @return La instancia única de {@link ReservationSystem}.
     */
    public static ReservationSystem getInstance(){
        if (reservationSystem == null){
            reservationSystem = new ReservationSystem();
        }

        return reservationSystem;
    }

    /**
     * Agrega una nueva reserva al sistema.
     *
     * @param reservation Objeto de tipo {@link Reservation} que representa la reserva a agregar.
     */
    public void addReservartion(Reservation reservation){
        reservationsList.add(reservation);
    }

    /**
     * retorna la lista de reservas
     * */
    public List<Reservation> getReservations() {
        return reservationsList;
    }

    /**
     * Muestra en consola el historial de todas las reservas realizadas.
     * Si no existen reservas, muestra un mensaje indicándolo.
     */
    public void showReservations(){
        if (reservationsList.isEmpty()){
            System.out.println("No hay reservas realizadas aun.");
        } else {
            System.out.println("====== HISTORIAL DE RESERVAS =======");
            for(Reservation r: reservationsList){
                r.showDetails();
                System.out.println("-------------------------");
            }
        }
    }
}
