/**
 *
 * @author 
 * Darwin Prasetio (13512015)
 * Chrestella Stephanie (13512005)
 * Jan Wira Gotama Putra (13512015)
 * Eric (13512021)
 * Willy(13512070)
 * Melvin Fonda (13512085)
 */

package monster;

/**
 *
 * @author user
 */
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JComponent;

public class Monster {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Monster");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.add(new TrainCanvas());
        
        frame.setVisible(true);
    }

}

class TrainCanvas extends JComponent {
    public static int TempN=0;
    private int lastX = 0;
    private int lastY = 0;
   private Timer timer;
    
    public TrainCanvas() {
        Thread animationThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    
                    repaint();
                    
                    try {Thread.sleep(10);} catch (Exception ex) {}
                }
            }
        });

        animationThread.start();
        Thread animationThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    
                    TempN++;
                    
                    try {Thread.sleep(200);} catch (Exception ex) {}
                }
            }
        });

        animationThread2.start();
        
        
    }

    @Override
         public void paintComponent(Graphics g) {
        Graphics2D gg = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();
        int trainW=100;
        int x = lastX;
        int y = lastY;
        int Speed = 1;
        int temp = 2;
        if(temp == 1)
        {
           x  += Speed;
            
        }
        else if (temp == 2)
        {
            y  += Speed;
        }
        else if (temp == 4)
        {
            x  -= Speed;
        }
        else if (temp == 8)
        {
            y  -= Speed;
        }
        

        if (x > w + trainW) {
            x = 0;
        }
        
        
        BufferedImage bigImg = null;
        try {
            bigImg = ImageIO.read(new File("img/monster.png"));
        } catch (IOException ex) {
            Logger.getLogger(TrainCanvas.class.getName()).log(Level.SEVERE, null, ex);
        }
        final int width = 50;
        final int height = 60;
        final int rows = 5;
        final int cols = 5;
        BufferedImage[] sprites = new BufferedImage[rows * cols];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                sprites[(i * cols) + j] = bigImg.getSubimage(
                    j * width,
                    i * height,
                    width,
                    height
                );
            }
        }
        gg.drawImage(sprites[TempN%5], x, y, this);
        gg.drawImage(sprites[TempN%5], x, y+70, this);
//        gg.setColor(Color.BLACK);
//        gg.fillRect(x, h/2 + trainH, trainW, trainH);

        lastX = x;
        lastY = y;
    }

}


