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
public class FormLoginAdminCLI {
    private boolean superAdmin;
    public FormLoginAdminCLI(){
        loginAdmin();
    }
    private void loginAdmin(){
        System.out.println("=============================================");
        System.out.println("=============================================");
        System.out.println("==              Kolom Admin                ==");
        System.out.println("=============================================");
        System.out.println("=============================================");
        System.out.println("\n\n");
        System.out.println("Silakan login terlebih dahulu\n");
        System.out.print("Username > ");
        Scanner input = new Scanner(System.in);
        String username = new String();
        username = input.next();
        System.out.print("\nPassword > ");
        String password = new String();
        password = input.next();
    }
    public boolean isAdmin(String username, String password){
        boolean stop = false;
        if("entah".equals(username)){
            if("entah".equals(password)){
                stop = true;
            }
        }
        return stop;
    }
    public boolean isSuperAdmin(String username, String password){
        boolean stop = false;
        if("entah".equals(username)){
            if("entah".equals(password)){
                stop = true;
            }
        }
        return stop;
    }
}
