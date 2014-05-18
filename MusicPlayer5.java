/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package musicplayer5;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.PlayerApplet;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;


/**
 *
 * @author Kevin Huang
 */
public class MusicPlayer5 implements Runnable {

    /**
     * @param args the command line arguments
     */
    private static int pausedOnFrame = 0;
    public int GetPausedFrame()
    {
        return  pausedOnFrame;
    }
    public void SetPausedOnFrame(int i)
    {
         pausedOnFrame = i;
    }
    private AdvancedPlayer player;
    public AdvancedPlayer GetPlayer()
    {
        return player;
    }
    public MusicPlayer5()
    {
        
    }
    public MusicPlayer5(String path) throws FileNotFoundException, JavaLayerException
    {
        FileInputStream fis = new FileInputStream(path);
        player = new AdvancedPlayer(fis);

    }
    public void SetPath(String path) throws FileNotFoundException, JavaLayerException
    {
       FileInputStream fis = new FileInputStream(path);
       player = new AdvancedPlayer(fis);
    }
    public synchronized void run()
    {
        if(player!=null)
        {
            try {
                player.play(pausedOnFrame,Integer.MAX_VALUE);
            } catch (JavaLayerException ex) {
                Logger.getLogger(MusicPlayer5.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }
    
}
