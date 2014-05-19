/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameState;

import character.Hero;
import java.awt.Graphics;
import map.Map;
import map.Tile;
import java.awt.event.KeyEvent;
/**
 * abstract class for level.
 * @author kevinyu
 */
public abstract class Level {
    
    /**
     * The Map of level
     */
    protected Map map;

    /**
     * The Hero of level
     */
    protected Hero hero;

    /**
     * the offset of X map.
     */
    protected int offsetX;

    /**
     * the offset of Y map.
     */
    protected int offsetY;

    /**
     * status bar
     */
    protected StatusBar statusBar;

    /**
     * current game state.
     */
    protected PlayGameState playGameState;

    /**
     * index of level.
     */
    protected int indexLevel;
    
    /**
     * method for drawing
     * @param g is graphics
     */
    public abstract void draw(Graphics g);

    /**
     * method for updating the game
     */
    public abstract void update();

    /**
     * method for initialize the class
     */
    public abstract void init();
    
    /**
     * response if key pressed
     * @param k the pressed key.
     */
    public void keyPressed(int k){
        if (k == KeyEvent.VK_U){
            for (int i=-1;i<=1;i++){
                for (int j=-1;j<=1;j++){
                    int n = map.getCell((int)hero.getPositionX()/32+i,
                    (int)hero.getPositionY()/32+j).getId();
                    if ((n == Tile.tileDownStairs) || (n==Tile.tileUpStairs)){
                        System.out.println("Enter Level 2");
                        playGameState.switchLevel(indexLevel+1);
                    }
                }
            }
        }
    }

    /**
     * method for read if the key is released or not
     * @param k the released key
     */
    public abstract void keyReleased(int k);
    
    /**
     * method for setting the game state
     * @param pgs the game state
     */
    public void setPlayGameState(PlayGameState pgs){
        playGameState = pgs;
    }
}
