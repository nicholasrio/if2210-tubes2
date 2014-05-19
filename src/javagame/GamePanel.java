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
    
    /**
     * game time
     */
    protected GameTime gameTime;
    /**
     * scene manager
     */
    protected GameStateManager sceneManager;
    /**
     * integer max fps
     */
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
    
    /**
     * constructor
     */
    
    public GamePanel()
    {
        this.initialize();
    }
    
    /**
     * method for initialize
     */
    public void initialize()
    {
        setDoubleBuffered(true);
        this.maxFPS = 60;
        setBackground(Color.BLACK);
        sceneManager = new GameStateManager(this);
        sceneManager.addScene(new MainMenu(sceneManager));
        sceneManager.addScene(new PlayGameState(sceneManager));
        sceneManager.addScene(new Help(sceneManager));
        sceneManager.switchScene("MainMenu");
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new GameKeyListener());
        gameTime = new GameTime(1000/getMaxFPS(), new GameActionListener());
	gameTime.start();
    }
    
    /**
     * method update
     * @param gameTime 
     */
    @Override
    public void update(GameTime gameTime)
    {
        sceneManager.update(this.gameTime);
    }

    /**
     * method for draw
     * @param gameTime
     * @param g 
     */
    @Override
    public void draw(GameTime gameTime, Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 600);
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
