/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.util.ArrayList;

/**
 *
 * @author Tony
 */
public class ImageLoader extends JPanel
{
    private static ArrayList<Image> allImages = new ArrayList<>();  
    
    private static Image loadImage(String path)
    {
        Image tes = null;
        tes = new ImageIcon(path).getImage();
        return tes;
    }
    
    public static void loadAllImages()
    {
        allImages.add(loadImage("Image/tes.png"));
    }
    
    public static Image getImage(String imgName)
    {
        if ("tes".equalsIgnoreCase(imgName))
        {
            return allImages.get(0);
        }
        return null;
    }
    
}
