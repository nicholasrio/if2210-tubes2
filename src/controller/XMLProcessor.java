/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.Point;
import model.menu.*;
import model.node.*;
import model.room.*;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import model.*;

/**
 *
 * @author Fahziar Riesad Wutono
 */
public class XMLProcessor {
    
    /**
     * Create a w3c DOM Element. The element will contain ID, xPosition and uPosition. These information come frome model.Node
     * @param elementTag The tag for element that will be created
     * @param n Node that contain information for created element.
     * @param doc W3C Document. Must be created first.
     * @return New element that created.
     */
    private static Element createNode(String elementTag, Node n, Document doc)
    {
        Element e = doc.createElement(elementTag);
        e.setAttribute("id", Integer.toString(n.getID()));
        
            
        Element pointX = doc.createElement("xPosition");
        pointX.appendChild(doc.createTextNode(Double.toString(n.getLocation().getX())));
        e.appendChild(pointX);
            
        Element pointY = doc.createElement("yPosition");
        pointY.appendChild(doc.createTextNode(Double.toString(n.getLocation().getY())));
        e.appendChild(pointY);
        
        return e;
    }
    
    /**
     * Create W3C element that contain Neighbours of n
     * @param n Node that will be processed
     * @param doc W3C document. Doc must be initialized first
     * @return The created element
     */
    private static Element createNeighbours(Node n, Document doc)
    {
        Element neighbours = doc.createElement("Neighbours");
        for(int neighbourID : n.getListOfNeighbours())
        {
            Element neighbour = doc.createElement("Neighbour");
            neighbour.setAttribute("id", Integer.toString(neighbourID));
            neighbours.appendChild(neighbour);
        }
        return neighbours;
    }
    
    /**
     * Create W3C DOM Element that contain name tag
     * @param name The name that will inserted in tag
     * @param doc W3C document. Doc must be initialized first
     * @return The created element
     */
    private static Element createName(String name, Document doc)
    {
        Element nameElement = doc.createElement("Name");
        nameElement.appendChild(doc.createTextNode(name));
        return nameElement;
    }
    
    /**
     * Create W3C DOM Element that contain all room in input.
     * @param input Building that will be processed.
     * @param doc W3C document. Doc must be initialized first
     * @return Element that will be created.
     */
    private static Element createRooms(Building input, Document doc)
    {
        Element roomsElement = doc.createElement("Rooms");
        
        for (Room room: input.getListOfRooms())
        {
            Element roomElement = doc.createElement("Room");
            roomElement.setAttribute("name", room.getName());
            roomElement.setAttribute("location", Integer.toString(room.getLocation()));
            
            roomsElement.appendChild(roomElement);
        }
        
        return roomsElement;
    }
    
    /**
     * Create menu element from  canteen
     * @param canteen Source for menu element
     * @param doc W3C document. Doc must be initialized first
     * @return Element that created.
     */
    private static Element createMenu(Canteen canteen, Document doc)
    {
        Element menuElements = doc.createElement("Menus");
        
        for(Menu m : canteen.getListOfMenus())
        {
            Element menuElement;
            
            if (m instanceof Beverage)
            {
                menuElement = doc.createElement("Beverage");
            } else {
                menuElement = doc.createElement("Food");
            }
            
            menuElement.setAttribute("name", m.getName());
            menuElement.setAttribute("price", Integer.toString(m.getPrice()));
            menuElements.appendChild(menuElement);
        }
        
        
        return menuElements;
    }
    /**
     * Get node information (id, xPosition, yPosition) from element.
     * @param element Element that will be processed. Element must contain attribute "id", has 2 child with tag "xPosition" and "yPosition"
     * @param out Out will contain information from element.
     * @throws Exception Will throw exception if element doesn't contain the tag and elements needed.
     */
    private static void getNodeInformation(Element element, Node out) throws Exception
    {
        //Process id
        if (element.getAttribute("id").isEmpty())
        {
            throw (new Exception("Invalid ID"));
        }
                
        out.setID(Integer.parseInt(element.getAttribute("id")));
                
        //Process node location
        double x, y;
        x = Double.parseDouble(element.getElementsByTagName("xPosition").item(0).getTextContent());
        y = Double.parseDouble(element.getElementsByTagName("yPosition").item(0).getTextContent());
                
        out.setLocation(x, y);
    }
    
    /**
     * Get all neighbour from element.
     * @param element Element that will be processed. Element must have child with tag "Neighbour"
     * @param node  Node will contain neighbour from element
     */
    private static void getNeighbour(Element element, Node node)
    {
        NodeList neighbours = element.getElementsByTagName("Neighbour");
        int j;
        for(j = 0; j < neighbours.getLength(); j++)
        {
            Element e = (Element) neighbours.item(j);
            node.addNeighbor(Integer.parseInt(e.getAttribute("id")));
        }
    }
    
    /**
     * Get all room from element
     * @param element W3C DOM element that contain node with "Room" tag
     * @param output Rooms in output will contain room in element
     */
    private static void getRooms(Element element, Building output)
    {
        NodeList rooms = element.getElementsByTagName("Room");
        
        int i;
        for(i=0; i<rooms.getLength(); i++)
        {
            Element roomElement = (Element) rooms.item(i);
            
            Room room = new Room(roomElement.getAttribute("name"), Integer.parseInt(roomElement.getAttribute("location")));
            output.addRoom(room);
        }
    }
    
    /**
     * Get all menus from element
     * @param element W3C DOM element that contain node with "Food" and "Beverage" tag
     * @param canteen (Output) will contain food inside element.
     */
    private static void getMenu(Element element, Canteen canteen)
    {
        NodeList foods = element.getElementsByTagName("Food");
        NodeList beverages = element.getElementsByTagName("Beverage");
        
        //Process all foods
        int i;
        for(i=0; i<foods.getLength(); i++)
        {
            Element e = (Element) foods.item(i);
            String name = e.getAttribute("name");
            int price = Integer.parseInt(e.getAttribute("price"));
            
            canteen.addMenu(MenuFactory.createMenu(MenuType.FOOD, name, price));
        }
        
        //Process all beverages
        for(i=0; i<beverages.getLength(); i++)
        {
            Element e = (Element) beverages.item(i);
            String name = e.getAttribute("name");
            int price = Integer.parseInt(e.getAttribute("price"));
            
            canteen.addMenu(MenuFactory.createMenu(MenuType.BEVERAGE, name, price));
        }
    }
    
    /**
     * Save all nodes in list into XML file
     * @param nodes List containing nodes
     * @param filename Filename of XML
     * @throws Exception 
     */
    public static void saveToXML(List<Node> nodes, String filename) throws Exception
    {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        
        //Root Elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("PetaITB");
        doc.appendChild(rootElement);
        
        //Root untuk nodes
        Element nodeElements = doc.createElement("Nodes");
        rootElement.appendChild(nodeElements);
        
        //Root untuk building
        Element buildingElements = doc.createElement("Buildings");
        rootElement.appendChild(buildingElements);
        
        //Root untuk canteen
        Element canteenElements = doc.createElement("Canteens");
        rootElement.appendChild(canteenElements);
                
        //Proses tiap-tiap node
        for(Node n : nodes)
        {
            //Kalau tipe dari n itu building
            if (n instanceof Building)
            {
                //Buat nodenya
                Element buildingElement = createNode("Building",n,doc);
                buildingElements.appendChild(buildingElement);
                
                //Buat bagian nama building
                Building temp = (Building) n;
                buildingElement.appendChild(createName(temp.getName(), doc));
                
                //Proses neighbournya
                buildingElement.appendChild(createNeighbours(temp, doc));
                
                //Proses ruangannya
                buildingElement.appendChild(createRooms(temp, doc));
                
            } else if (n instanceof Canteen) {
                //Buat nodenya
                Element canteenElement = createNode("Canteen", n, doc);
                canteenElements.appendChild(canteenElement);
                
                //Kasih nama
                Canteen temp = (Canteen) n;
                canteenElement.appendChild(createName(temp.getName(), doc));
                
                //Kasih tetangganya
                canteenElement.appendChild(createNeighbours(temp, doc));
                
                //Proses menunya
                canteenElement.appendChild(createMenu(temp, doc));
            } else if (n instanceof Node)
            {
                //Buat nodenya
                Element nodeElement = createNode("Node",n,doc);
                nodeElements.appendChild(nodeElement);
                nodeElement.appendChild(createNeighbours(n, doc));
            }
        }
        
        //Persiapkan file output
        StreamResult result = new StreamResult(new File(filename));
        
        //Trasnform ke xml
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	Transformer transformer = transformerFactory.newTransformer();
	DOMSource source = new DOMSource(doc);
        transformer.transform(source, result);
    }
    
    /**
     * Load nodes from XML file
     * @param filename Filename of XML file
     * @return List of node from loaded XML
     * @throws Exception 
     */
    public static List<Node> loadFromXml(String filename) throws Exception
    {
        List<Node> out = new LinkedList<>();
        File file = new File(filename);
        
        //Prepare document and load xml file
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(file);
        doc.getDocumentElement().normalize();
        
        //Check if XML is for PetaITB
        if (doc.getElementsByTagName("PetaITB").getLength() == 0)
        {
            throw (new PrimaryXMLTagNotFound(PrimaryXMLTagNotFound.bahasa.indonesia));
        }
        //Get all node and process them
        Element nodesElement = (Element) doc.getElementsByTagName("Nodes").item(0);
        NodeList nList = nodesElement.getElementsByTagName("Node");
        
        int i;
        for(i=0; i < nList.getLength(); i++)
        {
            org.w3c.dom.Node node = nList.item(i);
            if (node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                
                Node newNode = NodeFactory.createNode(NodeType.NODE, null, 0);
                getNodeInformation(element, newNode);
                
                getNeighbour(element, newNode);
                out.add(newNode);
            }
        }
        
        //Get all buildings and process them
        Element buildingsElement = (Element) doc.getElementsByTagName("Buildings").item(0);
        nList = buildingsElement.getElementsByTagName("Building");
        
        for(i=0; i < nList.getLength(); i++)
        {
            org.w3c.dom.Node node = nList.item(i);
            if (node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                
                Building newNode = (Building) NodeFactory.createNode(NodeType.BUILDING, null, 0);
                
                getNodeInformation(element, newNode);
                newNode.setName(element.getElementsByTagName("Name").item(0).getTextContent());
                getNeighbour(element, newNode);
                getRooms((Element) element.getElementsByTagName("Rooms").item(0), newNode);
                
                out.add(newNode);
            }
        }
        
        //Get all canteens and process them
        Element canteenElements = (Element) doc.getElementsByTagName("Canteens").item(0);
        nList = canteenElements.getElementsByTagName("Canteen");
        for(i=0; i<nList.getLength(); i++)
        {
            org.w3c.dom.Node node = nList.item(i);
            if (node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                
                Canteen newNode = (Canteen) NodeFactory.createNode(NodeType.CANTEEN, null, 0);
                
                getNodeInformation(element, newNode);
                newNode.setName(element.getElementsByTagName("Name").item(0).getTextContent());
                getNeighbour(element, newNode);
                getMenu(element, newNode);
                
                out.add(newNode);
            }
        }
        
        return out;
    }
}