/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.user;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CakBin
 */
public class GroupPageUser {
    static int id;
    static String GroupName;
    static int no_tubes;
    static boolean valid;
    static int option;
    static int VidId;
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
        try {
            System.out.println("Group Name: "+DataController.GC.GroupData().get(id)[1]);
            System.out.println("Project Number: "+DataController.GC.GroupData().get(id)[0]);
            System.out.println("Member 1: "+DataController.GC.GroupData().get(id)[2]);
            System.out.println("Member 2: "+DataController.GC.GroupData().get(id)[3]);
            System.out.println("Member 3: "+DataController.GC.GroupData().get(id)[4]);
        } catch (SQLException ex) {
            Logger.getLogger(GroupPageUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("");
        System.out.println("Menu:");
        System.out.println("1. Show Details");
        System.out.println("2. Show Video");
        System.out.println("0. Back");
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
        if(option==1){DetailPage.action(no_tubes,GroupName);}
        else if(option==2){VideoPageUser.action(VidId);}
        else{GroupsUser.action(1,10);}
    }
    static void action(int _id){
        id=_id;
        try {
            no_tubes=Integer.valueOf(DataController.GC.GroupData().get(id)[0]);
            GroupName=DataController.GC.GroupData().get(id)[1];
            VidId=DataController.SearchVideoByGroup(GroupName, no_tubes);
        } catch (SQLException | OptionException ex) {
            Logger.getLogger(GroupPageUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        print();
        input();
        execute();
    }
}
