package Video;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Video {
	
	private String title;
	private int no_tubes;
	private String group_name;
	private int id;
	private String link;
	private int rating;
	private int view;
	SqlStatement s;
        
        public Video() {
            try {
                s = new SqlStatement();
            } catch (SQLException ex) {
                Logger.getLogger(Video.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	public void Insert() throws SQLException {
            s.insert_video(title, link, rating, view, no_tubes, group_name);
	}
	public void Update(int id) throws SQLException {
            s.update_video(id, title, link, rating, view, no_tubes, group_name);
        }
	public void Delete(int id) throws SQLException {
            s.delete_video(id);
	}
        public void select_video_by(int id) throws SQLException{
            try (ResultSet rs = s.getStatement().executeQuery("select * from video where id = \"" + id + "\";")) {
                while(rs.next()){
                    this.setId(rs.getInt("id"));
                    this.setTitle(rs.getString("title"));
                    this.setGroup_name(rs.getString("group_name"));
                    this.setLink(rs.getString("link"));
                    this.setNo_tubes(rs.getInt("no_tubes"));
                    this.setRating(rs.getInt("rating"));
                    this.setView(rs.getInt("view"));
                }
            }
        }
	public List<String> SelectData(int id) {
		List<String> L = new ArrayList<> ();
		return L;
	}
	//public GetThumbnail() {
	
	//}
	public List<String> GetMember() {
		List<String> L = new ArrayList<> ();
		return L;
	}
	
	// getter dan setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
}