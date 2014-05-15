/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.DataStructure;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Winson
 */
public class GameItemTest {
    
    public GameItemTest() {
    }

    /**
     * Test of getName method, of class GameItem.
     */
    @Test
    public void testGetName() {
        
        GameItem instance;
        String expResult;
        String result;
        //Testing get name dari semua item
        System.out.println("getName Coin");
        instance = new CoinItem();
        expResult = "coin";
        result = instance.getName();
        assertEquals(expResult, result);
        
        System.out.println("getName Finish");
        instance = new FinishItem();
        expResult = "finish";
        result = instance.getName();
        assertEquals(expResult, result);
        
        System.out.println("getName Hole");
        instance = new HoleItem();
        expResult = "hole";
        result = instance.getName();
        assertEquals(expResult, result);
        
        System.out.println("getName Road");
        instance = new RoadItem();
        expResult = "road";
        result = instance.getName();
        assertEquals(expResult, result);
        
        System.out.println("getName Start");
        instance = new StartItem();
        expResult = "start";
        result = instance.getName();
        assertEquals(expResult, result);
        
        System.out.println("getName Wall");
        instance = new WallItem();
        expResult = "wall";
        result = instance.getName();
        assertEquals(expResult, result);
        
        System.out.println("getName Teleporter");
        Location L = new Location(5,6,7);
        instance = new TeleporterItem(L);
        expResult = "teleporter";
        result = instance.getName();
        assertEquals(expResult, result);
        //Tes lokasi tujuan untuk teleporter
        Location expLocation = new Location(5,6,7);
        Location resultLocation = ((TeleporterItem)instance).getArrivalLocation();
        assertEquals(expLocation.getCol() ,resultLocation.getCol());
        assertEquals(expLocation.getRow() ,resultLocation.getRow());
        assertEquals(expLocation.getLevel() ,resultLocation.getLevel());
    }
    
}
