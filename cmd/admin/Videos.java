/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.admin;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Menampilkan daftar data video
 * @author CakBin
 */
public class Videos {
    static int up;
    static int down;
    static boolean valid;
    static int option;
    static String choice;
    static Scanner input=new Scanner(System.in);
    static int id;
    
    static void SelectChoice(){
        System.out.print("Masukkan Judul: ");
        choice= input.nextLine();
    }
    
    static void SelectOption(int i) throws OptionException{
        System.out.println("Masukkan pilihan menu: ");
        option= Integer.valueOf(input.nextLine());
        if (option > i || option <0){
            throw new OptionException("Pilihan tidak valid");
        }
        else{
            valid = true;
        }
    }
    
    static void print(){
        for(int i=(up-1);i<down;i++){
            try {
                System.out.println(Arrays.toString(DataController.VC.SelectVideoData().get(i)));
            } catch (SQLException ex) {
                Logger.getLogger(Videos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("");
        System.out.println("1. Berikutnya");
        System.out.println("2. Sebelumnya");
        System.out.println("3. Pilih Video");
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
            Videos.action(up+10,down+10);
        }
        else if(option==2){Videos.action(up-10,down-10);}
        else if(option==3){
            try {
                SelectChoice();
                id = DataController.SearchVideoByTitle(choice);
                VideoPage.action(id);
            } catch (OptionException ex) {
                System.out.println(ex.getMessage());
                Videos.action(up,down);
            } catch (SQLException ex) {
                Logger.getLogger(Videos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{ManageVideoMenu.action();}
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
            Logger.getLogger(Videos.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(up<1){
            up=1;
            down=up+9;
            try {
                if(down>DataController.VC.SelectVideoData().size()){
                    down=DataController.VC.SelectVideoData().size();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Videos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        print();
        input();
        execute();
    }
}
