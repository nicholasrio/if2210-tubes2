package entity;

import java.io.Serializable;

public class Credential implements Serializable {

	private static final long serialVersionUID = -5227294909324983861L;

	public static final int LOGIN = 0;
	public static final int LOGOUT = 1;
	
	private String id;
	private String password;
	private String filePath;
	private int type;

	public Credential(String id, String password, int type) {
		this.id = id;
		this.password = password;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}
	
	public int getType(){
		return type;
	}

}
