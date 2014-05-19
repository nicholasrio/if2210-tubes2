/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Menampilkan detil untuk kelompok/video yang dipilih
 * @author CakBin
 */
public class DetailPage {
    static String title;
    static int no_tubes;
    static String group_name;
    static List<String> Member = new ArrayList<>();
    static String link;
    static int rating;
    static int view;
    static int VideoID;
    static int GroupID;
    static boolean valid;
    static int option;
    static Scanner input=new Scanner(System.in);
    
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
    
    static void print(){
        System.out.println("Video: "+title);
        System.out.println("Link: "+link);
        System.out.println("No Tugas Besar: "+no_tubes);
        System.out.println("Nama Kelompok: "+group_name);
        try {
            System.out.println("   Anggota 1: "+DataController.GC.GroupData().get(GroupID)[2]);
            System.out.println("   Anggota 2: "+DataController.GC.GroupData().get(GroupID)[3]);
            System.out.println("   Anggota 3: "+DataController.GC.GroupData().get(GroupID)[4]);
        } catch (SQLException ex) {
            Logger.getLogger(DetailPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Rating: "+rating);
        System.out.println("View: "+view);
        System.out.println("");
        System.out.println("Menu:");
        System.out.println("0. Tampilkan Kelompok");
        System.out.println("1. Tampilkan Video");
    }
    static void input(){
        valid=false;
        while(!valid){
            try{
                SelectOption(1);
            }
            catch(OptionException a){
                System.out.println(a.getMessage());
            }
        }
    }
    static void execute(){
        if(option==1){VideoPageUser.action(VideoID);}
        else{GroupPageUser.action(GroupID);}
    }
    static void action(String _title){
        title=_title;
        no_tubes=VideoPageUser.no_tubes;
        group_name=VideoPageUser.GroupName;
        link=VideoPageUser.URL;
        VideoID=VideoPageUser.id;
        GroupID=VideoPageUser.GroupID;
        try {
            GroupID=DataController.SearchGroup(group_name, no_tubes);
            view=Integer.valueOf(DataController.VC.SelectVideoData().get(VideoID)[3]);
            //add data according to title
            print();
            input();
            execute();
        } catch (SQLException ex) {
            Logger.getLogger(DetailPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (OptionException ex) {
            System.out.println(ex.getMessage());
            VideoPageUser.action(VideoID);
        }
        
    }
    static void action(int _no_tubes, String _GroupName){
        group_name=_GroupName;
        no_tubes=_no_tubes;
        GroupID=GroupPageUser.id;
        try {
            VideoID=DataController.SearchVideoByGroup(group_name, _no_tubes);
            title=DataController.VC.SelectVideoData().get(VideoID)[1];
            link=DataController.VC.SelectVideoData().get(VideoID)[2];
            view=Integer.valueOf(DataController.VC.SelectVideoData().get(VideoID)[3]);
            //add data according to Group data
            print();
            input();
            execute();
        } catch (SQLException ex) {
            Logger.getLogger(DetailPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (OptionException ex) {
            System.out.println(ex.getMessage());
            GroupPageUser.action(GroupID);
        }
        
    }
}
