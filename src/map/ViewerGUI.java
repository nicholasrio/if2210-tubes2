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

    /**
     * view to GUI without visibility
     * @param g graphic device
     * @param M the map to be printed.
     */
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
                    continue;
                }
                if (M.getCell(i, j).isOpenable()){
                    if(((Openable)M.getCell(i, j)).isOpen()){
                        g.drawImage(TileImagePrototype.getTileImage(M.getCell(i, j).getId()*10)
                        , i*TileImagePrototype.tileWidth, j*TileImagePrototype.tileHeight, null);
                    }
                    continue;
                }
                g.drawImage(TileImagePrototype.getTileImage(M.getCell(i, j).getId())
                        , i*TileImagePrototype.tileWidth, j*TileImagePrototype.tileHeight, null);
            }
        }
    }
    
    /**
     * view the map to GUI with visibility
     * @param g graphic device
     * @param M map to be printed.
     */
    public static void viewWithoutVisiblity(Graphics g,Map M){
        try {
            TileImagePrototype.loadCache();
            } catch (IOException ex) {
                Logger.getLogger(ViewerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        for (int i = 0; i < M.xsize; i++){
            for (int j = 0; j < M.ysize; j++){
                if (M.getCell(i, j).isOpenable()){
                    if(((Openable)M.getCell(i, j)).isOpen()){
                        g.drawImage(TileImagePrototype.getTileImage(M.getCell(i, j).getId()*10)
                        , i*TileImagePrototype.tileWidth, j*TileImagePrototype.tileHeight, null);
                        continue;
                    }
                }
                g.drawImage(TileImagePrototype.getTileImage(M.getCell(i, j).getId())
                        , i*TileImagePrototype.tileWidth, j*TileImagePrototype.tileHeight, null);
            }
        }
    }
    
    // menampilkan map mulai dengan posisi Left Top (x,y) 
    // dengan lebar dan tinggi yang bersesuaian

    /**
     * show map from left top (x,y) with specific width and height.
     * @param g graphic device
     * @param M map to be printed
     * @param x1 x-pos
     * @param y1 y-pos
     * @param width width
     * @param height height
     */
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
        for (int i = (int)(x1/32); i < Math.min((int)(x1+width)/32+3,M.xsize-1); i++){
            for (int j = (int)(y1/32); j < Math.min((int)(y1+height)/32+3,M.ysize-1); j++){
                if (!M.isVisible(i, j)) {
                    g.fillRect((i*32) - x1, (j*32) - y1,32,32);
                    continue;
                }
                if (M.getCell(i, j).isOpenable()){
                    if(((Openable)M.getCell(i, j)).isOpen()){
                        g.drawImage(TileImagePrototype.getTileImage(M.getCell(i, j).getId()*10)
                        , (i*32) - x1, (j*32) -y1, null);
                        continue;
                    }
                }
                g.drawImage(TileImagePrototype.getTileImage(M.getCell(i, j).getId())
                        , (i*32) - x1, (j*32) -y1, null);
            }
        }
    }
}
