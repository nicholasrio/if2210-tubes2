/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.io.*;
/**
 *
 * @author Winson
 */
public class Sound {
    
    private static Sound staticSound = new Sound();
    
    public String name;
    public AudioClip sound;
    
    private Sound(){}
    
    public Sound(String name, URL url){
        this.name = name;
        try{
            sound = Applet.newAudioClip(url);
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
    }
    
    public void play(){
        new Thread(new Runnable(){
            public void run(){
                if(sound != null)
                    sound.play();
            }
        }).start();
    }
    
    public void loop(){
        new Thread(new Runnable(){
            public void run(){
                if(sound != null)
                    sound.loop();
            }
        }).start();
    } 
    
    public void stop(){
        if(sound != null)
            sound.stop();
    }
    
    public static URL getURL(String fileName){
        try{
            return new File("Sound/"+fileName).toURI().toURL();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
