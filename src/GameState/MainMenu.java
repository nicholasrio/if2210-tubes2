/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameState;

import java.awt.Graphics;
import java.io.IOException;
import javagame.GameTime;
import javagame.ResizeImage;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
/**
 *
 * @author Luqman
 */
public class MainMenu extends GameState{
    private int posX;
    private int posY;
    
    private int keyCode;
    
    private BufferedImage startImage;
    private BufferedImage exitImage;
    private BufferedImage helpImage;
    private BufferedImage cursorImage;
    
    private enum MenuState{
        Start,
        Help,
        Exit;
    }
    
    private MenuState menuState;
    
    private boolean isStateChange = false;
  
    /**
     * constructor MainMenu
     * @param gsm is gamestatemanager
     */
    public MainMenu(GameStateManager gsm)
    {
        super(gsm);
        name = "MainMenu";
    }
    
    @Override
    public void initialize() {
        posX = 0;
        posY = 100;
        menuState = MenuState.Start;
        String url = null;
        try{
            url = "src/Resource/MainMenu/Start.png";
            startImage = ImageIO.read(new File(url));
            url = "src/Resource/MainMenu/exit.png";
            exitImage = ImageIO.read(new File(url));
            url = "src/Resource/MainMenu/help.png";
            helpImage = ImageIO.read(new File(url));

            url = "src/Resource/MainMenu/cursor.png";
            cursorImage = ImageIO.read(new File(url));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        try{
            startImage = new ResizeImage().resizeImage(startImage, 100, 50);
            exitImage = new ResizeImage().resizeImage(exitImage, 100, 50);
            helpImage = new ResizeImage().resizeImage(helpImage, 100, 50);
            cursorImage = new ResizeImage().resizeImage(cursorImage, 50, 50);
        }
        catch(IOException e){
            System.out.println("Cannot resize the image" + e.getMessage());
        }
    }

    @Override
    public void terminate() {
        
    }

    /**
     * method for drawing to form
     * @param gameTime is GameTime
     * @param g is Graphics
     */
    @Override
    public void draw(GameTime gameTime, Graphics g) {
        //System.out.println("draw");
        g.drawImage(startImage, 350, 100, null);
        g.drawImage(helpImage, 350, 200, null);
        g.drawImage(exitImage, 350, 300, null);
        g.drawImage(cursorImage, 450, posY, null);
    }

    @Override
    public void update(GameTime gameTime) {
        //System.out.println("update");
        if (keyCode != -1 && !isStateChange){
            isStateChange = true;
        }
    }
    
    public void keyPressed(int k){
        keyCode = k;

        if (menuState == MenuState.Start){
            if (keyCode == 38){
                posY = 300;
                menuState = MenuState.Exit;
                System.out.println("Exit");
            }
            else if (keyCode == 40){
                posY = 200;
                menuState = MenuState.Help;
                System.out.println("Help");
            }
            else if (keyCode == 10){
                //panggil kelas game
                //cara panggil kelas game
                //class game harus extends scene agar bisa dimasukan ke array of scene
                //misal nama class adalah Game
                //nama scene nya adalah "Game" (nama scene sudah ada di class scene
                //masukan class Game (class game harus extend scene) ke dalam array of scene dalam class riseofyuu
                //class riseofyuu dijadiin static dalam main.java jadinya biar bisa dipanggil dimana-mana (mau bikin setter getter susah soalnya ada di main)
                //nama static variable riseofyuu yang dipake adalah 'game' (check Main.java)
                //contoh pemanggilannya ada dibawah ini
                //==========================================================================
                gsm.switchScene("PlayGameState");
                
                System.out.println("Enter");
            }
        }
        else if (menuState == MenuState.Help){
            if (keyCode == 38){
                posY = 100;
                menuState = MenuState.Start;
                System.out.println("Start");
            }
            else if (keyCode == 40){
                posY = 300;
                menuState = MenuState.Exit;
                System.out.println("Exit");
            }
            else if (keyCode == 10){
                //panggil kelas help
                System.out.println("Enter");
                gsm.switchScene("Help");
            }
        }
        else if (menuState == MenuState.Exit){
            if (keyCode == 38){
                posY = 200;
                menuState = MenuState.Help;
                System.out.println("Help");
            }
            else if (keyCode == 40){
                posY = 100;
                menuState = MenuState.Start;
                System.out.println("Start");
            }
            else if (keyCode == 10){
                //panggil exit
                System.out.println("Enter");
                gsm.switchScene("Exit");
                System.exit(1);
            }
        }
    }
    
    public void keyReleased(int k){
        //do nothing
    }
    
    public void keyTyped(int k){
        //do nothing
    }
}
