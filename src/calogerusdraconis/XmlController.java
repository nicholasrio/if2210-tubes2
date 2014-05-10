/*
 * Copyright (C) 2014 Calogerus Draconis Team
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package calogerusdraconis;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author Dariel Valdano
 */
public class XmlController {

	public void XMLtest() {
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File("calogerusSave.xml"));
			// normalize text representation
			doc.getDocumentElement().normalize();
			System.out.println("Root element of the doc is "
					+ doc.getDocumentElement().getNodeName());

			NodeList listOfPersons = doc.getElementsByTagName("item");
			
			int totalPersons = listOfPersons.getLength();
			System.out.println("Total no of items : " + totalPersons);
			
			//bla

			/*for(int s=0; s<listOfPersons.getLength() ; s++){
			 Node firstPersonNode = listOfPersons.item(s);
			 if(firstPersonNode.getNodeType() == Node.ELEMENT_NODE){
			 Element firstPersonElement = (Element)firstPersonNode;
			 //-------
			 NodeList firstNameList = firstPersonElement.getElementsByTagName("first");
			 Element firstNameElement = (Element)firstNameList.item(0);
			 NodeList textFNList = firstNameElement.getChildNodes();
			 System.out.println("First Name : "  + 
			 ((Node)textFNList.item(0)).getNodeValue().trim());

			 //-------
			 NodeList lastNameList = firstPersonElement.getElementsByTagName("last");
			 Element lastNameElement = (Element)lastNameList.item(0);

			 NodeList textLNList = lastNameElement.getChildNodes();
			 System.out.println("Last Name : " + 
			 ((Node)textLNList.item(0)).getNodeValue().trim());

			 //----
			 NodeList ageList = firstPersonElement.getElementsByTagName("age");
			 Element ageElement = (Element)ageList.item(0);

			 NodeList textAgeList = ageElement.getChildNodes();
			 System.out.println("Age : " + 
			 ((Node)textAgeList.item(0)).getNodeValue().trim());
			 //------
			 }//end of if clause
			 }//end of for loop with s var
			 */
		} catch (Exception err) {
			System.out.println("ASDF");
		}

		/* urutan: name, health, maxHealth, stamina, maxStamina, thirst, bladder, hunger, level, experience, password, money, happiness */
		UserDragon d = new UserDragon("willy", 0, 100, 0, 100, 0, 0, 0, 1, 0, "asdf", 0, 0);
		System.out.println("halo");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("ASFDASDFASDF");
		}
	}
}
