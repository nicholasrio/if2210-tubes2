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


}
