/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.superadmin;

import Admin.AdminException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Menampilkan daftar data admin
 * @author CakBin
 */
public class Admins {
    static int up;
    static int down;
    static boolean valid;
    static int option;
    static String choice;
    static Scanner input=new Scanner(System.in);
    
    static void SelectChoice(){
        System.out.println("Masukkan NIM: ");
        choice= input.next();
    }
    
    static void SelectOption(int i) throws OptionException{
        System.out.println("Masukkan piihan menu: ");
        option= Integer.valueOf(input.next());
        if (option > i || option <0){
            throw new OptionException("Pilihan tak valid");
        }
        else{
            valid = true;
        }
    }
    
    static void print(){
        for(int i=up-1;i<down;i++){
            try {
                System.out.println(Arrays.toString(DataController.AC.getAdminsData().get(i)));
            } catch (SQLException ex) {
                Logger.getLogger(Admins.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("");
        System.out.println("1. Berikutnya");
        System.out.println("2. Sebelumnya");
        System.out.println("3. Pilih Admin");
        System.out.println("0. Kembali");
    }
    static void input(){
        valid=false;
        while(!valid){
            try{
                SelectOption(4);
            }
            catch(OptionException a){
                System.out.println(a.getMessage());
            }
        }
    }
    static void execute(){
        if(option==1){
            Admins.action(up+10,down+10);
        }
        else if(option==2){Admins.action(up-10,down-10);}
        else if(option==3){
            SelectChoice();
            try {
                    DataController.AC.CallNIM(choice);
                    AdminData.action(choice);
                } catch (SQLException ex) {
                    Logger.getLogger(AdminSearchForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (AdminException ex) {
                    System.out.println(ex.getMessage());
                    Admins.action(up, down);
                }
        }
        else{ManageAdminMenu.action();}
    }
    static void action(int a, int b){
        up=a;
        down=b;
        try {
            if(down>DataController.AC.getAdminsData().size()){
                down=DataController.AC.getAdminsData().size();
                up=down-9;
                if(up<1){
                    up=1;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admins.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(up<1){
            up=1;
            down=up+9;
            try {
                if(down>DataController.AC.getAdminsData().size()){
                    down=DataController.AC.getAdminsData().size();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Admins.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        print();
        input();
        execute();
    }
}
