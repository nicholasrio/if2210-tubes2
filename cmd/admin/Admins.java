/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.admin;

import Admin.*;
import java.util.Scanner;

/**
 *
 * @author CakBin
 */
public class Admins {
    static AdministratorController AC;
    static int up;
    static int down;
    static Administrator A[];
    static boolean valid;
    static int option;
    static int choice;
    static Scanner input=new Scanner(System.in);
    
    static void SelectChoice(int i) throws OptionException{
        System.out.println("Insert option: ");
        choice= input.nextInt();
        if (choice > i || choice <0){
            throw new OptionException("Invalid Choice");
        }
        else{
            valid = true;
        }
    }
    
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
        System.out.println("Admin output form "+up+" to "+down);
        System.out.println("");
        System.out.println("1. Select Admin");
        System.out.println("0. Back");
    }
    static void input(){
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
        if(option==1){
            valid=false;
            try{
                SelectChoice(10);
            }
            catch(OptionException a){
                System.out.println(a.getMessage());
            }
            if(valid){
                AdminData.action("19234");
            }
        }
        else{ManageAdminMenu.action();}
    }
    static void action(){
        print();
        input();
        execute();
    }
}
