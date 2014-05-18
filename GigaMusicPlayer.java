/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package giga.music.player;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.io.IOException;



/**
 *
 * @author Fauzan
 */
public class GigaMusicPlayer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, UnsupportedTagException, InvalidDataException{
        /*Mp3File mp3file = new Mp3File("02 All the right moves.mp3");
        System.out.println("Length of this mp3 is: " + mp3file.getLengthInSeconds() + " seconds");
        System.out.println("Bitrate: " + mp3file.getLengthInSeconds() + " kbps " + (mp3file.isVbr() ? "(VBR)" : "(CBR)"));
        System.out.println("Sample rate: " + mp3file.getSampleRate() + " Hz");
        System.out.println("Has ID3v1 tag?: " + (mp3file.hasId3v1Tag() ? "YES" : "NO"));
        System.out.println("Has ID3v2 tag?: " + (mp3file.hasId3v2Tag() ? "YES" : "NO"));
        System.out.println("Has custom tag?: " + (mp3file.hasCustomTag() ? "YES" : "NO"));
        
        if (mp3file.hasId3v1Tag()) {
        	ID3v1 id3v1Tag = mp3file.getId3v1Tag();
        	System.out.println("Track: " + id3v1Tag.getTrack());
        	System.out.println("Artist: " + id3v1Tag.getArtist());
        	System.out.println("Title: " + id3v1Tag.getTitle());
        	System.out.println("Album: " + id3v1Tag.getAlbum());
        	System.out.println("Year: " + id3v1Tag.getYear());
        	System.out.println("Genre: " + id3v1Tag.getGenre() + " (" + id3v1Tag.getGenreDescription() + ")");
        	System.out.println("Comment: " + id3v1Tag.getComment());
        }
        
        if (mp3file.hasId3v2Tag()) {
            ID3v2 id3v2Tag = mp3file.getId3v2Tag();
            byte[] imageData = id3v2Tag.getAlbumImage();
            if (imageData != null) {
				String mimeType = id3v2Tag.getAlbumImageMimeType();
				System.out.println("Mime type: " + mimeType);
				// Write image to file - can determine appropriate file extension from the mime type
				RandomAccessFile file = new RandomAccessFile("album-artwork", "rw");
				file.write(imageData);
				file.close();
            }
        }*/
        
    Song s = new Song ("02 All the right moves.mp3");
    
    }
    
    
}
