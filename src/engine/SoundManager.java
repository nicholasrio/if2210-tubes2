/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;

import java.util.ArrayList;
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
}
