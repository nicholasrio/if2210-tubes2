/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 *
 * @author Opel Howard
 */
class MyCanvas extends Canvas implements MouseListener, KeyListener {

    private int currentIdx;
    private ArrayList<GUIComponent> listOfComponent;
    /**
    * the constructor
    * @author Opel Howard
    */
    public MyCanvas() throws IOException {
        //typing = "";
        this.addMouseListener(this);
        this.addKeyListener(this);
        currentIdx = -1;
    }

    public void addImage(String str, int _opt, int _x, int _y) throws IOException {
        ImageComponent temp = new ImageComponent(str, _opt);
        temp.setX(_x);
        temp.setY(_y);
        listOfComponent.add(temp);
    }

    public void addLabel(String str, int _opt, int _x, int _y, int _width, int _height, Font f) throws IOException {
        LabelComponent temp = new LabelComponent(str, _opt, f);
        temp.setX(_x);
        temp.setY(_y);
        temp.setWidth(_width);
        temp.setHeight(_height);
        listOfComponent.add(temp);
    }

    public ArrayList getListOfImage() {
        return listOfComponent;
    }

    public void setListOfImage(ArrayList _listOfImg) {
        listOfComponent = _listOfImg;
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics graphic) {
        for (GUIComponent it : listOfComponent) {
            if (it.isModified()) {
                if (it.getStatus().compareTo("label") == 0) {
                    LabelComponent temp = (LabelComponent) it;
                    graphic.setFont(temp.getFont());
                    graphic.setColor(Color.WHITE);
                    graphic.drawString(temp.getDisplayed(), temp.getX(), temp.getY());
                } else {
                    ImageComponent temp = (ImageComponent) it;
                    graphic.drawImage(temp.getDisplayed(), temp.getX(), temp.getY(), null);
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int count = 0;
        for (GUIComponent comp : listOfComponent) {
            if (comp.getOption() != 0) {
                if (comp.isInvoked(e.getX(), e.getY())) {
                    currentIdx = count;
                    if (comp.getStatus().compareTo("image") == 0) {
                        ((ImageComponent) comp).setDisplayed(((ImageComponent) comp).getClicked());
                    }
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
        GUIComponent comp = listOfComponent.get(currentIdx);
        if (comp.isInvoked(e.getX(), e.getY())) {
            try {
                comp.invoke();
            } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException ex) {
                ex.printStackTrace();
            }
        }

        if (comp.getStatus().compareTo("image") == 0) {
            ((ImageComponent) comp).setDisplayed(((ImageComponent) comp).getClicked());
        }
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
    public void keyTyped(KeyEvent ke) {
        System.out.println("hahaha");
        if (Character.isLetter(ke.getKeyChar())) {
            TowerDefense.inputMenu += ke.getKeyChar();
        } else if (ke.getKeyChar() == 8) {
            TowerDefense.inputMenu = TowerDefense.inputMenu.substring(0, TowerDefense.inputMenu.length() - 1);
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
