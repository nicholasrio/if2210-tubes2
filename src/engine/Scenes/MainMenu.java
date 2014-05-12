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
       DrawHeader();
    }
    
    private void DrawHeader() {
       String Title = "CUBE MAZER";
       int spaces, spacebetween;
       spacebetween = width/25;
       for (int i = 0;i<width;i++) System.out.print("=");
       System.out.println();
       if (width%2 == 0)System.out.print("||");
       else System.out.print("|| ");
       spaces = (width - (spacebetween*10) - 10 - 4 )/2;
       for (int i = 0;i < spaces;i++) System.out.print(" ");
       for (int i = 0;i < Title.length();i++) {
            System.out.print(Title.charAt(i));
            for(int j = 0;j<spacebetween;j++) System.out.print(" ");
       }
       for (int i = 0;i < spaces;i++) System.out.print(" ");
       System.out.print("||");
       System.out.println();
       for (int i = 0;i<width;i++) System.out.print("=");
       System.out.println();
    }
}
