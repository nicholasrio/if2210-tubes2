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
import main.Pemilih;

/**
 *
 * @author user
 */
public class FormLoginPemilihCLI {
    private FormPemilihCLI formPemilihCLI;
    public FormLoginPemilihCLI(){
        formPemilihCLI = new FormPemilihCLI();
    }
    public void start(){
        int t=2014;
        System.out.println("=============================================");
        System.out.println("=============================================");
        System.out.println("==              Yuk, Coblos                ==");
        System.out.println("=============================================");
        System.out.println("=============================================");
        System.out.println("\n");
        System.out.println("Selamat datang di Software Pemilu "+t);
        System.out.println("Silakan login terlebih dahulu");
        System.out.print("NIK > ");
        Scanner input = new Scanner(System.in);
        String NIK;
        NIK = input.next();
        System.out.print("\nPassword > ");
        String password;
        password = input.next();
        if(isTerdaftar(NIK,password)){
            System.out.println("Anda berhasil login!");
            formPemilihCLI.start();
        }
        else 
            System.out.println("NIK ataupun password salah. Ulangi lagi!");
        
    }
    public boolean isTerdaftar(String NIK, String password){
        boolean valid = false;
        Pemilih pemilih = new Pemilih(NIK,password);
        try {
            valid = pemilih.ValidateInput();
        } catch (PasswordErrorException ex) {
            System.out.println(ex.getMessage());
        }
        return valid;
    }
}
