package org;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;


public class FileController implements IFileController {
	private static String uploadURL = "http://localhost/bookbay/upload.php";
	private static String downloadURL = "http://localhost/bookbay/download.php";
	private static String syncURL = "http://localhost/bookbay/sync.php";
	private static String charset = "UTF-8"; // character set
	
	private FileExt model;
	private IFileView view;
	
	private String prevName;
	
	public FileController(FileExt model, IFileView view) {
		registerModel(model);
		registerView(view);
		
		updateView();
	}
	
	@Override
	public void registerModel(FileExt model) {
		this.model = model;
		
		if(model != null)
			this.prevName = model.getNamedName();
	}
	
	@Override
	public void registerView(IFileView view) {
		this.view = view;
	}
	
	@Override
	public boolean isModelEmpty() {
		return model == null;
	}
	
	@Override
	public String getFileNamedName() {
		return model.getNamedName();
	}
	
	@Override
	public void setFileNamedName(String name) {
		model.setNamedName(name);
	}
	
	@Override
	public String getFileLocation() {
		return model.getAbsolutePath();
	}
	
	@Override
	public void rename(String name) throws SecurityException, NullPointerException {
		model.renameTo(new File(model.getPath() + name)); // TODO: ubah jadi hash.
		model.setNamedName(name);
	}
	
	@Override
	public long getFileSize() {
		return model.length();
	}
	
	@Override
	public User getFileUploader() {
		return model.getUploader();
	}
	
	@Override
	public long getFileDownloadCount() {
		return model.getDownloadCount();
	}
	
	@Override
	public String getFileCategory() {
		return model.getCategory();
	}
	
	@Override
	public void setFileCategory(FileCategory cat) {
		model.setCategory(cat);
	}
	
	@Override
	public Date getFileUploadTime() {
		return model.getUploadTime();
	}
	
	@Override
	public String getFileDescription() {
		return model.getDesc();
	}
	
	@Override
	public void setFileDescription(String desc) {
		model.setDesc(desc);
	}
	
	@Override
	public void delete() {
		model.delete();
		model = null;
	}
	
	public static String getSyncURL() {
		return syncURL;
	}
	
	public static void setSyncURL(String newURL) {
		syncURL = newURL;
	}
	
	public static String getUploadURL() {
		return uploadURL;
	}
	
	public static void setUploadURL(String newURL) {
		uploadURL = newURL;
	}
	
	public static String getDownloadURL() {
		return downloadURL;
	}
	
	public static void setDownloadURL(String newURL) {
		downloadURL = newURL;
	}
	
	public static String getCharset() {
		return charset;
	}
	
	public static void setCharset(String newCharset) {
		charset = newCharset;
	}
	
	@Override
	public void upload() throws IOException {
		ServerPOST sp = new ServerPOST(uploadURL, charset, false);
		
		sp.addFormField("File-Name", model.getNamedName());
		sp.addFormField("File-Uploader", model.getUploader().getID());
		sp.addFormField("File-Category", model.getCategory().toString());
		sp.addFormField("File-Desc", model.getDesc());
		
		sp.addFile("file", model);
		
		List<String> response =	sp.execute();
		
		// TODO: output dialihkan ke tempat lain
		for(String s: response) {
			System.out.println(s);
		}
	}
	
	@Override
	public void download(File saveLocation, User user) throws IOException {
		ServerPOST sp = new ServerPOST(uploadURL, charset, true);
		
		sp.addFormField("File-Name", model.getNamedName());
		sp.addFormField("User-Name", user.name());
		
		sp.execute(saveLocation);
	}

	@Override
	public void updateView() {
		if(!isModelEmpty())
			view.updateModel();
	}

	@Override
	public void sync() throws IOException {
		assert(model != null);
		assert(prevName != null);
		
		ServerPOST sp = new ServerPOST(syncURL, charset, false);
		
		sp.addFormField("Prev-Name", prevName);
		sp.addFormField("File-Name", model.getNamedName());
		sp.addFormField("File-Category", model.getCategory());
		sp.addFormField("File-Desc", model.getDesc());
		
		List<String> response = sp.execute();
		
		for(String s: response) {
			System.out.println(s);
		}
	}
}