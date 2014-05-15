/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package character;

import java.util.HashMap;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.net.URL;

/**
 *
 * @author yafithekid
 */
public class CharacterCache {
    /**
     * contains unique character. need to be cloned to get instance.
     */
    public static HashMap<String,Character> characterCache = new HashMap<>();
    /**
     * the image related to the character.
     */
    public static HashMap<String,BufferedImage> image = new HashMap<>();
    
    private CharacterCache() { }
    
    /**
     * load all available resources and reset the cache.
     */
    public static void loadCache(){
        stubLoadItem();
    }

    /**
     * get a clone of item from cache
     * use like getItem("CIRCLE")
     * @param itemName the name item
     * @return new item if exist, null if not.
     */
    public static Character getItem(String itemName){
        if (characterCache.containsKey(itemName)){
            try {
                return characterCache.get(itemName).clone();
            } catch (CloneNotSupportedException e){
                return null;
            }
        } else {
            return null;
        }
    }
    /**
     * stub for load item
     */
    public static void stubLoadItem(){
        Character character = new Hero();
        
    }
}
