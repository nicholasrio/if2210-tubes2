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
public class DetailPage {
    static String title;
    static int no_tubes;
    static String group_name;
    static int id;
    static String link;
    static int rating;
    static int view;
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
        System.out.println("Video: "+title);
        System.out.println("Link: "+link);
        System.out.println("Group Name: "+group_name);
        System.out.println("Project Number: "+no_tubes);
        System.out.println("Rating: "+rating);
        System.out.println("View: "+view);
        System.out.println("");
        System.out.println("Menu:");
        System.out.println("0. Show Group");
        System.out.println("1. Show Video");
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
        if(option==1){VideoPageUser.action("ahya");}
        else{GroupPageUser.action(1,"topKek");}
    }
    static void action(String _title){
        title=_title;
        //add data according to title
        print();
        input();
        execute();
    }
    static void action(int _no_tubes, String _GroupName){
        group_name=_GroupName;
        no_tubes=_no_tubes;
        //add data according to Group data
        print();
        input();
        execute();
    }
}
