/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.superadmin;

import Admin.AdminException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Formulir untuk mencari data admin tertentu
 * @author CakBin
 */
public class AdminSearchForm {
    static Scanner input = new Scanner (System.in);
    static String NIM;
    static boolean login;
    
    static void input(){
        System.out.print("Masukkan NIM: ");
        NIM = input.next();
    }
    static void execute(){
        try {
            DataController.AC.CallNIM(NIM);
            AdminData.action(NIM);
        } catch (SQLException ex) {
            Logger.getLogger(AdminSearchForm.class.getName()).log(Level.SEVERE, null, ex);
            ManageAdminMenu.action();
        } catch (AdminException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    static void action(){
        input();
        execute();
    }
}
