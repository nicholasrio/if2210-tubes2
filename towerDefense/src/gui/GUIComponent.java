/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author Opel Howard
 */
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
