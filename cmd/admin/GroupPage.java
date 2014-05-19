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
 * Untuk menunjukkan data kelompok tertentu
 * @author CakBin
 */
public class GroupPage {
    static int id;
    static boolean valid;
    static int option;
    static Scanner input=new Scanner(System.in);
    
    static void SelectOption(int i) throws OptionException{
        System.out.println("Masukkan pilihan menu: ");
        option= input.nextInt();
        if (option > i || option <0){
            throw new OptionException("Pilihan tak valid");
        }
        else{
            valid = true;
        }
    }
    
    
    static void print(){
        try {
            System.out.println("Nama Kelompok: "+DataController.GC.GroupData().get(id)[1]);
            System.out.println("No Tugas Besar: "+DataController.GC.GroupData().get(id)[0]);
            System.out.println("Anggota 1: "+DataController.GC.GroupData().get(id)[2]);
            System.out.println("Anggota 2: "+DataController.GC.GroupData().get(id)[3]);
            System.out.println("Anggota 3: "+DataController.GC.GroupData().get(id)[4]);
        } catch (SQLException ex) {
            Logger.getLogger(GroupPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("");
        System.out.println("1. Ubah");
        System.out.println("0. Kembali");
    }
    static void input(){
        valid=false;
        while(!valid){
            try{
                SelectOption(1);
            }
            catch(OptionException a){
                System.out.println(a.getMessage());
            }
        }
    }
    static void execute(){
        if(option==1){
            GroupEditForm.action();
        }
        else{
            Groups.action(1,10);
        }
    }
    static void action(int _id){
        id=_id;
        print();
        input();
        execute();
    }
}
