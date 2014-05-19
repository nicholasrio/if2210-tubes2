package org;

import java.util.List;

public class UserController implements Controller {
	private User _model;
	private UserView _view;
	public UserController(User model, UserView view ){
		_model=model;
		_view=view;
	}
	public String getUserName(){
		return _model.name();
	}
	public void setUserName(String name){
		_model.name(name);
	}
	public String getUserID(){
		return _model.getID();
	}
	public void setUserID(String ID){
		_model.id(ID);
	}
	public String getUserPassword(){
		return _model.password();
	}
	public void setUserPassword(String password){
		_model.password(password);
	}
	public FileController getUserFile(int n){ 
		List<FileController> tempFileController = _model.fileController();
		return tempFileController.get(n);
	}
	public List<FileController> getFileList(){
		return _model.fileController();
	}
	@Override
	public void updateView() {
		// TODO soal view, mau diapain?
		_view = null;
	}

}
