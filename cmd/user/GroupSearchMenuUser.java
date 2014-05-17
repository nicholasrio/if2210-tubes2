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
public class GroupSearchMenuUser {
    static Scanner input = new Scanner (System.in);
    static String Group_Name;
    static int no_tubes;
    static boolean login;
    
    static void input(){
        System.out.print("Insert Group Name");
        Group_Name= input.next();
        System.out.print("Insert Password");
        no_tubes = input.nextInt();
    }
    static void execute(){
        //validate existence, if exist...
        GroupPageUser.action(no_tubes,Group_Name);
    }
    static void action(){
        input();
        execute();
    }
}
