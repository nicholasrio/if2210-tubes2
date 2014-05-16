/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameState;

import java.awt.Graphics;
import javagame.GameTime;
import map.MapViewer;
import character.*;
import java.awt.Graphics2D;

/**
 *
 * @author kevinyu
 */
public class PlayGameState extends GameState{
    private int currentLevel;
    private MapViewer map;
    private Hero hero;
    
    public PlayGameState(){
        super();
        this.name="PlayGameState";
        currentLevel=1;
        hero = new Hero();
        //map = new MapViewer();
        //map.createAndShowGUI();
    }
    public void initialize(){
        
    }
    
    public void draw(GameTime gameTime,Graphics g){
        hero.draw((Graphics2D)g);
    }
    
    public void update(GameTime gameTime){
        hero.update();
    }
    
    public void keyPressed(int k){
        hero.keyPressed(k);
    }
    
    public void keyReleased(int k){
        hero.keyReleased(k);
    }
    
    public void keyTyped(int k){
        
    }
    
    public void terminate(){
        
    }
}
