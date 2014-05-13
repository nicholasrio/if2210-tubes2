package org;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginController {
	
	public boolean Validate(String Username, String Password) throws SQLException {
		DBConnection conn = new DBConnection();
		ResultSet rs = conn.executeQuery("SELECT * FROM user");
		while(rs.next())
		{
			if(Username.matches(rs.getString("username")) && Password.matches(rs.getString("password")))
			{
				conn.closeConnection();
				return true;
			}
		}
		
		// Jika user tidak ditemukan
		conn.closeConnection();
		return false;
	}
}
