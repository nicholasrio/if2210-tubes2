/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.Scenes;
import engine.*;

/**
 *
 * @author Tony
 */
public class MainMenu extends Scene
{
    private int height;
    private int width;
    public MainMenu()
    {
        super("MainMenu");
        height = 30;
        width = 50;
    }
    
    @Override
    public void Initialize()
    {
        
    }
    
    @Override
    public void Update()
    {
        
    }
    
    @Override
    public void Draw()
    {
       for (int i = 0;i<width;i++) System.out.print("=");
       for (int i = 0;i<width;i++) System.out.print("=");
       System.out.println();
    }
}
