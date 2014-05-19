/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Video;

import java.sql.SQLException;
import java.util.List;

/**
 * kelas controller video
 * @author asus
 */
public class VideoController {
    private Video vid;
    private VideoView view;
    /**
     * Default konstraktor
     */
    public VideoController() {
        vid = new Video();
        view = new VideoView();
    }
    /**
     * insert data video
     * @throws SQLException
     * @throws NullException 
     */
    public void InsertVideo() throws SQLException, NullException {
        vid.Insert();
    }
    /**
     * update data video
     * @param id
     * @throws SQLException
     * @throws NullException 
     */
    public void UpdateVideo(int id) throws SQLException, NullException {
        vid.Update(id);
    }
    /**
     * delete data video
     * @param id
     * @throws SQLException 
     */
    public void DeleteVideo(int id) throws SQLException {
        vid.Delete(id);
    }
    /**
     * mengambil semua data video
     * @return
     * @throws SQLException 
     */
    public List<String[]> SelectVideoData() throws SQLException {
        return vid.SelectData();
    }
    /**
     * mengambil link video dari no_tubes dan namakelompok
     * @param no_tubes
     * @param namakelompok
     * @return 
     * @throws java.sql.SQLException
    */
    public String LinkVideo(int no_tubes, String namakelompok) throws SQLException{
        String temp = vid.LinkVideo(no_tubes, namakelompok);
        System.out.println(temp);
        return temp;
    }
    
    /**
     * method buat cmd (lagi)
     * @param title
     * @param URL
     * @param group_name
     * @param no_tubes
     * @throws AttributeException
     * @throws SQLException
     * @throws NullException 
     */
    public void AddVideo(String title, String URL, String group_name, int no_tubes) throws AttributeException, SQLException, NullException{
        vid.setTitle(title);
        vid.setLink(URL);
        vid.setGroup_name(group_name);
        vid.setNo_tubes(no_tubes);
        vid.Insert();
        System.out.println("Video data has been added, don't forget to add the group too if it hasn't been registered");
    }
    /** 
     * edit data video
     * @param id
     * @param title
     * @param URL
     * @param group_name
     * @param no_tubes
     * @throws AttributeException
     * @throws SQLException
     * @throws NullException 
     */
    public void EditDataVideo(int id, String title, String URL, String group_name, int no_tubes) throws AttributeException, SQLException, NullException{
        vid.setTitle(title);
        vid.setLink(URL);
        vid.setGroup_name(group_name);
        vid.setNo_tubes(no_tubes);
        vid.Update(id);
        System.out.println("Video data has been changed");
    }
}
