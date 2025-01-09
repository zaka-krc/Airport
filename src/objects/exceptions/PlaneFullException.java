package objects.exceptions;

public class PlaneFullException extends RuntimeException {
    public PlaneFullException(String message) {
        super(message);
    }
}
