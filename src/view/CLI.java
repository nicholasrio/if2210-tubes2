/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;
import controller.*;
import model.Point;
import model.node.Node;

/**
 *
 * @author Yusuf
 */
public class CLI {

    private static Scanner input = new Scanner(System.in);
    private static String userLocation;
    private static String destinationLocation;
    private static String[] menu;
    private static final int width = 100;
    private static int choice;
    private static MapController mc;
	private	static String fileName;

    /**
     * Constructor initialize the menu variable, print the header, then print
     * the menu
     */
    public CLI() {
        double userLoc, destinationLoc;
        int choice;
        mc = new MapController(fileName);
        initMenu();
        printHeader();
        printMainMenu();
    }

    /**
     * main program that construct object of CLI
     *
     * @param args arguments from the Command Line
     */
    public static void main(String[] args) {
        CLI cli = new CLI();
		fileName = "peta.xml";
        mc = new MapController(fileName);
    }

    /**
     * print the menu after it's initialized
     */
    private static void printMainMenu() {
        printMenuString(menu);
        System.out.print("|\tEnter the number of your choice : ");
        try {
            choice = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            choice = 8;
        }
        printSeparator();
        choiceMenu(choice);
    }

    /**
     * print the list of Menu then add iterator at the begin example : 1. Menu1
     * 2. Menu2 etc.
     *
     * @param sArray array of Menu that will be written to the console
     */
    private static void printMenuString(String[] sArray) {
        System.out.print("|");
        writeSameString(" ", width - 5);
        System.out.println("|");
        for (int i = 0; i < sArray.length; i++) {
            int rightSpace = width - sArray[i].length() - 16;
            System.out.print("|");
            System.out.print((i + 1) + ".  ");
            writeSameString(" ", 7);
            System.out.print(sArray[i]);
            writeSameString(" ", rightSpace);
            System.out.println("|");
        }
        printSeparator();
    }

    /**
     * print the header of the application
     */
    private static void printHeader() {
        String[] line = new String[7];
        line[0] = " ____  ______  ____       ____   ___   __ __  ______    ___  ____  ";
        line[1] = "|    ||      ||    \\     |    \\ /   \\ |  |  ||      |  /  _]|    \\ ";
        line[2] = " |  | |      ||  o  )    |  D  )     ||  |  ||      | /  [_ |  D  )";
        line[3] = " |  | |_|  |_||     |    |    /|  O  ||  |  ||_|  |_||    _]|    / ";
        line[4] = " |  |   |  |  |  O  |    |    \\|     ||  :  |  |  |  |   [_ |    \\ ";
        line[5] = " |  |   |  |  |     |    |  .  \\     ||     |  |  |  |     ||  .  \\";
        line[6] = "|____|  |__|  |_____|    |__|\\_|\\___/  \\__,_|  |__|  |_____||__|\\_|";

        int headerWidth = line[1].length();
        int headerSpace = (width - headerWidth) / 2 - 2;

        System.out.print(" ");
        writeSameString("=", width - 5);
        System.out.println(" ");

        for (String str : line) {
            System.out.print("|");
            writeSameString(" ", headerSpace);
            System.out.print(str);
            writeSameString(" ", headerSpace);
            System.out.println("|");
        }

        System.out.print("|");
        writeSameString("=", width - 5);
        System.out.println("|");
    }

    /**
     * print the separator for each Menu
     */
    private static void printSeparator() {
        System.out.print("|");
        writeSameString("_", width - 5);
        System.out.println("|");
    }

    /**
     * initialize the menu variable
     */
    private static void initMenu() {
        menu = new String[8];
        menu[0] = "Input Your Location";
        menu[1] = "Input Your Destination";
        menu[2] = "Find Nearest Canteen";
        menu[3] = "Find Nearest Rest Room";
        menu[4] = "Show Menu in Canteen";
        menu[5] = "Show Room Information";
        menu[6] = "Show Shortest Route to Your Destination";
        menu[7] = "Exit";

        choice = 0;
    }

    /**
     * write String s n times in one line
     *
     * @param s String that to be written
     * @param n how many times that String s will be written
     */
    private static void writeSameString(String s, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(s);
        }
    }

    /**
     * check that the loc is a location format or not
     *
     * @param loc location that input by user
     * @return true if loc is a lcoation format
     */
    private static boolean isLocationRight(String loc) {
        boolean retVal = false;

        if (loc.contains("loc-") || loc.contains(",167") || loc.contains(", 167")) {
            retVal = true;
        }
        return retVal;
    }

    /**
     *
     * @param whatLocation string that determines what location will be checked
     * @return true if a specific location is entered
     */
    private static boolean isLocationEntered(String whatLocation) {
        boolean retVal = true;
        if (((whatLocation.toLowerCase().compareTo("user") == 0) && userLocation == null)
                || ((whatLocation.toLowerCase().compareTo("destination") == 0) && destinationLocation == null)
                || ((whatLocation.toLowerCase().compareTo("both") == 0) && userLocation == null && destinationLocation == null)) {
            retVal = false;
        }
        return retVal;
    }

    /**
     * show the menus depend on user's choice switch-case like methods
     *
     * @param n the number of choice that user has chosen
     */
    private static void choiceMenu(int n) {
        if (n == 1) {
            System.out.print("|\tEnter Your Location (geolocation|building) : ");
            userLocation = input.nextLine();
            while (!isLocationRight(userLocation)) {
                System.out.println("|\tYour location isn't right.");
                System.out.print("|\tEnter Your Location (geolocation|building) : ");
                userLocation = input.nextLine();
            }
            printSeparator();
            printMainMenu();
        } else if (n == 2) {
            if (userLocation != null) {
                System.out.print("|\tEnter Your Destination (geolocation|building) : ");
                destinationLocation = input.nextLine();
                while (!isLocationRight(destinationLocation)) {
                    System.out.println("|\tYour destination isn't right.");
                    System.out.print("|\tEnter Your Destination (geolocation|building) : ");
                    destinationLocation = input.nextLine();
                }
            } else {
                System.out.println("|\tYour location isn't defined.");
                System.out.println("|\tPlease input Your location in main menu number 1.");
            }
            printSeparator();
            printMainMenu();
        } else if (n == 3) {
            if (!isLocationEntered("user")) {
                System.out.println("|\tThe location isn't defined.");
                System.out.println("|\tPlease input the location in main menu.");
            } else {
                String nearestCanteen = "Bengkok Canteen";
                String canteenLoc1 = "35.76, 167.64";
                String canteenLoc2 = "Beside Chemistry Building";

                System.out.print("|\tThe nearest Canteen is " + nearestCanteen);
                writeSameString(" ", width - 35 - nearestCanteen.length());
                System.out.println("|");

                System.out.print("|\tGeolocation : " + canteenLoc1);
                writeSameString(" ", width - 26 - canteenLoc1.length());
                System.out.println("|");

                System.out.print("|\tlocation : " + canteenLoc2);
                writeSameString(" ", width - 23 - canteenLoc2.length());
                System.out.println("|");
            }
            printSeparator();
            printMainMenu();
        } else if (n == 4) {
            if (!isLocationEntered("user")) {
                System.out.println("|\tThe location isn't defined.");
                System.out.println("|\tPlease input the location in main menu.");
            } else {
                String nearestRestRoom = "Labtek V ";
                String restRoomLoc1 = "-135.6276, 167.0264";
                String restRoomLoc2 = "Labtek V 1st floor";

                System.out.print("|\tThe nearest Canteen is " + nearestRestRoom);
                writeSameString(" ", width - 35 - nearestRestRoom.length());
                System.out.println("|");

                System.out.print("|\tGeolocation : " + restRoomLoc1);
                writeSameString(" ", width - 26 - restRoomLoc1.length());
                System.out.println("|");

                System.out.print("|\tLocation : " + restRoomLoc2);
                writeSameString(" ", width - 23 - restRoomLoc2.length());
                System.out.println("|");
            }
            printSeparator();
            printMainMenu();
        } else if (n == 5) {
            if(isLocationEntered("user")){
                String canteen;
                String[] canteenMenu = new String[4];
                canteenMenu[0] = "Coke";
                canteenMenu[1] = "Fried Rice";
                canteenMenu[2] = "Mineral Water";
                canteenMenu[3] = "Instant Noodle";

                System.out.print("|\tEnter Canteen Name or Location : ");
                canteen = input.nextLine();
                while (!isLocationRight(canteen)) {
                    System.out.println("|\tCanteen isn't right.");
                    System.out.print("|\tEnter Canteen Name or Location : ");
                    canteen = input.nextLine();
                }
                printMenuString(canteenMenu);
            }else{
                System.out.println("|\tYour location isn't defined.");
                System.out.println("|\tPlease input Your location in main menu.");
            }
            printSeparator();
            printMainMenu();
        } else if (n == 6) {
            if(!isLocationEntered("user")){
                System.out.println("|\tYour location isn't defined.");
                System.out.println("|\tPlease input Your location in main menu.");
            }else{
                String room;
                Node nearestRoom = mc.nearestRoom(new Node(new Point(9, 9)), "Labdas 3");
                String roomInfo = "Place for Informatics Engineering lecture.";
                String[] roomInformation = roomInfo.split(";");

                System.out.print("|\tEnter Room Name or Location : ");
                room = input.nextLine();
                while (!isLocationRight(room)) {
                    System.out.println("|\tRoom isn't right.");
                    System.out.print("|\tEnter Room Name or Location : ");
                    room = input.nextLine();
                }
                printMenuString(roomInformation);
            }
            printSeparator();
            printMainMenu();
        } else if (n == 7) {
            if(!isLocationEntered("both")){
                System.out.println("|\tYour location isn't defined.");
                System.out.println("|\tPlease input Your location in main menu.");
            }else{
                String[] routes = new String[5];
                for(int i=0; i < routes.length; i++)
                    routes[i] = "Go to ";
                for(int i=0; i < routes.length; i++)
                    routes[i] += Integer.toString(i);
                for(int i=0; i < routes.length; i++){
                    System.out.print("|");
                    System.out.print(routes[i]);
                    writeSameString(" ", width-5-routes[i].length());
                    System.out.println("|");
                }
            }
            printSeparator();
            printMainMenu();
        } else if (n == 8) {
            System.out.print("|\tThanks for using this application.");
            writeSameString(" ", width - 46);
            System.out.println("|");
            printSeparator();
        } else {
            System.out.print("|\tYour input isn't right, input the right number (1-7)");
            writeSameString(" ", width - 64);
            System.out.println("|");
            printSeparator();
            printMainMenu();
        }
    }
}
