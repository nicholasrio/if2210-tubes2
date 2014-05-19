/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.admin;

import java.util.Scanner;

/**
 * Menu awal pada program utama untuk admin
 * @author CakBin
 */
public class StartMenuAdmin {
    static boolean exit;
    static boolean valid;
    static int option;
    static Scanner input=new Scanner(System.in);
    
    static void SelectOption(int i) throws OptionException{
        System.out.println("Masukkan Pilihan Menu: ");
        option= Integer.valueOf(input.next());
        if (option > i || option <0){
            throw new OptionException("Pilihan tidak valid");
        }
        else{
            valid = true;
        }
    }
    static void print(){
        System.out.println("1. Login");
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
