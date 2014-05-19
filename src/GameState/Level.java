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
 *
 * @author kevinyu
 */
public abstract class Level {
    
    protected Map map;
    protected Hero hero;
    protected int offsetX;
    protected int offsetY;
    protected StatusBar statusBar;
    protected PlayGameState playGameState;
    protected int indexLevel;
    
    public abstract void draw(Graphics g);
    public abstract void update();
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
    public abstract void keyReleased(int k);
    
    public void setPlayGameState(PlayGameState pgs){
        playGameState = pgs;
    }
}
