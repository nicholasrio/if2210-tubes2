/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CLI;

import java.util.ArrayList;
import java.util.Scanner;
import main.Caleg;
import main.DaftarPilihan;

/**
 *
 * @author user
 */
public class FormPemilihCLI {
    private int sudahDipilih[];
    private DaftarPilihan daftarPilihan;
    public FormPemilihCLI(){
        sudahDipilih = new int[4];
        for (int i = 0; i < 4; i++){
            sudahDipilih[i] = 0;
        }
        int dapil = 0;
        daftarPilihan = new DaftarPilihan(dapil);
    }
    public void start(){
        System.out.println("==========================================================================");
        System.out.println("==========================================================================");
        System.out.println("=                                  Form Pemilih                          =");
        System.out.println("==========================================================================\n\n\n");
        tampilkanKertasSuara();
        kertasSuaraBerdPartai(daftarPilihan.GetDaftarPartai());
    }
    public void tampilkanKertasSuara(){
        int j = 0;
        for (int i = 0; i < 4; i++){
            if(i == 0 && sudahDipilih[i] == 0){
                j++;
                System.out.println(j + ". Memilih anggota Dewan Perwakilan Rakyat\n");
            }
            if(i == 1 && sudahDipilih[i] == 0){
                j++;
                System.out.println(i+1 + ". Memilih anggota Dewan Perwakilan Rakyat Daerah tingkat Provinsi\n");
            }
            if(i == 2 && sudahDipilih[i] == 0){
                j++;
                System.out.println(i+1 + ". Memilih anggota Dewan Perwakilan Rakyat Daerah tingkat Kabupaten/ Kota\n");
            }
            if(i == 3 && sudahDipilih[i] == 0){
                j++;
                System.out.println(i+1 + ". Memilih anggota Dewan Perwakilan Daerah\n");
            }
        }
        int i;
        System.out.print("Silakan pilih (");
        for(i = 1; i < j; i++){
            System.out.print(j + "/");
        }
        System.out.print(j + ") : ");
    }
    public void kertasSuaraBerdPartai(ArrayList<String> daftarPartai){
        Scanner in = new Scanner(System.in);
        int pil = in.nextInt();
        int noKertas [] = new int[4];
        for (int i = 0; i < 4; i++)
            noKertas[i] = 0;
        int i = 0;
        while (noKertas[pil] != 1){
            System.out.println("Daftar Partai yang dapat dipilih pada Pemilu tahun ini :");
            String temp;
            for (int j = 0; j < daftarPartai.size(); j++){
                System.out.println(i+1 + ". "+ daftarPartai.get(i));
            }
            System.out.print("Silakan pilih sesuai dengan hati nurani Anda : ");
            pil = in.nextInt();
            tampilkanKertasSuara(pil);
        }
    }
    private void tampilkanKertasSuara(int pil){
        if (pil == 1)
            kertasSuaraDPR();
        else if (pil == 2)
            kertasSuaraDPRDProv();
        else if (pil == 3)
            kertasSuaraDPRDKab();
        else if (pil == 4)
            kertasSuaraDPD();
    }
    public void kertasSuaraDPR(){//ArrayList<Caleg> daftarCalegDPR){
        sudahDipilih[0] = 1;
    }
    public void kertasSuaraDPRDProv(){//ArrayList<Caleg> daftarCalegDPRDPROV){
        sudahDipilih[1] = 1;
    }
    public void kertasSuaraDPRDKab(){//ArrayList<Caleg> daftarCalegDPRDKab){
        sudahDipilih[2] = 1;
    }
    public void kertasSuaraDPD(){//ArrayList<Caleg> daftarCalegDPD){
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
    public void println(Caleg caleg){
        System.out.println(caleg.GetPartai() + caleg.getLingkup() + caleg.GetDapil());
    }
}
