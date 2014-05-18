/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.user;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CakBin
 */
public class DetailPage {
    static String title;
    static int no_tubes;
    static String group_name;
    static List<String> Member;
    static String link;
    static int rating;
    static int view;
    static int VideoID;
    static int GroupID;
    static boolean valid;
    static int option;
    static Scanner input=new Scanner(System.in);
    
    static void SelectOption(int i) throws OptionException{
        System.out.println("Insert option: ");
        option= input.nextInt();
        if (option > i || option <0){
            throw new OptionException("Invalid Option");
        }
        else{
            valid = true;
        }
    }
    
    static void print(){
        System.out.println("Video: "+title);
        System.out.println("Link: "+link);
        System.out.println("Group Name: "+group_name);
        System.out.println("Project Number: "+no_tubes);
        System.out.println("Members: "+Member);
        System.out.println("Rating: "+rating);
        System.out.println("View: "+view);
        System.out.println("");
        System.out.println("Menu:");
        System.out.println("0. Show Group");
        System.out.println("1. Show Video");
    }
    static void input(){
        valid=false;
        while(!valid){
            try{
                SelectOption(1);
            }
            catch(OptionException a){
                System.out.println(a.getMessage());
            }
        }
    }
    static void execute(){
        if(option==1){VideoPageUser.action(VideoID);}
        else{GroupPageUser.action(GroupID);}
    }
    static void action(String _title){
        title=_title;
        no_tubes=VideoPageUser.no_tubes;
        group_name=VideoPageUser.GroupName;
        link=VideoPageUser.URL;
        VideoID=VideoPageUser.id;
        GroupID=VideoPageUser.GroupID;
        try {
            GroupID=DataController.SearchGroup(group_name, no_tubes);
            view=Integer.valueOf(DataController.VC.SelectVideoData().get(VideoID)[3]);
        } catch (SQLException ex) {
            Logger.getLogger(DetailPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (OptionException ex) {
            System.out.println(ex.getMessage());
            VideoPageUser.action(VideoID);
        }
        //add data according to title
        print();
        input();
        execute();
    }
    static void action(int _no_tubes, String _GroupName){
        group_name=_GroupName;
        no_tubes=_no_tubes;
        GroupID=GroupPageUser.id;
        try {
            VideoID=DataController.SearchVideoByGroup(group_name, _no_tubes);
            title=DataController.VC.SelectVideoData().get(VideoID)[1];
            link=DataController.VC.SelectVideoData().get(VideoID)[2];
            view=Integer.valueOf(DataController.VC.SelectVideoData().get(VideoID)[3]);
        } catch (SQLException ex) {
            Logger.getLogger(DetailPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (OptionException ex) {
            System.out.println(ex.getMessage());
            GroupPageUser.action(GroupID);
        }
        //add data according to Group data
        print();
        input();
        execute();
    }
}
