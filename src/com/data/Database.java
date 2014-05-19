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
import java.io.File;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class Database {

	private String host;
	private String user;
	private String pass;
	private String db_name;
	private Connection connection;
	private Statement statement;
	private String where = "";

	public Database() {
		try {
                        File file = new File("config.xml");
                        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();  
                        Document doc = builder.parse(file);
                        Element Host = (Element) doc.getElementsByTagName("host").item(0);
                        Element User = (Element) doc.getElementsByTagName("user").item(0);
                        Element Pass = (Element) doc.getElementsByTagName("pass").item(0);
                        Element DbName = (Element) doc.getElementsByTagName("dbname").item(0);
                        host = Host.getTextContent();
                        user = User.getTextContent();
                        pass = Pass.getTextContent();
                        db_name = DbName.getTextContent();
                        String connectionURL = "jdbc:mysql://" + host + "/" + db_name;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = (Connection) DriverManager.getConnection(connectionURL, user, pass);
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
					if (i < Col.length - 1) {
						set += Col[i] + "='" + Val[i] + "',";
					} else {
						set += Col[i] + "='" + Val[i] + "'";
					}
				}
				if (where == "") {
					statement.executeUpdate("UPDATE `" + Table + "` SET " + set);
				} else {
					statement.executeUpdate("UPDATE `" + Table + "` SET " + set + " " + where);
					where = "";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        public static void main(String[] args)
        {
            Database data = new Database();
        }
}
