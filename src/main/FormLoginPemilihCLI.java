/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class FormLoginPemilihCLI {
    public FormLoginPemilihCLI(){
    
    }
    public void login(){
        int t=2014;
        System.out.println("=============================================");
        System.out.println("=============================================");
        System.out.println("==              Yuk, Coblos                ==");
        System.out.println("=============================================");
        System.out.println("=============================================");
        System.out.println("\n");
        System.out.println("Selamat datang di Software Pemilu "+t+"\n");
        System.out.println("Silakan login terlebih dahulu\n");
        System.out.println("username>");
        Scanner input = new Scanner(System.in);
        String username = new String();
        username = input.next();
        System.out.println("\npassword>");
        String password = new String();
        password = input.next();
    }
    public boolean isTerdaftar(String username, String password){
        boolean stop = false;
        if("entah".equals(username)){
            if("entah".equals(password)){
                stop = true;
            }
        }
        return stop;
    } 
}
