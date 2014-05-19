package org;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

public class Configuration {
	public static final String defaultFileName = "config.xml";
	public static final int defaultHeaderDownloadLimit = 20;
	
	private static int headerDownloadLimit; // limit on downloaded headers
	private static File config;
	
	/**
	 * Memeriksa apakah file konfigurasi sudah di-load
	 * @return true jika iya
	 */
	public static boolean isLoaded() {
		return config != null;
	}
	
	/**
	 * Mendapatkan lokasi absolut dari file konfigurasi sekarang
	 * @return lokasi absolut file konfigurasi yang ter-load
	 */
	public static String getCurrentLocation() {
		assert(isLoaded());
		return config.getAbsolutePath();
	}
	
	/**
	 * Melakukan loading file konfigurasi
	 * @param filename nama file tujuan buat di-load
	 * @throws Exception
	 */
	public static void load(String filename) throws Exception {
		if(filename == null)
			generateNew();
		else
			config = new File(filename);
		
		if(config.isDirectory()) {
			generateNew();
		} else {
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = dBuilder.parse(config);
			doc.getDocumentElement().normalize();
			
			NodeList nodes = doc.getElementsByTagName("config");
			
			Node node = nodes.item(0);
				
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				headerDownloadLimit = Integer.parseInt(getValue("headerDownloadLimit", element));
			}
		}
	}
	
	/**
	 * Menghasilkan file konfigurasi baru, dengan nilai default
	 * @throws Exception
	 */
	private static void generateNew() throws Exception {
		headerDownloadLimit = defaultHeaderDownloadLimit;
		save(defaultFileName);
	}
	
	/**
	 * Mendapatkan nilai dari tag yang ditunjuk
	 * @param tag tag element yang dituju
	 * @param element objek Element dari XML
	 * @return String isi tag element tersebut
	 */
	private static String getValue(String tag, Element element) {
		NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodes.item(0);
		
		return node.getNodeValue();
	}
	
	/**
	 * Mendapatkan nilai batas download header sekarang
	 * @return headerDownloadLimit
	 */
	public static int getHeaderDownloadLimit() {
		return headerDownloadLimit;
	}
	
	/**
	 * Mengubah nilai batas download header sekarang
	 * @param val nilai batas download header yang baru
	 */
	public static void setHeaderDownloadLimit(int val) {
		headerDownloadLimit = val;
	}
	
	/**
	 * Menyimpan konfigurasi dalam bentuk XML
	 * @param filename nama file tujuan
	 * @throws Exception
	 */
	public static void save(String filename) throws Exception {
		DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = dBuilder.newDocument();
		
		// buat dulu headernya
		Element rootElement = doc.createElement("config");
		doc.appendChild(rootElement);
		
		// tulis semua bagiannya
		// headerDownloadLimit
		Element headerDownLimit = doc.createElement("headerDownloadLimit");
		headerDownLimit.appendChild(doc.createTextNode(Integer.toString(headerDownloadLimit)));
		
		// tulis ke XML
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result;
		if(config == null) {
			config = new File(filename);
		} else if (config.getName() != filename) {
			String location = config.getAbsolutePath() + filename;
			config.renameTo(new File(location));
		}
		
		result = new StreamResult(config);
		tf.transform(source, result);
	}
}
