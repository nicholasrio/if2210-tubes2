/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.admin;

import Admin.AdministratorController;
import Group.GroupController;
import Video.VideoController;
import java.sql.SQLException;

/**
 * Kumpulan kontroller dan fungsi global yang dipakai di konsol
 * @author CakBin
 */
public class DataController {
    static AdministratorController AC= new AdministratorController();
    static VideoController VC= new VideoController();
    static GroupController GC= new GroupController();
    
    static int SearchVideoByTitle(String _Title) throws OptionException, SQLException{
        int i=0;
        while(i<VC.SelectVideoData().size() && (!VC.SelectVideoData().get(i)[1].equals(_Title)) ){
            i++;
        }
        if(i<VC.SelectVideoData().size()){
            return i;
        }
        else{
            throw new OptionException("Video tidak ditemukan");
        }
    }
    
    static int SearchGroup(String _group_name, int _no_tubes) throws SQLException, OptionException{
        int i=0;
        while(i<GC.GroupData().size() && !(GC.GroupData().get(i)[1].equals(_group_name)&& GC.GroupData().get(i)[0].equals(Integer.toString(_no_tubes)))){
            i++;
        }
        if(i>=GC.GroupData().size()){
            throw new OptionException("Kelompok tidak ditemukan");
        }
        else{
            return i;
        }
    }
}
