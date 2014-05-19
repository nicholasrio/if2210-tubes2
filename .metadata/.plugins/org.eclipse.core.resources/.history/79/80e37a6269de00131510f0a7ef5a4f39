package org;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4932513626147661013L;

	public LoginPanel(){
		Dimension d = getPreferredSize();
		d.width = 200;
		setPreferredSize(d);
		
		//setBorder(BorderFactory.createTitledBorder("Login"));
		
		// Inisialisasi swing component
		JLabel usernameLabel = new JLabel("Username: ");
		JLabel passwordLabel = new JLabel("Password: ");
		final JLabel statusLabel = new JLabel("");
		
		final JTextField usernameField = new JTextField(10);
		final JTextField passwordField = new JTextField(10);
		JButton loginBtn = new JButton("Login");
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = GridBagConstraints.REMAINDER;
		add(statusLabel, c);

		GridBagConstraints gc = new GridBagConstraints();

		// First column		
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 0;
		gc.gridy = 1;
		add(usernameLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		add(passwordLabel, gc);
		
		// Second column
		gc.anchor = GridBagConstraints.LINE_START;
		
		gc.gridx = 2;
		gc.gridy = 1;
		add(usernameField, gc);
		
		gc.gridx = 2;
		gc.gridy = 2;
		add(passwordField, gc);
		
		// Final row
		gc.anchor = GridBagConstraints.LINE_END;
		
		gc.gridx = 2;
		gc.gridy = 3;
		add(loginBtn, gc);
		
		// Login button listener
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String Username = usernameField.getText();
				String Password = passwordField.getText();
				
				LoginController lc = new LoginController();
				try {
					// Jika login berhasil
					if(lc.Validate(Username, Password))
					{
						statusLabel.setText("You're now logged in!");
						statusLabel.setForeground(Color.BLUE);
					}
					else
					{
						statusLabel.setText("Username or password incorrect!");
						statusLabel.setForeground(Color.RED);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
