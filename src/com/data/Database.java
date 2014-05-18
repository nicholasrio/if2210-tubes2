/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

/**
 *
 * @author Luthfi Hamid M / 135120100
 */
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private String host;
	private String user;
	private String pass;
	private String db_name;
	private Connection connection;
	private Statement statement;
	private String where = "";

	public Database() {
		host = "localhost";
		user = "root";
		pass = "underground";
		db_name = "tubes_oop";
		String connectionURL = "jdbc:mysql://" + host + "/" + db_name;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = (Connection) DriverManager.getConnection(connectionURL, "root", "underground");
			statement = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Where(String col, String comp) {
		if (where == "") {
			where += "WHERE " + col + "'" + comp + "'";
		} else {
			where += " AND " + col + "'" + comp + "'";
		}
	}

	public ResultSet Select(String Table) {
		ResultSet result = null;
		try {
			if (where == "") {
				result = statement.executeQuery("SELECT * FROM `" + Table + "`");
			} else {
				result = statement.executeQuery("SELECT * FROM `" + Table + "` " + where);
				where = "";
			}
		} catch (Exception e) {

		}
		return result;
	}

	public int Insert(String Table, String Col[], String Val[]) {
		String ColName = "(";
		int i = 1;
		for (String col : Col) {
			if (i < Col.length) {
				ColName += col + ",";
			} else {
				ColName += col + ")";
			}
			i++;
		}
		String Values = "(";
		i = 1;
		for (String val : Val) {
			if (i < Col.length) {
				Values += "'" + val + "',";
			} else {
				Values += "'" + val + "')";
			}
			i++;
		}
		try {
			return statement.executeUpdate("INSERT INTO `" + Table + "` " + ColName + " VALUES " + Values);
		} catch (Exception e) {
			return 0;
		}
	}

	public void Delete(String Table) {
		try {
			if (where == "") {
				statement.executeUpdate("DELETE FROM `" + Table + "`");
			} else {
				statement.executeUpdate("DELETE FROM `" + Table + "` " + where);
				where = "";
			}
		} catch (Exception e) {

		}
	}

	public void Update(String Table, String Col[], String Val[]) {
		try {
			String set = "";
			if (Col.length == Val.length) {
				for (int i = 0; i < Col.length; i++) {
					set += Col[i] + "='" + Val[i] + "'";
				}
				if (where == "") {
					statement.executeUpdate("UPDATE `" + Table + "` SET " + set);
				} else {
					statement.executeUpdate("UPDATE `" + Table + "` SET " + set + " " + where);
					where = "";
				}
			}
		} catch (Exception e) {

		}
	}
}
