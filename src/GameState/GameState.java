/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameState;

import javagame.Drawable;
import javagame.Updateable;

/**
 *
 * @author Luqman
 */
public abstract class GameState implements Drawable, Updateable {
    protected String name;
    protected GameStateManager gsm;
    
    public GameState(GameStateManager gsm)
    {
        this.gsm = gsm;
    }

    public abstract void initialize();


    public abstract void terminate();

    public String getName() {
        return name;
    }
    
    public GameStateManager getGameStateManager(){
        return gsm;
    }
    
    public abstract void keyTyped(int k);
    
    public abstract void keyReleased(int k);
    
    public abstract void keyPressed(int k);
}
