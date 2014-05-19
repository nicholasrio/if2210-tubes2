/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.superadmin;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Formulir untuk menghapus data admin
 * @author CakBin
 */
public class AdminDeleteForm {
    static boolean valid;
    static int option;
    static Scanner input=new Scanner(System.in);
    
    static void SelectOption(int i) throws OptionException{
        System.out.println("Masukkan pilihan: ");
        option= Integer.valueOf(input.next());
        if (option > i || option <0){
            throw new OptionException("Pilihan tak valid");
        }
        else{
            valid = true;
        }
    }
    static void print(){
        System.out.println("Apa anda yakin akan menghapusnya?");
        System.out.println("0. Yes");
        System.out.println("1. No");
    }
    
    static void input(){
        valid=false;
        while(!valid){
            try {
                SelectOption(1);
            } catch (OptionException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    static void execute(){
        if(option==0){
            try {
                DataController.AC.AdminDelete(Integer.toString(DataController.AC.getAdmin().GetNIM()));
            } catch (SQLException ex) {
                Logger.getLogger(AddAdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    static void action(){
        print();
        input();
        execute();
        ManageAdminMenu.action();
    }
}
