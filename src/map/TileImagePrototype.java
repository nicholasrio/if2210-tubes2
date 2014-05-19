/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Calvin
 */
public class TileImagePrototype {
    
    static HashMap<Integer, Image> ImageMap = new HashMap<Integer, Image> ();
    public static int tileHeight = 32;
    public static int tileWidth = 32;
    static boolean hasLoadImage = false;
    
    public static Image getTileImage(int id) {
        if (!hasLoadImage) {
            try {
                loadCache();
                hasLoadImage = true;
            } catch (IOException ex) {
                Logger.getLogger(TileImagePrototype.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ImageMap.get(id); 
    }
    
    // for each shape run database query and create shape 
    // shapeMap.put(shapeKey, shape); 
    // for example, we are adding three shapes 
    public static void loadCache() throws IOException {
        TileImagePrototype P = new TileImagePrototype();
        Image Temp = Toolkit.getDefaultToolkit().getImage(P.getClass().getResource("resource/floor_concrete.png"));
        ImageMap.put(Tile.tileDirtFloor,Temp); 
        Temp = Toolkit.getDefaultToolkit().getImage(P.getClass().getResource("resource/floor_walkway.png"));
        ImageMap.put(Tile.tileCorridor,Temp);
        Temp = Toolkit.getDefaultToolkit().getImage(P.getClass().getResource("resource/wall_brick.png"));
        ImageMap.put(Tile.tileDirtWall,Temp);
        Temp = Toolkit.getDefaultToolkit().getImage(P.getClass().getResource("resource/wall_stone.png"));
        ImageMap.put(Tile.tileStoneWall,Temp);
        Temp = Toolkit.getDefaultToolkit().getImage(P.getClass().getResource("resource/gate_closed.png"));
        ImageMap.put(Tile.tileDoor,Temp);
        Temp = Toolkit.getDefaultToolkit().getImage(P.getClass().getResource("resource/stairs_up.png"));
        ImageMap.put(Tile.tileUpStairs,Temp);
        Temp = Toolkit.getDefaultToolkit().getImage(P.getClass().getResource("resource/stairs_down.png"));
        ImageMap.put(Tile.tileDownStairs,Temp);
        Temp = Toolkit.getDefaultToolkit().getImage(P.getClass().getResource("resource/gate_open.png"));
        ImageMap.put(Tile.tileDoor*10,Temp);
    }
}