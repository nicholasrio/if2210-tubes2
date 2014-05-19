/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.user;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CakBin
 */
public class VideosUser {
    static int up;
    static int down;
    static boolean valid;
    static int option;
    static int choice;
    static Scanner input=new Scanner(System.in);
    
    static void SelectChoice() throws OptionException, SQLException{
        System.out.println("Insert Video Number: ");
        choice= input.nextInt();
        if (choice<1 || choice>DataController.VC.SelectVideoData().size()){
            throw new OptionException("Invalid Number");
        }
        else{
            valid = true;
        }
    }
    
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
        for(int i=up-1;i<down;i++){
            try {
                System.out.println(Arrays.toString(DataController.VC.SelectVideoData().get(i)));
            } catch (SQLException ex) {
                Logger.getLogger(VideosUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("");
        System.out.println("1. Prev");
        System.out.println("2. Next");
        System.out.println("3. Select Video");
        System.out.println("0. Back");
    }
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
    static void execute(){
        if(option==1){
            VideosUser.action(down+10,up+10);
        }
        else if(option==2){VideosUser.action(down-10,up-10);}
        else if(option==3){
            try {
                SelectChoice();
                VideoPageUser.action(choice-1);
            } catch (OptionException ex) {
                System.out.println(ex.getMessage());
                VideosUser.action(up,down);
            } catch (SQLException ex) {
                Logger.getLogger(VideosUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{MainMenuUser.action();}
    }
    static void action(int a, int b){
        up=a;
        down=b;
        try {
            if(down>DataController.VC.SelectVideoData().size()){
                down=DataController.VC.SelectVideoData().size();
                up=down-9;
                if(up<1){
                    up=1;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(VideosUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(up<1){
            up=1;
            down=up+10;
            try {
                if(down>DataController.VC.SelectVideoData().size()){
                    down=DataController.VC.SelectVideoData().size();
                }
            } catch (SQLException ex) {
                Logger.getLogger(VideosUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        print();
        input();
        execute();
    }
}
