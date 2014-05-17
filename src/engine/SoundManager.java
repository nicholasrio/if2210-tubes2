/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;

import java.util.ArrayList;
import javax.sound.sampled.*;
/**
 *
 * @author Winson
 */
public class SoundManager {
    public static ArrayList<Sound> sounds = new ArrayList<>();

    public static void Initialize(){
        sounds.clear();
    }
    
    public static void addSound(Sound sound){
        sounds.add(sound);
    }
    
    public static void removeSound(Sound sound){
        sounds.remove(sound);
    }
    
    public static void playSound(String name){
        for(Sound s : sounds){
            if(s.name.equals(name)){
                s.play();
            }
        }
    }
    
    public static void loopSound(String name){
        for(Sound s : sounds){
            if(s.name.equals(name)){
                s.loop();
            }
        }
    }
    
    public static void stopSound(String name){
        for(Sound s : sounds){
            if(s.name.equals(name)){
                s.stop();
            }
        }
    }
    
    public static void stopAllSound(String name){
        for(Sound s : sounds){
            s.stop();
        }
    }
    
    public static void setSFXVolume(float value){
        if (value<0f) value = 0f;
        if (value>100f) value = 100f;
        for(Sound s : sounds){
            if (s.type == Sound.SoundType.sfx){
                FloatControl volume = (FloatControl) s.clip.getControl(FloatControl.Type.MASTER_GAIN);
                float maxVal = volume.getMaximum();
                float minVal = volume.getMinimum();
                volume.setValue(minVal+value/100*(maxVal-minVal));
            }
        }
    }
    
    public static void setBGMVolume(float value){
        if (value<0f) value = 0f;
        if (value>100f) value = 100f;
        for(Sound s : sounds){
            if (s.type == Sound.SoundType.bgm){
                FloatControl volume = (FloatControl) s.clip.getControl(FloatControl.Type.MASTER_GAIN);
                float maxVal = volume.getMaximum();
                float minVal = volume.getMinimum();
                volume.setValue(minVal+value/100*(maxVal-minVal));
            }
        }
    }
}
