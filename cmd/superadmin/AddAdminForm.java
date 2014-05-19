/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.superadmin;

import Video.NullException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Formulir untuk menambah data admin
 * @author CakBin
 */
public class AddAdminForm {
    static boolean valid;
    static String NIM;
    static String Name;
    static String Password;
    static Scanner input=new Scanner(System.in);
    
    static void input(){
        System.out.print("Masukkan NIM: ");
        NIM = input.nextLine();
        System.out.print("Nama: ");
        Name = input.nextLine();
        System.out.print("Password: ");
        Password = input.nextLine();
    }
    static void execute(){
        try {
            DataController.AC.AdminRegister(NIM, Name, Password);
        } catch (SQLException | NullException ex) {
            Logger.getLogger(AddAdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    static void action(){
        input();
        execute();
        ManageAdminMenu.action();
    }
}
