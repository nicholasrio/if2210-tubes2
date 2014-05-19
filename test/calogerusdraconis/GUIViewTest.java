/*
 * Copyright (C) 2014 Calogerus Draconis Team
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package calogerusdraconis;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ASUS
 */
public class GUIViewTest {
    
    public GUIViewTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of showMenu method, of class GUIView.
     */
    @Test
    public void testShowMenu() {
        System.out.println("showMenu");
        GUIView instance = new GUIView();
        instance.showMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UpdateScreen method, of class GUIView.
     */
    @Test
    public void testUpdateScreen_UserDragon() {
        System.out.println("UpdateScreen");
        UserDragon drg = null;
        GUIView instance = new GUIView();
        instance.UpdateScreen(drg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UpdateScreen method, of class GUIView.
     */
    @Test
    public void testUpdateScreen_Store() {
        System.out.println("UpdateScreen");
        Store str = null;
        GUIView instance = new GUIView();
        instance.UpdateScreen(str);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UpdateScreen method, of class GUIView.
     */
    @Test
    public void testUpdateScreen_UserDragon_Dragon() {
        System.out.println("UpdateScreen");
        UserDragon drg = null;
        Dragon enemy = null;
        GUIView instance = new GUIView();
        instance.UpdateScreen(drg, enemy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UpdateScreen method, of class GUIView.
     */
    @Test
    public void testUpdateScreen_UserDragon_Event() {
        System.out.println("UpdateScreen");
        UserDragon drg = null;
        Event evnt = null;
        GUIView instance = new GUIView();
        instance.UpdateScreen(drg, evnt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seeFoodDirectory method, of class GUIView.
     */
    @Test
    public void testSeeFoodDirectory() {
        System.out.println("seeFoodDirectory");
        UserDragon drg = null;
        GUIView instance = new GUIView();
        instance.seeFoodDirectory(drg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
