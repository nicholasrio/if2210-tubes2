package org;
import java.util.List;
import java.util.ArrayList;

public class User {
	private String name; // the user's real name
	private String ID;  // user's ID
	private String password; // password of the user
	private List<FileController> files; // files owned by the user
	
	public User(String name, String ID, String password) {
		this.name = name;
		this.ID = ID;
		this.password = password;
		files = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getID() {
		return ID;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<FileController> getFileController() {
		return files;
	}
	
}
