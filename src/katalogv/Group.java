/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package katalogv;

import java.util.List;

/**
 *
 * @author KURING
 */
public class Group {
    private int no_tubes;
    private String group_name;
    private List<String> member;

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
    
    public void save(){
        
    }
    
    public void update(int no_tubes, String group_name){
        
    }
    
    public void delete(int no_tubes, String group_name){
        
    }
    
    public void SelectAllData(){
        
    }
    
    public List<String> getHistory(){
        return member;
    }
    
}
