/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameState;

import java.awt.Graphics;
import javagame.GameTime;
import map.*;
import character.*;
import java.awt.Graphics2D;
import map.Map;
import java.util.*;
import character.Boss.Dragon;
/**
 *
 * @author kevinyu
 */
public class PlayGameState extends GameState{
    private Level currentLevel;
    private ArrayList<Monster> monsters;
    private Hero hero;
    
    public PlayGameState(GameStateManager gsm){
        super(gsm);
        this.name="PlayGameState";
        
        
        //load Character
        character.CharacterCache.loadCache();
        
        //load Hero
        hero = (Hero)CharacterCache.getItem("Yuu");
        
        currentLevel=new RegulerLevel(1,hero);
        currentLevel.init();
        currentLevel.setPlayGameState(this);
        
    }
    
    public void switchLevel(int n){
        currentLevel = new BossLevel(2,hero);
        currentLevel.init();
        currentLevel.setPlayGameState(this);
    }
    
    public void initialize(){
        
    }
    
    public void draw(GameTime gameTime,Graphics g){
        currentLevel.draw(g);
    }
    
    public void update(GameTime gameTime){
        currentLevel.update();
    }
    
    /**
     * response if key pressed
     * @param k the pressed key.
     */
    public void keyPressed(int k){
        currentLevel.keyPressed(k);
    }
    
    public void keyReleased(int k){
        currentLevel.keyReleased(k);
    }
    
    public void keyTyped(int k){
        
    }
    
    public void terminate(){
        
    }
}
