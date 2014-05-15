/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javagame;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luqman
 */
public class SceneManager implements Drawable, Updateable{
    private GamePanel game;
    private List<Scene> scenes;
    private Scene activeScene;

    /**
     *
     * @param game
     */
    public SceneManager(GamePanel game)
    {
        this.game = game;
        scenes = new ArrayList<>();
    }

    /**
     *
     * @param scene
     */
    public void addScene(Scene scene)
    {
        for(Scene s: scenes)
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
        for(Scene s: scenes)
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
}
