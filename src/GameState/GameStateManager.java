/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameState;

import GameState.GameState;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javagame.Drawable;
import javagame.GamePanel;
import javagame.GameTime;
import javagame.Updateable;

/**
 *
 * @author Luqman
 */
public class GameStateManager implements Drawable, Updateable{
    private GamePanel game;
    private List<GameState> scenes;
    private GameState activeScene;

    /**
     *
     * @param game
     */
    public GameStateManager(GamePanel game)
    {
        this.game = game;
        scenes = new ArrayList<>();
    }

    /**
     *
     * @param scene
     */
    public void addScene(GameState scene)
    {
        for(GameState s: scenes)
        {
            if(s.getName().equals(scene.getName())) return;
        }
        scenes.add(scene);
    }

    /**
     *
     * @param name
     */
    public void switchScene(String name)
    {
        for(GameState s: scenes)
        {
            if(s.getName().equals(name))
            {
                if(activeScene!=null) activeScene.terminate();
                activeScene = s;
                activeScene.initialize();
            }
        }
    }

    @Override
    public void draw(GameTime gameTime, Graphics g) {
        if(activeScene!=null) activeScene.draw(gameTime, g);
    }

    @Override
    public void update(GameTime gameTime) {
        if(activeScene!=null) activeScene.update(gameTime);
    }
    
    public void keyReleased(int k){
        activeScene.keyReleased(k);
    }
    
    public void keyTyped(int k){
        activeScene.keyTyped(k);
    }
    
    public void keyPressed(int k){
        activeScene.keyPressed(k);
    }
    
}
