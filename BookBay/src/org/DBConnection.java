package org;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String DATABASE = "jdbc:mysql://localhost/bookbay";
	
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	ResultSet executeQuery(String Query) throws SQLException
	{
		try {
			conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(Query);

		} catch (SQLException e) {
			System.err.println(e);
		}
		
		return rs;
	}

	void executeQuery(String Query, String Val1, String Val2) throws SQLException
	{
		try {
			conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
			PreparedStatement preparedStatement = conn.prepareStatement(Query);
                        preparedStatement.setString(1, Val1);
                        preparedStatement.setString(2, Val2);
                        preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e);
		}
		
	}
        
        void executeQuery(String Query, String val) {
            try {
                conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
                PreparedStatement ps = conn.prepareStatement(Query);
                ps.setString(1, val);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	
	void closeConnection() throws SQLException {
		if(conn!=null)
			conn.close();
		if(stmt!=null)
			stmt.close();
		if(rs!=null)
			rs.close();
	}
}