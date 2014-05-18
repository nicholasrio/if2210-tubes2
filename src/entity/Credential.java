package entity;

import java.io.Serializable;

public class Credential implements Serializable {

	private static final long serialVersionUID = -5227294909324983861L;

	public static final int LOGIN = 0;
	public static final int LOGOUT = 1;
	public static final int PRINT = 2;
	
	private String id;
	private String password;
	private String fileName;
	private int type;

	public Credential(String id, String password, int type) {
		this.id = id;
		this.password = password;
		this.type = type;
	}
	
	public void setFile(String fileName){
		this.fileName = fileName;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}
	
	public String getFile(){
		return fileName;
	}
	
	public int getType(){
		return type;
	}

}
