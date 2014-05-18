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
public class VideoPage {
    static String VideoTitle;
    static String URL;
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
        System.out.println("Video: "+VideoTitle);
        System.out.println("Link: "+URL);
        System.out.println("");
        System.out.println("Menu:");
        System.out.println("1. Edit");
        System.out.println("2. Delete");
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
        if(option==1){VideoEditForm.action();}
        else if(option==2){VideoDeleteForm.action();}
        else{Groups.action();}
    }
    static void action(String title){
        VideoTitle=title;
        print();
        input();
        execute();
    }
}
