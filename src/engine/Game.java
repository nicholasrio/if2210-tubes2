/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;

import engine.DataStructure.GameData;
import engine.Scenes.*;
import engine.GUIScenes.*;
import engine.Exception.SceneNotFoundException;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author Tony
 */
public class Game 
{
    static public boolean gameRunning = true;
    static public int mode; // 1 for CLI, 2 for GUI
    static public JFrame gameFrame = new JFrame();
    static public Graphics g = gameFrame.getGraphics();
    static public final int ResolutionWidth = 800;
    static public final int ResolutionHeight = 600;
    
    private Game()
    {
        // Choice Mode
        //mode = 2;
        
        GameData.loadMap();
        GameData.loadPlayer("player.xml");
        if (mode == 2)
        {
            ImageLoader.loadAllImages();
            prepareFrame();
        }
        
        PrepareScenes();
        gameLoop();
    }
    
    /**
     * Menyiapkan frame untuk game Cube Mazer
     */
    private static void prepareFrame()
    {
        gameFrame.setTitle("CubeMazer");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.pack();
        gameFrame.setSize(new Dimension(ResolutionWidth,ResolutionHeight));
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setResizable(true);
        gameFrame.setVisible(true);
    }
    
    /**
     * Me-load semua scene yang akan digunakan di dalam game.
     */
    private static void PrepareScenes()
    {
        SceneManager.Initialize();
        SoundManager.Initialize();
        if (mode == 1)
        {
            SceneManager.AddScene(new MainMenu());
            SceneManager.AddScene(new LevelMenu());
            SceneManager.AddScene(new GameMenu());
            try{
                SceneManager.SwitchScene("MainMenu");
            }catch(SceneNotFoundException e){
                e.printStackTrace();
            }
        }
        else if (mode == 2)
        {
            SceneManager.AddScene(new MainMenuGUI());
            SceneManager.AddScene(new LevelMenuGUI());
            SceneManager.AddScene(new GameMenuGUI());
            SceneManager.AddScene(new AchievementMenuGUI());
            SceneManager.AddScene(new OptionsMenuGUI());
            SceneManager.AddScene(new AboutMenuGUI());
            SceneManager.AddScene(new UserMenuGUI());
            SoundManager.addSound(new Sound("teleport","teleport.wav",Sound.SoundType.sfx));
            SoundManager.addSound(new Sound("coin","cling.wav",Sound.SoundType.sfx));
            SoundManager.addSound(new Sound("button","button.wav",Sound.SoundType.sfx));
            SoundManager.addSound(new Sound("fall","fall.wav",Sound.SoundType.sfx));
            SoundManager.addSound(new Sound("icebreak","icebreak.wav",Sound.SoundType.sfx));
            SoundManager.addSound(new Sound("impact","impact.wav",Sound.SoundType.sfx));
            SoundManager.addSound(new Sound("fbutton","futuristic_button.wav",Sound.SoundType.sfx));
            SoundManager.addSound(new Sound("glass","glass_break.wav",Sound.SoundType.sfx));
            SoundManager.addSound(new Sound("mainBm","MainMenu.au",Sound.SoundType.bgm));
            SoundManager.addSound(new Sound("levelBm","LevelMenu.au",Sound.SoundType.bgm));
            SoundManager.addSound(new Sound("lv1bm","Level1.au",Sound.SoundType.bgm));
            SoundManager.addSound(new Sound("lv2bm","Level2.au",Sound.SoundType.bgm));
            SoundManager.Initialize();
            try{
                SceneManager.SwitchScene("GameMenuGUI");
            }catch(SceneNotFoundException e){
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Memulai game
     */
    private static void gameLoop()
    {
        while(gameRunning) 
        { 
            long time = System.currentTimeMillis(); 
            final int fps = 40;
            
            SceneManager.Draw(); 
            SceneManager.Update(); 
                
            time = (1000 / fps) - (System.currentTimeMillis() - time); 
            if (time > 0) 
            { 
                try 
                { 
                    Thread.sleep(time); 
                } 
                catch(Exception e){} 
            } 
        }   
        GameData.savePlayer("player.xml");
        System.exit(0);
    }
    
    public static void main(String []args)
    {
        if(args.length == 0) {
            mode = 2;
        } else {
            mode = 1;
        }
        Game CubeMazer = new Game();
    }
}
