/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package character;

import java.awt.Graphics2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import map.Map;
/**
 *
 * @author kevinyu
 */
public class HeroTest {
    
    private static Hero instance;
    private static Monster enemy;
    public HeroTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        CharacterCache.loadCache();
        Map map =new Map();
        map.createBossDungeon(26,16);
        instance = (Hero)CharacterCache.getItem("Yuu");
        instance.setPosition(30,30);
        instance.loadImage(CharacterCache.getImage("Yuu"));
        instance.loadAttackFrame(CharacterCache.getAttack("Yuu"));
        instance.setMap(map);
        instance.init();
        enemy = (Monster)CharacterCache.getItem("Ghost");
        enemy.loadImage(CharacterCache.getImage("Ghost"));
        enemy.loadAttackFrame(CharacterCache.getAttack("Ghost"));
        enemy.setPosition(50,50);
        enemy.setMap(map);
        enemy.init();
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
     * Test of checkHitting method, of class Hero.
     */
    @Test
    public void testCheckHitting() {
        enemy.setCurrentHealth(50);
        instance.checkHitting(enemy);
        assertTrue(enemy.getCurrentHealth()==50);
    }

    /**
     * Test of update method, of class Hero.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        instance.setPosition(5,5);
        instance.update();
        assertTrue(instance.getPositionX()==5);
        assertTrue(instance.getPositionY()==5);
    }

    /**
     * Test of pushedBackandFlinching method, of class Hero.
     */
    @Test
    public void testPushedBackandFlinching() {
        System.out.println("pushedBackandFlinching");
        instance.setCurrentHealth(56);
        instance.pushedBackandFlinching();
        instance.hitted(10);
        assertTrue(instance.getCurrentHealth()==56);
    }
    
}
