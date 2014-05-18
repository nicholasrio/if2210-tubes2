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
 *
 * @author CakBin
 */
public class VideoDeleteForm {
    static boolean valid;
    static int option;
    static Scanner input=new Scanner(System.in);
    
    static void SelectOption(int i) throws OptionException{
        System.out.println("Insert option: ");
        option= input.nextInt();
        if (option > i || option <0){
            throw new OptionException("Invalid Option");
        }
        else{
            valid = true;
        }
    }
    
    static void print(){
        System.out.println("Are you sure you wanna erase this thing?");
        System.out.println("1. Yes");
        System.out.println("2. No");
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
        if(option==1){
            try {
                DataController.VC.DeleteVideo(VideoPage.id);
            } catch (SQLException ex) {
                Logger.getLogger(AddGroupForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    static void action(){
        print();
        input();
        execute();
        ManageVideoMenu.action();
    }
}
