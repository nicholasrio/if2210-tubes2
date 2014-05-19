/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gigamen;

import java.util.ArrayList;
import java.util.Collections;
import javax.xml.bind.annotation.*;
/**
 *
 * @author Fauzan
 */
@XmlRootElement
@XmlType(propOrder = {"playlistTitle", "playlist"})
public class Playlist {

    private ArrayList<Song> playlist;
    String PlaylistTitle;

    public String getPlaylistTitle() {
        return PlaylistTitle;
    }
    @XmlElement
    public void setPlaylistTitle(String PlaylistTitle) {
        this.PlaylistTitle = PlaylistTitle;
    }

    public ArrayList<Song> getPlaylist() {
        return playlist;
    }
    @XmlElement(name="song")
    public void setPlaylist(ArrayList<Song> p) {
        playlist = p;
    }
    public Playlist() {
        this.PlaylistTitle="Untitled Playlist";
        this.playlist = new ArrayList<>();
    }

    public Playlist(Playlist pL) {
        this.playlist = new ArrayList<>();
        this.playlist.addAll(pL.playlist);
    }

    public void addSong(Song song) {
        playlist.add(song);
    }

    public void delSong(Song song) {
        playlist.remove(song);
    }

    public Song getSongByTitle(String title) {
        int i;
        Song song = null;
        for (i = 0; i < playlist.size(); i++) {
            if (title.equals(playlist.get(i).getTitle())) {
                song = new Song(playlist.get(i));
            }
        }
        return song;
    }

    public int getIndexByTitle(String title) {
        int index = -1;
        for (int i = 0; i < playlist.size(); i++) {
            if (title.equals(playlist.get(i).getTitle())) {
                index = i;
            }
        }
        return index;
    }

    public ArrayList<Song> getSongByArtist(String artist) {
        int i;
        ArrayList<Song> tmp = new ArrayList<>();
        for (i = 0; i < playlist.size(); i++) {
            if (artist.equals(playlist.get(i).getArtist())) {
                tmp.add(playlist.get(i));
            }
        }
        return tmp;
    }

    /*
     public int getIndex(String artist) {
     int index = -1;
     for (int i = 0; i < playlist.size(); i++) {
     if (artist.equals(playlist.get(i).getTitle())) {
     index=i;
     }
     }
     return index;
     }
     */
    public ArrayList<Song> getSongByGenre(String genre) {
        ArrayList<Song> tmp = new ArrayList<>();
        for (int i = 0; i < playlist.size(); i++) {
            if (genre.equals(playlist.get(i).getGenre())) {
                tmp.add(playlist.get(i));
            }
        }
        return tmp;
    }

    /*
     public int getIndexByGenre(String genre) {
     int index = -1;
     for (int i = 0; i < playlist.size(); i++) {
     if (genre.equals(playlist.get(i).getGenre())) {
     index=i;
     }
     }
     return index;
     }
     */
    public ArrayList<Song> getSongByAlbum(String album) {
        ArrayList<Song> tmp = new ArrayList<>();
        for (int i = 0; i < playlist.size(); i++) {
            if (album.equals(playlist.get(i).getAlbum())) {
                tmp.add(playlist.get(i));
            }
        }
        return tmp;
    }

    /*
     public int getIndexByAlbum(String album) {
     int index = -1;
     for (int i = 0; i < playlist.size(); i++) {
     if (genre.equals(playlist.get(i).getGenre())) {
     index=i;
     }
     }
     return index;
     }
     */
    public ArrayList<Song> getSongByYear(int _i) {
        ArrayList<Song> tmp = new ArrayList<>();
        for (int i = 0; i < playlist.size(); i++) {
            if (playlist.get(i).getYear() == _i) {
                tmp.add(playlist.get(i));
            }
        }
        return tmp;
    }

    public ArrayList<Song> getSongByDuration(long _i) {
        ArrayList<Song> tmp = new ArrayList<>();
        for (int i = 0; i < playlist.size(); i++) {
            if (playlist.get(i).getLength() == _i) {
                tmp.add(playlist.get(i));
            }
        }
        return tmp;
    }

    public ArrayList<Song> getSongByTrack(int _i) {
        ArrayList<Song> tmp = new ArrayList<>();
        for (int i = 0; i < playlist.size(); i++) {
            if (playlist.get(i).getTrack() == _i) {
                tmp.add(playlist.get(i));
            }
        }
        return tmp;
    }

    /*
     public int getIndexByRating(String rating) {
     int index = -1;
     for (int i = 0; i < playlist.size(); i++) {
     if (genre.equals(playlist.get(i).getGenre())) {
     index=i;
     }
     } 
     return index;
     }
     */
    public void sortByTitle() {
        String[] holder = new String[playlist.size()];
        for (int i = 0; i < playlist.size(); i++) {
            holder[i] = playlist.get(i).getTitle();
        }
        //Sorting Title
        for (int i = 0; i < holder.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < holder.length; j++) {
                //ignore case?
                if (holder[j].compareToIgnoreCase(holder[min]) < 0) {
                    min = j;
                }
            }
            String tmp = holder[min];
            holder[min] = holder[i];
            holder[i] = tmp;

            ArrayList<Song> smt = new ArrayList<>();
            for (String holder1 : holder) {
                smt.add(playlist.get(getIndexByTitle(holder1)));
            }

            playlist.clear();
            playlist.addAll(smt);
        }
    }

    public void sortByAlbum() {
        ArrayList<String> holders = new ArrayList<>();
        for (int i = 0; i < playlist.size(); i++) {
            if (!holders.contains(playlist.get(i).getAlbum())) {
                holders.add(playlist.get(i).getAlbum());
            }
        }
        String[] holder = new String[holders.size()];
        for(int i=0;i<holder.length;i++){
            holder[i]=holders.get(i);
        }
        for (int i = 0; i < holder.length-1; i++) {
            int min = i;
            for (int j = i + 1; j < holder.length; j++) {
                //ignore case?
                if (holder[j].compareToIgnoreCase(holder[min]) < 0) {
                    min = j;
                }
            }
            String tmp = holder[min];
            holder[min] = holder[i];
            holder[i] = tmp;

            ArrayList<Song> smt = new ArrayList<>();
            for (String holder1 : holder) {
                smt.addAll(getSongByAlbum(holder1));
            }

            playlist.clear();
            playlist.addAll(smt);
        }
    }

    public void sortByArtist() {
        ArrayList<String> holders = new ArrayList<>();
        for (int i = 0; i < playlist.size(); i++) {
            if (!holders.contains(playlist.get(i).getArtist())) {
                holders.add(playlist.get(i).getArtist());
            }
        }
        String[] holder = new String[holders.size()];
        for (int i = 0; i < holder.length; i++) {
            holder[i] = holders.get(i);
        }
        //Sorting Title
        for (int i = 0; i < holder.length-1; i++) {
            int min = i;
            for (int j = i + 1; j < holder.length; j++) {
                //ignore case?

                if (holder[j].compareToIgnoreCase(holder[min]) < 0) {
                    min = j;
                }
            }
            String tmp = holder[min];
            holder[min] = holder[i];
            holder[i] = tmp;

            ArrayList<Song> smt = new ArrayList<>();
            for (String holder1 : holder) {
                smt.addAll(getSongByArtist(holder1));
            }

            playlist.clear();
            playlist.addAll(smt);
        }
    }

    public void sortByGenre() {
        ArrayList<String> holders = new ArrayList<>();

        for (int i = 0; i < playlist.size(); i++) {
            if (!holders.contains(playlist.get(i).getGenre())) {
                holders.add(playlist.get(i).getGenre());
            }
        }
        //Sorting Title

        String[] holder = new String[holders.size()];
        for (int i = 0; i < holder.length; i++) {
            holder[i] = holders.get(i);
        }
        for (int i = 0; i < holder.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < holder.length; j++) {
                //ignore case?
                if (holder[j].compareToIgnoreCase(holder[min]) < 0) {
                    min = j;
                }
            }
            String tmp = holder[min];
            holder[min] = holder[i];
            holder[i] = tmp;

            ArrayList<Song> smt = new ArrayList<>();
            for (String holder1 : holder) {
                smt.addAll(getSongByGenre(holder1));
            }

            playlist.clear();
            playlist.addAll(smt);
        }
    }

    public void sortByYear() {
        ArrayList<Integer> holders = new ArrayList<>();
        for (int i = 0; i < playlist.size(); i++) {
            if (!holders.contains(playlist.get(i).getYear())) {
                holders.add(playlist.get(i).getYear());
            }
        }
        Integer[] holder = new Integer[holders.size()];
        for (int i = 0; i < holder.length; i++) {
            holder[i] = holders.get(i);
        }
        for (int i = 0; i < holder.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < holder.length; j++) {
                if (holder[j] < holder[min]) {
                    min = j;
                }
            }
            int tmp = holder[min];
            holder[min] = holder[i];
            holder[i] = tmp;

            ArrayList<Song> smt = new ArrayList<>();
            for (int holder1 : holder) {
                smt.addAll(getSongByYear(holder1));
            }

            playlist.clear();
            playlist.addAll(smt);
        }
    }

    public void sortByDuration() {
        ArrayList<Long> holders = new ArrayList<>();
        for (int i = 0; i < playlist.size(); i++) {
            if (!holders.contains(playlist.get(i).getLength())) {
                holders.add(playlist.get(i).getLength());
            }
        }
        Long[] holder = new Long[holders.size()];
        for (int i = 0; i < holder.length; i++) {
            holder[i] = holders.get(i);
        }
        for (int i = 0; i < holder.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < holder.length; j++) {
                if (holder[j] < holder[min]) {
                    min = j;
                }
            }
            long tmp = holder[min];
            holder[min] = holder[i];
            holder[i] = tmp;

            ArrayList<Song> smt = new ArrayList<>();
            for (long holder1 : holder) {
                smt.addAll(getSongByDuration(holder1));
            }

            playlist.clear();
            playlist.addAll(smt);
        }
    }

    public void sortByTrack() {
        ArrayList<Integer> holders = new ArrayList<>();
        for (int i = 0; i < playlist.size(); i++) {
            if (!holders.contains(playlist.get(i).getTrack())) {
                holders.add(playlist.get(i).getTrack());
            }
        }
        Integer[] holder = (Integer[]) holders.toArray();
        for (int i = 0; i < holder.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < holder.length; j++) {
                if (holder[j] < holder[min]) {
                    min = j;
                }
            }
            int tmp = holder[min];
            holder[min] = holder[i];
            holder[i] = tmp;

            ArrayList<Song> smt = new ArrayList<>();
            for (int holder1 : holder) {
                smt.addAll(getSongByTrack(holder1));
            }

            playlist.clear();
            playlist.addAll(smt);
        }
    }

    public void sortByTitleDsc() {
        sortByTitle();
        Collections.reverse(playlist);
    }

    public void sortByAlbumDsc() {
        sortByAlbum();
        Collections.reverse(playlist);
    }

    public void sortByArtistDsc() {
        sortByArtist();
        Collections.reverse(playlist);
    }

    public void sortByGenreDsc() {
        sortByGenre();
        Collections.reverse(playlist);
    }

    public void sortByYearDsc() {
        sortByYear();
        Collections.reverse(playlist);
    }

    public void sortByDurationDsc() {
        sortByDuration();
        Collections.reverse(playlist);
    }

    public void sortByTrackDsc() {
        sortByTrack();
        Collections.reverse(playlist);
    }

    public void GroupByAlbum() {
        ArrayList<String> allAlbums = new ArrayList<>();
        ArrayList<Song> smt = new ArrayList<>();

        for (int i = 0; i < playlist.size(); i++) {
            if (!allAlbums.contains(playlist.get(i).getAlbum())) {
                allAlbums.add(playlist.get(i).getAlbum());
            }
        }
        allAlbums.stream().forEach((tmp) -> {
            smt.addAll(getSongByAlbum(tmp));
        });
        playlist.clear();
        playlist.addAll(smt);
    }

    public void GroupByGenre() {
        ArrayList<String> allGenre = new ArrayList<>();
        ArrayList<Song> smt = new ArrayList<>();

        for (int i = 0; i < playlist.size(); i++) {
            if (!allGenre.contains(playlist.get(i).getGenre())) {
                allGenre.add(playlist.get(i).getGenre());
            }
        }
        allGenre.stream().forEach((tmp) -> {
            smt.addAll(getSongByGenre(tmp));
        });
        playlist.clear();
        playlist.addAll(smt);
    }

    public void GroupByArtist() {
        ArrayList<String> allArtist = new ArrayList<>();
        ArrayList<Song> smt = new ArrayList<>();

        for (int i = 0; i < playlist.size(); i++) {
            if (!allArtist.contains(playlist.get(i).getArtist())) {
                allArtist.add(playlist.get(i).getArtist());
            }
        }
        allArtist.stream().forEach((tmp) -> {
            smt.addAll(getSongByArtist(tmp));
        });
        playlist.clear();
        playlist.addAll(smt);
    }

    public void GroupByYear() {
        ArrayList<Integer> allYear = new ArrayList<>();
        ArrayList<Song> smt = new ArrayList<>();

        for (int i = 0; i < playlist.size(); i++) {
            if (!allYear.contains(playlist.get(i).getYear())) {
                allYear.add(playlist.get(i).getYear());
            }
        }
        allYear.stream().forEach((Integer tmp) -> {
            smt.addAll(getSongByYear(tmp));
        });
        playlist.clear();
        playlist.addAll(smt);
    }

    public void GroupByDuration() {
        ArrayList<Long> allDuration = new ArrayList<>();
        ArrayList<Song> smt = new ArrayList<>();

        for (int i = 0; i < playlist.size(); i++) {
            if (!allDuration.contains(playlist.get(i).getLength())) {
                allDuration.add(playlist.get(i).getLength());
            }
        }
        allDuration.stream().forEach((Long tmp) -> {
            smt.addAll(getSongByDuration(tmp));
        });
        playlist.clear();
        playlist.addAll(smt);
    }

    public void GroupByTrack() {
        ArrayList<Integer> allTrack = new ArrayList<>();
        ArrayList<Song> smt = new ArrayList<>();

        for (int i = 0; i < playlist.size(); i++) {
            if (!allTrack.contains(playlist.get(i).getTrack())) {
                allTrack.add(playlist.get(i).getTrack());
            }
        }
        allTrack.stream().forEach((Integer tmp) -> {
            smt.addAll(getSongByTrack(tmp));
        });
        playlist.clear();
        playlist.addAll(smt);
    }

    public void shuffle() {
        Collections.shuffle(playlist);
    }

    @Override
    public String toString() {
        String s = "Playlist : " + PlaylistTitle;
        for (int i = 0; i < playlist.size(); i++) {
            s = s + "\n" + playlist.get(i).toString();
        }
        return s;
    }

    public void print() {
        System.out.println("Playlist : " + PlaylistTitle);
        for (int i = 0; i < playlist.size(); i++) {
            playlist.get(i).print();
            System.out.println();
        }
    }
    
    public void cleanFromError(){
        playlist.removeAll(this.getSongByDuration(0));
    }

    public void delSong(int no) {
        playlist.remove(no);
    }
}
