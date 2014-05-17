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
public class FormSuperAdminCLI {
    private final Scanner in;
    public FormSuperAdminCLI(){
        System.out.println("===============================");
        System.out.println("===============================");
        System.out.println("=       Form Super Admin      =");
        System.out.println("===============================s\n\n");
        System.out.println("Apa yang ingin Anda lakukan?");
        System.out.println("1. Menambahkan Admin");
        System.out.println("2. Menghapus Admin");
        System.out.println("Silakan pilih (1/2) > ");
        in = new Scanner(System.in);
    }
    public void addOrDelete(){
        int pil = in.nextInt();
        if(pil == 1){
            addAdmin();
        }
        else if(pil == 2)
            deleteAdmin();
    }
    public void addAdmin(){
        System.out.println("Masukkan username dan password Admin yang akan ditambahkan :");
        System.out.print("Username > ");
        String usernameAdmin = in.next();
        System.out.print("\nPassword > ");
        String passwordAdmin = in.next();
        System.out.println(usernameAdmin + " " + passwordAdmin);
    }
    public void deleteAdmin(){
        System.out.println("Masukkan username yang akan dihapus :");
        System.out.print("Username > ");
        String usernameAdmin = in.next();
        System.out.println(usernameAdmin);
    }
}
