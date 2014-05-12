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
        PrinterString("=");
        PrinterString("CUBE MAZER");
        PrinterString("");
        PrinterString("MAIN MENU");
        PrinterString("=");
    }
    
    private void PrinterString(String what) {
        if (what.equals("=")) {
            System.out.print("||");
            for(int i = 0; i < (width-4);i++) System.out.print("=");
            System.out.println("||");
        } else {
            int spaces, spacebetween;
            spacebetween = width / 25;
            if (width % 2 == 0) {
                System.out.print("||");
            } else {
                System.out.print("|| ");
            }
            spaces = (width - (spacebetween * what.length()) - what.length() - 4) / 2;
            for (int i = 0; i < spaces; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < what.length(); i++) {
                System.out.print(what.charAt(i));
                for (int j = 0; j < spacebetween; j++) {
                    System.out.print(" ");
                }
            }
            for (int i = 0; i < spaces; i++) {
                System.out.print(" ");
            }
            if (what.length() % 2 == 0) {
                System.out.print("||");
            } else {
                System.out.print(" ||");
            }
            System.out.println();
        }
    }
}
