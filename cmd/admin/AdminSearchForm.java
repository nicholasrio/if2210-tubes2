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
public class AdminSearchForm {
    static Scanner input = new Scanner (System.in);
    static String NIM;
    static boolean login;
    
    static void input(){
        System.out.print("Insert NIM");
        NIM = input.next();
    }
    static void execute(){
        //validate existence, if exist...
        AdminData.action(NIM);
    }
    static void action(){
        input();
        execute();
    }
}
