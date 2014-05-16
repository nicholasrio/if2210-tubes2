/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.Scenes;
import engine.*;
import engine.DataStructure.*;
import java.util.Scanner;

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
    
    /**
     * Inisialisasi nilai nilai Main Menu
     */
    @Override
    public void Initialize()
    {
        height = 57; //57 height of half full screen, 25 is standard cmd size full screen
        width = 168; // 80 full width of standard cmd screen and half full screen cmd size, 168 full screen
        status = 0;
        GameData.loadPlayer("player.xml");
    }
    
    /**
     * Update atribut berdasarkan input user
     */
    @Override
    public void Update()
    {
        System.out.print("Enter your choice (0 for main menu): ");
        Scanner Sc = new Scanner(System.in);
        if(status == 0) {
            status = Sc.nextInt();
        }
        else if(status == 2) {
            status = 0;
            int temp = Sc.nextInt();
            if(temp != 0) GameData.lastLogin = GameData.dataPlayer.get(temp-1);
        }
        else if (status == 3) {
            status = 0;
            SceneManager.SwitchScene("AchievementMenu");
        }
        else if (status == 4) {
            status = 0;
            int temp = Sc.nextInt();
            if(temp != 0) {
                if(temp == 1) {
                    width = 80;
                    height = 25;
                }
                if(temp == 2) {
                    width = 168;
                    height = 57;
                }
            }
        }
        if(status == 1)
        {
            status = 0;
            SceneManager.SwitchScene("LevelMenu");
        }
    }
    
    /**
     * Draw ke layar
     */
    @Override
    public void Draw()
    {
       System.out.flush();
       for (int i = 0; i < 100; i++) System.out.println();
       if (status == 5) 
       {
           Game.gameRunning = false;
       }
       else if (status == 1) SceneManager.SwitchScene("LevelMenu");
       else if (status == 3) SceneManager.SwitchScene("AchievementMenu");
       else {
            DrawHeader();
            if(status == 0) {
            DrawBody();
            }
            else if (status == 2) {
                DrawChange();
            }
            else if (status == 4) {
                DrawOption();
            }
       }
    }
    
    /**
     * Method untuk menggambar header ke layar
     */
    private void DrawHeader() {
        PrinterString("=",1);
        PrinterString("", 1);
        PrinterString("CUBE MAZER",1);
        PrinterString("",1);
       if (height > 25) {
           PrinterString("",1);
           PrinterString("",1);
       }
        PrinterString("MAIN MENU",1);
        PrinterString("",1);
        PrinterString("=",1);
    }
    
    /**
     * Method untuk menggambar content main menu
     */
    private void DrawBody() {
        String[] Body = new String[7];
        Body[0] = "Welcome " + GameData.lastLogin.getNama();
        Body[1] = "1 NEW GAME/CONTINUE GAME";
        Body[2] = "2 CHANGE USER";
        Body[3] = "3 ACHIEVEMENT";
        Body[4] = "4 OPTION";
        Body[5] = "5 EXIT";
        Body[6] = "=";
        PrinterStringVertical(Body);
    }
    
    /**
     * Method menggambar body untuk menu change player
     */
    private void DrawChange() {
        String[] temp = new String[GameData.getJumlahPlayer()+2];
        temp[0] = "Pilih user : ";
        temp[GameData.getJumlahPlayer()+1] = "=";    
        for(int i = 1; i <= GameData.getJumlahPlayer();i++) {
            temp[i] = Integer.toString(i) + ". " + GameData.dataPlayer.get(i-1).getNama();
        }
        PrinterStringVertical(temp);
    }
    
    /**
     * Method untuk menggambar option
     */
    private void DrawOption() {
        String[] temp = new String[6];
        temp[0] = "";
        temp[1] = "Choose Resolution";
        temp[2] = "1. Standard cmd size";
        temp[3] = "2. Maximized cmd size";
        temp[4] = "";
        temp[5] = "=";
        PrinterStringVertical(temp);
    }
    
    /**
     * Renderer CLI horizontal, PrinterString(String what, int mode), what adalah string yang akan digambar dan mode = 0 untuk spacing header dan 1 untuk spacing body
     */
    private void PrinterString(String what, int mode) { /* mode = space scaling */
        int width2 = width-2;
        if (what.equals("=")) {
            System.out.print("||");
            for(int i = 0; i < (width2-4);i++) System.out.print("=");
            System.out.print("||");
        } else {
            int spaces, spacebetween;
            if(mode == 1) spacebetween = width2 / 20;
            else spacebetween = 0;
            if (width2 % 2 == 0) {
                System.out.print("||");
            } else {
                System.out.print("|| ");
            }
            spaces = (width2 - (spacebetween * what.length()) - what.length() - 4) / 2;
            for (int i = 0; i < spaces; i++) {
                if(what.length() % 2 == 0 || i != spaces-1 || mode != 1 || width != 80) System.out.print(" ");
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
        }
        System.out.println();
    }
    
    /**
     * Renderer CLI vertikal, menerima array of string sebagai masukan
     */
    private void PrinterStringVertical(String[] what) {
        int entersbetween;
        entersbetween = (height - (5 + what.length)) / (what.length);
        for (int i = 0 ; i < what.length ; i++) {
            if(i == what.length-1 || i == 0) {
                entersbetween-=2;
            } else {
                entersbetween = (height - (5 + what.length)) / (what.length);
            }
            for (int j = 0; j < entersbetween; j++) PrinterString("",0);
            PrinterString(what[i], 0);
        }
    }
}
