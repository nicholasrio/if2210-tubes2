package exception;

/**
 *
 * @author Klongkgung
 */
public class NameExistException extends Exception {

    private static final String message = "username already exist";

    public NameExistException() {
        super(message);
    }
}
