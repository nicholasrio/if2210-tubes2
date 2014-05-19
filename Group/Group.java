/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Group;

import mysql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.eclipse.persistence.internal.expressions.SQLStatement;

/**
 *
 * @author KURING
 */
public class Group {
    private int no_tubes;
    private String group_name;
    private List<String> member;
    SqlStatement s;
    
    public Group(){
        try {
            s = new SqlStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Group.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getNo_tubes() {
        return no_tubes;
    }

    public void setNo_tubes(int no_tubes) {
        this.no_tubes = no_tubes;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public List<String> getMember() {
        return member;
    }

    public void setMember(List<String> member) {
        this.member = member;
    }
    
    public void addMember(String anggota){
        this.member.add(anggota);
    }
    
    public void save() throws SQLException{
        assert group_name != null : "Precondition group_name != null";
        assert member != null : "Precondition member != null";
        s.insert_group(no_tubes, group_name, member.get(0), member.get(1), member.get(2));
        assert cekDataGroup(no_tubes, group_name) == true : "Postcondition group exist"; 
    }
    
    public void update(int _no_tubes, String _group_name) throws SQLException{
        assert group_name != null : "Precondition group_name != null";
        s.update_group(no_tubes, group_name, member.get(0), member.get(1), member.get(2), _no_tubes, _group_name);
    }
    
    public void delete(int no_tubes, String group_name){
        
    }
    
    public void SelectAllData(){
        
    }
    
    public List<String[]> GroupData() throws SQLException{
        return new SqlStatement().select_group();
    }
    
    
    public List<String[]> GroupDataEdit() throws SQLException{
        return new SqlStatement().select_group_by_group(no_tubes, group_name);
    }
    
    public boolean cekDataGroup(int no_tubes, String group_name) throws SQLException{
        assert group_name != null : "Precondition group_name != null";
        return new SqlStatement().cekDataGroup(no_tubes, group_name);
    }
 
    public List<String> getHistory(){
        assert member != null : "Precondition member != null";
        return member;
    }
    
}
