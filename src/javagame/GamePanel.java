/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javagame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;
import tes.scene.*;

/**
 *
 * @author Luqman
 */
public class GamePanel extends JPanel implements Drawable, Updateable, ActionListener{
    protected GameTime gameTime;
    protected SceneManager sceneManager;
    protected int maxFPS;

    public GamePanel()
    {
        this.maxFPS = 60;
        setBackground(Color.BLACK);
        sceneManager = new SceneManager(this);
        sceneManager.addScene(new MainMenu());
        sceneManager.switchScene("MainMenu");
        gameTime = new GameTime(1000/getMaxFPS(), this);
	gameTime.start();
    }

    
    public void initialize()
    {

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
        super.paintComponent(g);
        draw(this.gameTime, g);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        update(gameTime);
        repaint();
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
