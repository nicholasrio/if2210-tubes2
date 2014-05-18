/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

import java.sql.ResultSet;
import onlineprinter.Encrypt;

/**
 *
 * @author Luthfi Hamid M / 135120100
 */
public class User {

	private String username;
	private String password;
	private String nama;
	private String email;
	private int saldo;

	public User() {

	}

	public User(String username, String password, String nama, String email, int saldo) {
		this.username = username;
		this.password = Encrypt.MD5(password);
		this.nama = nama;
		this.email = email;
		this.saldo = saldo;
	}

	public User(ResultSet Data) {
		try {
			username = Data.getString("username");
			password = Data.getString("password");
			nama = Data.getString("nama");
			email = Data.getString("email");
			saldo = Data.getInt("saldo");
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

	public void print() {
		System.out.println(username);
		System.out.println(password);
		System.out.println(nama);
		System.out.println(email);
		System.out.println(saldo);
	}
}
