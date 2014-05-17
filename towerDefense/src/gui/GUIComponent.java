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

    public GUIComponent(String _status, int _opt) throws IOException {
        //event = _event;
        status = _status;
        event = null;
        option = _opt;
        dirtyBit = true;
    }

    public void setX(int _x) {
        x = _x;
    }

    public void setY(int _y) {
        y = _y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isModified() {
        return dirtyBit;
    }

    public boolean isInvoked(int _x, int _y) {
        return (x < _x) && (_x < x + getWidth()) && ((y < _y) && (_y < y + getHeight()));
    }

    public String getStatus() {
        return status;
    }

    public int getOption() {
        return option;
    }

    public void invoke() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        TowerDefense.pilihanMenu = option;
        /*if (event != null) {
         Class[] interfaces = event.getInterfaces();
         boolean isThread = false;
         for (Class implement : interfaces) {
         if (implement == Runnable.class)
         isThread = true;
         }
         if (isThread)
         new Thread((Runnable) event.newInstance()).start();
         else {
         event.getMethod("run", null).invoke(event.newInstance(), null);
         }
         }*/
    }

    abstract protected int getWidth();

    abstract protected int getHeight();
}