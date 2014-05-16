/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameState;

import java.awt.*;
import javagame.GameTime;
import java.awt.event.KeyEvent;

/**
 *
 * @author Luqman
 */
public class MainMenu extends GameState{
    int posX;
  
    public MainMenu()
    {
        super();
        name = "MainMenu";
    }
    
    @Override
    public void initialize() {
        
        //intialize
        posX = 0;
    }

    @Override
    public void terminate() {
        
        //fill only if you need to save this GameState curent attribute before leaving
    }

    @Override
    public void draw(GameTime gameTime, Graphics g) {
        
        //replace draw Bacground image here;
        //System.out.println("draw");
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.orange);
        g2d.fillOval(posX, 300, 100, 100);
    }

    @Override
    public void update(GameTime gameTime) {
        
        //Replace update MainMenu example if your background image moving every gameLoop
        //Can be empty
        //System.out.println("update");
        posX++;
        
    }
    
    public void keyReleased(int k){
        
        //Reaction to Key Released
    }
    
    public void keyPressed(int k){
        
        //Reaction to KeyPressed
        if(k == KeyEvent.VK_ENTER){
            System.out.println("You Press Enter on Main Menu");
        }
        if(k == KeyEvent.VK_UP) {
            System.out.println("You Press Up on Main Menu");
	}
	if(k == KeyEvent.VK_DOWN) {
            System.out.println("You Press Down on Main Menu");
	}
    }
    
    public void keyTyped(int k){
        //Reaction to KeyTyped
        
    }
    
}
