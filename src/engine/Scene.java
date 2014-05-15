/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;
import javax.swing.JPanel;

/**
 *
 * @author Tony
 */
public abstract class Scene extends JPanel
{
    private final String name;
    
    
    public Scene(String sceneName)
    {
        name = sceneName;
    }
    
    public String getSceneName()
    {
        return name;
    }
    
    public abstract void Initialize();

    public abstract void Update();

    public abstract void Draw();
}