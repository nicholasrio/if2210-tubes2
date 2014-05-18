/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameState;

import java.awt.Graphics;
import javagame.GameTime;
import javax.imageio.ImageIO;
import java.net.URL;
import java.awt.image.BufferedImage;
import java.io.File;
/**
 *
 * @author General User
 */
public class Help extends GameState{
    
    private int keyCode;
    private BufferedImage Text;
    
    public Help(GameStateManager gsm){
        super(gsm);
        name = "Help";
    }
    
    @Override
    public void initialize(){
        try{
            String path = "src/Resource/MainMenu/Text.png";
            Text = ImageIO.read(new File(path));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void terminate(){
        
    }
    
    @Override
    public void draw(GameTime gameTime, Graphics g){
        g.drawImage(Text, 100, 100, null);
    }
    
    @Override
    public void update(GameTime gameTime) {
        //do nothing
    }
    
    public void keyPressed(int k){
        if (keyCode == 27){
            gsm.switchScene("MainMenu");
        }
    }
    
    public void keyReleased(int k){
        //do nothing
    }
    
    public void keyTyped(int k){
        //do nothing
    }
}
