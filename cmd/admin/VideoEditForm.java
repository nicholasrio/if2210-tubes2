/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.admin;

import Video.AttributeException;
import Video.NullException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CakBin
 */
public class VideoEditForm {
    static boolean valid;
    static String title;
    static int no_tubes;
    static String group_name;
    static String link;
    static Scanner input=new Scanner(System.in);
    
    static void input(){
        System.out.print("Insert new title: ");
        title = input.next();
        
        System.out.print("Insert new Video URL: ");
        link = input.next();
        
        System.out.print("Insert new Group Name: ");
        group_name = input.next();
        
        System.out.print("Insert new Project Number: ");
        no_tubes = input.nextInt();
        
        try{
        if(title.equals("")){
            title=DataController.VC.SelectVideoData().get(VideoPage.id)[2];
        }
        if(link.equals("")){
            link=DataController.VC.SelectVideoData().get(VideoPage.id)[3];
        }
        if(group_name.equals("")){
            group_name=DataController.VC.SelectVideoData().get(VideoPage.id)[6];
        }
        if(Integer.toString(no_tubes).equals("")){
            no_tubes=Integer.valueOf(DataController.VC.SelectVideoData().get(VideoPage.id)[5]);
        }
        }catch(SQLException ex){
            Logger.getLogger(VideoEditForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    static void execute(){
        try {
            DataController.VC.EditDataVideo(VideoPage.id, title, link, group_name, no_tubes);
        } catch (SQLException | NullException | AttributeException ex) {
            Logger.getLogger(VideoEditForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    static void action(){
        input();
        execute();
        VideoPage.action(VideoPage.id);
    }
}
