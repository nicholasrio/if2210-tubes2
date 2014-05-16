/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MapAndCharacter;

import character.Character;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import map.Tile;
import map.TileImagePrototype;

/**
 *
 * @author Calvin
 */
public class ViewerGUI {
    public static void view(Graphics g,MapAdapter MA){
        map.ViewerGUI.view(g,MA.getMap());
        //!!Gambar Orang Disini
        for (int i = 0; i < MA.getAllCharacter().size(); i++){
            Point pos = MA.getPos(i);
            Image CharImage = getImage(MA.getCharByIndeks(i));
            if (MA.getMap().isVisible(pos.x, pos.y)){
                g.drawImage(CharImage, pos.x*TileImagePrototype.tileWidth
                        , pos.y*TileImagePrototype.tileHeight, null);
            }
        }
    }
    
    public static void viewWithoutVisiblity(Graphics g,MapAdapter MA){
        map.ViewerGUI.viewWithoutVisiblity(g,MA.getMap());
        //!!Gambar Orang Disini
        for (int i = 0; i < MA.getAllCharacter().size(); i++){
            Point pos = MA.getPos(i);
            Image CharImage = getImage(MA.getCharByIndeks(i));
            g.drawImage(CharImage, pos.x*TileImagePrototype.tileWidth
                        , pos.y*TileImagePrototype.tileHeight, null);
        }
    }
    
    // menampilkan map mulai dengan posisi Left Top (x,y) 
    // dengan lebar dan tinggi yang bersesuaian
    public static void view(Graphics g,MapAdapter MA, int x1, int y1
                            ,int width, int height){
        map.ViewerGUI.view(g,MA.getMap(),x1,y1,width,height);
        //!!Gambar Orang Disini
        for (int i = 0; i < MA.getAllCharacter().size(); i++){
            Point pos = MA.getPos(i);
            Image CharImage = getImage(MA.getCharByIndeks(i));
            if (MA.getMap().isVisible(pos.x, pos.y)
                    && pos.x >= x1 && pos.x < x1+width
                    && pos.y >= y1 && pos.y < y1+height){
                g.drawImage(CharImage, (pos.x-x1)*TileImagePrototype.tileWidth
                        , (pos.y-y1)*TileImagePrototype.tileHeight, null);
            }
        }
    }

    //STUB
    private static Image getImage(Character C) {
        return TileImagePrototype.getTileImage(Tile.tileStoneWall);
    }
}
