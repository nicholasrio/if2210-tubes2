package exception;

/**
 * Exception yang menandakan nama pemain tidak ditemukan di database
 */
public class NameNotExistException extends Exception {

    private static final String message = "username doesn't exist";

    public NameNotExistException() {
        super(message);
    }
}
