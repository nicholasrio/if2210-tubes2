package exception;

/**
 * Exception yang menandakan nama player sudah ada di dalam database
 */
public class NameExistException extends Exception {

    private static final String message = "username already exist";

    public NameExistException() {
        super(message);
    }
}
