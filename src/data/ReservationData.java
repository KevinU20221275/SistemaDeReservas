package data;


/**
 * Clase que centraliza los datos de reservas disponibles para hoteles, vuelos y vehículos.
 * Permite mantener separados el nombre, precio y otras propiedades de cada tipo de reserva,
 * facilitando la extensión y el mantenimiento de los adapters sin modificar su lógica.
 */
public class ReservationData {

    /**
     * Representa un hotel disponible para reservar.
     */
    public static class Hotel {
        public String name;
        public int stars;
        public int price;

        public Hotel(String name, int stars, int price) {
            this.name = name;
            this.stars = stars;
            this.price = price;
        }

        @Override
        public String toString() {
            return name + ", " + stars + " Estrellas, $" + price;
        }
    }

    /**
     * Representa un vuelo disponible para reservar.
     */
    public static class Flight {
        public String destination;
        public int price;

        public Flight(String destination, int price) {
            this.destination = destination;
            this.price = price;
        }

        @Override
        public String toString() {
            return destination + ", $" + price;
        }
    }

    /**
     * Representa un vehículo disponible para reservar.
     */
    public static class Car {
        public String type;
        public int price;

        public Car(String type, int price) {
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return type + ", $" + price;
        }
    }


    /** Lista de hoteles disponibles */
    public static Hotel[] hotels = {
            new Hotel("El Marito", 4, 150),
            new Hotel("El Canopi", 4, 300),
            new Hotel("El Luxor", 5, 450)
    };

    /** Lista de vuelos disponibles */
    public static Flight[] flights = {
            new Flight("Madrid", 100),
            new Flight("Londres", 200),
            new Flight("Miami", 300)
    };

    /** Lista de vehículos disponibles */
    public static Car[] cars = {
            new Car("Familiar 4 puertas", 75),
            new Car("2 Puertas", 150),
            new Car("Camioneta todo terreno", 225)
    };
}

