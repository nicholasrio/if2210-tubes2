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
public class GroupSearchForm {
    static Scanner input = new Scanner (System.in);
    static String Group_Name;
    static int no_tubes;
    static int id;
    static boolean login;
    
    static void input(){
        System.out.print("Insert Group Name: ");
        Group_Name= input.next();
        System.out.print("Insert Password: ");
        no_tubes = input.nextInt();
    }
    static void execute(){
        try {
            id = DataController.SearchGroup(Group_Name,no_tubes);
            GroupPage.action(id);
        } catch (OptionException ex) {
            System.out.println(ex.getMessage());
            ManageGroupMenu.action();
        } catch (SQLException ex) {
            Logger.getLogger(GroupSearchForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    static void action(){
        input();
        execute();
    }
}
