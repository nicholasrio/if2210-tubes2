/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package character.Skill;

import character.Character;
import character.CharacterCache;
import character.Monster;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import map.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kevinyu
 */
public class FireBallTest {
    
    private static final FireBall instance = new FireBall();
    private static JFrame frame = new JFrame("Tes");
    private static JPanel panel;
    
    public FireBallTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        panel = new JPanel(){
            public void paint(Graphics g){
                RenderingHints rh =
                new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
                rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
                instance.draw((Graphics2D)g,0,0);
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
     * Test of update method, of class FireBall.
     */
    @Test
    public void testUpdateandDraw() {
        System.out.println("update");
        instance.start(300,300,4);
        while(instance.isActive()){
            instance.update();
            frame.repaint();
        }
    }

    /**
     * Test of checkHitting method, of class FireBall.
     */
    @Test
    public void testCheckHitting() {
        System.out.println("checkHitting");
        CharacterCache.loadCache();
        Monster monster = (Monster)CharacterCache.getItem("Skeleton");
        Map map = new Map();
        map.createBossDungeon(16,26);

        monster.setMap(map);
        monster.setPosition(20,30);
        monster.setWidth(32);
        monster.setHeight(32);

        assertFalse(instance.checkHitting(monster));
    }
    
}
