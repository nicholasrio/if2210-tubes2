/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javagame;

import GameState.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.RenderingHints;

/**
 *
 * @author Luqman
 */
public class GamePanel extends JPanel implements Drawable,Updateable{
    
    protected GameTime gameTime;
    protected GameStateManager sceneManager;
    protected int maxFPS;
    private Thread thread;
    
    //kelas yang menimplemen ActionListener untuk Timer
    private class GameActionListener implements ActionListener{
        
         @Override
        //Game loop setiap loop melakukan update dan repaint
        public void actionPerformed(ActionEvent ae) {
        update(gameTime);
        repaint();
        }
    }
    
    private class GameKeyListener implements KeyListener{
        
        public void keyTyped(KeyEvent key){
            sceneManager.keyTyped(key.getKeyCode());
        }
        
        public void keyPressed(KeyEvent key){
            sceneManager.keyPressed(key.getKeyCode());
        }
        
        public void keyReleased(KeyEvent key){
            sceneManager.keyReleased(key.getKeyCode());
        }
        
    }
    
    public GamePanel()
    {
        this.initialize();
    }
    
    public void initialize()
    {
        setDoubleBuffered(true);
        this.maxFPS = 60;
        setBackground(Color.BLACK);
        sceneManager = new GameStateManager(this);
        sceneManager.addScene(new MainMenu());
        sceneManager.addScene(new PlayGameState());
        sceneManager.switchScene("PlayGameState");
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new GameKeyListener());
        gameTime = new GameTime(1000/getMaxFPS(), new GameActionListener());
	gameTime.start();
    }
    
    @Override
    public void update(GameTime gameTime)
    {
        sceneManager.update(this.gameTime);
    }

    @Override
    public void draw(GameTime gameTime, Graphics g)
    {
        sceneManager.draw(this.gameTime, g);
    }

    @Override
    public void paint(Graphics g){
        RenderingHints rh =
        new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING,
        RenderingHints.VALUE_RENDER_QUALITY);
        draw(this.gameTime, g);
    }

    /**
     * @return the maxFPS
     */
    public int getMaxFPS() {
        return maxFPS;
    }

    /**
     * @param maxFPS the maxFPS to set
     */
    public void setMaxFPS(int maxFPS) {
        this.maxFPS = maxFPS;
        gameTime.setDelay(1000/maxFPS);
    }
    
}
