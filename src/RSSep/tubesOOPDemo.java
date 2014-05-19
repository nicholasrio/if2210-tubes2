package RSSep;
import java.util.Scanner;

import RSS.slidinglayout.SLAnimator;

/**
 * 
 * @author Capokantil
 *
 */
public class tubesOOPDemo implements TUBES_2_OOP{
	
	
	/**
	 * Method to run Graphic User Interface version
	 */
	public void runGUI(){
		SLAnimator.start();

		TheFrame frame = new TheFrame();
		frame.topTen();
		frame.setSize(1024, 700);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	/**
	 * Method to run Comment Line Interface version
	 */	
	public void runConsole(){
		int pil;
		Scanner scanner = new Scanner(System.in);
		Pengkategori pk = new Pengkategori();
		do{
			System.out.println("+------------------------------------------------------------+");
			System.out.println("|--------------- RSSep - RSS Reader nu Mantep ---------------|");
			System.out.println("+------------------------------------------------------------+");
			System.out.println("Menu:");
			System.out.println("1. International News");
			System.out.println("2. Technology");
			System.out.println("3. Business");
			System.out.println("4. Sport");
			System.out.println("5. Entertainment");
			System.out.println("6. Trending Topics");
			System.out.println("7. Search");
			System.out.print("Choice (-99 to exit) : ");
			pil = scanner.nextInt();
			
			switch(pil){
			case 1://International 
				for(FeedMessage fm: pk.ListWorld){
					System.out.println(fm.description);
				}
				break;
				
			case 2://Technology
				for(FeedMessage fm: pk.ListTech){
					System.out.println(fm.description);
				}
				break;
				
			case 3://Business
				for(FeedMessage fm: pk.ListBusiness){
					System.out.println(fm.description);
				}
				break;
				
			case 4://Sport
				for(FeedMessage fm: pk.ListSport){
					System.out.println(fm.description);
				}
				break;
			
			case 5://Entertainment
				for(FeedMessage fm: pk.ListEnt){
					System.out.println(fm.description);
				}
				break;
			
			case 6://Hot topics
				System.out.println("Hot Topics:");
				for(String s : TheFrame.topTen()){
					System.out.println(s);
				}
				break;
			
			case 7://Search
				System.out.println("Querry : ");
				String searchQuerry = scanner.next();
				System.out.println(search(searchQuerry, pk));
				break;
				
			case -99://Exit
				System.out.println("Goodbye, moga - moga OOP lulus. Amin :D");
				break;
			default:
				System.out.println("Wrong input");
				break;
			
			}
			assert(pil!=-99) : "Assertion is called, program ended";
		}while(pil!=-99);
		
	}

	/**
	 * Return String that the result of searching String s from Pengkategori Class
	 * @param s
	 * @param PK
	 * @return
	 */
	public static String search(String s, Pengkategori PK){
		String temp = "";
		boolean found = false;
	    for(FeedMessage fm : PK.ListAll){
	    	if(fm.getDescription().toLowerCase().contains(s.toLowerCase())){
	    		found = true;
	    		temp +=fm.getDescription()+"\n";
	    	}
	    }
	    if(!found){
	    	temp += "Search querry not found";
	    }
	    
		
		return temp;
	}

}