/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Video;

import java.sql.SQLException;
/**
 * Kelas view video
 * @author asus
 */
public class VideoView {
    /** 
     * Default konstraktor
     */
    public VideoView(){
        
    }
    /** 
     * mencetak details
     * @param details
     * @throws SQLException 
     */
    public void printVideoDetails(String details) throws SQLException{
        System.out.println(details);
    }
    
}
