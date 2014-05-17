/**
 *
 * @author 
 * Darwin Prasetio (13512015)
 * Chrestella Stephanie (13512005)
 * Jan Wira Gotama Putra (13512015)
 * Eric (13512021)
 * Willy(13512070)
 * Melvin Fonda (13512085)
 */

package exception;

/**
 * Exception yang menandakan nama player sudah ada di dalam database
 */
public class NameExistException extends Exception {

    private static final String message = "username already exist";
    
    /** 
     * Default constructor 
     */
    public NameExistException() {
        super(message);
    }
}
