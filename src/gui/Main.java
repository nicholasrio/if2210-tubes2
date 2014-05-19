/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Client.Client;
import gui.Login;

/**
 *
 * @author Rosi
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static Client client;

	public static void main(String[] args) {
		// TODO code application logic here
		client = new Client("localhost", 5432);
		Login login = new Login();
		login.show();
	}

}
