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
 * Formulir untuk mencari data video tertentu
 * @author CakBin
 */
public class VideoSearchForm {
    static Scanner input = new Scanner (System.in);
    static String VideoTitle;
    static int id;
    static boolean login;
    
    static void input(){
        System.out.print("Masukkan Judul: ");
        VideoTitle= input.nextLine();
    }
    static void execute(){
        try {
            id = DataController.SearchVideoByTitle(VideoTitle);
            VideoPage.action(id);
        } catch (OptionException ex) {
            System.out.println(ex.getMessage());
            ManageVideoMenu.action();
        } catch (SQLException ex) {
            Logger.getLogger(VideoSearchForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    static void action(){
        input();
        execute();
    }
}
