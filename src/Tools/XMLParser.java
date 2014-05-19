/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tools;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import main.PilihanCaleg;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLParser {
    public static void saveToXML(String Dapil) throws ParserConfigurationException, SQLException, TransformerConfigurationException, IOException, TransformerException
    {
        /* load database */
        List<PilihanCaleg> daftarPilihan = new ArrayList<>();
        Connection koneksi = KoneksiDatabase.getKoneksi();
        Statement statement = koneksi.createStatement();
        String command = "Select distinct PilihanCaleg.NIKPemilih, PilihanCaleg.NIKCaleg, PilihanCaleg.Lingkup"
                + "from PilihanCaleg, Caleg "
                + "where PilihanCaleg.NIKCaleg = Caleg.NIKCaleg and Caleg.NoDapil = " + Dapil;
        
        ResultSet result = statement.executeQuery(command);
        while (result.next())
        {
            daftarPilihan.add(new PilihanCaleg(result.getString("NIKPemilih"), result.getString("NIKCaleg"),
            result.getString("Lingkup")));
        }
        result.close();
        statement.close();
        
        /* Save list to xml */
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("Hasil Pemilihan Caleg");
        doc.appendChild(rootElement);
        
        /* Set daerah pemilihan */
        Element dapil = doc.createElement("Dapil");
        dapil.setAttribute("No", Dapil);
        
        for(PilihanCaleg pilihan : daftarPilihan)
        {
            Element Pemilih = doc.createElement("NIKPemilih");
            Pemilih.appendChild(doc.createTextNode(pilihan.getNIKPemilih()));
            dapil.appendChild(Pemilih);
            
            Element Caleg = doc.createElement("NIKCaleg");
            Caleg.appendChild(doc.createTextNode(pilihan.getNIKCaleg()));
            dapil.appendChild(Caleg);
            
            Element Lingkup = doc.createElement("Lingkup");
            Caleg.appendChild(doc.createTextNode(pilihan.getLingkup()));
            dapil.appendChild(Lingkup);
        }
        
        TransformerFactory tranFactory = TransformerFactory.newInstance();
        Transformer aTransformer = tranFactory.newTransformer();
        
        aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
        aTransformer.setOutputProperty(
                "{http://xml.apache.org/xslt}indent-amount", "4");
        aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
        
        DOMSource source = new DOMSource(doc);
        FileWriter FW = new FileWriter("PilihanCaleg.xml");
        StreamResult resultStream = new StreamResult(FW);
        aTransformer.transform(source, resultStream);
        
    }
}
