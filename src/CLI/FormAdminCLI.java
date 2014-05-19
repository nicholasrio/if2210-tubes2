/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CLI;

import java.util.Scanner;
import main.DaftarAdmin;

/**
 *
 * @author user
 */
public class FormAdminCLI {
    private final Scanner in;
    private DaftarAdmin daftarAdmin;
    public FormAdminCLI(){
        in = new Scanner(System.in);
        daftarAdmin = new DaftarAdmin();
    }
    public void start(){
        System.out.println("=========================");
        System.out.println("=========================");
        System.out.println("=       Form Admin      =");
        System.out.println("=========================\n\n\n");
        System.out.println("Apa yang ingin Anda lakukan?\n");
        System.out.println("1. Menambahkan Daerah Pemilihan\n");
        System.out.println("2. Menambahkan Calon Legislatif\n");
        System.out.println("Silakan pilih (1/2) > ");
        input();
    }
    
    public void input(){
        int pilihan = in.nextInt();
        if(pilihan == 1){
            inputDapil();
        }
        else if (pilihan == 2){
            inputCaleg();
        }
    }
    public void inputDapil(){
        String dapil = in.nextLine();
    }
    public void inputCaleg(){
        String NIK = in.nextLine();
    }
}
