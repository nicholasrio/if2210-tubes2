import java.sql.*;
import java.io.*;
import java.util.*;


public class JavaStatus {
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	public static final String DB_URL = "jdbc:mysql://localhost/jais";
	public static final String USER = "root";
	public static final String PASS = "";
	public static Connection conn = null;
	public static Statement stmt = null;
	public static int pilihMenu;
	public static int pilihBulan;
	public static String ketBudget;
	public static String tanggal;
	public static void insertStatus() {
		regJDBCException();
		openConn();
		int pilihMenu;
		int 
	}
}
