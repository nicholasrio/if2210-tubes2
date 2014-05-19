/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package character;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author kevinyu
 */
public class CharacterCacheTest {
    private static JFrame frame = new JFrame("Tes");
    private static JPanel panel = new JPanel();
    
    private static BufferedImage instance;
    
    public CharacterCacheTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        frame = new JFrame("Tes");
        panel = new JPanel(){
            public void paint(Graphics g){
                RenderingHints rh =
                new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
                rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
                Graphics2D g2d = (Graphics2D) g;
                g2d.drawImage(instance,30,30,null);
            }
        };
        frame.add(panel);
    	frame.setSize(800, 500);
    	frame.setVisible(true);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getItem method, of class CharacterCache.
     */
    @Test
    public void testLoadCacheandGetItem() {
        CharacterCache.loadCache();
        Character c = CharacterCache.getItem("Yuu");
        assertTrue(c!=null);
    }
    
    public void testLaodImagedanGetImage(){
        CharacterCache.loadCache();
        instance = CharacterCache.getImage("Yuu");
        frame.repaint();
    }
}
