/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.admin;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Formulir untuk menghapus data video
 * @author CakBin
 */
public class VideoDeleteForm {
    static boolean valid;
    static int option;
    static int id;
    static int VidID;
    static Scanner input=new Scanner(System.in);
    
    static void SelectOption(int i) throws OptionException{
        System.out.println("Masukkan pilihan Menu: ");
        option= Integer.valueOf(input.next());
        if (option > i || option <0){
            throw new OptionException("Pilihan tak valid");
        }
        else{
            valid = true;
        }
    }
    
    static void print(){
        System.out.println("Apa anda yakin akan menghapus video ini?");
        System.out.println("0. Ya");
        System.out.println("1. Tidak");
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
        if(option==0){
            try {
                DataController.VC.DeleteVideo(VidID);
                ManageVideoMenu.action();
            } catch (SQLException ex) {
                Logger.getLogger(AddGroupForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            VideoPage.action(id);
        }
    }
    static void action(){
        id=VideoPage.id;
        try {
            VidID=Integer.valueOf(DataController.VC.SelectVideoData().get(id)[0]);
            print();
            input();
            execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(VideoDeleteForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
