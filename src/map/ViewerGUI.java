/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Calvin
 */
public class ViewerGUI {
    public static void view(Graphics g,Map M){
        try {
            TileImagePrototype.loadCache();
            } catch (IOException ex) {
                Logger.getLogger(ViewerGUI.class.getName()).log(Level.SEVERE, null, ex);
            
}
        for (int i = 0; i < M.xsize; i++){
            for (int j = 0; j < M.ysize; j++){
                if (!M.isVisible(i, j)) {
                    g.fillRect(i*TileImagePrototype.tileWidth, j*TileImagePrototype.tileHeight,TileImagePrototype.tileWidth, TileImagePrototype.tileHeight);
                }
                else g.drawImage(TileImagePrototype.getTileImage(M.getCell(i, j).getId())
                        , i*TileImagePrototype.tileWidth, j*TileImagePrototype.tileHeight, null);
            }
        }
    }
    
    public static void viewWithoutVisiblity(Graphics g,Map M){
        try {
            TileImagePrototype.loadCache();
            } catch (IOException ex) {
                Logger.getLogger(ViewerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        for (int i = 0; i < M.xsize; i++){
            for (int j = 0; j < M.ysize; j++){
                g.drawImage(TileImagePrototype.getTileImage(M.getCell(i, j).getId())
                        , i*TileImagePrototype.tileWidth, j*TileImagePrototype.tileHeight, null);
            }
        }
    }
    
    // menampilkan map mulai dengan posisi Left Top (x,y) 
    // dengan lebar dan tinggi yang bersesuaian
    public static void view(Graphics g,Map M, int x1, int y1
                            ,int width, int height){
        assert(x1+width+1 <= M.xsize);
        assert(y1+height+1 <= M.ysize);
        assert(width > 0);
        assert(height > 0);
        try {
            TileImagePrototype.loadCache();
            } catch (IOException ex) {
                Logger.getLogger(ViewerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        for (int i = x1; i < x1+width; i++){
            for (int j = y1; j < y1+height; j++){
                if (!M.isVisible(i, j)) {
                    g.fillRect((i-x1)*TileImagePrototype.tileWidth, (j-y1)*TileImagePrototype.tileHeight,TileImagePrototype.tileWidth, TileImagePrototype.tileHeight);
                }
                else g.drawImage(TileImagePrototype.getTileImage(M.getCell(i, j).getId())
                        , (i-x1)*TileImagePrototype.tileWidth, (j-y1)*TileImagePrototype.tileHeight, null);
            }
        }
    }
}
