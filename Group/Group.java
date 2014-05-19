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
 * Kelas untuk mengutus urusan grup
 * @author Hendro Triokta Brianto - 13512081
 */
public class Group {
    private int no_tubes;
    private String group_name;
    private List<String> member;
    SqlStatement s;
    
    
    /**
     * Default Constructor
     */
    public Group(){
        try {
            s = new SqlStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Group.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * getter untuk no tubes
     * @return no_tubes
     */
    public int getNo_tubes() {
        return no_tubes;
    }

    /**
     * setter untuk no_tubes
     * @param no_tubes
     */
    public void setNo_tubes(int no_tubes) {
        this.no_tubes = no_tubes;
    }

    /**
     * getter untuk mendapatkan nama grup
     * @return group_name
     */
    public String getGroup_name() {
        return group_name;
    }

    /**
     * setter untuk nama grup
     * @param group_name 
     */
    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    /**
     * getter untuk nama member
     * @return member
     */
    public List<String> getMember() {
        return member;
    }

    /**
     * setter untuk member
     * @param member
     */
    public void setMember(List<String> member) {
        this.member = member;
    }
    
    /**
     * method untuk tambah member
     * @param anggota 
     */
    public void addMember(String anggota){
        this.member.add(anggota);
    }

    /**
     * 
     * memasukkan data group ke dalam database
     * @throws SQLException 
     */
    public void save() throws SQLException{
        assert group_name != null : "Precondition group_name != null";
        assert member != null : "Precondition member != null";
        s.insert_group(no_tubes, group_name, member.get(0), member.get(1), member.get(2));
        assert cekDataGroup(no_tubes, group_name) == true : "Postcondition group exist"; 
    }
    
    /**
     * 
     * mengubah data pada database berdasarkan parameternya
     * @param _no_tubes
     * @param _group_name
     * @throws SQLException 
     */
    public void update(int _no_tubes, String _group_name) throws SQLException{
        assert group_name != null : "Precondition group_name != null";
        s.update_group(no_tubes, group_name, member.get(0), member.get(1), member.get(2), _no_tubes, _group_name);
    }
    
    /**
     * Menghapus data group yang dipilih
     * @param no_tubes
     * @param group_name 
     */
    
    public void delete(int no_tubes, String group_name){
        
    }
    
    /**
     * 
     * mengambalikan data ke dalam List
     * @return
     * @throws SQLException 
     */
    public List<String[]> GroupData() throws SQLException{
        return new SqlStatement().select_group();
    }
    
    /**
     * 
     * mengembalikan data yang akan diedit ke dalam List
     * @return
     * @throws SQLException 
     */
    public List<String[]> GroupDataEdit() throws SQLException{
        return new SqlStatement().select_group_by_group(no_tubes, group_name);
    }
    
    /**
     * 
     * Mengecek apakah data ada di dalam database
     * @param no_tubes
     * @param group_name
     * @return
     * @throws SQLException 
     */
    public boolean cekDataGroup(int no_tubes, String group_name) throws SQLException{
        assert group_name != null : "Precondition group_name != null";
        return new SqlStatement().cekDataGroup(no_tubes, group_name);
    }
 
    /**
     * mendapatkan seluruh member dari suatu grup
     * @return 
     */
    public List<String> getHistory(){
        assert member != null : "Precondition member != null";
        return member;
    }
    
}
