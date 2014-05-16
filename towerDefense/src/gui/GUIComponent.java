/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.imageio.ImageIO;

/**
 *
 * @author Opel Howard
 */
public class ImgComp {

    private final BufferedImage img_unclicked;
    private final BufferedImage img_clicked;
    private BufferedImage img_displayed;
    private int x;
    private int y;
    private final Class event;
    private boolean dirtyBit;

    public ImgComp(String str, Class _event) throws IOException {
        if (new File("img\\"+str+".png").exists())
            img_displayed = ImageIO.read(new File("img\\"+str+".png"));
        
        if (new File("img\\"+str+"_unclicked.png").exists())
            img_displayed = img_unclicked = ImageIO.read(new File("img\\"+str+"_unclicked.png"));
        else
            img_unclicked = null;
        if (new File("img\\"+str+"_clicked.png").exists())
            img_clicked = ImageIO.read(new File("img\\"+str+"_clicked.png"));
        else
            img_clicked = null;
        event = _event;
        
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

    public boolean isInvoked(int _x, int _y) {
        return (x < _x) && (_x < x + img_displayed.getWidth()) && ((y < _y) && (_y < y + img_displayed.getHeight()));
    }
    public void invoke() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        if (event != null) {
            Class[] interfaces = event.getInterfaces();
            boolean isThread = false;
            for (Class implement : interfaces) {
                if (implement == Runnable.class)
                    isThread = true;
            }
            if (isThread)
                new Thread((Runnable) event.newInstance()).start();
            else {
                event.getMethod("run", null).invoke(event.newInstance(), null);
            }
        }
    }
}