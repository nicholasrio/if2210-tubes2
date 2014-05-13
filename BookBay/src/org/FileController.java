package org;

import java.io.File;
import java.util.Date;

public class FileController implements Contoller {
	private FileExt _model;
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
	
	public FileCategory fileCategory() {
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
	
	public void upload() {
		
	}

	@Override
	public void updateView() {
		// TODO soal view, mau diapain?
		_view = null;
	}
}