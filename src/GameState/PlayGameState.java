/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameState;

import java.awt.Graphics;
import javagame.GameTime;
import map.MapViewer;
import map.*;
import character.*;
import java.awt.Graphics2D;
import map.Map;
/**
 *
 * @author kevinyu
 */
public class PlayGameState extends GameState{
    private int currentLevel;
    private Hero hero;
    private Map map;
    private int offsetX;
    private int offsetY;
    
    public PlayGameState(){
        super();
        this.name="PlayGameState";
        currentLevel=1;
        map = new Map();
        map.createDungeon(80,100,40);
        hero = new Hero(map);
        boolean found = false;
        for (int i=map.xsize-1;i>=0;i--){
            for (int j=map.ysize-1;j>=0;j--){
                if (map.getCell(i,j).isWalkable()){
                    offsetX = i*32;
                    offsetY = j*32;
                    hero.setPosition(i*32,j*32);
                    found = true;
                    break;
                }
            }
            if (found){
                break;
            }
        }
    }
    public void initialize(){
        
    }
    
    public void draw(GameTime gameTime,Graphics g){
        if (hero.getPositionX()>400){
            offsetX = (int)hero.getPositionX()-(400/32)*32;
        }
        if (hero.getPositionY()>250){
            offsetY = (int)hero.getPositionY()-(250/32)*32;
        }
        ViewerGUI.view(g,map,(int)offsetX,(int)offsetY,(int)800,(int)500);
        hero.draw((Graphics2D)g,offsetX,offsetY);
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
