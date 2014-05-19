/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.user;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CakBin
 */
public class GroupSearchMenuUser {
    static Scanner input = new Scanner (System.in);
    static String Group_Name;
    static int no_tubes;
    static int id;
    static boolean login;
    
    static void input(){
        System.out.print("Masukkan nama kelompok: ");
        Group_Name= input.nextLine();
        System.out.print("Masukkan no tugas besar: ");
        no_tubes = Integer.valueOf(input.nextLine());
    }
    static void execute(){
        try {
            id = DataController.SearchGroup(Group_Name,no_tubes);
            GroupPageUser.action(id);
        } catch (OptionException ex) {
            System.out.println(ex.getMessage());
            MainMenuUser.action();
        } catch (SQLException ex) {
            Logger.getLogger(GroupSearchMenuUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    static void action(){
        input();
        execute();
    }
}
