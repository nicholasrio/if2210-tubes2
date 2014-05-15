/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Opel Howard
 */
public class GUI {
    public static JFrame mainFrame;
    public static MyCanvas mainCanvas;
    public static void main(String[] arg) throws IOException {
        System.setProperty("sun.awt.noerasebackground", "true");

        mainFrame = new JFrame();
        mainCanvas = new MyCanvas();
        mainCanvas.setPreferredSize(new Dimension(720, 380));
        mainFrame.add(mainCanvas);
        
        MainMenuGUI mmg = new MainMenuGUI();
        mmg.run();
        /*try {
            mmg.run();
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
    }
}
class MainMenuGUI {
    public void run() {
        GUI.mainCanvas.setListOfImage(new ArrayList<ImgComp>());
        try {
            GUI.mainCanvas.addImage("background_mainmenu", null, 0, 0);
            GUI.mainCanvas.addImage("newgame", null, 0, 29);
            GUI.mainCanvas.addImage("loadgame", null, 0, 86);
            GUI.mainCanvas.addImage("highscore", HighScoreGUI.class, 0, 143);
            GUI.mainCanvas.addImage("about", null, 0, 200);
            GUI.mainCanvas.addImage("exit", Exit.class, 0, 257);
            GUI.mainCanvas.addImage("towerDefense", null, 420, 0);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // set window button
        GUI.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.mainFrame.setResizable(false);

        GUI.mainFrame.pack();

        //mainFrame.setSize(new Dimension(720, 380));
        GUI.mainFrame.setVisible(true);
    }
}

class HighScoreGUI {
    public void run() {
        GUI.mainCanvas.setListOfImage(new ArrayList<ImgComp>());
        try {
            GUI.mainCanvas.addImage("highscore_display", null, 0, 0);
            GUI.mainCanvas.addImage("exit", MainMenuGUI.class, 200, 200);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class Exit {

    public void run() {
        System.exit(0);
    }
}

class MyCanvas extends Canvas implements MouseListener {

    private int currentIdx;
    private ArrayList<ImgComp> listOfImg;

    public MyCanvas() throws IOException {
        this.addMouseListener(this);
        currentIdx = -1;
    }

    public void addImage(String str, Class _class, int _x, int _y) throws IOException {
        ImgComp temp = new ImgComp(str, _class);
        temp.setX(_x);
        temp.setY(_y);
        listOfImg.add(temp);
    }

    public ArrayList getListOfImage() {
        return listOfImg;
    }

    public void setListOfImage(ArrayList _listOfImg) {
        listOfImg = _listOfImg;
    }

    @Override
    public void paint(Graphics graphic) {
        for (ImgComp it : listOfImg) {
            if (it.isModified()) {
                graphic.drawImage(it.getDisplayed(), it.getX(), it.getY(), this);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int count = 0;
        for (ImgComp img : listOfImg) {
            if (img.getClicked() != null) {
                if (img.isInvoked(e.getX(), e.getY())) {
                    currentIdx = count;
                    img.setDisplayed(img.getClicked());
                    repaint();
                }
            }
            ++count;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (currentIdx == -1) {
            return;
        }
        ImgComp img = listOfImg.get(currentIdx);
        if (img.isInvoked(e.getX(), e.getY())) {
            try {
                img.invoke();
            } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException ex) {
                Logger.getLogger(MyCanvas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        img.setDisplayed(img.getUnclicked());
        currentIdx = -1;
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }
}
