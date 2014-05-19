/*
 * @author Zaky		
 */

import java.util.*; 
import java.io.*;

public class ThePlants {

	/** Application title */
	private static final String TITLE = "The Plan(t)s";

	public static void main(String args[]) {
		/** Load data */
		Scanner scan = new Scanner(System.in);
		PlantFactory.loadData();
		int level = 0;
		int input;
		System.out.println("WELCOME TO THE PLAN(T)S");
		System.out.println("\nMain Menu");
		System.out.println("1. Start Game");
		System.out.println("2. Credits");
		System.out.println("3. Exit");
		input = scan.nextInt();
		while(input != 3){
			if (input == 1){
				while(level<=0 || level >5){
					System.out.println("Choose the level you want to play");
					System.out.println("1. Baby");
					System.out.println("2. Newbie");
					System.out.println("3. Moderate");
					System.out.println("4. Hell");
					System.out.println("5. AZaky");
					System.out.print("Please choose the level you want to play : ");
					level = scan.nextInt();
					if(level<=0 || level >5){
						System.out.println("Wrong input!!! ckck....");
						System.out.println();
						System.out.println();
					}
				}
				Game game = new Game(new Level(level));
			}
			else if(input == 2){
				System.out.println("We are Students of Informatics Engineering in Institute Technology of Bandung");
				System.out.println("Creator of the game : ");
				System.out.println("1. Ahmad Zaky");
				System.out.println("2. Eldwin Christian");
				System.out.println("3. Nisa Dian Rachmadi");
				System.out.println("4. Riady Sastra Kusuma");
				System.out.println("5. William Stefan Hartono");
			}
			System.out.println("WELCOME TO THE PLAN(T)S");
			System.out.println("\nMain Menu");
			System.out.println("1. Start Game");
			System.out.println("2. Credits");
			System.out.println("3. Exit");
			input = scan.nextInt();
		}
		System.out.println("Bye BYE!!!");
	}
}

