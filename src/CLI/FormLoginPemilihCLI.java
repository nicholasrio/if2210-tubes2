/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CLI;

import java.util.Scanner;
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
        System.out.println("Selamat datang di Software Pemilu "+t+"\n");
        System.out.println("Silakan login terlebih dahulu\n");
        System.out.println("NIK > ");
        Scanner input = new Scanner(System.in);
        String NIK = new String();
        NIK = input.next();
        System.out.println("\nPassword > ");
        String password = new String();
        password = input.next();
        if(isTerdaftar(NIK,password))
            System.out.println("Anda berhasil login!");
        else{
            System.out.println("NIK ataupun password salah. Ulangi lagi!");
        }
    }
    public boolean isTerdaftar(String NIK, String password){
        boolean valid = false;
        Pemilih pemilih = new Pemilih(NIK,password);
        return pemilih.ValidateInput();
    }
}
