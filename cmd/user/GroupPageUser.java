/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.user;

import java.util.Scanner;

/**
 *
 * @author CakBin
 */
public class GroupPageUser {
    static int No_tubes;
    static String Group_name;
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
        System.out.println("Group Name: "+Group_name);
        System.out.println("Project Number: "+No_tubes);
        System.out.println("");
        System.out.println("Menu:");
        System.out.println("1. Show Detail");
        System.out.println("2. Show Video");
        System.out.println("0. Back");
    }
    static void input(){
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
        if(option==1){DetailPage.action(No_tubes,Group_name);}
        else if(option==2){VideoPageUser.action("ahya");}
        else{MainMenuUser.action();}
    }
    static void action(int Tubes, String grup){
        No_tubes=Tubes;
        Group_name=grup;
        print();
        input();
        execute();
    }
}
