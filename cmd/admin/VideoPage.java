/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.admin;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import cmd.cmdVidPlayer;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Menampilkan data video tertentu
 * @author CakBin
 */
public class VideoPage {
    static String VideoTitle;
    static String URL;
    static int id;
    static boolean valid;
    static int option;
    static Scanner input=new Scanner(System.in);
    static cmdVidPlayer cmd;
    
    static void SelectOption(int i) throws OptionException{
        System.out.println("Masukkan Pilihan menu: ");
        option= Integer.valueOf(input.next());
        if (option > i || option <0){
            throw new OptionException("Masukan tak valid");
        }
        else{
            valid = true;
        }
    }
    
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
    
    static void print(){
        System.out.println("Video: "+VideoTitle);
        System.out.println("Tautan: "+URL);
        System.out.println("");
        System.out.println("Menu:");
        System.out.println("1. Ubah");
        System.out.println("2. Hapus");
        System.out.println("0. Kembali");
    }
    static void input(){
        valid=false;
        while(!valid){
            try{
                SelectOption(2);
            }
            catch(OptionException a){
                System.out.println(a.getMessage());
            }
        }
    }
    static void execute(){
        cmd.Exit();
        if(option==1){VideoEditForm.action();}
        else if(option==2){VideoDeleteForm.action();}
        else{Videos.action(1,10);}
    }
    static void action(int _id){
        id=_id;
        try {
            VideoTitle=DataController.VC.SelectVideoData().get(id)[1];
            URL=DataController.VC.SelectVideoData().get(id)[2];
            PlayVideo();
            print();
            input();
            execute();
        } catch (SQLException ex) {
            Logger.getLogger(VideoPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
