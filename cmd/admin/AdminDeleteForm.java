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
public class AdminDeleteForm {
    static boolean valid;
    static String NIM;
    static Scanner input=new Scanner(System.in);
    
    static void input(){
        System.out.print("Insert NIM: ");
        NIM = input.next();
    }
    static void execute(){
        try {
            Admins.AC.AdminDelete(NIM);
        } catch (SQLException ex) {
            Logger.getLogger(AddAdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    static void action(){
        input();
        execute();
        ManageAdminMenu.action();
    }
}
