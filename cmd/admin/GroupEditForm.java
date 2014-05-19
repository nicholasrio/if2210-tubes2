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
 * Formulir untuk mengedit data kelompok
 * @author CakBin
 */
public class GroupEditForm {
    static boolean valid;
    static int id;
    static int No_Tubes;
    static int new_no_tubes;
    static String GroupName;
    static String new_group_name;
    static int Num;
    static List<String> Member = new ArrayList<>();
    static Scanner input=new Scanner(System.in);
    
    static void input(){
        System.out.print("Masukkan no Tugas Besar: ");
        new_no_tubes = Integer.valueOf(input.nextLine());
        if(new_no_tubes==0){
            new_no_tubes=No_Tubes;
        }
        System.out.print("Nama kelompok: ");
        new_group_name = input.nextLine();
        if(new_group_name.equals("")){
            new_group_name=GroupName;
        }
        System.out.print("Jumlah Anggota: ");
        Num = Integer.valueOf(input.nextLine());
        for(int i = 0; i<Num; i++){
        System.out.print("Masukkan Anggota"+ (i+1) + " : ");
        Member.add(input.nextLine());
        }
    }
    static void execute(){
        try {
            DataController.GC.EditGroup(new_no_tubes, new_group_name, Member, No_Tubes, GroupName);
        } catch (SQLException ex) {
            Logger.getLogger(GroupEditForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    static void action(){
        id=GroupPage.id;
        try {
            GroupName=DataController.GC.GroupData().get(id)[1];
            No_Tubes=Integer.valueOf(DataController.GC.GroupData().get(id)[0]);
        } catch (SQLException ex) {
            Logger.getLogger(GroupEditForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        input();
        execute();
        ManageGroupMenu.action();
    }
}
