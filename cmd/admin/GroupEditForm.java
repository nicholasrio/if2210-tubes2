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
public class GroupEditForm {
    static boolean valid;
    static int No_Tubes;
    static String GroupName;
    static int Num;
    static String Member[];
    static Scanner input=new Scanner(System.in);
    
    static void input(){
        System.out.print("Insert Project Number: ");
        No_Tubes = input.nextInt();
        System.out.print("Insert Group Name: ");
        GroupName = input.next();
        System.out.print("Number of Member: ");
        Num = input.nextInt();
        Member = new String[Num];
        for(int i = 0; i<Num; i++){
            System.out.print("Insert Member"+ (i+1));
            Member[0] = input.next();
        }
    }
    static void execute(){
        Groups.GC.UpdateGroup();
        
    }
    static void action(){
        input();
        execute();
        ManageGroupMenu.action();
    }
}
