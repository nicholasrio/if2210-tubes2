/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameState;

import javagame.Drawable;
import javagame.Updateable;

/**
 * the
 * @author Luqman
 */
public abstract class GameState implements Drawable, Updateable {
    /**
     * the name of game state
     */
    protected String name;
    /**
     * the game state manager.
     */
    protected GameStateManager gsm;
    
    /**
     * constructor
     * @param gsm 
     */
    public GameState(GameStateManager gsm)
    {
        this.gsm = gsm;
    }
    
    /**
     * initialize game state
     */
    public abstract void initialize();

    /**
     * terminate current game state
     */
    public abstract void terminate();
    
    /**
     * get the current state name
     * @return string name
     */
    public String getName() {
        return name;
    }
    
    /**
     * return the game state manager.
     * @return GameStateManager
     */
    public GameStateManager getGameStateManager(){
        return gsm;
    }
    
    /**
     * response if key typed
     * @param k the key typed
     */
    public abstract void keyTyped(int k);
    
    /**
     * response if key released
     * @param k the released key
     */
    public abstract void keyReleased(int k);
    
    /**
     * response if key pressed
     * @param k the pressed key.
     */
    public abstract void keyPressed(int k);
}
