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
 * Formulir untuk masuk sebagai super admin
 * @author CakBin
 */
public class LoginMenu {
    static Scanner input = new Scanner (System.in);
    static String NIM;
    static String Pass;
    static boolean login;
    
    static void input(){
        System.out.print("NIM: ");
        NIM = input.next();
        System.out.print("Password: ");
        Pass = input.next();
    }
    static void execute(){
        login=false;
        try {
            if(!DataController.AC.checkLoginAdmin(NIM,Pass)){
            } else {
                login=true;
                System.out.println("Anda telah masuk sebagai Super Admin");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    static void action(){
        input();
        execute();
        while(login){ManageAdminMenu.action();}
    }
}
