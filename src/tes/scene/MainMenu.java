/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tes.scene;

import java.awt.Graphics;
import javagame.GameTime;
import javagame.Scene;

/**
 *
 * @author Luqman
 */
public class MainMenu extends Scene{
    int posX;
  
    public MainMenu()
    {
        super();
        name = "MainMenu";
    }
    
    @Override
    public void initialize() {
        
        posX = 0;
    }

    @Override
    public void terminate() {
        
    }

    @Override
    public void draw(GameTime gameTime, Graphics g) {
        System.out.println("draw");
        g.drawOval(posX, 300, 100, 100);
    }

    @Override
    public void update(GameTime gameTime) {
        System.out.println("update");
        posX++;
    }
    
}
