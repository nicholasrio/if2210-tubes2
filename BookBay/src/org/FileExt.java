package org;

import java.io.File;
import java.util.Date;

public class FileExt extends File {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4560430887734007570L;
	private User _uploader; // uploader
	private String _name; // real file name
	private Date _uploadtime; // upload time
	private long _downloadCount; // download count
	private FileCategory _cat; // file category
	
	public FileExt(String location, String filename, User uploader) {
		super(location); // physical location of the file
		_name = filename;
		_uploader = uploader;
		_downloadCount = 0;
		_uploadtime = new Date();
	}
	
	public User uploader() {
		return _uploader;
	}
	
	public void uploader(User newUploader) {
		_uploader = newUploader;
	}
	
	public String name() {
		return _name;
	}
	
	public void name(String newName) {
		_name = newName;
	}
	
	public Date uploadTime() {
		return _uploadtime;
	}
	
	// TODO: cek, ini butuh ato ngga?
	public void uploadTime(Date uploadTime) {
		_uploadtime = uploadTime;
	}
	
	public long downloadCount() {
		return _downloadCount;
	}
	
	public void downloadCount(long count) {
		_downloadCount = count;
	}
	
	public FileCategory category() {
		return _cat;
	}
	
	public void category(FileCategory cat) {
		_cat = cat;
	}
}
