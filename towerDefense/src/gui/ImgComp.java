/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Opel Howard
 */
public class ImgComp {

    final private BufferedImage img_unclicked;
    final private BufferedImage img_clicked;
    private BufferedImage img_displayed;
    private int x;
    private int y;
    private boolean dirtyBit;

    public ImgComp(String str) throws IOException {
        if (new File(str+".png").exists())
            img_displayed = ImageIO.read(new File(str+".png"));
        
        if (new File(str+"_unclicked.png").exists())
            img_displayed = img_unclicked = ImageIO.read(new File(str+"_unclicked.png"));
        else
            img_unclicked = null;
        if (new File(str+"_clicked.png").exists())
            img_clicked = ImageIO.read(new File(str+"_clicked.png"));
        else
            img_clicked = null;
        
        dirtyBit = true;
    }

    public void setDisplayed(BufferedImage _img_diplayed) {
        dirtyBit = true;
        img_displayed = _img_diplayed;
    }

    public BufferedImage getClicked() {
        return img_clicked;
    }

    public BufferedImage getUnclicked() {
        return img_unclicked;
    }

    public BufferedImage getDisplayed() {
        dirtyBit = false;
        return img_displayed;
    }

    public void setX(int _x) {
        x = _x;
    }

    public void setY(int _y) {
        y = _y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isModified() {
        return dirtyBit;
    }

    public boolean invoked(int _x, int _y) {
        if ((x < _x) && (_x < x + img_displayed.getWidth()) && ((y < _y) && (_y < y + img_displayed.getHeight()))) {
            return true;
        }
        return false;
    }   
}