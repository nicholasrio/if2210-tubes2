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
    
    private static float bgmVol;
    private static float sfxVol;
    
    public static void Initialize(){
        setSFXVolume(90f);
        setBGMVolume(80f);
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
    
    public static void stopAllSound(){
        for(Sound s : sounds){
            s.stop();
        }
    }
    
    public static void stopAllBGMSound(){
        for(Sound s : sounds){
            if (s.type == Sound.SoundType.bgm){
                s.stop();
            }
        }
    }
    
    public static void setSFXVolume(float value){
        if (value<0f) value = 0f;
        if (value>100f) value = 100f;
        sfxVol = value;
        for(Sound s : sounds){
            if (s.type == Sound.SoundType.sfx){
                FloatControl volume = (FloatControl) s.clip.getControl(FloatControl.Type.MASTER_GAIN);
                float maxVal = volume.getMaximum();
                float minVal = volume.getMinimum();
                volume.setValue(minVal+sfxVol/100*(maxVal-minVal));
            }
        }
    }
    
    public static void setBGMVolume(float value){
        if (value<0f) value = 0f;
        if (value>100f) value = 100f;
        bgmVol = value;
        for(Sound s : sounds){
            if (s.type == Sound.SoundType.bgm){
                FloatControl volume = (FloatControl) s.clip.getControl(FloatControl.Type.MASTER_GAIN);
                float maxVal = volume.getMaximum();
                float minVal = volume.getMinimum();
                volume.setValue(minVal+bgmVol/100*(maxVal-minVal));
            }
        }
    }
    
    public static float getSFXVolume(){
        return sfxVol;
    }
    
    public static float getBGMVolume(){
        return bgmVol;
    }
}
