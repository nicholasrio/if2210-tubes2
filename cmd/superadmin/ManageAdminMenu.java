/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.superadmin;

import java.util.Scanner;

/**
 * Menu utama untuk super admin dalam mengatur data admin
 * @author CakBin
 */
public class ManageAdminMenu {
    static boolean valid;
    static int option;
    static Scanner input=new Scanner(System.in);
    
    static void SelectOption(int i) throws OptionException{
        System.out.println("Masukkan pilihan: ");
        option= Integer.valueOf(input.next());
        if (option > i || option <0){
            throw new OptionException("Pilihan tak valid");
        }
        else{
            valid = true;
        }
    }
    static void print(){
        System.out.println("1. Daftarkan Admin");
        System.out.println("2. Tampilkan daftar Admin");
        System.out.println("3. Cari Admins");
        System.out.println("0. Logout");
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
        if(option==1){AddAdminForm.action();}
        else if(option==2){Admins.action(1,10);}
        else if(option==3){AdminSearchForm.action();}
        else{LoginMenu.login=false;}
    }
    static void action(){
        print();
        input();
        execute();
    }
}
