/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package character.Boss;

import character.Character;
import character.CharacterCache;
import character.Fightable;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import map.Map;
import character.Hero;
/**
 *
 * @author kevinyu
 */
public class DragonTest {
    
    private Dragon instance;
    private Hero enemy;

    public DragonTest() {
        instance = new Dragon();
        instance.init();
        Map map = new Map();
        map.createBossDungeon(26,16);
        instance.setMap(map);
        enemy = new Hero();
        enemy.setMap(map);
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance.setPosition(200,200);
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of setMoveUp method, of class Dragon.
     */
    @Test
    public void testSetMoveUp() {
        System.out.println("setMoveUp");
        instance.setMoveUp();
        instance.update();
        System.out.println(instance.getPositionY());
        assertEquals(true,instance.getPositionY()==199);
        assertEquals(true,instance.getPositionX()==200);
    }

    /**
     * Test of setMoveRight method, of class Dragon.
     */
    @Test
    public void testSetMoveRight() {
        System.out.println("setMoveRight");
        instance.setMoveRight();
        instance.update();
        assertEquals(true,instance.getPositionX()==201);
        assertEquals(true,instance.getPositionY()==200);
        
    }

    /**
     * Test of setMoveDown method, of class Dragon.
     */
    @Test
    public void testSetMoveDown() {
        System.out.println("setMoveDown");
        instance.setMoveDown();
        instance.update();
        assertTrue(instance.getPositionX()==200);
        assertTrue(instance.getPositionY()==201);
    }

    /**
     * Test of setMoveLeft method, of class Dragon.
     */
    @Test
    public void testSetMoveLeft() {
        System.out.println("setMoveLeft");
        instance.setMoveLeft();
        instance.update();
        assertTrue(instance.getPositionX()==199);
        assertTrue(instance.getPositionY()==200);
    }
    
}
