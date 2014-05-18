package JunitTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import Admin.*;
import java.sql.SQLException;
/**
 *
 * @author asus
 */
public class AdminJUnitTest {
    Administrator A;
    public AdminJUnitTest() {
        A = new Administrator();
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void TestIsUserExist() throws SQLException {
        boolean exist = false;
        assertEquals(exist, A.isUserExist(1));
    }
    
    @Test
    public void TestIsPasswordMatch() throws SQLException {
        boolean match = true;
        A.SetPassword("49f0bad299687c62334182178bfd75d8");
        A.SetNIM(21);
        assertEquals(match, A.isPasswordMatch("49f0bad299687c62334182178bfd75d8"));
    }
    
    @Test
    public void TestGetAdmins() throws SQLException {
        String[] row1 = {"21", "aswd"};
        assertArrayEquals(row1, A.getAdmins().get(0));
    }
}
