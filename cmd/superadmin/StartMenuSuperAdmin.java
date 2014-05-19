/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.superadmin;

import java.util.Scanner;

/**
 * Menu awal program utama super admin
 * @author CakBin
 */
public class StartMenuSuperAdmin {
    static boolean exit;
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
        System.out.println("1. Log in");
        System.out.println("0. Keluar");
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
        if(option==1){LoginMenu.action();}
        else {exit=true;}
    }
    static void action(){
        while(!exit){
            print();
            input();
            execute();
        }
    }
}
