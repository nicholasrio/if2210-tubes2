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
    private DaftarPilihan daftarPilihan;
    public FormPemilihCLI(){
        int dapil = 0;
        daftarPilihan = new DaftarPilihan(dapil);
    }
    public void start(){
        System.out.println("==========================================================================");
        System.out.println("==========================================================================");
        System.out.println("=                                  Form Pemilih                          =");
        System.out.println("==========================================================================\n\n\n");
        kertasSuaraBerdPartai(daftarPilihan.GetDaftarPartai());
    }
    
    public void kertasSuaraBerdPartai(ArrayList<String> daftarPartai){
        for (int i = 0; i < daftarPartai.size(); i++){
            System.out.println(i+1 + ". " + daftarPartai.get(i));
        }
    }
    public void kertasSuaraDPR(){//ArrayList<Caleg> daftarCalegDPR){
        
    }
    public void kertasSuaraDPRDProv(){//ArrayList<Caleg> daftarCalegDPRDPROV){
        
    }
    public void kertasSuaraDPRDKab(){//ArrayList<Caleg> daftarCalegDPRDKab){
        
    }
    public void kertasSuaraDPD(){//ArrayList<Caleg> daftarCalegDPD){
        
    }
    public boolean isExist(int pilihan){
        return pilihan < 10;
    }
    public void println(Caleg caleg){
        System.out.println(caleg.GetPartai() + caleg.getLingkup() + caleg.GetDapil());
    }
}
