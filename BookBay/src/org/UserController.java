package org;

import java.util.List;

public class UserController implements Contoller {
	private User _model;
	private UserView _view;
	public UserController(User model, UserView view ){
		_model=model;
		_view=view;
	}
	public String getUserName(){
		return _model.getName();
	}
	public void setUserName(String name){
		_model.setName(name);
	}
	public String getUserID(){
		return _model.getID();
	}
	public void setUserID(String ID){
		_model.setID(ID);
	}
	public String getUserPassword(){
		return _model.getPassword();
	}
	public void setUserPassword(String password){
		_model.setPassword(password);
	}
	public FileController getUserFile(int n){ 
		List<FileController> tempFileController = _model.getFileController();
		return tempFileController.get(n);
	}
	public List<FileController> getFileList(){
		return _model.getFileController();
	}
	@Override
	public void updateView() {
		// TODO soal view, mau diapain?
		_view = null;
	}

}
