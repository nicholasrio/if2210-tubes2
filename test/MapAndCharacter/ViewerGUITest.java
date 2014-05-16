/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MapAndCharacter;

import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import map.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Calvin
 */
public class ViewerGUITest {
    Map M;
    MapAdapter MA;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        M =new Map();
        M.createDungeon(20, 20, 20);
        MA = new MapAdapter(M);
        MA.addChar(new character.Character(), 3, 3);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testView() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame f = new JFrame("Map Viewer GUI");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(250,250);
                M.createDungeon(20, 20, 40);

                f.add(new JPanel(){
                    public void paint(Graphics g){
                        super.paint(g);
                        ViewerGUI.view(g, MA);
                    }
                }
                );
                f.pack();
                f.setVisible(true);
            }
        });
        System.out.println("view");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ViewerGUITest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testViewArea() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame f = new JFrame("Map Viewer GUI");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(250,250);
                M.createDungeon(20, 20, 40);

                f.add(new JPanel(){
                    public void paint(Graphics g){
                        super.paint(g);
                        ViewerGUI.view(g, MA,1,1,5,5);
                    }
                }
                );
                f.pack();
                f.setVisible(true);
            }
        });
        System.out.println("viewArea");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ViewerGUITest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testViewWithoutVisiblity() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame f = new JFrame("Map Viewer GUI");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(0,0);
                f.add(new JPanel(){
                    public void paint(Graphics g){
                        super.paint(g);
                        ViewerGUI.viewWithoutVisiblity(g, MA);
                    }
                }
                );
                f.pack();
                f.setVisible(true);
            }
        });
        System.out.println("viewWithoutVisibility");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ViewerGUITest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
