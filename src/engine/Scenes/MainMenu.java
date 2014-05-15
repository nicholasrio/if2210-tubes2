/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.Scenes;
import engine.*;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

/**
 *
 * @author Michael
 */
public class MainMenu extends Scene
{
    private int height;
    private int width;
    private int status;
    private String[] players;
    private String[] playersscore;
    private String[] playerslevel;
    private String[] playersachievement;
    private int currentplayer;
    
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
        height = 25; //57 height of half full screen, 25 is standard cmd size full screen
        width = 80; // full width of standard cmd screen and half full screen cmd size
        status = 0;
        currentplayer = 0;
        ReadPlayerDataXML();
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
        else if(status == 1) {
            status = 0;
            SceneManager.SwitchScene("LevelMenu");
        }
        else if(status == 2) {
            status = 0;
            int temp = Sc.nextInt();
            if(temp != 0) currentplayer = temp-1;
        }
        else if (status == 3) {
            status = 0;
            Sc.nextInt();
        }
        else if (status == 4) {
            status = 0;
            int temp = Sc.nextInt();
            if(temp != 0) {
                if(temp == 1) height = 25;
                if(temp == 2) height = 57;
            }
        }
    }
    
    /**
     * Draw ke layar
     */
    @Override
    public void Draw()
    {
       for (int i = 0; i < 100; i++) System.out.println();
       System.out.flush();
       if (status == 5) System.exit(0);
       else if (status == 1) SceneManager.SwitchScene("LevelMenu");
       DrawHeader();
       if(status == 0) {
       DrawBody();
       }
       else if (status == 2) {
           DrawChange();
       }
       else if (status == 3) {
           DrawAchievement();
       }
       else if (status == 4) {
           DrawOption();
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
        Body[0] = "Welcome " + players[currentplayer];
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
        String[] temp = new String[players.length+2];
        temp[0] = "Pilih user : ";
        temp[players.length+1] = "=";    
        for(int i = 1; i <= players.length;i++) {
            temp[i] = Integer.toString(i) + ". " + players[i-1];
        }
        PrinterStringVertical(temp);
    }
    
    /**
     * Method untuk menggambar data player
     */
    private void DrawAchievement() {
        String[] temp = new String[6];
        temp[0] = "Player Data";
        temp[1] = "Name : " + players[currentplayer];
        temp[2] = "Score: " + playersscore[currentplayer];
        temp[3] = "Level: " + playerslevel[currentplayer];
        temp[4] = "Achievement Unlocked: " + playersachievement[currentplayer];
        temp[5] = "=";
        PrinterStringVertical(temp);
    }
    
    /**
     * Method untuk menggambar option
     */
    private void DrawOption() {
        String[] temp = new String[6];
        temp[0] = "Choose Resolution";
        temp[1] = "";
        temp[2] = "1. Standard cmd size";
        temp[3] = "";
        temp[4] = "2. Maximized cmd size";
        temp[5] = "=";
        PrinterStringVertical(temp);
    }
    
    /**
     * Renderer CLI horizontal, PrinterString(String what, int mode), what adalah string yang akan digambar dan mode = 0 untuk spacing header dan 1 untuk spacing body
     */
    private void PrinterString(String what, int mode) { /* mode = space scaling */
        if (what.equals("=")) {
            System.out.print("||");
            for(int i = 0; i < (width-4);i++) System.out.print("=");
            System.out.print("||");
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
        }
    }
    
    /**
     * Renderer CLI vertikal, menerima array of string sebagai masukan
     */
    private void PrinterStringVertical(String[] what) {
        int entersbetween;
        entersbetween = (height - (5 + what.length)) / (what.length);
        for (int i = 0 ; i < what.length ; i++) {
            if(i == what.length-1 || i == 0) {
                entersbetween--;
            } else {
                entersbetween = (height - (5 + what.length)) / (what.length);
            }
            for (int j = 0; j < entersbetween; j++) PrinterString("",0);
            PrinterString(what[i], 0);
        }
    }
    
    /**
     * Pembacaan data player dari file
     */
    private void ReadPlayerDataXML() {
        try {
 
	File fXmlFile = new File("player.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
 
	doc.getDocumentElement().normalize();
 
	NodeList nList = doc.getElementsByTagName("player");
 
        players = new String[nList.getLength()];
        playersscore = new String[nList.getLength()];
        playerslevel = new String[nList.getLength()];
        playersachievement = new String[nList.getLength()];
	for (int temp = 0; temp < nList.getLength(); temp++) {
		Node nNode = nList.item(temp);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    players[temp] = eElement.getElementsByTagName("nama").item(0).getTextContent();
                    playersscore[temp] = eElement.getElementsByTagName("score").item(0).getTextContent();
                    playerslevel[temp] = eElement.getElementsByTagName("levelUnlocked").item(0).getTextContent();
                    playersachievement[temp] = eElement.getElementsByTagName("achievementUnlocked").item(0).getTextContent();
		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
    }
}
