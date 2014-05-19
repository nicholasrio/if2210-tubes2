/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.user;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Tampilkan daftar data kelompok
 * @author CakBin
 */
public class GroupsUser {
    static int up;
    static int down;
    static boolean valid;
    static int option;
    static String GroupName;
    static int no_tubes;
    static int id;
    static Scanner input=new Scanner(System.in);
    
    static void SelectChoice(){
        System.out.println("Masukkan nama kelompok: ");
        GroupName= input.nextLine();
        System.out.println("No tugas besar: ");
        no_tubes=Integer.valueOf(input.nextLine());
    }
    
    static void SelectOption(int i) throws OptionException{
        System.out.println("Masukkan pilihan menu: ");
        option= Integer.valueOf(input.nextLine());
        if (option > i || option <0){
            throw new OptionException("Pilihan tak valid");
        }
        else{
            valid = true;
        }
    }
    
    static void print(){
        for(int i=up-1;i<down;i++){
            try {
                System.out.println(Arrays.toString(DataController.GC.GroupData().get(i)));
            } catch (SQLException ex) {
                Logger.getLogger(GroupsUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("");
        System.out.println("1. Berikutnya");
        System.out.println("2. Sebelumnya");
        System.out.println("3. Pilih Kelompok");
        System.out.println("0. Kembali");
    }
    static void input(){
        valid=false;
        while(!valid){
            try{
                SelectOption(3);
            }
            catch(OptionException a){
                System.out.println(a.getMessage());
            }
        }
    }
    static void execute(){
        if(option==1){
            GroupsUser.action(up+10,down+10);
        }
        else if(option==2){GroupsUser.action(up-10,down-10);}
        else if(option==3){
            SelectChoice();
            try {
            id = DataController.SearchGroup(GroupName,no_tubes);
            GroupPageUser.action(id);
             } catch (OptionException ex) {
            System.out.println(ex.getMessage());
            GroupsUser.action(up,down);
            } catch (SQLException ex) {
            Logger.getLogger(GroupsUser.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else{MainMenuUser.action();}
    }
    static void action(int a, int b){
        up=a;
        down=b;
        try {
            if(down>DataController.GC.GroupData().size()){
                down=DataController.GC.GroupData().size();
                up=down-9;
                if(up<1){
                    up=1;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupsUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(up<1){
            up=1;
            down=up-9;
            try {
                if(down>DataController.GC.GroupData().size()){
                    down=DataController.GC.GroupData().size();
                }
            } catch (SQLException ex) {
                Logger.getLogger(GroupsUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        print();
        input();
        execute();
    }
}
