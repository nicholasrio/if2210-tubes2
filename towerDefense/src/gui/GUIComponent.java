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

package gui;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

abstract public class GUIComponent {

    private int x;
    private int y;
    int option;
    private final Class event;
    protected boolean dirtyBit;
    final private String status;

    /**
     * the Constructor for any component
     *
     * @param _status
     * @param _opt
     * @throws IOException
     */
    public GUIComponent(String _status, int _opt) throws IOException {
        //event = _event;
        status = _status;
        event = null;
        option = _opt;
        dirtyBit = true;
    }

    /**
     * setting the x position for the component
     * @param _x
     */
    public void setX(int _x) {
        x = _x;
    }

    /**
     * setting the y position for the component
     * @param _y
     */
    public void setY(int _y) {
        y = _y;
    }

    /**
     * 
     * @return the x position
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return the y position
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @return if the component has been modified
     */
    public boolean isModified() {
        return dirtyBit;
    }

    /**
     *
     * @param _x
     * @param _y
     * @return check if the component is invoked
     */
    public boolean isInvoked(int _x, int _y) {
        return (x < _x) && (_x < x + getWidth()) && ((y < _y) && (_y < y + getHeight()));
    }

    /**
     *
     * @return get the status of the component
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @return get option of the component
     */
    public int getOption() {
        return option;
    }

    /**
     *
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * the option menu is new
     */
    public void invoke() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        TowerDefense.pilihanMenu = option;
    }

    abstract protected int getWidth();

    abstract protected int getHeight();
}
