package exceptions;

public class MissingBaseException extends RuntimeException {
    public MissingBaseException(String message) {
        super(message);
    }
}
