/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package character;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yafithekid
 */
public class FightableTest {
    
    /**
     * constructor
     */
    public FightableTest() {
    }
    
    /**
     * method set up class
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     * method tear down class
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     * method set up
     */
    @Before
    public void setUp() {
    }
    
    /**
     * method tear down
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of getAttackPoint method, of class Fightable.
     */
    @Test
    public void testGetAttackPoint() {
        System.out.println("getAttackPoint");
        Hero kar = new Hero();
        kar.setStrAgiInt(1, 2, 3);
        //str = atk
        int expResult = kar.getStr();
        int result = kar.getAttackPoint();
        assertEquals(expResult, result);
        
        Monster monster = new Monster();
        monster.setStrAgiInt(1,2,3);
        //str = atk
        expResult = monster.getStr();
        result = monster.getAttackPoint();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDefensePoint method, of class Fightable.
     */
    @Test
    public void testGetDefensePoint() {
        System.out.println("getDefensePoint");
        Hero kar = new Hero();
        kar.setStrAgiInt(1, 2, 3);
        //agi = def
        int expResult = kar.getAgi();
        int result = kar.getDefensePoint();
        assertEquals(expResult, result);
        
        Monster monster = new Monster();
        monster.setStrAgiInt(1, 2, 3);
        //agi = def
        expResult = monster.getAgi();
        result = monster.getDefensePoint();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of getNetDamage method, of class Fightable.
     */
    @Test
    public void testGetNetDamage(){
        //asumsi benar
    }

    /**
     * Test of isDead method, of class Fightable.
     */
    @Test
    public void testIsDead() {
        System.out.println("isDead");
        Fightable instance = new FightableImpl();
        boolean expResult = false;
        boolean result = instance.isDead();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isAlive method, of class Fightable.
     */
    @Test
    public void testIsAlive() {
        System.out.println("isAlive");
        Fightable instance = new FightableImpl();
        boolean expResult = false;
        boolean result = instance.isAlive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of doAbsorbDamage method, of class Fightable.
     */
    @Test
    public void testDoAbsorbDamage() {
        System.out.println("doAbsorbDamage");
        int damage = 10;
         
        Hero kar = new Hero();
        kar.setMaxHealthMana(10, 10);
        kar.setCurrentHealthMana(10, 10);
        
        int lastHP = kar.getCurrentHealth();
        kar.doAbsorbDamage(damage);
        assertEquals(kar.getCurrentHealth(),lastHP - kar.getNetDamage(damage));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    
    /**
     * Test of doAttack method, of class Fightable.
     */
    @Test
    public void testDoAttack() {
        System.out.println("doAttack");
        Hero hero = new Hero();
        hero.setStrAgiInt(10, 1,10);
        hero.setMaxHealthMana(1000,1000);
        hero.setCurrentHealthMana(1000,1000);
        
        Monster monster = new Monster();
        monster.setStrAgiInt(5,1,5);
        monster.setMaxHealthMana(1000, 1000);
        monster.setCurrentHealthMana(1000,1000);
        int lastHP;
        
        //attack against monster
        lastHP = monster.getCurrentHealth();
        hero.doAttack(monster);
        assertEquals(monster.getCurrentHealth(),lastHP - monster.getNetDamage(hero.getAttackPoint()));
        
        //attack against hero
        lastHP = hero.getCurrentHealth();
        monster.doAttack(hero);
        assertEquals(hero.getCurrentHealth(),lastHP - hero.getNetDamage(monster.getAttackPoint()));
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * class fightableimpl implements fightable
     */
    public class FightableImpl implements Fightable {

        /**
         * method get attack point
         * @return 
         */
        public int getAttackPoint() {
            return 0;
        }

        /**
         * method get defense point
         * @return 
         */
        public int getDefensePoint() {
            return 0;
        }

        /**
         * method is dead
         * @return 
         */
        public boolean isDead() {
            return false;
        }

        /**
         * method is alive
         * @return 
         */
        public boolean isAlive() {
            return false;
        }
        
        /**
         * method get net damage
         * @param damage
         * @return 
         */
        public int getNetDamage(int damage){
            return 0;
        }
        /**
         * method do damage calculation
         * @param damage 
         */
        public void doDamageCalculation(int damage) {
        }

        /**
         * method do attack
         * @param fight 
         */
        public void doAttack(Fightable fight) {
        }

        /**
         * method do absorb damage
         * @param damage 
         */
        public void doAbsorbDamage(int damage) {
        }

        @Override
        public void hitted(int damage) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void pushedBackandFlinching() {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
