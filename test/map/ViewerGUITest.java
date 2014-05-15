/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;

import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
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
    
    public ViewerGUITest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
     * Test of view method, of class ViewerGUI.
     */
    @Test
    public void testView() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame f = new JFrame("Map Viewer GUI");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(250,250);
                final Map M = new Map();
                M.createDungeon(20, 20, 40);

                f.add(new JPanel(){
                    public void paint(Graphics g){
                        super.paint(g);
                        ViewerGUI.view(g, M);
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
                final Map M = new Map();
                M.createDungeon(20, 20, 40);

                f.add(new JPanel(){
                    public void paint(Graphics g){
                        super.paint(g);
                        ViewerGUI.view(g, M,10,10,5,5);
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
                final Map M = new Map();
                M.createDungeon(20, 20, 40);

                f.add(new JPanel(){
                    public void paint(Graphics g){
                        super.paint(g);
                        ViewerGUI.viewWithoutVisiblity(g, M);
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
