/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.admin;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CakBin
 */
public class Groups {
    static int up;
    static int down;
    static boolean valid;
    static int option;
    static String GroupName;
    static int no_tubes;
    static int id;
    static Scanner input=new Scanner(System.in);
    
    static void SelectChoice(){
        System.out.println("Insert Group Name: ");
        GroupName= input.next();
        System.out.println("Insert Project Number: ");
        no_tubes=input.nextInt();
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
        for(int i=up-1;i<down;i++){
            try {
                System.out.println(DataController.GC.GroupData().get(i)[1]+DataController.GC.GroupData().get(i)[2]);
                for(int j=3;j<=(DataController.GC.GroupData().size());j++){
                    System.out.println("Member"+ (j-2) +" :" +DataController.GC.GroupData().get(i)[j]);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Groups.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("");
        System.out.println("1. Prev");
        System.out.println("2. Next");
        System.out.println("3. Select Admin");
        System.out.println("0. Back");
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
        if(option==1){
            Groups.action(down+10,up+10);
        }
        else if(option==2){Groups.action(down-10,up-10);}
        else if(option==3){
            SelectChoice();
            try {
            id = DataController.SearchGroup(GroupName,no_tubes);
            GroupPage.action(id);
             } catch (OptionException ex) {
            System.out.println(ex.getMessage());
            Groups.action(up,down);
            } catch (SQLException ex) {
            Logger.getLogger(Groups.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else{ManageGroupMenu.action();}
    }
    static void action(int a, int b){
        up=a;
        down=b;
        try {
            if(down>DataController.GC.GroupData().size()){
                down=DataController.GC.GroupData().size();
                up=down-9;
                if(up<1){
                    up=1;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Groups.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(up<1){
            up=1;
            down=up+10;
            try {
                if(down>DataController.GC.GroupData().size()){
                    down=DataController.GC.GroupData().size();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Groups.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        print();
        input();
        execute();
    }
}
