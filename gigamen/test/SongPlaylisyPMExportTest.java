/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;
import gigamen.PlaylistManager;
import gigamen.Song;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ACER
 */
public class SongPlaylisyPMExportTest {

    
    public SongPlaylisyPMExportTest() {
    }

    @BeforeClass
    public static void setUpClass() throws IOException, UnsupportedTagException, InvalidDataException {
        Song s = new Song("Westlife - Flying Without Wing.mp3");
        //System.out.println(s);
        Song s1 = new Song("Westlife - Fool Again.wav");
        //System.out.println(s1);
        Song s2 = new Song("Westlife - Home.mp3");
        //System.out.println(s2);
        Song s3 = new Song("Westlife - I Have A Dream.mp3");
        //System.out.println(s3);
        Song s4 = new Song("Westlife - I Lay My Love On You.mp3");
        //System.out.println(s4);
        Song s5 = new Song("Westlife - If I Let You Go.mp3");
        //System.out.println(s5);
        Song s6 = new Song("Westlife - In This Life.mp3");
        //System.out.println(s6);
        Song s7 = new Song("Westlife - Mandy.mp3");
        //System.out.println(s7);
        Song s8 = new Song("Westlife - More Than Than Words.mp3");
        //System.out.println(s8);
        Song s9 = new Song("Westlife - My Love.mp3");
        //System.out.println(s9);
        Song s10 = new Song("Westlife - My Love.wav");
        //System.out.println(s10);
        Song s11 = new Song("Westlife - Uptown Girl.mp3");
        //System.out.println(s11);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException, InvalidDataException, UnsupportedTagException {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void TestSong() throws IOException, InvalidDataException, UnsupportedTagException {
       
        Song s = new Song("Westlife - Flying Without Wing.mp3");
        assertEquals(s.toString(),"Flying Without Wing       Westlife                                  Other                00 0000 3:53" );
        Song s1 = new Song("Westlife - Fool Again.wav");
        assertEquals(s1.toString(),"-                         -                    -                    -                    00 0000 0:00");
        Song s2 = new Song("Westlife - Home.mp3");
        assertEquals(s2.toString(),"Home                      Westlife             Back Home            Other                01 2007 3:27");
        //System.out.println(s2);
        
    }
    
    @Test
    public void TestSort() throws IOException, UnsupportedTagException, InvalidDataException{
        
        Song s = new Song("Westlife - Flying Without Wing.mp3");
        //System.out.println(s);
        //Song s1 = new Song("Westlife - Fool Again.wav");
        //System.out.println(s1);
        Song s2 = new Song("Westlife - Home.mp3");
        //System.out.println(s2);
        ///Song s3 = new Song("Westlife - I Have A Dream.mp3");
        //System.out.println(s3);
        Song s4 = new Song("Westlife - I Lay My Love On You.mp3");
        //System.out.println(s4);
        //Song s5 = new Song("Westlife - If I Let You Go.mp3");
        //System.out.println(s5);
        Song s6 = new Song("Westlife - In This Life.mp3");
        //System.out.println(s6);
        //Song s7 = new Song("Westlife - Mandy.mp3");
        //System.out.println(s7);
        Song s8 = new Song("Westlife - More Than Than Words.mp3");
        //System.out.println(s8);
        //Song s9 = new Song("Westlife - My Love.mp3");
        //System.out.println(s9);
        Song s10 = new Song("Westlife - My Love.wav");
        //System.out.println(s10);
        //Song s11 = new Song("Westlife - Uptown Girl.mp3");
        //System.out.println(s11);
        PlaylistManager pM = new PlaylistManager();
        ArrayList<Song> play1 = new ArrayList<>();
        pM.AddPlaylist();
        pM.getCollection().get(0).setPlaylistTitle("Westlife Pl1");

        play1.add(s);
        play1.add(s2);
        play1.add(s4);
        play1.add(s6);
        play1.add(s8);
        play1.add(s10);

        pM.getCollection().get(0).setPlaylist(play1);
        pM.getCollection().get(0).cleanFromError();

        //pM.setCollection(pM.getCollection());
        //System.out.println(pM.getCollection().get(0));
        // pM.getCollection().get(0).print();
        //  pM.getCollection().get(0).shuffle();
        //System.out.println(pM.getCollection().get(0));
        
        pM.getCollection().get(0).sortByTitle();
        assertEquals(pM.getCollection().get(0).toString(), "Playlist : Westlife Pl1\n" +
"Flying Without Wing       Westlife                                  Other                00 0000 3:53\n" +
"Home                      Westlife             Back Home            Other                01 2007 3:27\n" +
"I Lay My Love On You      Westlife             Coast To Coast       Pop                  08 2002 3:30\n" +
"More Than Than Words      Westlife             Swear It Again       Other                00 0000 3:53\n" +
"NoTitle                   Westlife             Face To Face         Other                00 0000 4:13");
        pM.getCollection().get(0).GroupByGenre();
        assertEquals(pM.getCollection().get(0).toString(),"Playlist : Westlife Pl1\n" +
"Flying Without Wing       Westlife                                  Other                00 0000 3:53\n" +
"Home                      Westlife             Back Home            Other                01 2007 3:27\n" +
"More Than Than Words      Westlife             Swear It Again       Other                00 0000 3:53\n" +
"NoTitle                   Westlife             Face To Face         Other                00 0000 4:13\n" +
"I Lay My Love On You      Westlife             Coast To Coast       Pop                  08 2002 3:30");
        pM.getCollection().get(0).sortByDuration();
        assertEquals(pM.getCollection().get(0).toString(),"Playlist : Westlife Pl1\n" +
"Home                      Westlife             Back Home            Other                01 2007 3:27\n" +
"I Lay My Love On You      Westlife             Coast To Coast       Pop                  08 2002 3:30\n" +
"Flying Without Wing       Westlife                                  Other                00 0000 3:53\n" +
"More Than Than Words      Westlife             Swear It Again       Other                00 0000 3:53\n" +
"NoTitle                   Westlife             Face To Face         Other                00 0000 4:13");
        pM.getCollection().get(0).sortByYearDsc();
        assertEquals(pM.getCollection().get(0).toString(),"Playlist : Westlife Pl1\n" +
"Home                      Westlife             Back Home            Other                01 2007 3:27\n" +
"I Lay My Love On You      Westlife             Coast To Coast       Pop                  08 2002 3:30\n" +
"NoTitle                   Westlife             Face To Face         Other                00 0000 4:13\n" +
"More Than Than Words      Westlife             Swear It Again       Other                00 0000 3:53\n" +
"Flying Without Wing       Westlife                                  Other                00 0000 3:53");
        
    }
    
    @Test
    public void TestExportImport() throws IOException, InvalidDataException, UnsupportedTagException{
        Song s = new Song("Westlife - Flying Without Wing.mp3");
        //System.out.println(s);
        Song s1 = new Song("Westlife - Fool Again.wav");
        //System.out.println(s1);
        Song s2 = new Song("Westlife - Home.mp3");
        //System.out.println(s2);
        Song s3 = new Song("Westlife - I Have A Dream.mp3");
        //System.out.println(s3);
        Song s4 = new Song("Westlife - I Lay My Love On You.mp3");
        //System.out.println(s4);
        Song s5 = new Song("Westlife - If I Let You Go.mp3");
        //System.out.println(s5);
        Song s6 = new Song("Westlife - In This Life.mp3");
        //System.out.println(s6);
        Song s7 = new Song("Westlife - Mandy.mp3");
        //System.out.println(s7);
        Song s8 = new Song("Westlife - More Than Than Words.mp3");
        //System.out.println(s8);
        Song s9 = new Song("Westlife - My Love.mp3");
        //System.out.println(s9);
        Song s10 = new Song("Westlife - My Love.wav");
        //System.out.println(s10);
        Song s11 = new Song("Westlife - Uptown Girl.mp3");
        //System.out.println(s11);
        
        PlaylistManager pM = new PlaylistManager();
        ArrayList<Song> play1 = new ArrayList<>();
        ArrayList<Song> play2 = new ArrayList<>();
        pM.AddPlaylist();
        pM.AddPlaylist();
        pM.getCollection().get(0).setPlaylistTitle("Westlife Pl1");
        pM.getCollection().get(1).setPlaylistTitle("Westlife Pl2");
        
        play1.add(s);
        play1.add(s2);
        play1.add(s4);
        play1.add(s6);
        play1.add(s8);
        play1.add(s10);
        play2.add(s1);
        play2.add(s3);
        play2.add(s5);
        play2.add(s7);
        play2.add(s11);
        
        pM.getCollection().get(0).setPlaylist(play1);
        pM.getCollection().get(1).setPlaylist(play2);
        assertEquals(pM.getCollection().get(0).toString(), "Playlist : Westlife Pl1\n" +
"Flying Without Wing       Westlife                                  Other                00 0000 3:53\n" +
"Home                      Westlife             Back Home            Other                01 2007 3:27\n" +
"I Lay My Love On You      Westlife             Coast To Coast       Pop                  08 2002 3:30\n" +
"NoTitle                   Westlife             Face To Face         Other                00 0000 4:13\n" +
"More Than Than Words      Westlife             Swear It Again       Other                00 0000 3:53\n" +
"-                         -                    -                    -                    00 0000 0:00");
        assertEquals(pM.getCollection().get(1).toString(), "Playlist : Westlife Pl2\n" +
"-                         -                    -                    -                    00 0000 0:00\n" +
"I Have A Dreams           Westlife             Swear It Again       Other                00 0000 4:13\n" +
"If I Let You Go           Westlife                                  Other                00 0000 3:35\n" +
"Westlife - Mandy          Westlife             www.mp3sfinder.com   Other                00 2003 3:35\n" +
"Uptown Girl               Westlife             Uptown Girl PROMO    Pop                  00 2001 3:07");
        PlaylistManager.Export(pM);
        PlaylistManager pM1 = PlaylistManager.Import();
        assertEquals(pM1.getCollection().get(0).toString(), "Playlist : Westlife Pl1\n" +
"Flying Without Wing       Westlife                                  Other                00 0000 3:53\n" +
"Home                      Westlife             Back Home            Other                01 2007 3:27\n" +
"I Lay My Love On You      Westlife             Coast To Coast       Pop                  08 2002 3:30\n" +
"NoTitle                   Westlife             Face To Face         Other                00 0000 4:13\n" +
"More Than Than Words      Westlife             Swear It Again       Other                00 0000 3:53\n" +
"-                         -                    -                    -                    00 0000 0:00");
        assertEquals(pM1.getCollection().get(1).toString(), "Playlist : Westlife Pl2\n" +
"-                         -                    -                    -                    00 0000 0:00\n" +
"I Have A Dreams           Westlife             Swear It Again       Other                00 0000 4:13\n" +
"If I Let You Go           Westlife                                  Other                00 0000 3:35\n" +
"Westlife - Mandy          Westlife             www.mp3sfinder.com   Other                00 2003 3:35\n" +
"Uptown Girl               Westlife             Uptown Girl PROMO    Pop                  00 2001 3:07");
        
       
        //pM.setCollection(pM.getCollection());
        //System.out.println(pM.getCollection().get(0));
       // pM.getCollection().get(0).print();
      //  pM.getCollection().get(0).shuffle();
        //System.out.println(pM.getCollection().get(0));
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
