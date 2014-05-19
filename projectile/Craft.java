package javaapplication9;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;

public class Craft {

    private String craft = "bola.png";
    private static final int STEPS = 400;
    private static final long INTERVAL = 500;
    private static final long STEP_INTERVAL = INTERVAL/STEPS;
    private int endX=100,startX=0,endY=100,startY=0;
    private int stepX = (endX - startX)/STEPS, stepY = (endY - startY)/STEPS;
    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;

    public Craft() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft));
        image = ii.getImage();
        x = 40;
        y = 60;
    }


    public void move() throws InterruptedException {
        
            x +=1;
            y+=1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

/*    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }*/
} 