/**
 *
 * @author 
 * Darwin Prasetio (13512015)
 * Chrestella Stephanie (13512005)
 * Jan Wira Gotama Putra (13512015)
 * Eric (13512021)
 * Willy(13512070)
 * Melvin FOnda (13512085)
 */

package exception;

/**
 * Exception yang menandakan nama pemain tidak ditemukan di database
 */
public class NameNotExistException extends Exception {

    private static final String message = "username doesn't exist";
    
    /** Default constructor */
    public NameNotExistException() {
        super(message);
    }
}
