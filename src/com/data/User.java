package com.data;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import onlineprinter.Encrypt;

/**
 *
 * @author Luthfi Hamid Masykuri / 135120100
 */
public class User implements Serializable {

	private String username;
	private String password;
	private String nama;
	private String email;
	private int saldo;
	private int status;
	private UserLogDao Logs;

	public User() {

	}

	public User(String username, String password, String nama, String email, int saldo, int status) {
		this.username = username;
		this.password = Encrypt.MD5(password);
		this.nama = nama;
		this.email = email;
		this.saldo = saldo;
		this.status = status;
		Logs = new UserLogDaoImpl(this);
	}

	public User(ResultSet Data) {
		try {
			username = Data.getString("username");
			password = Data.getString("password");
			nama = Data.getString("nama");
			email = Data.getString("email");
			saldo = Data.getInt("saldo");
			status = Data.getInt("status");
			Logs = new UserLogDaoImpl(this);
		} catch (Exception e) {

		}
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getNama() {
		return nama;
	}

	public String getEmail() {
		return email;
	}

	public int getSaldo() {
		return saldo;
	}

	public int getStatus() {
		return status;
	}

	public List<UserLog> getLog() {
		return Logs.getAllLog();
	}

	public void TambahSaldo(int jumlah) {
		saldo += jumlah;
		UserLog Log = new UserLog(jumlah, saldo);
		Logs.AddLog(Log);
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = Encrypt.MD5(password);
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void print() {
		System.out.println(username);
		System.out.println(password);
		System.out.println(nama);
		System.out.println(email);
		System.out.println(saldo);
		System.out.println(status);
	}
}
