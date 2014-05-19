/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.user;

import java.util.Scanner;

/**
 * Menu utama untuk program utama user
 * @author CakBin
 */
public class MainMenuUser {
    static boolean valid;
    static int option;
    static Scanner input=new Scanner(System.in);
    static boolean exit;
    
    static void SelectOption(int i) throws OptionException{
        System.out.println("Insert option: ");
        option= Integer.valueOf(input.next());
        if (option > i || option <0){
            throw new OptionException("Invalid Option");
        }
        else{
            valid = true;
        }
    }
    static void print(){
        System.out.println("1. Tampilkan daftar Video");
        System.out.println("2. Cari Video");
        System.out.println("3. Tampilkan daftar kelompok");
        System.out.println("4. Cari Kelompok");
        System.out.println("0. Keluar");
    }
    static void input(){
        valid=false;
         while(!valid){
            try{
                SelectOption(4);
            }
            catch(OptionException a){
                System.out.println(a.getMessage());
            }
        }
    }
    static void execute(){
        if(option==1){VideosUser.action(1,10);}
        else if(option==2){VideoSearchMenuUser.action();}
        else if(option==3){GroupsUser.action(1,10);}
        else if(option==4){GroupSearchMenuUser.action();}
        else{exit=true;}
    }
    static void action(){
        print();
        while(!exit){
            input();
            execute();
        }
    }
}
