/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.admin;

import java.util.Scanner;

/**
 * Menu utama untuk program utama admin
 * @author CakBin
 */
public class MainMenuAdmin {
    static boolean valid;
    static int option;
    static Scanner input=new Scanner(System.in);
    
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
        System.out.println("1. Atur Video");
        System.out.println("2. Atur Kelompok");
        System.out.println("0. Batal");
    }
    static void input(){
        valid=false;
         while(!valid){
            try{
                SelectOption(2);
            }
            catch(OptionException a){
                System.out.println(a.getMessage());
            }
        }
    }
    static void execute(){
        if(option==1){ManageVideoMenu.action();}
        else if(option==2){ManageGroupMenu.action();}
        else{LoginMenu.login=false;}
    }
    static void action(){
        print();
        input();
        execute();
    }
}
