/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.Scenes;
import engine.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

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
        width = 150;
        status = 0;       
    }
    
    @Override
    public void Update()
    {
        KeyEvent K = new KeyEvent();
     //   while (K.RetKeyVal() != 10) { /* 10 = Enter Key */
            if(K.RetKeyVal() == 37) /* Left arrow code */ {
                status--;
                if(status < 0) status = 4;
            }
            else if (K.RetKeyVal() == 39) /*Right arrow code */ {
                status++;
                if(status > 4) status = 0;
            }
      //  }
    }
    
    @Override
    public void Draw()
    {
       DrawHeader();
       PrinterString("");
       if(status == 0) {
           PrinterString("<< NEW GAME/CONTINUE GAME >>");
       } else if (status == 1) {
           PrinterString("<< CHANGE USER >>");
       } else if (status == 2) {
           PrinterString("<< ACHIEVEMENT >>");
       } else if (status == 3) {
           PrinterString("<< OPTION >>");
       } else {
           PrinterString("<< EXIT >>");
       }
       PrinterString("");
       PrinterString("=");
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

class KeyEvent implements KeyListener{
    int ret;
    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {
        
    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {
        ret = e.getKeyCode();
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {
        
    }
    
    public int RetKeyVal() {
        System.out.println(ret);
        return ret;
    }
}
