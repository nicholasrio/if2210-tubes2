package org;
import java.sql.SQLException;

public class Main{
	public static MainFrame frame = new MainFrame("Login");

	public static void main(String[] args) throws SQLException {
		
		// Main Frame
		frame.setVisible(true);
		frame.setLocation(850, 50);
		frame.setSize(300, 200);
		
		//UserUI ui = new UserUI();
		//ui.setVisible(true);
		//ui.setSize(500,500);
		

	}
}
