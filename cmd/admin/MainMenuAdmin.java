/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.admin;

import java.util.Scanner;

/**
 *
 * @author CakBin
 */
public class MainMenuAdmin {
    static boolean valid;
    static int option;
    static Scanner input=new Scanner(System.in);
    
    static void SelectOption(int i) throws OptionException{
        System.out.println("Insert option: ");
        option= input.nextInt();
        if (option > i || option <0){
            throw new OptionException("Invalid Option");
        }
        else{
            valid = true;
        }
    }
    static void print(){
        System.out.println("1. Manage Videos");
        System.out.println("2. Manage Groups");
        System.out.println("3. Manage Admins");
        System.out.println("0. Logout");
    }
    static void input(){
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
        if(option==1){ManageVideoMenu.action();}
        else if(option==2){ManageGroupMenu.action();}
        else if(option==3){ManageAdminMenu.action();}
        else{LoginMenu.login=false;}
    }
    static void action(){
        print();
        input();
        execute();
    }
}
