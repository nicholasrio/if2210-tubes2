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
    
    // Methods
    static public void AddScene(Scene S)
    {
        for (Scene Scn : Scenes)
        {
            if (Scn.getSceneName().equalsIgnoreCase(S.getSceneName())) return;
        }
        Scenes.add(S);
    }
    
    /**
     * Pindah Scene dari satu scene ke scene lain.
     * @param name Scene yang akan dijalankan
     */
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
    
    /**
     * Melakukan inisialisasi Scene.
     */
    static public void Initialize()
    {
        Started = true;
    }
    
    /**
     * Melakukan update scene dengan scene pada ActiveScene
     */
    static public void Update()
    {
        if (!Started) return;
        if (activeScene != null)
            activeScene.Update();
    }
    
    /**
     * Menggambar scene yang ada pada ActiveScene.
     */
    static public void Draw()
    {
        if (!Started) return;
        if (activeScene != null)
            activeScene.Draw();
    }
    
    /**
     * Menghentikan game CubeMazer.
     */
    static public void ShutDown()
    {
        Game.gameRunning = false;
    }
}
