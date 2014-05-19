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
 * Formulir untuk mengubah data video
 * @author CakBin
 */
public class VideoEditForm {
    static boolean valid;
    static int id;
    static int VidID;
    static String title;
    static int no_tubes;
    static String group_name;
    static String link;
    static Scanner input=new Scanner(System.in);
    
    static void input(){
        System.out.print("Masukkan Judul baru: ");
        title = input.nextLine();
        
        System.out.print("URL video baru: ");
        link = input.nextLine();
        
        System.out.print("Nama Kelompok baru: ");
        group_name = input.nextLine();
        
        System.out.print("No Tugas Besar baru: ");
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
            DataController.VC.EditDataVideo(VidID, title, link, group_name, no_tubes);
        } catch (SQLException | NullException | AttributeException ex) {
            Logger.getLogger(VideoEditForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    static void action(){
        id=VideoPage.id;
        try {
            VidID=Integer.valueOf(DataController.VC.SelectVideoData().get(id)[0]);
            input();
            execute();
            VideoPage.action(id);
        } catch (SQLException ex) {
            Logger.getLogger(VideoEditForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
