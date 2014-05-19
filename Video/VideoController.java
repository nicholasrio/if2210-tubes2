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
    
}
