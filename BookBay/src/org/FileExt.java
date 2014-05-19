package org;

import java.io.File;
import java.util.Date;

public class FileExt extends File {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4560430887734007570L;
	private User uploader; // uploader
	private String namedName; // real file name
	private Date uploadTime; // upload time
	private long downloadCount; // download count
	private FileCategory cat; // file category
	private String description;
	
	public FileExt(String location, String filename, User uploader, Date uploadTime, String desc, String cat) throws Exception {
		super(location); // physical location of the file
		this.namedName = filename;
		this.uploader = uploader;
		this.downloadCount = 0;
		this.uploadTime = uploadTime;
		this.description = desc;
		this.cat = FileCategory.getCategory(cat);
	}
	
	public User getUploader() {
		return uploader;
	}
	
	public void setUploader(User newUploader) {
		uploader = newUploader;
	}
	
	public String getNamedName() {
		return namedName;
	}
	
	public void setNamedName(String newName) {
		namedName = newName;
	}
	
	public Date getUploadTime() {
		return uploadTime;
	}
	
	// TODO: cek, ini butuh ato ngga?
	public void uploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	
	public long getDownloadCount() {
		return downloadCount;
	}
	
	public void setDownloadCount(long count) {
		downloadCount = count;
	}
	
	public String getCategory() {
		return cat.toString();
	}
	
	public void setCategory(FileCategory cat) {
		this.cat = cat;
	}
	
	public String getDesc() {
		return description;
	}
	
	public void setDesc(String desc) {
		description = desc;
	}
}
