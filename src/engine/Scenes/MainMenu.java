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
    private int currentplayer;
    public MainMenu()
    {
        super("MainMenu");
    }
    
    @Override
    public void Initialize()
    {
        height = 25; //57 height of half full screen, 25 is standard cmd size full screen
        width = 80; // full width of standard cmd screen and half full screen cmd size
        status = 0;
        currentplayer = 0;
        ReadPlayerNameXML();
    }
    
    @Override
    public void Update()
    {
        System.out.print("Enter your choice (0 for main menu): ");
        Scanner Sc = new Scanner(System.in);
        if(status == 0) {
            status = Sc.nextInt();
        } else if(status == 2) {
            status = 0;
            int temp = Sc.nextInt();
            if(temp != 0) currentplayer = temp-1;
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
    
    @Override
    public void Draw()
    {
       System.out.println();
       System.out.flush();
       if (status == 5) System.exit(0);
       DrawHeader();
       if(status == 0) {
       DrawBody();
       } else if (status == 1) {
           System.out.println("NEW GAME STUB");
       }
       else if (status == 2) {
           DrawChange();
       }
       else if (status == 3) {
           System.out.println("ACHIEVEMENT STUB");
       }
       else if (status == 4) {
           DrawOption();
       }
       
    }
    
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
    
    private void DrawChange() {
        String[] temp = new String[players.length+2];
        temp[0] = "Pilih user : ";
        temp[players.length+1] = "=";    
        for(int i = 1; i <= players.length;i++) {
            temp[i] = Integer.toString(i) + ". " + players[i-1];
        }
        PrinterStringVertical(temp);
    }
    
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
    
    private void ReadPlayerNameXML() {
        try {
 
	File fXmlFile = new File("player.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
 
	doc.getDocumentElement().normalize();
 
	NodeList nList = doc.getElementsByTagName("player");
 
        players = new String[nList.getLength()];
	for (int temp = 0; temp < nList.getLength(); temp++) {
		Node nNode = nList.item(temp);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			/*System.out.println("Player id : " + eElement.getAttribute("id"));
			System.out.println("Nama : " + eElement.getElementsByTagName("nama").item(0).getTextContent());
			System.out.println("Score : " + eElement.getElementsByTagName("score").item(0).getTextContent());
			System.out.println("Levelunlocked : " + eElement.getElementsByTagName("levelUnlocked").item(0).getTextContent());
			System.out.println("Achievement unlocked : " + eElement.getElementsByTagName("achievementUnlocked").item(0).getTextContent());*/
                        players[temp] = eElement.getElementsByTagName("nama").item(0).getTextContent();
		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
    }
}
