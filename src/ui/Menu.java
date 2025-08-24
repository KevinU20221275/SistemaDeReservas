package ui;

import java.util.Scanner;

public class Menu {
    // menu principal
    public static void mainMenu(){
        System.out.println("======= Menu ==========");
        System.out.println("1. Realizar Reserva");
        System.out.println("2. Ver Reservas");
        System.out.println("3. Salir");
    }

    // menu para seleccionar el tipo de reserva
    public static void reservationMenu(){
        System.out.println("==== TIPOS DE RESERVA DISPONIBLES =====");
        System.out.println("1. Hotel");
        System.out.println("2. Vuelo");
        System.out.println("3. Auto");
    }

    // menu de metodos de pago
    public static void paidMethodMenu(){
        System.out.println("=== METODOS DE PAGO ======");
        System.out.println("1. Tarjeta de credito");
        System.out.println("2. Paypal");;
    }

    // valida que se ingrese una opcion valida
    public static int getValidatedOption(Scanner scanner, int min, int max){
        while (true){
            System.out.print("Ingrese una opción (" + min + "-" + max + "): ");

            if (scanner.hasNextInt()){
                int option = scanner.nextInt();
                scanner.nextLine();

                if (option >= min && option <= max){
                    return option;
                } else {
                    System.out.println("Por favor, ingrese un número entre " + min + " y " + max + ".");
                }
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.nextLine(); // Limpiar la entrada incorrecta
            }
        }
    }
}
