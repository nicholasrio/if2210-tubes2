package org;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;


public class FileController implements Contoller {
	private static String uploadURL = "http://localhost/bookbay/upload.php";
	private static String downloadURL = "http://localhost/bookbay/download.php";
	private static String charset = "UTF-8"; // character set
	
	private FileExt _model;
	@SuppressWarnings("unused")
	private FileView _view;
	
	public FileController(FileExt model, FileView view) {
		_model = model;
		_view = view; 
	}
	
	public String fileName() {
		return _model.getName();
	}
	
	public void rename(String name) throws SecurityException, NullPointerException {
		_model.renameTo(new File(_model.getPath() + "\\" + name)); // TODO: ubah jadi hash.
		_model.name(name);
	}
	
	public long fileSize() {
		return _model.length();
	}
	
	public User fileUploader() {
		return _model.uploader();
	}
	
	public void fileUploader(User newUploader) {
		_model.uploader(newUploader);
	}
	
	public long fileDownloadCount() {
		return _model.downloadCount();
	}
	
	public void fileDownloadCount(long count) {
		_model.downloadCount(count);
	}
	
	public String fileCategory() {
		return _model.category();
	}
	
	public void fileCategory(FileCategory cat) {
		_model.category(cat);
	}
	
	public Date fileUploadTime() {
		return _model.uploadTime();
	}
	
	public void delete() {
		_model.delete();
		_model = null;
	}
	
	public static String uploadURL() {
		return uploadURL;
	}
	
	public static void uploadURL(String newURL) {
		uploadURL = newURL;
	}
	
	public static String downloadURL() {
		return downloadURL;
	}
	
	public static void downloadURL(String newURL) {
		downloadURL = newURL;
	}
	
	public static String charset() {
		return charset;
	}
	
	public static void charset(String newCharset) {
		charset = newCharset;
	}
	
	public void upload() throws IOException {
		ServerPOST sp = new ServerPOST(uploadURL, charset);
		
		sp.addFormField("File-Name", _model.name());
		sp.addFormField("File-Uploader", _model.uploader().id());
		sp.addFormField("File-Category", _model.category().toString());
		
		sp.addFile("ebook", _model);
		
		List<String> response =	sp.execute();
		
		// TODO: ini output di-alihkan ke tempat lain
		for(String s: response) {
			System.out.println(s);
		}
	}
	
	/**
	 * NOTE: this will remove the current model reference
	 */
	public void download() {
		
	}

	@Override
	public void updateView() {
		// TODO soal view, mau diapain?
		// masih berupa stub
		_view = null;
	}
}