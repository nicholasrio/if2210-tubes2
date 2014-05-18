package entity;

import java.io.Serializable;

public class Credential implements Serializable {

	private static final long serialVersionUID = -5227294909324983861L;

	private String id;
	private String password;
	private String filePath;
	private boolean LoginOnly;

	public Credential(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

}
