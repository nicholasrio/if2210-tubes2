/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Client.Client;
import gui.Login;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
            try
            {
                File file = new File("config.xml");
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = builder.parse(file);
                Element Server = (Element) doc.getElementsByTagName("server_addr").item(0);
		client = new Client(Server.getTextContent(), 5432);
		Login login = new Login();
		login.show();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
	}

}
