/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Opel Howard
 */
public class GUI {

    protected static JFrame mainFrame;
    protected static MyCanvas mainCanvas;

    public GUI() {
        System.setProperty("sun.awt.noerasebackground", "true");

        mainFrame = new JFrame();
        mainFrame.setTitle("Tower Defense");
        try {
            mainCanvas = new MyCanvas();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        mainCanvas.setPreferredSize(new Dimension(720, 380));
        mainFrame.add(mainCanvas);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);

        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    public void show() {
        mainFrame.setVisible(true);
    }
    public void hide() {
        mainFrame.setVisible(false);
    }
}

class MainMenuGUI extends GUI {

    public void showMenu() {
        mainCanvas.setListOfImage(new ArrayList<GUIComponent>());
        try {
            mainCanvas.addImage("background_mainmenu", 0, 0, 0);
            mainCanvas.addImage("newgame", 1, 0, 29);
            mainCanvas.addImage("loadgame", 2, 0, 86);
            mainCanvas.addImage("highscore", 3, 0, 143);
            mainCanvas.addImage("about", 4, 0, 200);
            mainCanvas.addImage("exit", 7, 0, 257);
            mainCanvas.addImage("towerDefense", 0, 420, 0);
            if ((TowerDefense.inputMenu == null) || (TowerDefense.inputMenu.equalsIgnoreCase(""))) {
                mainCanvas.addLabel("Hi Guest", 5, 15, 350, 100, 100, new Font("AR DECODE", Font.BOLD, 60));
            } else {
                mainCanvas.addLabel("Hi " + TowerDefense.inputMenu, 5, 50, 350, 100, 100, new Font("AR DECODE", Font.BOLD, 60));
                mainCanvas.addLabel("X", 6, 5, 350, 100, 100, new Font("AR DECODE", Font.BOLD, 60));
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        mainCanvas.repaint();
    }

    public void showHighScore(List<model.Player> listOfPlayers) {
        mainCanvas.setListOfImage(new ArrayList<GUIComponent>());
        try {
            mainCanvas.addImage("highscore_display", 0, 0, 0);
            int count = 0;
            for (model.Player P : listOfPlayers) {
                ++count;
                if (count == 5)
                    break;
                mainCanvas.addLabel(P.getName() + " " + P.getHighScore(), 0, 300, 80 + count * 30, 0, 0, new Font("AR DECODE", Font.BOLD, 30));
            }
            mainCanvas.addLabel("Exit", 6, 300, 350, 100, 100, new Font("AR DECODE", Font.BOLD, 60));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        mainCanvas.repaint();
    }

    class refreshInput extends Thread {

        public void run() {
            TowerDefense.inputMenu = "";

        }
    }

    public void showLogin(String str) {
        mainCanvas.setListOfImage(new ArrayList<GUIComponent>());
        TowerDefense.inputMenu = JOptionPane.showInputDialog(mainFrame, null, str, JOptionPane.QUESTION_MESSAGE);
        mainCanvas.repaint();
    }

    public int showChoice(String str) {
        mainCanvas.setListOfImage(new ArrayList<GUIComponent>());
        mainCanvas.repaint();
        return JOptionPane.showConfirmDialog(mainFrame, str, null, JOptionPane.YES_NO_OPTION);
    }
    
    public void showWarning(String str) {
        mainCanvas.setListOfImage(new ArrayList<GUIComponent>());
        mainCanvas.repaint();
        JOptionPane.showMessageDialog(mainFrame, str, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    public void showAbout() {
        mainCanvas.setListOfImage(new ArrayList<GUIComponent>());
        try {
            mainCanvas.addImage("about_us", 0, 0, 0);
            mainCanvas.addLabel("Exit", 6, 300, 350, 100, 100, new Font("AR DECODE", Font.BOLD, 60));
        } catch (IOException ex) {
            Logger.getLogger(MainMenuGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        mainCanvas.repaint();
    }
}
