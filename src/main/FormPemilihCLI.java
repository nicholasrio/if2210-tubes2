/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class FormPemilihCLI {
    public FormPemilihCLI(){}
    public void kertasSuaraDPR(){
        
    }
    public void kertasSuaraDPRDProv(){
    
    }
    public void kertasSuaraDPRDKab(){
    
    }
    public void kertasSuaraDPD(){
    
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
