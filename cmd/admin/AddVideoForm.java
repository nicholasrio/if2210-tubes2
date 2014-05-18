/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.admin;

import Video.NullException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CakBin
 */
public class AddVideoForm {
    static boolean valid;
    static String title;
    static int no_tubes;
    static String group_name;
    static String link;
    static Scanner input=new Scanner(System.in);
    
    static void input(){
        System.out.print("Insert title: ");
        title = input.next();
        System.out.print("Insert Video URL: ");
        link = input.next();
        System.out.print("Insert Group Name: ");
        group_name = input.next();
        System.out.print("Insert Project Number: ");
        no_tubes = input.nextInt();
    }
    static void execute(){
        System.out.println("The feature to add Video isn't not implemented yet");
    }
    static void action(){
        input();
        execute();
        ManageVideoMenu.action();
    }
}
