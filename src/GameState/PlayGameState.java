/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameState;

import java.awt.Graphics;
import javagame.GameTime;
import map.MapViewer;
/**
 *
 * @author kevinyu
 */
public class PlayGameState extends GameState{
    private int currentLevel;
    private MapViewer map;
    
    public PlayGameState(){
        super();
        this.name="PlayGameState";
        currentLevel=1;
        map = new MapViewer();
        map.createAndShowGUI();
    }
    public void initialize(){
        
    }
    
    public void draw(GameTime gameTime,Graphics g){
        
    }
    
    public void update(GameTime gameTime){
        
    }
    
    public void keyPressed(int k){
        
    }
    
    public void keyReleased(int k){
        
    }
    
    public void keyTyped(int k){
        
    }
    
    public void terminate(){
        
    }
}
