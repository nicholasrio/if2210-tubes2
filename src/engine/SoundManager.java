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
    public ArrayList<Sound> sounds = new ArrayList<>();
    
    public SoundManager(){
        sounds.clear();
    }
    
    public void addSound(Sound sound){
        sounds.add(sound);
    }
    
    public void removeSound(Sound sound){
        sounds.remove(sound);
    }
    
    public void playSound(String name){
        for(Sound s : sounds){
            if(s.name.equals(name)){
                s.play();
            }
        }
    }
    
    public void loopSound(String name){
        for(Sound s : sounds){
            if(s.name.equals(name)){
                s.loop();
            }
        }
    }
    
    public void stopSound(String name){
        for(Sound s : sounds){
            if(s.name.equals(name)){
                s.stop();
            }
        }
    }
    
    public void stopAllSound(String name){
        for(Sound s : sounds){
            s.stop();
        }
    }
    
    public void setSFXVolume(float value){
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
    
    public void setBGMVolume(float value){
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
