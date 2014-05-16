/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;
import java.util.*;

/**
 *
 * @author Calvin
 */
public class TilePrototype {
    private static HashMap<Integer, Tile> TileMap = new HashMap<Integer, Tile>(); 
    public static Tile getTile(int id) {
        Tile cachedShape = TileMap.get(id);
        return cachedShape.copy(); 
    }
    
    // for each shape run database query and create shape 
    // shapeMap.put(shapeKey, shape); 
    // for example, we are adding three shapes 
    public static void loadCache() { 
        Tile Temp = new tileChest();
        TileMap.put(Temp.getId(),Temp); 
        Temp = new tileCorridor();
        TileMap.put(Temp.getId(),Temp); 
        Temp = new tileDirtFloor();
        TileMap.put(Temp.getId(),Temp); 
        Temp = new tileDirtWall();
        TileMap.put(Temp.getId(),Temp); 
        Temp = new tileDoor();
        TileMap.put(Temp.getId(),Temp); 
        Temp = new tileDownStairs();
        TileMap.put(Temp.getId(),Temp);
        Temp = new tileStoneWall();
        TileMap.put(Temp.getId(),Temp);
        Temp = new tileUnused();
        TileMap.put(Temp.getId(),Temp);
        Temp = new tileUpstair();
        TileMap.put(Temp.getId(),Temp);
    } 
}

