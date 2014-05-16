import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PlantFactory {

	// Container to save all kind of plants
	private static ArrayList<Plant> plantPrototype = null;

	// Path to data file
	private static final String DATA_PATH = "data/plants.xml";

	// Load Plant data from XML
	public static void loadData() {
		plantPrototype = new ArrayList<Plant>();
		try {
			// Load xml file
			File xmlFile = new File(DATA_PATH);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			// optional, but recommended
			// read this -
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			// Iterate through all plants, add them one by one
			NodeList plants = doc.getElementsByTagName("plant");
			for (int i = 0; i < plants.getLength(); i++) {
				Node node = plants.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) node;

					// Get attributes of current Plant
					String name = e.getAttribute("name");
					double maxWaterLevel = Double.parseDouble(e
							.getAttribute("maxWaterLevel"));
					double maxFertilizerLevel = Double.parseDouble(e
							.getAttribute("maxFertilizerLevel"));

					// Create new Plants
					Plant plant = new Plant(name, maxWaterLevel,
							maxFertilizerLevel);
					plantPrototype.add(plant);

					System.out.println("Plant name = " + name
							+ ", maxWaterLevel = " + maxWaterLevel
							+ ", maxFertilizerLevel = " + maxFertilizerLevel);

					// Get stages of current Plant
					NodeList stages = e.getElementsByTagName("stage");
					for (int j = 0; j < stages.getLength(); j++) {
						Element stage = (Element) stages.item(j);

						// Get attributes of current Stage
						String stageName = stage.getAttribute("name");
						double lifeTime = Double.parseDouble(stage
								.getAttribute("lifeTime"));
						double waterDropLevel = Double.parseDouble(stage
								.getAttribute("waterDropLevel"));
						double fertilizerDropLevel = Double.parseDouble(stage
								.getAttribute("fertilizerDropLevel"));
						String imageSource = stage.getAttribute("img");

						System.out.println("\tStage " + stageName + ", img = "
								+ imageSource);
						plant.addStage(stageName, lifeTime, waterDropLevel,
								fertilizerDropLevel, imageSource);
					}

					// TODO handle fruit
				}
			}
		} catch (Exception e) {
			// TODO handle exception
		}
	}

	public static Plant getInstance(String name) {
		for (Plant p : plantPrototype) {
			if (p.getName().equalsIgnoreCase(name)) {
				return p.clone();
			}
		}
		return null;
	}
}
