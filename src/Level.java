import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Level {
	/** Path to data file */
	private static final String DATA_PATH = "data/level.xml";
	
	// 1 untuk apel , 2 untuk apel-strawberry, 3 untuk apel-jeruk , 4 untuk apel-durian
	private int unlockedFruit; 
	
	private int id;
	
	private int startMoney;
	private int goalMoney;
	private double limitTime;
	
	public int getUnlockedFruit(){
		return unlockedFruit;
	}
	
	public int getStartMoney(){
		return startMoney;
	}
	
	public int getGoalMoney(){
		return goalMoney;
	}
	
	public double getLimitTime(){
		return limitTime;
	}
	
	Level(int id){
		this.id = id;
		try{
			File xmlFile = new File(DATA_PATH);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			doc.getDocumentElement().normalize();
			
			NodeList levels = doc.getElementsByTagName("level");
			
			boolean found = false;
			
			for(int i=0;i<levels.getLength()&&!found;i++){
				Node node = levels.item(i);
				
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) node;
					
					if(Integer.parseInt(e.getAttribute("id"))==id){
						unlockedFruit = Integer.parseInt(e.getAttribute("unlockedFruit"));
						startMoney = Integer.parseInt(e.getAttribute("startMoney"));
						goalMoney = Integer.parseInt(e.getAttribute("goalMoney"));
						limitTime = Double.parseDouble(e.getAttribute("limitTime"));
						found=true;
					}
					
				}
				
			}
		}
		catch(Exception e){
			System.out.println("level.xml failed to load");
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
