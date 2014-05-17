package Video;

import mysql.SqlStatement;
import java.sql.SQLException;
import java.util.List;
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
        /* insert attribut to database */
	public void Insert() throws SQLException {
            s.insert_video(title, link, rating, view, group_name);
	}
        /* update attribut to database */
	public void Update(int id) throws SQLException {
            s.update_video(id, title, link, rating, view, group_name);
        }
        /* delete attribut to database */
	public void Delete(int id) throws SQLException {
            s.delete_video(id);
	}
        /* cek data apakah ada didatabase */
        public boolean cekData(int id) throws SQLException{
            return s.cekDataVideo(id);
        }
        /* mengambil semua data yang ada didatabase */
	public List<String[]> SelectData() throws SQLException {
            return s.select_video();
	}
	//public GetThumbnail() {
	
	//}
	
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