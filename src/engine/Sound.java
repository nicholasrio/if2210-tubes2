/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;

import javax.sound.sampled.*;
import java.io.*;
/**
 *
 * @author Winson
 */
public class Sound {

    public static enum SoundType {bgm,sfx};
    
    public String name;
    public Clip clip;
    public SoundType type;
    
    public Sound(String name, String fileName, SoundType type){
        this.name = name;
        this.type = type;
        try{
            File file = new File("Sound/"+fileName);
            if(file.exists()){
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(sound);
            }else
                throw new RuntimeException("Sound file not found : Sound/"+fileName);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void play(){
        new Thread(new Runnable(){
            public void run(){
                if(clip != null){
                    clip.setFramePosition(0);
                    clip.start();
                }
            }
        }).start();
    }
    
    public void loop(){
        new Thread(new Runnable(){
            public void run(){
                if(clip != null){
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                }
            }
        }).start();
    } 
    
    public void stop(){
        if(clip != null)
            clip.stop();
    }
   
}
