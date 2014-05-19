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
public class MapViewer {
    
    /**
     * create and show the gui
     */
    public static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+
                SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(250,250);
        Map M = new Map();
        M.createDungeon(20, 20, 40);
        f.add(new MapGui(M));
        f.pack();
        f.setVisible(true);
    }
}

class MapGui extends JPanel {
    Map M;
    public MapGui(Map M) {
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.M = M;
        try {
            TileImagePrototype.loadCache();
        } catch (IOException ex) {
            Logger.getLogger(MapGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(TileImagePrototype.tileWidth*M.xsize,TileImagePrototype.tileHeight*M.ysize);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);       

        // Draw Text
        for (int i = 0; i < M.xsize; i++){
            for (int j = 0; j < M.ysize; j++){
                g.drawImage(TileImagePrototype.getTileImage(M.getCell(i, j).getId())
                        , i*TileImagePrototype.tileWidth, j*TileImagePrototype.tileHeight, this);
            }
        }
    }  
}
