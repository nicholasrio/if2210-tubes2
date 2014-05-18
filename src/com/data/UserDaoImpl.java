/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import onlineprinter.Encrypt;

/**
 *
 * @author Luthfi Hamid M / 135120100
 */
public class UserDaoImpl extends Database implements UserDao {

	private String Table;

	public UserDaoImpl() {
		Table = "user";
	}

	@Override
	public List<User> getAllUser() {
		try {
			ResultSet res = super.Select(Table);
			boolean isExist = res.first();
			List<User> TblUser = new LinkedList();
			while (isExist) {
				User user = new User(res);
				TblUser.add(user);
				isExist = res.next();
			}
			return TblUser;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User getByUsername(String username) {
		try {
			super.Where("username = ", username);
			ResultSet res = super.Select(Table);
			if (res.first()) {
				User user = new User(res);
				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User Validate(String username, String pass) {
		try {
			super.Where("username = ", username);
			super.Where("password = ", Encrypt.MD5(pass));
			ResultSet res = super.Select(Table);
			if (res.first()) {
				User user = new User(res);
				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void UpdateUser(String username, User user) {
		super.Where("username = ", username);
		String col[] = {"username", "password", "nama", "email", "saldo"};
		String val[] = new String[5];
		val[0] = user.getUsername();
		val[1] = user.getPassword();
		val[2] = user.getNama();
		val[3] = user.getEmail();
		val[4] = "" + user.getSaldo();
		super.Update(Table, col, val);
	}

	@Override
	public void DeleteUser(String username) {
		super.Where("username = ", username);
		super.Delete(Table);
	}

	@Override
	public void AddUser(User user) {
		String col[] = {"username", "password", "nama", "email", "saldo"};
		String val[] = new String[5];
		val[0] = user.getUsername();
		val[1] = user.getPassword();
		val[2] = user.getNama();
		val[3] = user.getEmail();
		val[4] = "" + user.getSaldo();
		int hasil = super.Insert(Table, col, val);
	}

}
