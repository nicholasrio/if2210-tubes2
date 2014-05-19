package org;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginController {
	public static User currUser = new User();
	
	public boolean Validate(String Username, String Password) throws SQLException {
		DBConnection conn = new DBConnection();
		ResultSet rs = conn.executeQuery("SELECT * FROM user");
		while(rs.next())
		{
			if(Username.matches(rs.getString("username")) && Password.matches(rs.getString("password")))
			{
				currUser.name(rs.getString("realname"));
				currUser.password(Password);
				currUser.id(Username);
				Main.frame.dispose();
				conn.closeConnection();
				return true;
			}
		}
		
		// Jika user tidak ditemukan
		conn.closeConnection();
		return false;
	}
}
