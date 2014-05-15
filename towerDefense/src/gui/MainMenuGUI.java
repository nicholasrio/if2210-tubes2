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
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Opel Howard
 */
public class MainMenuGUI {

    public void start() throws IOException {
        JFrame mainFrame = new JFrame();
        System.setProperty("sun.awt.noerasebackground", "true");
        //mainFrame.setLayout(new GridBagLayout());
        MyCanvas canvas = new MyCanvas();
        canvas.setPreferredSize(new Dimension(720, 380));
        canvas.addImage("background_mainmenu", 0, 0);
        canvas.addImage("newgame", 0, 29);
        canvas.addImage("loadgame", 0, 86);
        canvas.addImage("highscore", 0, 143);
        canvas.addImage("about", 0, 200);
        canvas.addImage("exit", 0, 257);
        //canvas.addImage("towerDefense.png", null, 400, 0);
        mainFrame.add(canvas);

        // set window button
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);

        mainFrame.pack();

        //mainFrame.setSize(new Dimension(720, 380));
        mainFrame.setVisible(true);
    }

    public static void main(String[] arg) {
        MainMenuGUI mmg = new MainMenuGUI();
        try {
            mmg.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
class MyCanvas extends Canvas implements MouseListener {
    private final ArrayList<ImgComp> listOfImg;
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
        for (ImgComp img : listOfImg) {
            if (img.getClicked() != null) {
                if (img.invoked(e.getX(), e.getY())) {
                    img.setDisplayed(img.getClicked());
                    repaint();
                }
            }
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        for (ImgComp img : listOfImg) {
            if (img.getUnclicked() != null) {
                if (img.invoked(e.getX(), e.getY())) {
                    img.setDisplayed(img.getUnclicked());
                    repaint();
                }
            }
        }
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
    public MyCanvas() throws IOException {
        listOfImg = new ArrayList<>();
        this.addMouseListener(this);
    }
    public void addImage(String str, int _x, int _y) throws IOException {
        ImgComp temp = new ImgComp(str);
        temp.setX(_x);
        temp.setY(_y);
        listOfImg.add(temp);
        
    }
    @Override
    public void paint(Graphics graphic) {
        for (ImgComp it : listOfImg) {
            //if (it.isModified()) {
                graphic.drawImage(it.getDisplayed(), it.getX(), it.getY(), this);
            //}
        }
    }
}
