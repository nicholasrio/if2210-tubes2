/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gigamen;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author Fauzan
 */
public class GigaMusicPlayer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, UnsupportedTagException, InvalidDataException {
        /*Mp3File mp3file = new Mp3File("02 All the right moves.mp3");
         //System.out.println("Length of this mp3 is: " + mp3file.getLengthInSeconds() + " seconds");
         //System.out.println("Bitrate: " + mp3file.getLengthInSeconds() + " kbps " + (mp3file.isVbr() ? "(VBR)" : "(CBR)"));
         //System.out.println("Sample rate: " + mp3file.getSampleRate() + " Hz");
         //System.out.println("Has ID3v1 tag?: " + (mp3file.hasId3v1Tag() ? "YES" : "NO"));
         //System.out.println("Has ID3v2 tag?: " + (mp3file.hasId3v2Tag() ? "YES" : "NO"));
         //System.out.println("Has custom tag?: " + (mp3file.hasCustomTag() ? "YES" : "NO"));
        
         if (mp3file.hasId3v1Tag()) {
         ID3v1 id3v1Tag = mp3file.getId3v1Tag();
         //System.out.println("Track: " + id3v1Tag.getTrack());
         //System.out.println("Artist: " + id3v1Tag.getArtist());
         //System.out.println("Title: " + id3v1Tag.getTitle());
         //System.out.println("Album: " + id3v1Tag.getAlbum());
         //System.out.println("Year: " + id3v1Tag.getYear());
         //System.out.println("Genre: " + id3v1Tag.getGenre() + " (" + id3v1Tag.getGenreDescription() + ")");
         //System.out.println("Comment: " + id3v1Tag.getComment());
         }
        
         if (mp3file.hasId3v2Tag()) {
         ID3v2 id3v2Tag = mp3file.getId3v2Tag();
         byte[] imageData = id3v2Tag.getAlbumImage();
         if (imageData != null) {
         String mimeType = id3v2Tag.getAlbumImageMimeType();
         //System.out.println("Mime type: " + mimeType);
         // Write image to file - can determine appropriate file extension from the mime type
         RandomAccessFile file = new RandomAccessFile("album-artwork", "rw");
         file.write(imageData);
         file.close();
         }
         }*/

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
        //pM.setCollection(pM.getCollection());
        //System.out.println(pM.getCollection().get(0));
       // pM.getCollection().get(0).print();
      //  pM.getCollection().get(0).shuffle();
        //System.out.println(pM.getCollection().get(0));
        pM.getCollection().get(0).print();
        pM.getCollection().get(1).print();
        //PlaylistManager.Export(pM);
    }

}
