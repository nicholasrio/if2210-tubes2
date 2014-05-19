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
	private int view;
	SqlStatement s;
        
        public Video() {
            try {
                s = new SqlStatement();
            } catch (SQLException ex) {
                Logger.getLogger(Video.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /* insert nilai attribute ke database */
	public void Insert() throws NullException, SQLException {
            if(title.equals("") || !(no_tubes>0 && no_tubes<4) || link.equals("") || group_name.equals("") || view<0) {
                throw new NullException ("Tidak boleh ada data yang null");
            }
            else {
                s.insert_video(title, link, view, no_tubes, group_name);
            }
	}
	/* update database dengan nilai attribute berdasarkan id*/
	public void Update(int id) throws SQLException, NullException {
            if(title.equals("") || !(no_tubes>0 && no_tubes<4) || link.equals("") || group_name.equals("") || view<0) {
                throw new NullException ("Tidak boleh ada data yang null");
            }
            else {
             s.update_video(id, title, link, view, no_tubes, group_name);
            }
        }
        /* delete data video berdasarkan id */
	public void Delete(int id) throws SQLException {
            s.delete_video(id);
	}
	/* cek data video di database */
        public boolean cekData(int id) throws SQLException{
            return s.cekDataVideo(id);
        }
        /* mengambil semua data video didatabase */
	public List<String[]> SelectData() throws SQLException {
            return s.select_video();
	}
	/* mengambil link video berdasarkan no_tubes dan nama group */
        public String LinkVideo (int no_tubes, String groupname) throws SQLException{
            return s.SearchVideo(no_tubes, groupname);
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
	public void setNo_tubes(int no_tubes) throws AttributeException{
            if(no_tubes == 1 || no_tubes ==2 || no_tubes ==3) {
		this.no_tubes = no_tubes;
            }
            else {
                throw new AttributeException("No Tubes salah! masukkan angka 1, 2 atau 3..");
            }
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
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
}
