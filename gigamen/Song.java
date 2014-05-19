/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gigamen;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.io.IOException;
import javax.xml.bind.annotation.*;
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
    private long Length;
    //Belum implementasi rating

    public Song() {
        this.Path = "Unpath";
        this.Title = "-";
        this.Artist = "-";
        this.Album = "-";
        this.Genre = "-";
        this.Track = 0;
        this.Year = 0;
        this.Length = 0;
    }

    public Song(String path) throws IOException, UnsupportedTagException, InvalidDataException {
        try {
            Mp3File mp3file = new Mp3File(path);
            if (mp3file.hasId3v1Tag()) {
                ID3v1 id3v1Tag = mp3file.getId3v1Tag();
                Path = path;
                Title = id3v1Tag.getTitle();
                if (Title == null) {
                    String tmp;
                    int i = path.length() - 1;

                    while (path.charAt(i) != '.' && i >= 0) {
                        i--;
                    }
                    int j = i;
                    while (path.charAt(j) != '\\' && j >= 0) {
                        j--;
                    }
                    tmp = path.substring(j + 1, i - 1);
                } else if (Title.equals("")) {
                    Title = "NoTitle";
                }
                Artist = id3v1Tag.getArtist();
                if (Artist == null) {
                    Artist = "Other Artist";
                }
                Album = id3v1Tag.getAlbum();
                if (Album == null) {
                    Album = "Other Album";
                }
                Genre = id3v1Tag.getGenreDescription();
                if (Genre == null) {
                    Genre = "Other";
                }

                try {
                    Track = Integer.parseInt(id3v1Tag.getTrack());
                } catch (Exception e) {
                    Track = 0;
                }
                try {
                    Year = Integer.parseInt(id3v1Tag.getYear());
                } catch (Exception e) {
                    Year = 0;
                }

                Length = mp3file.getLengthInSeconds();

            } else {
                this.Path = path;
                this.Title = "-";
                this.Artist = "-";
                this.Album = "-";
                this.Genre = "-";
                this.Track = 0;
                this.Year = 0;
                this.Length = 0;
            }

        } catch (IOException | UnsupportedTagException | InvalidDataException e) {
            System.out.println("Error in loading '" + path + "'!");
            System.out.println("Check again the path,file type or the file tag");
            this.Path = path;
            this.Title = "-";
            this.Artist = "-";
            this.Album = "-";
            this.Genre = "-";
            this.Track = 0;
            this.Year = 0;
            this.Length = 0;
        }

    }

    public Song(Song s) {
        this.Path = s.Path;
        this.Title = s.Title;
        this.Artist = s.Artist;
        this.Album = s.Album;
        this.Genre = s.Genre;
        this.Track = s.Track;
        this.Year = s.Year;
        this.Length = s.Length;
    }

    @Override
    public String toString() {
        return new String(String.format("%-25s %-20s %-20s %-20s %02d %04d %d:%02d", Title, Artist, Album, Genre, Track, Year, Length / 60, Length % 60));
    }

    public void print() {
        System.out.printf("%-25s %-20s %-20s %-20s %02d %04d %d:%02d", Title, Artist, Album, Genre, Track, Year, Length / 60, Length % 60);
    }

    public String getPath() {
        return Path;
    }

    public String getTitle() {
        return Title;
    }

    public String getArtist() {
        return Artist;
    }

    public String getAlbum() {
        return Album;
    }

    public String getGenre() {
        return Genre;
    }

    public int getTrack() {
        return Track;
    }

    public int getYear() {
        return Year;
    }

    public long getLength() {
        return Length;
    }

    public void setPath(String s) {
        Path = s;
    }

    public void setTitle(String s) {
        Title = s;
    }

    public void setArtist(String s) {
        Artist = s;
    }

    public void setAlbum(String s) {
        Album = s;
    }

    public void setGenre(String s) {
        Genre = s;
    } //?

    public void setTrack(int x) {
        Track = x;
    }

    public void setYear(int x) {
        Year = x;
    }

    public void setLength(long x) {
        Length = x;
    }

}
