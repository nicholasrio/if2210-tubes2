package org;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;


public class FileController implements Contoller {
	private static String uploadURL = "http://localhost/bookbay/upload.php";
	private static String downloadURL = "http://localhost/bookbay/download.php";
	private static String charset = "UTF-8"; // character set
	
	private FileExt model;
	@SuppressWarnings("unused") // TODO: stub
	private FileView view;
	
	public FileController(FileExt model, FileView view) {
		this.model = model;
		this.view = view; 
	}
	
	public String getFileLocation() {
		return model.getName();
	}
	
	public void rename(String name) throws SecurityException, NullPointerException {
		model.renameTo(new File(model.getPath() + "\\" + name)); // TODO: ubah jadi hash.
		model.setNamedName(name);
	}
	
	public long getFileSize() {
		return model.length();
	}
	
	public User getFileUploader() {
		return model.getUploader();
	}
	
	public void setFileUploader(User newUploader) {
		model.setUploader(newUploader);
	}
	
	public long setFileDownloadCount() {
		return model.getDownloadCount();
	}
	
	public void getFileDownloadCount(long count) {
		model.setDownloadCount(count);
	}
	
	public String fileCategory() {
		return model.getCategory();
	}
	
	public void fileCategory(FileCategory cat) {
		model.setCategory(cat);
	}
	
	public Date fileUploadTime() {
		return model.getUploadTime();
	}
	
	public String fileDescription() {
		return model.getDesc();
	}
	
	public void fileDescription(String desc) {
		model.setDesc(desc);
	}
	
	public void delete() {
		model.delete();
		model = null;
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
		ServerPOST sp = new ServerPOST(uploadURL, charset, false);
		
		sp.addFormField("File-Name", model.getNamedName());
		sp.addFormField("File-Uploader", model.getUploader().name());
		sp.addFormField("File-Category", model.getCategory().toString());
		sp.addFormField("File-Desc", model.getDesc());
		
		sp.addFile("ebook", model);
		
		List<String> response =	sp.execute();
		
		// TODO: output dialihkan ke tempat lain
		for(String s: response) {
			System.out.println(s);
		}
	}
	
	public void download(String saveLocation, User user) throws IOException {
		ServerPOST sp = new ServerPOST(uploadURL, charset, true);
		
		sp.addFormField("File-Name", model.getName());
		sp.addFormField("User-Name", user.name());
		
		sp.execute(new File(saveLocation));
	}

	@Override
	public void updateView() {
		// TODO soal view, mau diapain?
		// masih berupa stub
		view = null;
	}
}