/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tubesoop;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class FormAdminCLI {
    private final Scanner in;
    public FormAdminCLI(){
        in = new Scanner(System.in);
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
        String w = in.nextLine();
    }
    public void inputCaleg(){
        String w = in.nextLine();
    }
}
