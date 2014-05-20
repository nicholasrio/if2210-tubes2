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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("1 jika admin, 2 jika pemilih (1/2) > ");
        Scanner in = new Scanner (System.in);
        int pil = in.nextInt();
        assert (pil == 1 || pil == 2);
        if(pil == 1){
            FormLoginAdminCLI formLogin = new FormLoginAdminCLI();
            formLogin.start();
        }
        else if (pil == 2){
            FormLoginPemilihCLI formLoginPemilih = new FormLoginPemilihCLI();
            formLoginPemilih.start();
        }
    }
}