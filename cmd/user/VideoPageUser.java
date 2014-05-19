/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.user;

import Main.GuestView;
import Xml.StaxWriter;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import cmd.cmdVidPlayer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Menampilkan data video tertentu
 * @author CakBin
 */
public class VideoPageUser {
    static String VideoTitle;
    static String URL;
    static String GroupName;
    static int no_tubes;
    static int id;
    static int GroupID;
    static boolean valid;
    static int option;
    static int rating;
    static String Rated;
    static List<String> Rate = new ArrayList<>();
    static Scanner input=new Scanner(System.in);
    static cmdVidPlayer cmd;
    
    /**
     * Untuk inisialisasi data rating
     */
    static void InitRate(){
        try {
            for(int i = 0; i< DataController.VC.SelectVideoData().size();i++){
                Rate.add(i,"Rating : 0");
            }
        } catch (SQLException ex) {
            Logger.getLogger(VideoPageUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Fungsi khusus untuk User, untuk mengisi rate untuk video
     */
    static void RateIt(){
        try {
            InsertRate();
        } catch (OptionException ex) {
            Logger.getLogger(VideoPageUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        Rate.add(id, "Rating : "+rating);
        try 
        {
            StaxWriter configFile = new StaxWriter();
            configFile.setConfigFile("xml/ratings.xml");
            configFile.setRating(Rate);
            configFile.setVid(DataController.VC.SelectVideoData());
            configFile.saveConfig();
            System.out.println("Berhasil memasukkan rating");
        } catch (Exception ex) {
            Logger.getLogger(GuestView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Untuk mengisi Rating
     * @throws OptionException 
     */
    static void InsertRate()throws OptionException{
        System.out.println("Masukkan rating: ");
        rating= Integer.valueOf(input.next());
        if (rating > 5 || option <0){
            throw new OptionException("Angka tidak tepat");
        }
    }
    
    /**
     * Untuk memasukkan pilihan menu, i merupakan jumlah pilihan dalam menu 
     * @param i
     * @throws OptionException 
     */
    static void SelectOption(int i) throws OptionException{
        System.out.println("Masukkan pilihan menu: ");
        option= Integer.valueOf(input.next());
        if (option > i || option <0){
            throw new OptionException("Pilihan tak valid");
        }
        else{
            valid = true;
        }
    }
    
    /**
     * Memainkan "video" yang dipilih
     */
    static void PlayVideo(){
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                NativeInterface.open();
                cmd = new cmdVidPlayer(URL);
                cmd.setVisible(true);
            }
        });
    }
    
    
    /**
     * Mencetak pilihan menu
     */
    static void print(){
        System.out.println("Video: "+VideoTitle);
        System.out.println("Link: "+URL);
        System.out.println("");
        System.out.println("Menu:");
        System.out.println("1. Tampilkan Detil");
        System.out.println("2. Tampilkan Kelompok");
        System.out.println("3. Tambahkan Rating");
        System.out.println("0. Kembali");
    }
    
    
    /**
     * Pengulangan untuk masukan, semisal terjadi kesalahan masukan
     */
    static void input(){
        valid=false;
        while(!valid){
            try{
                SelectOption(3);
            }
            catch(OptionException a){
                System.out.println(a.getMessage());
            }
        }
    }
    
    
    /**
     * Menjalankan menu berdasarkan masukan
     */
    static void execute(){
        cmd.Exit();
        if(option==1){
            DetailPage.action(VideoTitle);            
        }
        else if(option==2){
            try {
                GroupID=DataController.SearchGroup(GroupName, no_tubes);
                GroupPageUser.action(GroupID);
            } catch (SQLException ex) {
            } catch (OptionException ex) {
                VideoPageUser.action(id);
            }
            
        }
        else if(option==3){
            RateIt();
            VideoPageUser.action(id);
        }
        else{
            VideosUser.action(1,10);
        }
    }
    
    /**
     * Menjalankan keseluruhan VideoPageUser, dibuat supaya bisa diakses dari
     * "halaman" lain. _id adalah ID untuk video yang akan dimainkan.
     * @param _id 
     */
    static void action(int _id){
        id=_id;
        InitRate();
        try {
            VideoTitle=DataController.VC.SelectVideoData().get(id)[1];
            URL=DataController.VC.SelectVideoData().get(id)[2];
            GroupName=DataController.VC.SelectVideoData().get(id)[5];
            no_tubes=Integer.valueOf(DataController.VC.SelectVideoData().get(id)[4]);
            
        } catch (SQLException ex) {
            Logger.getLogger(VideoPageUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        PlayVideo();
        print();
        input();
        execute();
    }
}
