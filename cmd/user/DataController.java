/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmd.user;

import Admin.AdministratorController;
import Group.GroupController;
import Video.VideoController;
import java.sql.SQLException;

/**
 * Kumpulan Controller dan method global untuk program utama user
 * @author CakBin
 */
public class DataController {
    static AdministratorController AC= new AdministratorController();
    static VideoController VC= new VideoController();
    static GroupController GC= new GroupController();
    
    static int SearchVideoByGroup(String _group_name, int _no_tubes) throws OptionException, SQLException{
        int i=0;
        while(i<VC.SelectVideoData().size() && !(VC.SelectVideoData().get(i)[5].equals(_group_name)&& VC.SelectVideoData().get(i)[4].equals(Integer.toString(_no_tubes)))){
            i++;
        }
        if(i>=VC.SelectVideoData().size()){
            throw new OptionException("Video tak ditemukan");
        }
        else{
            return i;
        }
    }
    
    static int SearchVideoByTitle(String _Title) throws OptionException, SQLException{
        int i=0;
        while(i<VC.SelectVideoData().size() && !VC.SelectVideoData().get(i)[1].equals(_Title)){
            i++;
        }
        if(i>=VC.SelectVideoData().size()){
            throw new OptionException("Video tak ditemukan");
        }
        else{
            return i;
        }
    }
    
    static int SearchGroup(String _group_name, int _no_tubes) throws SQLException, OptionException{
        int i=0;
        while(i<GC.GroupData().size() && !(GC.GroupData().get(i)[1].equals(_group_name)&& GC.GroupData().get(i)[0].equals(Integer.toString(_no_tubes)))){
            i++;
        }
        if(i>=GC.GroupData().size()){
            throw new OptionException("Kelompok tak ditemukan");
        }
        else{
            return i;
        }
    }
}
