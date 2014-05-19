/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.superadmin;

import Admin.Administrator;
import java.util.Scanner;

/**
 * Menampilkan data admin tertentu
 * @author CakBin
 */
public class AdminData {
    static String NIM;
    static boolean valid;
    static int option;
    static Scanner input=new Scanner(System.in);
    static Administrator Admin=DataController.AC.getAdmin();
    
    static void SelectOption(int i) throws OptionException{
        System.out.println("Insert option: ");
        option= Integer.valueOf(input.next());
        if (option > i || option <0){
            throw new OptionException("Invalid Option");
        }
        else{
            valid = true;
        }
    }
    
    static void print(){
        System.out.println("NIM: "+Admin.GetNIM());
        System.out.println("Nama: "+Admin.GetName());
        System.out.println("");
        System.out.println("Menu:");
        System.out.println("1. Hapus");
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
        if(option==1){AdminDeleteForm.action();}
        else{Admins.action(1,10);}
    }
    static void action(String _NIM){
        NIM=_NIM;
        print();
        input();
        execute();
    }
}
