/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;
import java.util.ArrayList;

/**
 *
 * @author Tony
 */
public class SceneManager 
{
    // Attributes
    static private ArrayList<Scene> Scenes = new ArrayList<Scene>();
    static private boolean Started = false;
    static private Scene activeScene = null;
    static public boolean Play = true;
    
    // Methods
    static public void AddScene(Scene S)
    {
        for (Scene Scn : Scenes)
        {
            if (Scn.getSceneName().equalsIgnoreCase(S.getSceneName())) return;
        }
        Scenes.add(S);
    }
    
    static public void SwitchScene(String name)
    {
        for (Scene Scn : Scenes)
        {
            if (Scn.getSceneName().equalsIgnoreCase(name))
            {
                activeScene = Scn;
                Scn.Initialize();
            }
        }
    }
    
    static public void Initialize()
    {
        Started = true;
    }
    
    static public void Update()
    {
        if (!Started) return;
        if (activeScene != null)
            activeScene.Update();
    }
    
    static public void Draw()
    {
        if (!Started) return;
        if (activeScene != null)
            activeScene.Draw();
    }
    
}
