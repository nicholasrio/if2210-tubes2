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
	
	public String name() {
		return name;
	}
	
	public void name(String name) {
		this.name = name;
	}
	
	public String id() {
		return ID;
	}
	
	public void id(String ID) {
		this.ID = ID;
	}
	
	public String password() {
		return password;
	}
	
	public void password(String password) {
		this.password = password;
	}
	
	public List<FileController> fileController() {
		return files;
	}
}
