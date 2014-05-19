/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javagame;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author General User
 */
public class ImageLoader {
    private BufferedImage image;

    public ImageLoader(String url){
       try {                
            image = ImageIO.read(new File(url));
       } catch (IOException ex) {
            System.out.println("Cannot open the file");
       }
    }
    
    public BufferedImage getImage(){
        return image;
    }
    
    public void setBufferedImage(BufferedImage img){
        image = img;
    }
    
    public void setImage(String url){
        try {                
            image = ImageIO.read(new File(url));
       } catch (IOException ex) {
            System.out.println("Cannot open the file");
       }
    }
}
