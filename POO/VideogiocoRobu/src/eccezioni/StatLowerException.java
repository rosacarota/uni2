package eccezioni;

public class StatLowerException extends RuntimeException {
    public StatLowerException() {
        super("Stats non valide");
    }

    public StatLowerException(String message) {
        super(message);
    }
}
