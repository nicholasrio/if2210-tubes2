/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.admin;

import java.util.Scanner;

/**
 * Formulir untuk menghapus data kelompok (belum diimplementasikan)
 * @author CakBin
 */
public class GroupDeleteForm {
    static boolean valid;
    static int No_Tubes;
    static String GroupName;
    static int Num;
    static String Member[];
    static Scanner input=new Scanner(System.in);
    
    static void input(){
        System.out.print("Masukkan no Tugas Besar: ");
        No_Tubes = input.nextInt();
        System.out.print("Nama Kelompok: ");
        GroupName = input.next();
        System.out.print("Jumlah Anggota: ");
        Num = input.nextInt();
        Member = new String[Num];
        for(int i = 0; i<Num; i++){
            System.out.print("Masukkan Anggota"+ (i+1));
            Member[0] = input.next();
        }
    }
    static void execute(){
        System.out.println("The feature to delete a Group data isn't implemented yet");
        
    }
    static void action(){
        input();
        execute();
        ManageGroupMenu.action();
    }
}
