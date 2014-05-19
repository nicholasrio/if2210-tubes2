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
 * @author ACER
 */
public class Console {

    public static void main(String args[]) throws IOException, UnsupportedTagException, InvalidDataException {

        System.out.println("Playlist Manager");
        System.out.println("----------------");
        System.out.println();
        System.out.println("1. Add Playlist");
        System.out.println("2. Edit Playlist");
        System.out.println("3. Delete Playlist");
        System.out.println("4. Show Playlist");
        System.out.println("5. Show Song");
        System.out.println("Ketix exit unutk keluar");
        System.out.println();
        System.out.println("Pilihan menu:");

        Scanner input = new Scanner(System.in);
        String opsi;
        PlaylistManager pm = new PlaylistManager();
        opsi = input.next();
        pm = PlaylistManager.Import();

        while (opsi.compareTo("exit") != 0) {
            if (opsi.compareTo("1") == 0) {
                Scanner title = new Scanner(System.in);
                System.out.println(pm);
                pm.AddPlaylist();
                System.out.printf("Masukkan nama playlist: ");
                String nama = title.nextLine();
                pm.getCollection().get(pm.getCollection().size() - 1).setPlaylistTitle(nama);
                PlaylistManager.Export(pm);
            } else if (opsi.compareTo("2") == 0) {
                Scanner playlist = new Scanner(System.in);
                System.out.println(pm);
                System.out.println("Masukkan indeks playlist yang ingin diedit : ");
                int pil = playlist.nextInt();
                while (pil >= pm.getCollection().size()) {
                    System.out.printf("Masukan salah, silahkan masukan indeks baru");
                    pil = playlist.nextInt();
                }
                String command = "";
                while (!command.toLowerCase().contains("exit")) {
                    System.out.println(pm.getCollection().get(pil));
                    System.out.println("Masukkan command untuk editing. Format :\n"
                            + "Menambah lagu : add [Path\n]"
                            + "Menghapus lagu : del [NomorIndeks] \n"
                            + "Merename playlist : ren [NamaBaru]\n"
                            + "Keluar : exit ");
                    System.out.println("Command : ");
                    command = playlist.nextLine();
                    if (command.toLowerCase().contains("add")) {
                        String path = command.substring(4);
                        Song tmp = new Song(path);
                        pm.getCollection().get(pil).addSong(tmp);
                    } else if (command.toLowerCase().contains("del")) {
                        String path = command.substring(4);
                        int no = Integer.valueOf(path);
                        while (no >= pm.getCollection().get(pil).getPlaylist().size() && no != -1) {
                            System.out.printf("Masukan salah, silahkan masukan indeks baru (-1 untuk batal)");
                            no = playlist.nextInt();
                        }
                        if (no != -1) {
                            pm.getCollection().get(pil).delSong(no);
                        }
                    } else if (command.toLowerCase().contains("ren")) {
                        String path = command.substring(4);
                         pm.getCollection().get(pil).setPlaylistTitle(path);
                    } else {
                        System.out.println("Masukkan salah");
                    }
                }

            } else if (opsi.compareTo("3") == 0) {
                Scanner playlist = new Scanner(System.in);
                System.out.println(pm);
                int pil = playlist.nextInt();
                while (pil >= pm.getCollection().size()) {
                    System.out.printf("Masukan salah, silahkan masukan indeks baru");
                    pil = playlist.nextInt();
                }
                pm.DelPlayList(pm.getCollection().get(pil));
            } else if (opsi.compareTo("4") == 0) {
                if (!pm.getCollection().isEmpty()) {
                    System.out.println(pm);
                }
            } else if (opsi.compareTo("5") == 0) {
                if (!pm.getCollection().isEmpty()) {
                    Scanner playlist = new Scanner(System.in);
                    System.out.println(pm);
                    System.out.printf("Masukkan indeks list");
                    int playlist_title = playlist.nextInt();

                    while (playlist_title >= pm.getCollection().size()) {
                        System.out.printf("Masukan salah, silahkan masukan indeks baru");
                        playlist_title = playlist.nextInt();
                    }
                    System.out.println(pm.getCollection().get(playlist_title));
                } else {
                    System.out.println("Tidak ada playlist");
                }
            } else {
                System.out.println("Masukan salah");
            }
             System.out.println("Masukan PILIHAN MENU : ");
            opsi = input.next();
        }

        PlaylistManager.Export(pm);
    }

}
