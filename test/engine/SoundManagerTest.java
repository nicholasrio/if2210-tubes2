/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Winson
 */
public class SoundManagerTest {
    
    public SoundManagerTest() {
    }

    /**
     * Test of addSound method, of class SoundManager.
     */
    @Test
    public void testAddSound() {
        System.out.println("addSound");
        
        SoundManager.addSound(new Sound("teleport","teleport.wav",Sound.SoundType.sfx));
        SoundManager.playSound("teleport");
        
        assertFalse(SoundManager.sounds.isEmpty());
    }
    
}
