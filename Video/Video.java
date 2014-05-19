package Video;

import mysql.SqlStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * kelas video
 * @author asus
 */
public class Video {
	
	private String title;
	private int no_tubes;
	private String group_name;
	private int id;
	private String link;
	private int view;
	SqlStatement s;
        
        /**
         * Default konstraktor
         */
        public Video() {
            try {
                s = new SqlStatement();
            } catch (SQLException ex) {
                Logger.getLogger(Video.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /**
         * insert nilai attribute ke database 
         * @throws NullException
         * @throws SQLException 
         */
	public void Insert() throws NullException, SQLException {
            if(title.equals("") || !(no_tubes>0 && no_tubes<4) || link.equals("") || group_name.equals("") || view<0) {
                throw new NullException ("Tidak boleh ada data yang null");
            }
            else {
                s.insert_video(title, link, view, no_tubes, group_name);
            }
	}
	/**
         * update database dengan nilai attribute berdasarkan id
     * @param _id
         * @throws SQLException
         * @throws NullException 
         */
	public void Update(int _id) throws SQLException, NullException {
            if(title.equals("") || !(no_tubes>0 && no_tubes<4) || link.equals("") || group_name.equals("") || view<0) {
                throw new NullException ("Tidak boleh ada data yang null");
            }
            else {
             s.update_video(_id, title, link, view, no_tubes, group_name);
            }
        }
        /**
         * delete data video berdasarkan id
         * @param id
         * @throws SQLException 
         */ 
	public void Delete(int id) throws SQLException {
            s.delete_video(id);
	}
	/**
         * cek data video di database
         * @param id
         * @return
         * @throws SQLException 
         */ 
        public boolean cekData(int id) throws SQLException{
            return s.cekDataVideo(id);
        }
        /**
         * mengambil semua data video didatabase
         * @return
         * @throws SQLException 
         */
	public List<String[]> SelectData() throws SQLException {
            return s.select_video();
	}
        
        /**
         * mengambil data berdasarkan id
         * @return
         * @throws SQLException 
         */
	public List<String[]> SelectDataById(int _id) throws SQLException {
            return s.select_video_by_id(_id);
	}
	/**
         * mengambil link video berdasarkan no_tubes dan nama group
         * @param no_tubes
         * @param groupname
         * @return
         * @throws SQLException 
         */
        public String LinkVideo (int no_tubes, String groupname) throws SQLException{
            return s.SearchVideo(no_tubes, groupname);
        }
	
	/**
         * Getter title
         * @return 
         */
	public String getTitle() {
		return title;
	}
        /**
         * Setter title
         * @param title 
         */
	public void setTitle(String title) {
		this.title = title;
	}
        /** 
         * Getter no_tubes
         * @return 
         */
	public int getNo_tubes() {
		return no_tubes;
	}
        /** Setter no_tubes
         * 
         * @param no_tubes
         * @throws AttributeException 
         */
	public void setNo_tubes(int no_tubes) throws AttributeException{
            if(no_tubes == 1 || no_tubes ==2 || no_tubes ==3) {
		this.no_tubes = no_tubes;
            }
            else {
                throw new AttributeException("No Tubes salah! masukkan angka 1, 2 atau 3..");
            }
	}
        /** Getter group_name
         * 
         * @return 
         */
	public String getGroup_name() {
		return group_name;
	}
        /** Setter group_name
         * 
         * @param group_name 
         */
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
        /** Getter id
         * 
         * @return 
         */
	public int getId() {
		return id;
	}
        /** Setter id
         * 
         * @param id 
         */
	public void setId(int id) {
		this.id = id;
	}
        /**
         * Getter link
         * @return 
         */
	public String getLink() {
		return link;
	}
        /** Setter link
         * 
         * @param link 
         */
	public void setLink(String link) {
		this.link = link;
	}
        /**
         * Getter view
         * @return 
         */
	public int getView() {
		return view;
	}
        /** Setter view
         * 
         * @param view 
         */
	public void setView(int view) {
		this.view = view;
	}
}
