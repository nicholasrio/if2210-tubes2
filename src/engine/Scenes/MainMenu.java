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
    public MainMenu()
    {
        super("MainMenu");
    }
    
    @Override
    public void Initialize()
    {
        height = 57; //57 height of half full screen, 25 is standard cmd size full screen
        width = 80; // full width of standard cmd screen and half full screen cmd size
        status = 0;     
        ReadPlayerNameXML();
    }
    
    @Override
    public void Update()
    {
        Draw();
        System.out.print("Enter your choice: ");
        Scanner Sc = new Scanner(System.in);
        status = Sc.nextInt();
    }
    
    @Override
    public void Draw()
    {
       System.out.println();
       System.out.flush();
       DrawHeader();
       if(status == 0) {
       DrawBody();
       } else if (status == 1) {
           
       }
       else if (status == 2) {
           DrawChange();
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
        String[] Body = new String[6];
        Body[0] = "1 NEW GAME/CONTINUE GAME";
        Body[1] = "2 CHANGE USER";
        Body[2] = "3 ACHIEVEMENT";
        Body[3] = "4 OPTION";
        Body[4] = "5 EXIT";
        Body[5] = "=";
        PrinterStringVertical(Body);
    }
    
    private void DrawChange() {
        PrinterStringVertical(players);
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
        if (height > 25) entersbetween = (height - (5 + what.length)) / (what.length);
        else entersbetween = 2;
        for (int i = 0 ; i < what.length ; i++) {
            if(i == what.length-1 || i == 0) {
                entersbetween--;
            } else {
                if (height > 25) entersbetween = (height - (5 + what.length)) / (what.length);
                else entersbetween = 2;
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
 
        players = new String[nList.getLength()+2];
        players[0] = "Pilih user : ";
        players[nList.getLength()+1] = "=";        
	for (int temp = 0; temp < nList.getLength(); temp++) {
		Node nNode = nList.item(temp);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			/*System.out.println("Player id : " + eElement.getAttribute("id"));
			System.out.println("Nama : " + eElement.getElementsByTagName("nama").item(0).getTextContent());
			System.out.println("Score : " + eElement.getElementsByTagName("score").item(0).getTextContent());
			System.out.println("Levelunlocked : " + eElement.getElementsByTagName("levelUnlocked").item(0).getTextContent());
			System.out.println("Achievement unlocked : " + eElement.getElementsByTagName("achievementUnlocked").item(0).getTextContent());*/
                        players[temp+1] = Integer.toString(Integer.valueOf(eElement.getAttribute("id"))+1) + ". " + eElement.getElementsByTagName("nama").item(0).getTextContent();
		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
    }
}
