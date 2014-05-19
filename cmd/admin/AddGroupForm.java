/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Formulir untuk menambah data kelompok
 * @author CakBin
 */
public class AddGroupForm {
    static boolean valid;
    static int No_Tubes;
    static String GroupName;
    static int Num;
    static List<String>Member = new ArrayList<>();
    static String Name;
    static Scanner input=new Scanner(System.in);
    
    static void input(){
        System.out.print("Masukkan nomor Tugas Besar: ");
        No_Tubes = Integer.valueOf(input.nextLine());
        System.out.print("Nama Kelompok: ");
        GroupName = input.nextLine();
        System.out.print("Jumlah Anggota: ");
        Num = Integer.valueOf(input.nextLine());
        for(int i = 0; i<Num; i++){
            System.out.print("Masukkan Anggota "+ (i+1)+" : ");
            Name=input.nextLine();
            Member.add(Name);
        }
    }
    static void execute(){
        try {
            DataController.GC.RegisterGroup(No_Tubes,GroupName,Member);
        } catch (SQLException ex) {
            Logger.getLogger(AddGroupForm.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    /**
     * Untuk Eksekusi AddGroupForm dari tempat lain
     */
    static void action(){
        input();
        execute();
        ManageGroupMenu.action();
    }
}
