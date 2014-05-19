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
public class ManageAdminMenu {
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
        System.out.println("1. Register Admin");
        System.out.println("2. View Admins");
        System.out.println("3. Search Admins");
        System.out.println("0. Cancel");
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
        else{MainMenuAdmin.action();}
    }
    static void action(){
        print();
        input();
        execute();
    }
}
