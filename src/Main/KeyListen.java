/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author General User
 */
public class KeyListen extends KeyAdapter {
    
    private int keyCode;
    private char keyChar;
    
    @Override
    public void keyPressed(KeyEvent event) {
        keyCode = event.getKeyCode();
        keyChar = event.getKeyChar();
        System.out.println("Key pressed = "+keyChar+" || code = " + keyCode);
    }

    @Override
    public void keyReleased(KeyEvent event) {
        keyCode = -1;
        keyChar = ' ';
        System.out.println("Key released = "+keyChar+" || code = " + keyCode);
    }
    
    /**
     * get key code
     * @return int key code
     */
    public int getKeyCode(){
        return keyCode;
    }
    
    /**
     * get key char
     * @return char key char.
     */
    public int getKeyChar(){
        return keyChar;
    }
}
