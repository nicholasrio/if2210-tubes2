/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package character;

import java.awt.image.BufferedImage;
import java.util.*;

public class ItemCache {
    public static HashMap<String,Item> itemCache = new HashMap<>();
    public static HashMap<String,BufferedImage> imageCache = new HashMap<>();
    private ItemCache() { }
    
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
    public static Item getItem(String itemName){
        if (itemCache.containsKey(itemName)){
            try {
                return itemCache.get(itemName).clone();
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
    private static void stubLoadItem(){
        Item item = new Item();
        item.setId(1);
        item.setName("CIU");
        item.setDescription("+1 str, +1 agi, +1 int");
        item.setStrAgiInt(1,1,1);
        itemCache.put("ironwood_branch",item);
    }
    /**
     * load the item from database
     */
    private static void loadItem(){
        
    }
}
