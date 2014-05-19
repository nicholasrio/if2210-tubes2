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
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author Dariel Valdano, Cilvia
 */
public class XmlController {
	/**
	 * Constructor XmlController
	 */
	private XmlController() {
		
	}
	
	/**
	 * Mengembalikan Consumable yang sesuai berdasarkan input nama
	 * @param name nama Consumable yang dicari
	 * @return Consumable yang dicari
	 */
	public static Consumable produceConsumable(String name) {
		Store s = Store.getInstance();
		ArrayList<Consumable> ac = s.getFdInventory();
		for (Consumable c : ac){
			if (c.getName().equals(name)) {
				return c;
			}
		}
		return null;
	}
	
	/**
	 * Load Dragon from XML
	 */
	public static UserDragon LoadDragon(String name, String password) throws Exception {
		UserDragon retval = null;
		try {
			// Load XML and get root Node
			SAXBuilder builder = new SAXBuilder();
			File xmlFile = new File("calogerusSave.xml");
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();

			//get list of root/save nodes
			List saves = rootNode.getChildren("save");

			//iterate each root/save inside XML
			for (Object aSave : saves) {
				Element save = (Element) aSave;

				//get root/save/userDragon
				Element userDragon = (Element) save.getChildren("userDragon").get(0);

				//check if name is equal
				if (userDragon.getChildText("name").equals(name) && userDragon.getChildText("password").equals(password)) {
					// Make Dragon
					retval = new UserDragon(
							userDragon.getChildText("name"),
							Float.parseFloat(userDragon.getChildText("health")),
							Float.parseFloat(userDragon.getChildText("maxHealth")),
							Float.parseFloat(userDragon.getChildText("stamina")),
							Float.parseFloat(userDragon.getChildText("maxStamina")),
							Float.parseFloat(userDragon.getChildText("thirst")),
							Float.parseFloat(userDragon.getChildText("bladder")),
							Float.parseFloat(userDragon.getChildText("hunger")),
							Integer.parseInt(userDragon.getChildText("level")),
							Integer.parseInt(userDragon.getChildText("experience")),
							userDragon.getChildText("password"),
							Float.parseFloat(userDragon.getChildText("money")),
							Float.parseFloat(userDragon.getChildText("happiness"))
					);

					// Make Inventory
					List invList = userDragon.getChildren("inventory").get(0).getChildren("item");
					
					ArrayList<Consumable> arr = new ArrayList<>();
					for (Object anObj : invList) {
						
						Element node = (Element) anObj;
						String s  = node.getText();

						Consumable ctemp = produceConsumable(s);
						if (ctemp != null)
							arr.add(ctemp);
					}
					retval.setFdInventory(arr);
				}
			}
		} catch (IOException | JDOMException io) {
			System.out.println(io.getMessage());
		}
		
		if (retval == null) {
			throw new Exception("Cannot Find UserDragon");
		} else {
			return retval;
		}
	}

	/**
	 * Save Dragon to XML
	 */
	public static void SaveDragon(UserDragon dragon) {
		try {

			//Initial setup
			SAXBuilder builder = new SAXBuilder();
			File xmlFile = new File("calogerusSave.xml");
			Document saveXML = (Document) builder.build(xmlFile);
			Element rootNode = saveXML.getRootElement();

			//get list of root/save nodes
			List saves = rootNode.getChildren("save");

			//iterate each root/save inside XML to find if dragon already exist
			boolean found = false;
			for (Object aSave : saves) {
				Element save = (Element) aSave;

				//get root/save/userDragon
				Element userDragon = (Element) save.getChildren("userDragon").get(0);

				//check if name is equal
				if (userDragon.getChildText("name").equals(dragon.getName())) {
					found = true;
					System.out.println("Dragon Name : " + userDragon.getChildText("name"));
					
					userDragon.getChild("password").setText(dragon.getPassword());
					userDragon.getChild("money").setText(Float.toString(dragon.getMoney()));
					userDragon.getChild("happiness").setText(Float.toString(dragon.getHappiness()));
					userDragon.getChild("health").setText(Float.toString(dragon.getHealth()));
					userDragon.getChild("maxHealth").setText(Float.toString(dragon.getMaxHealth()));
					userDragon.getChild("stamina").setText(Float.toString(dragon.getStamina()));
					userDragon.getChild("maxStamina").setText(Float.toString(dragon.getMaxStamina()));
					userDragon.getChild("thirst").setText(Float.toString(dragon.getThirst()));
					userDragon.getChild("bladder").setText(Float.toString(dragon.getBladder()));
					userDragon.getChild("hunger").setText(Float.toString(dragon.getHunger()));
					userDragon.getChild("level").setText((int)dragon.getLevel()+"");
					userDragon.getChild("experience").setText((int)dragon.getExperience()+"");
					
					ArrayList<Element> invList = new ArrayList<>(); 
					for(Consumable c : dragon.getFdInventory()){
						Element item = new Element("item").setText(c.getName());
						invList.add(item);
					}
					userDragon.getChildren("inventory").get(0).setContent(invList);
				}
			}
			
			//make new entry if dragon not found
			if (!found){
				Element save = new Element("save");
				
				Element userDragon = new Element("userDragon");
				
				userDragon.addContent(new Element("name").setText(dragon.getName()));
				userDragon.addContent(new Element("password").setText(dragon.getPassword()));
				userDragon.addContent(new Element("money").setText(Float.toString(dragon.getMoney())));
				userDragon.addContent(new Element("happiness").setText(Float.toString(dragon.getHappiness())));
				userDragon.addContent(new Element("health").setText(Float.toString(dragon.getHealth())));
				userDragon.addContent(new Element("maxHealth").setText(Float.toString(dragon.getMaxHealth())));
				userDragon.addContent(new Element("stamina").setText(Float.toString(dragon.getStamina())));
				userDragon.addContent(new Element("maxStamina").setText(Float.toString(dragon.getMaxStamina())));
				userDragon.addContent(new Element("thirst").setText(Float.toString(dragon.getThirst())));
				userDragon.addContent(new Element("bladder").setText(Float.toString(dragon.getBladder())));
				userDragon.addContent(new Element("hunger").setText(Float.toString(dragon.getHunger())));
				int x = (int) dragon.getLevel();
				System.out.println("level " + x);
				userDragon.addContent(new Element("level").setText(x+""));
				System.out.println("exp " + x);
				x = (int) dragon.getExperience();
				userDragon.addContent(new Element("experience").setText(x+""));
				
				ArrayList<Element> invList = new ArrayList<>(); 
				for(Consumable c : dragon.getFdInventory()){
					System.out.println(c.getName());
					Element item = new Element("item").setText(c.getName());
					invList.add(item);
				}
				userDragon.addContent(new Element("inventory").addContent(invList));
				
				save.addContent(userDragon);
				rootNode.addContent(save);
			}

			// Formatting and Outputting
			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(saveXML, new FileWriter("calogerusSave.xml"));
		} catch (IOException | JDOMException io) {
			io.printStackTrace();
		}
	}
}
