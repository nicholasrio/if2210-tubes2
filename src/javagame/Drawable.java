/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javagame;

import java.awt.Graphics;

/**
 * interface of drawable object.
 * @author Luqman
 */
public interface Drawable {
    /**
     * method draw
     * @param gameTime
     * @param g 
     */
    public void draw(GameTime gameTime, Graphics g);
}
