package org;
import java.sql.SQLException;

public class Main{

	public static void main(String[] args) throws SQLException {
		
		// Main Frame
		MainFrame frame = new MainFrame("Login");
		frame.setVisible(true);
		frame.setLocation(850, 50);
		frame.setSize(300, 200);
		
	}
}
