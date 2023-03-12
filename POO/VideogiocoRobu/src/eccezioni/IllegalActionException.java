package eccezioni;

public class IllegalActionException extends Exception{
    public IllegalActionException() {
        super("Azione non valida");
    }

    public IllegalActionException(String message) {
        super(message);
    }
}
