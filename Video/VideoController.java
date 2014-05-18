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
import java.util.List;

public class VideoController {
    private final Video vid;
    private final VideoView view;
    
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
}
