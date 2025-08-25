package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
/**
 * Clase utilitaria para obtener y validar datos genericos de la Reserva.
 */
public class ReservationFields {
    public static String getName(Scanner scanner){
        String clientName;
        do {
            System.out.print("Ingrese el nombre del cliente: ");
            clientName = scanner.nextLine();
        } while (clientName.isBlank());

        return clientName;
    }

    public static String getDui(Scanner scanner){
        String dui;
        do {
            System.out.print("Ingrese su DUI (formato: 12345678-9): ");
            dui = scanner.nextLine();
        } while (!dui.matches("\\d{8}-\\d"));

        return dui;
    }

    public static String getDate(Scanner scanner){
        String date;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true){
            System.out.print("Ingrese la fecha de la reserva (YYYY-MM-DD): ");
            date = scanner.nextLine();

            // válida el formato con regex
            if (!date.matches("\\d{4}-\\d{2}-\\d{2}")){
                System.out.println("Formato invalido. Use el formato YYYY-MM-DD");
                continue;
            }

            try {
                LocalDate parsedDate = LocalDate.parse(date, formatter);
                if (parsedDate.isBefore(LocalDate.now())){
                    System.out.println("La fecha no puede ser anterior a hoy.");
                    continue;
                }

                return date;
            } catch (DateTimeParseException e){
                System.out.println("Fecha no valida. Ingrese una fecha real");
            }
        }
    }

    public static String getValidCardNumber(Scanner scanner){
        String cardNumber;

        while (true){
            System.out.println("Ingrese el numero de la tarjeta (16 digitos sin espacios): ");
            cardNumber = scanner.nextLine();

            if (!cardNumber.matches("\\d{16}")){
                System.out.println("Numero invalido. Asegúrese de ingresar 16 digitos");
            } else {
                return cardNumber;
            }
        }
    }

    public static String getPaypalAccount(Scanner scanner){
        String email;
        while (true){
            System.out.print("Ingrese su cuenta de PayPal (correo electrónico): ");
            email = scanner.nextLine();

            if (!email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                System.out.println("Correo electrónico inválido.");
            } else {
                return email;
            }
        }
    }
}
