package Group;

import java.sql.SQLException;
import java.util.List;

/**
 * MVC untuk Group
 * @author Hendro Triokta Brianto - 13512081
 */
public class GroupController {
    
    private final Group team;
    
    /**
     * construktor
     */
    public GroupController(){
        team = new Group();
    }
    
    /**
     * memasukan data ke dalam database
     * @throws SQLException 
     */
    public void InsertGroup() throws SQLException{
	team.save();
    }

    /**
     * 
     * mengubah data yang ada pada database
     * @param no_tubes
     * @param group_name
     * @throws SQLException 
     */
    public void UpdateGroup(int no_tubes, String group_name) throws SQLException{
        team.update(no_tubes, group_name);
    }

    /**
     * Select berdasarkan no tubes dan nama kelompok
     * @param no_tubes
     * @param namakelompok
     * @return
     * @throws SQLException 
     */
    public List<String[]> SelectSpecific(int no_tubes, String namakelompok) throws SQLException{
        team.setNo_tubes(no_tubes);
        team.setGroup_name(namakelompok);
        return team.GroupDataEdit();
    }
    
    /**
     * 
     * @return
     * @throws SQLException 
     */
    public List<String[]> GroupData() throws SQLException{
        return team.GroupData();
    }
    
    
    /**
     * Lagi, tambahan method buat cmd 
     * @param no_tubes
     * @param group_name
     * @param Member
     * @throws java.sql.SQLException
     */
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

    /**
     * Method untuk edit grup
     * @param no_tubes
     * @param group_name
     * @param Member
     * @param former_no_tubes
     * @param former_group_name
     * @throws SQLException 
     */
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
