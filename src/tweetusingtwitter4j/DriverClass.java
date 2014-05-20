/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetusingtwitter4j;

/**
 *
 * @author jais
 */
import java.io.*;
import java.util.Scanner;

public class  DriverClass{
	public static void main(String args[]) {
		
		int choice;
		boolean pilih = true;
		while(pilih == true) {
		System.out.println("Aplikasi Sistem Keuangan ");
		System.out.println();
		System.out.println("1. Budgetting");
		System.out.println("2. Status");
		System.out.println("3. Report");
		System.out.println("4. ShareTwitter");
		
		
		
			int pilihan;
		Scanner in = new Scanner(System.in);
		pilihan = in.nextInt();
		if(pilihan == 1) {
			Budget b = new Budget();
			System.out.println("apakah anda ingin melanjutkan menu program tekan 'y' untuk iya dan 'n' untuk no");
			choice = in.nextInt();
			 if(choice == 1) {
                            pilih = false;
                        }
               else {pilih = true;}
		}else if(pilihan == 2) {
			StatusBudget s = new StatusBudget();
			System.out.println("apakah anda ingin melanjutkan menu program tekan 'y' untuk iya dan 'n' untuk no");
			choice = in.nextInt();
			 if(choice == 1) {
                            pilih = false;
                        }
                        else {pilih = true;}
		}
		else if(pilihan == 3) {
			Report r = new Report();
			System.out.println("apakah anda ingin melanjutkan menu program tekan 'y' untuk iya dan 'n' untuk no");
			choice = in.nextInt();
			 if(choice == 1) {
                            pilih = false;
                        }
                        else {pilih = true;}
		}
		else if(pilihan == 4) {
                try{
                TweetUsingTwitter4j t = new   TweetUsingTwitter4j();
		System.out.println("apakah anda ingin melanjutkan menu program tekan 'y' untuk iya dan 'n' untuk no");
		choice = in.nextInt();
		 if(choice == 1) {
                            pilih = false;
                        }
                        else {pilih = true;}
		}catch(Exception e) { e.printStackTrace(); }
                }
                }
	}
} 

