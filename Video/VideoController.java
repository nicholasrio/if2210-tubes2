/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Video;

/**
 *
 * @author asus
 */
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VideoController {
    private Video vid;
    private VideoView view;
    
    public VideoController() {
        vid = new Video();
        view = new VideoView();
    }
    public void InsertVideo() throws SQLException, NullException {
        vid.Insert();
    }
    public void UpdateVideo(int id) throws SQLException, NullException {
        vid.Update(id);
    }
    public void DeleteVideo(int id) throws SQLException {
        vid.Delete(id);
    }
    public List<String[]> SelectVideoData() throws SQLException {
        return vid.SelectData();
    }
    
    public String LinkVideo(int no_tubes, String namakelompok) throws SQLException{
        String temp = vid.LinkVideo(no_tubes, namakelompok);
        System.out.println(temp);
        return temp;
    }
    
    /* method buat cmd (lagi) */
    public void AddVideo(String title, String URL, String group_name, int no_tubes) throws AttributeException, SQLException, NullException{
        vid.setTitle(title);
        vid.setLink(URL);
        vid.setGroup_name(group_name);
        vid.setNo_tubes(no_tubes);
        vid.Insert();
        System.out.println("Video data has been added, don't forget to add the group too if it hasn't been registered");
    }
    public void EditDataVideo(int id, String title, String URL, String group_name, int no_tubes) throws AttributeException, SQLException, NullException{
        vid.setTitle(title);
        vid.setLink(URL);
        vid.setGroup_name(group_name);
        vid.setNo_tubes(no_tubes);
        vid.Update(id);
        System.out.println("Video data has been changed");
    }
}
