/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javagame;

import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Luqman
 */
public class GameTime extends Timer {
    private long initialTime;
    /**
     * constructor
     * @param i
     * @param al 
     */
    public GameTime(int i, ActionListener al) {
        super(i, al);
        initialTime = 0;
    }
    
    @Override
    public void start()
    {
        super.start();
        initialTime = System.nanoTime();
    }
    @Override
    public void restart()
    {
        super.restart();
        initialTime = System.nanoTime();
    }
    /**
     * 
     * @return waktu yang telah dilewati dalam nano second
     */
    public long getElapsedTime()
    {
        return System.nanoTime() - initialTime;
    }
}
