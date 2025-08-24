package command;

/**
 * Clase Invoker del patrón Command.
 * Es responsable de recibir un comando y ejecutar la acción solicitada.
 *
 * Permite desacoplar el emisor de la acción del receptor,
 * facilitando la ejecución de comandos de manera flexible.
 */
public class Invoker {
    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void executeReservation(){
        command.execute();
    }
}
