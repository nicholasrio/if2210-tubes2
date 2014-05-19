/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Group;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KURING
 */
public class GroupController {
    
    private Group team;
    
    /* tambahan konstruktor, buat cmd (LOL) */
    public GroupController(){
        team = new Group();
    }
    
    public void InsertGroup() throws SQLException{
	team.save();
    }

    public void UpdateGroup(){

    }

    public void SelectAllGroup(){
        
    }

    public String GetAGroup(int no_tubes, String group_name){
        return "abc";
    }

    public List<String> GetXHistory(String group_name){
        return new ArrayList<>();
    }
    
    public List<String[]> GroupData() throws SQLException{
        return team.GroupData();
    }
    
    
    /* Lagi, tambahan method buat cmd */
    public void RegisterGroup(int no_tubes, String group_name, List<String> Member) throws SQLException{
        if(!team.cekDataGroup(no_tubes, group_name)){
            team.setNo_tubes(no_tubes);
            team.setGroup_name(group_name);
            team.setMember(Member);
            team.save();
            System.out.println("Registration complete");
        }
        else{
            System.out.println("The group is registered already");
        }
    }
    
    public void EditGroup(int no_tubes, String group_name, List<String> Member, int former_no_tubes, String former_group_name) throws SQLException{
        if(team.cekDataGroup(former_no_tubes, former_group_name)){
            team.setNo_tubes(no_tubes);
            team.setGroup_name(group_name);
            team.setMember(Member);
            team.update(former_no_tubes,former_group_name);
            System.out.println("Group data has been changed");
        }
        else{
            System.out.println("The group is registered already");
        }
    }

}
