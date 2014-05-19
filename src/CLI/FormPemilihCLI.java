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
import main.Pemilih;
import main.PilihanCaleg;
import main.PilihanPartai;

/**
 *
 * @author user
 */
public class FormPemilihCLI {
    private DaftarPilihan daftarPilihan;
    public FormPemilihCLI(){
        int dapil = 0;
        daftarPilihan = new DaftarPilihan(dapil);
    }/**
     * Tapilan awal form pemilih
     */
    public void start(Pemilih p){
        daftarPilihan.GetDaftarPartai();
        System.out.println("==================================================================");
        System.out.println("==================================================================");
        System.out.println("=                          Form Pemilih                          =");
        System.out.println("==================================================================\n\n\n");
        kertasSuaraBerdPartai(daftarPilihan.GetDaftarPartai(),p);
    }
    /**
     * Menampilkan daftar partai
     * @param daftarPartai 
     */
    public void kertasSuaraBerdPartai(ArrayList<String> daftarPartai, Pemilih p){
        System.out.print("Apabila Anda tidak ingin memilih, tekan 0 dan enter.\nDaftar Partai yang dapat dipilih : ");
        for (int i = 0; i < daftarPartai.size(); i++){
            System.out.println(i+1 + ". " + daftarPartai.get(i));
        }
        System.out.print("Silakan tekan pilihan Anda (1 - " + daftarPartai.size() + " > ");
        Scanner in = new Scanner(System.in);
        int pilihan = in.nextInt();
        if (pilihan >= 0 && pilihan <= daftarPartai.size()){
            String NIK = "12345";
            PilihanPartai pil = new PilihanPartai(p.GetNIK(),daftarPartai.get(pilihan - 1),"lingkup");
        }
    }
    /**
     * Menampilkan pilihan daftar caleg DPR
     */
    public void kertasSuaraDPR(){//ArrayList<Caleg> daftarCalegDPR){
        System.out.print("Caleg dari partai " + "adalah :");
        int i = 0;
        ArrayList<String> daftarPartai = daftarPilihan.GetDaftarPartai();
        while (i < daftarPartai.size()){
            ArrayList<Caleg> daftarCalegDPR = daftarPilihan.GetDaftarCalegDPR(daftarPartai.get(i));
            int j = 0;
            while (j < daftarCalegDPR.size()){
                println(j + 1, daftarCalegDPR.get(j));
                j++;
            }
            i++;
        }
    }
    /**
     * Menampilkan pilihan daftar caleg DPRD Provinsi
     */
    public void kertasSuaraDPRDProv(){//ArrayList<Caleg> daftarCalegDPRDPROV){
        System.out.print("Caleg dari partai " + "adalah :");
        int i = 0;
        ArrayList<String> daftarPartai = daftarPilihan.GetDaftarPartai();
        while (i < daftarPartai.size()){
            ArrayList<Caleg> daftarCalegDPRDProv = daftarPilihan.GetDaftarCalegDPRDProvinsi(daftarPartai.get(i));
            int j = 0;
            while (j < daftarCalegDPRDProv.size()){
                println(j + 1, daftarCalegDPRDProv.get(j));
                j++;
            }
            i++;
        }
    }
    /**
     * Menampilkan pilihan daftar caleg DPRD Kota/Kabupaten
     */
    public void kertasSuaraDPRDKab(){//ArrayList<Caleg> daftarCalegDPRDKab){
        System.out.print("Caleg dari partai " + "adalah :");
        int i = 0;
        ArrayList<String> daftarPartai = daftarPilihan.GetDaftarPartai();
        while (i < daftarPartai.size()){
            ArrayList<Caleg> daftarCalegDPRDKab = daftarPilihan.GetDaftarCalegDPRDKabupaten(daftarPartai.get(i));
            int j = 0;
            while (j < daftarCalegDPRDKab.size()){
                println(j + 1, daftarCalegDPRDKab.get(j));
                j++;
            }
            i++;
        }
    }
    /**
     * Menampilkan pilihan daftar caleg DPD
     */
    public void kertasSuaraDPD(){//ArrayList<Caleg> daftarCalegDPD){
        System.out.print("Caleg dari partai " + "adalah :");
        int i = 0;
        ArrayList<String> daftarPartai = daftarPilihan.GetDaftarPartai();
        while (i < daftarPartai.size()){
            ArrayList<Caleg> daftarCalegDPD = daftarPilihan.GetDaftarCalegDPD(daftarPartai.get(i));
            int j = 0;
            while (j < daftarCalegDPD.size()){
                println(j+1, daftarCalegDPD.get(j));
                j++;
            }
            i++;
        }
    }
    /**
     * Mengecek jumlah caleg pada rentang
     * @param pilihan
     * @param daftarCaleg
     * @return boolean
     */
    public boolean isExist(int pilihan, ArrayList<Caleg> daftarCaleg){
        return pilihan >= 0 && pilihan <= daftarCaleg.size();
    }
    /**
     * Menampilkan nomor dapil berdasarkan caleg
     * @param no
     * @param caleg 
     */
    public void println(int no, Caleg caleg){
        System.out.println(no + ". " + caleg.GetDapil());
    }
    /**
     * Memasukan pilihan
     */
    public void input(ArrayList<Caleg> daftarCaleg, Pemilih p){
        System.out.print("Silakan pilih (1 - " + daftarCaleg.size() + ") > ");
        Scanner in = new Scanner(System.in);
        int pilihan = in.nextInt();
        if (isExist(pilihan,daftarCaleg)){
            PilihanCaleg pil = new PilihanCaleg(p.GetNIK(),daftarCaleg.get(pilihan).GetNama(),"lingkup");
        }
        else {
            System.out.print("Tidak ada pilihan.");
        }
    }
}
