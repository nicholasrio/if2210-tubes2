/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameState;
import character.*;
import character.Boss.Boss;
import character.Boss.Dragon;
import map.Map;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import map.ViewerGUI;
/**
 *
 * @author kevinyu
 */
public class BossLevel extends Level{
    
    private Boss boss;
    
    public BossLevel(int k,Hero hero){
        offsetX = 0;
        offsetY = 0;
        indexLevel = k;
        this.hero = hero;
    }
    
    public void init(){
        boss = new Dragon();
        initMap();
        initHero();
        initBoss();
        statusBar = new StatusBar();
        statusBar.init();
    }
    
    public void initHero(){
        hero.loadImage(CharacterCache.getImage("Yuu"));
        hero.loadAttackFrame(CharacterCache.getAttack("Yuu"));
        hero.setMap(map);
        hero.init();
        hero.setPosition(12*32,13*32);
    }
    
    public void initBoss(){
        boss.setMap(map);
        boss.init();
        boss.setPosition(11*32,2*32);
    }
    
    public void initMap(){
        map = new Map();
        map.createBossDungeon(26,16);
    }
    
    public void update(){
        boss.checkHitting(hero);
        boss.checkSkillRange(hero);
        boss.checkAttackRange(hero);
        hero.update();
        hero.checkHitting(boss);
        boss.update();
        statusBar.setHP(hero.getCurrentHealth());
        statusBar.setMana(hero.getCurrentMana());
        if (hero.isDead()){
             playGameState.getGameStateManager().switchScene("MainMenu");
        }
        if (boss.isDead()){
            //masih belum ditentukan
        }
    }
    
    public void draw(Graphics g){
        ViewerGUI.view(g,map,(int)offsetX,(int)offsetY,(int)800,(int)500);
        boss.draw((Graphics2D)g,offsetX,offsetY);
        hero.draw((Graphics2D)g,offsetX,offsetY);
        statusBar.draw((Graphics2D)g);
    }
    
    public void keyPressed(int k){
        hero.keyPressed(k);
    }
    
    public void keyReleased(int k){
        hero.keyReleased(k);
    }
    
}
