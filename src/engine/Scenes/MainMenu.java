/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.Scenes;
import engine.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael
 */
public class MainMenu extends Scene
{
    private int height;
    private int width;
    private int status;
    public MainMenu()
    {
        super("MainMenu");
    }
    
    @Override
    public void Initialize()
    {
        height = 30;
        width = 80;
        status = 0;       
    }
    
    @Override
    public void Update()
    {
        
    }
    
    @Override
    public void Draw()
    {
       DrawHeader();
       PrinterString("",0);
       PrinterString("1 NEW GAME/CONTINUE GAME",0);
       PrinterString("2 CHANGE USER",0);
       PrinterString("3 ACHIEVEMENT",0);
       PrinterString("4 OPTION",0);      
       PrinterString("5 EXIT",0);       
       PrinterString("",0);
       PrinterString("=",0);
    }
    
    private void DrawHeader() {
        PrinterString("=",1);
        PrinterString("CUBE MAZER",1);
        PrinterString("",1);
        PrinterString("MAIN MENU",1);
        PrinterString("=",1);
    }
    
    private void PrinterString(String what, int mode) { /* mode = space scaling */
        if (what.equals("=")) {
            System.out.print("||");
            for(int i = 0; i < (width-4);i++) System.out.print("=");
            System.out.println("||");
        } else {
            int spaces, spacebetween;
            if(mode == 1) spacebetween = width / 20;
            else spacebetween = 0;
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
