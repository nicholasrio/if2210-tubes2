package org;
import java.sql.SQLException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main{
	public static MainFrame frame = new MainFrame("Login");

	public static void main(String[] args) throws SQLException {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Main Frame
		frame.setVisible(true);
		frame.setLocation(850, 50);
		frame.setSize(300, 200);
		
		//UserUI ui = new UserUI();
		//ui.setVisible(true);
		//ui.setSize(500,500);
		

	}
}
