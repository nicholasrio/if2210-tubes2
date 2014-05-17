/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CLI;

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
        System.out.println("Anda ingin login sebagai?");
        System.out.println("1. Admin");
        System.out.println("2. Super Admin");
        System.out.print("Silakan masukkan pilihan Anda (1/2) : ");
        Scanner input = new Scanner(System.in);
        int pilihan = input.nextInt();
    }
    public void login(){
        Scanner input = new Scanner(System.in);
        System.out.print("Username > ");
        String username = input.next();
        System.out.print("\nPassword > ");
        String password = input.next();
        if(isAdmin(username, password)){}
        else if(isSuperAdmin(username, password)){}
    }
    public boolean isAdmin(String username, String password){
        boolean stop = false;
        for (int i = 0; i < 10; i++){
            if("entah".equals(username)){
                if("entah".equals(password)){
                    stop = true;
                }
            }
        }
        return stop;
    }
    public boolean isSuperAdmin(String username, String password){
        boolean stop = false;
        for (int i = 0; i < 10; i++){
            if("entah".equals(username)){
                if("entah".equals(password)){
                    stop = true;
                }
            }
        }
        return stop;
    }
}
