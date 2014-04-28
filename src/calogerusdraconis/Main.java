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

package CalogerusDraconis;
import java.io.File;

import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.DA1CAA8E-DC4F-B1A6-2BEB-CD5E1F104533]
// </editor-fold> 
public class Main {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.63CA2664-F119-3E4F-70B9-EBE581D09D8B]
    // </editor-fold> 
    public Dragon draco;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0BE79718-C1E2-6BA1-97AA-29B6F470E4CF]
    // </editor-fold> 
    public Main () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C285A074-E684-E331-E7AB-CD728879D8B5]
    // </editor-fold> 
    public static void main (String[] args) {
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse (new File("book.xml"));
            // normalize text representation
            doc.getDocumentElement ().normalize ();
            System.out.println ("Root element of the doc is " + 
                 doc.getDocumentElement().getNodeName());

            NodeList listOfPersons = doc.getElementsByTagName("person");
            int totalPersons = listOfPersons.getLength();
            System.out.println("Total no of people : " + totalPersons);

            for(int s=0; s<listOfPersons.getLength() ; s++){
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
        }catch (Exception err) {
            System.out.println("ASDF");
        }
        
        /* urutan: name, health, maxHealth, stamina, maxStamina, thirst, bladder, hunger, level, experience, password, money, happiness */
        UserDragon d = new UserDragon("willy",0,100,0,100,0,0,0,1,0,"asdf",0,0);
        System.out.println("halo");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
           System.out.println("ASFDASDFASDF"); 
        }
        System.exit(0);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.300DE1C1-8FFF-9876-186B-6A300231FB80]
    // </editor-fold> 
    public void newGame () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A635F2FE-A9F8-36AD-47CE-2F0270215A08]
    // </editor-fold> 
    public void loadGame () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.80151BEA-D69C-3C3E-5363-37DFEC7601CC]
    // </editor-fold> 
    public Dragon getDraco () {
        return draco;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1EFC7D1A-E329-168A-3331-F1511B338D84]
    // </editor-fold> 
    public void setDraco (Dragon val) {
        this.draco = val;
    }
}

