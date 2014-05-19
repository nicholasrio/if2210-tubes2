/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CLI;

import Tools.PasswordErrorException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Admin;

/**
 *
 * @author user
 */
public class FormLoginAdminCLI {
    private FormAdminCLI formAdminCLI;
    private FormSuperAdminCLI formSuperAdminCLI;
    public FormLoginAdminCLI(){
        formAdminCLI = new FormAdminCLI();
        formSuperAdminCLI = new FormSuperAdminCLI();
    }
    public void start(){
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
        if (pilihan == 1){
            if (isAdmin()){
                System.out.println("Anda berhasil login!");
                formAdminCLI.start();
            }
            else
                System.out.println("Ulangi lagi!");
        }
        else if (pilihan == 2){
            if (isSuperAdmin()){
                System.out.println("Anda berhasil login!");
                formSuperAdminCLI.start();
            }
            else
                System.out.println("Ulangi lagi!");
        }
    }
    public void login(String username, String password){
        Scanner input = new Scanner(System.in);
        System.out.print("Username > ");
        username = input.next();
        System.out.print("\nPassword > ");
        password = input.next();
    }
    public boolean isAdmin(){
        String username = new String();
        String password = new String();
        login(username, password);
        boolean benar = false;
        boolean valid = false;
        Admin admin = new Admin(username, password, benar);
        try {
            valid = admin.ValidateInput();
        } catch (PasswordErrorException ex) {
            System.out.println(ex.getMessage());
        }
        return valid;
    }
    public boolean isSuperAdmin(){
        String username = new String();
        String password = new String();
        login(username, password);
        boolean benar = true;
        boolean valid = false;
        Admin admin = new Admin(username, password, benar);
        try {
            valid = admin.ValidateInput();
        } catch (PasswordErrorException ex) {
            System.out.println(ex.getMessage());
        }
        return valid;
    }
}
