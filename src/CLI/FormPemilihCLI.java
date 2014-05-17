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
public class FormPemilihCLI {
    private int sudahDipilih[];
    public FormPemilihCLI(){
        sudahDipilih = new int[4];
        for (int i = 0; i < 4; i++)
            sudahDipilih[i] = 0;
        System.out.println("=========================");
        System.out.println("=========================");
        System.out.println("=       Form Pemilih      =");
        System.out.println("=========================\n\n\n");
        System.out.println("Apa yang ingin Anda lakukan?\n");
        System.out.println("1. Memilih anggota Dewan Perwakilan Rakyat\n");
        System.out.println("2. Memilih anggota Dewan Perwakilan Rakyat Daerah tingkat Provinsi\n");
        System.out.println("3. Memilih anggota Dewan Perwakilan Rakyat Daerah tingkat Kabupaten/ Kota\n");
        System.out.println("4. Memilih anggota Dewan Perwakilan Daerah\n");
        System.out.println("Silakan pilih (1/2/3/4) > ");
        Scanner in = new Scanner(System.in);
    }
    public void kertasSuaraDPR(){
        sudahDipilih[0] = 1;
    }
    public void kertasSuaraDPRDProv(){
        sudahDipilih[1] = 1;
    }
    public void kertasSuaraDPRDKab(){
        sudahDipilih[2] = 1;
    }
    public void kertasSuaraDPD(){
        sudahDipilih[3] = 1;
    }
    public void pilihan(){
        Scanner in = new Scanner(System.in);
        int pilihan = in.nextInt();
        if(!isExist(pilihan)){
            
        }
    }
    public boolean isExist(int pilihan){
        return pilihan < 10;
    }
}
