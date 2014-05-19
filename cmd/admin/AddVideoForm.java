/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.admin;

import Video.AttributeException;
import Video.NullException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Formulir untuk menambah data Video
 * @author CakBin
 */
public class AddVideoForm {
    static boolean valid;
    static String title;
    static int no_tubes;
    static String group_name;
    static String link;
    static Scanner input=new Scanner(System.in);
    
    static void input(){
        System.out.print("Masukkan Judul: ");
        title = input.nextLine();
        System.out.print("URL Video: ");
        link = input.nextLine();
        System.out.print("Nama kelompok: ");
        group_name = input.nextLine();
        System.out.print("No. Tugas Besar: ");
        no_tubes = Integer.valueOf(input.nextLine());
    }
    static void execute(){
        try {
            DataController.VC.AddVideo(title, link, group_name, no_tubes);
        } catch (AttributeException | SQLException | NullException ex) {
            Logger.getLogger(AddVideoForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Untuk Eksekusi AddGroupForm dari tempat lain
     */
    static void action(){
        input();
        execute();
        ManageVideoMenu.action();
    }
}
