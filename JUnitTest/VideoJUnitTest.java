package JunitTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Video.*;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class VideoJUnitTest {
    
    public VideoJUnitTest() {
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
    public void TestSelectData() throws SQLException {
        Video vid = new Video();
        String[] row1 = {"1", "a", "a", "1", "2", "e"};
        String[] row2 = {"2", "as", "assa", "1", "1", "ssds"};
        assertArrayEquals(row1, vid.SelectData().get(0));
        assertArrayEquals(row2, vid.SelectData().get(1));
    }
    
    @Test
    public void TestCekData() throws SQLException {
        Video vid = new Video();
        boolean ada = true;
        assertEquals(ada, vid.cekData(1));
    }
}
