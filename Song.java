/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package giga.music.player;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.io.IOException;

/**
 *
 * @author Fauzan
 */
public class Song {
    private String Path;
    private String Title;
    private String Artist;
    private String Album;
    private String Genre;
    private int Track;
    private int Year;
    private int Bitrate;
    private long Length;
    
    public Song(String path) throws IOException, UnsupportedTagException, InvalidDataException
    {
        try
        {
            Mp3File mp3file = new Mp3File(path);        
            if (mp3file.hasId3v1Tag()) 
            {
                    ID3v1 id3v1Tag = mp3file.getId3v1Tag();
                    Path = path;
                    Title = id3v1Tag.getTitle();
                    Artist = id3v1Tag.getArtist();
                    Album = id3v1Tag.getAlbum();
                    Genre = id3v1Tag.getGenreDescription();
                    Track = Integer.parseInt(id3v1Tag.getTrack());
                    Year = Integer.parseInt(id3v1Tag.getYear());
                    Bitrate = mp3file.getBitrate();
                    Length = mp3file.getLengthInSeconds();
            }	
        }
        catch (IOException | UnsupportedTagException | InvalidDataException e)
        {
            System.out.println("Error in loading file tags!");
        }
        
    }
    
    public String getPath() {return Path;}
    public String getTitle() {return Title;}
    public String getArtist() {return Artist;}
    public String getAlbum() {return Album;}
    public String getGenre() {return Genre;}
    public int getTrack() {return Track;}
    public int getYear() {return Year;}
    public int getBitrate() {return Bitrate;}
    public long getLength() {return Length;}
    
    
}

