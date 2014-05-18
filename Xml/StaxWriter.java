/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Xml;

import Video.Video;
import java.io.FileOutputStream;
import java.util.List;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;

/**
 *
 * @author KURING
 */
public class StaxWriter {
    private String configFile;
    private List<String[]> vid;
    private List<String> rating;
    
    public String getConfigFile() {
        return configFile;
    }

    public void setConfigFile(String configFile) {
        this.configFile = configFile;
    }
    
    public List<String> getRating() {
        return rating;
    }

    public void setRating(List<String> rating) {
        this.rating = rating;
    }
    
    public void saveConfig() throws Exception{
        // create an XMLOutputFactory
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        // create XMLEventWriter
        XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream(getConfigFile()));
        // create an EventFactory
        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        XMLEvent end = eventFactory.createDTD("\n");
        // create and write Start Tag
        StartDocument startDocument = eventFactory.createStartDocument();
        eventWriter.add(startDocument);

        // create config open tag
        StartElement configStartElement = eventFactory.createStartElement("", "", "config");
        eventWriter.add(configStartElement);
        eventWriter.add(end);
        // Write the different nodes
        for(int i=0;i<getVid().size();i++){
            createNode(eventWriter, "Nama_Kelompok", getVid().get(i)[1]);
            createNode(eventWriter, "rating", getRating().get(i));
        }

        eventWriter.add(eventFactory.createEndElement("", "", "config"));
        eventWriter.add(end);
        eventWriter.add(eventFactory.createEndDocument());
        eventWriter.close();
    }
    
    private void createNode(XMLEventWriter eventWriter, String name, String value) throws XMLStreamException {

        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        XMLEvent end = eventFactory.createDTD("\n");
        XMLEvent tab = eventFactory.createDTD("\t");
        // create Start node
        StartElement sElement = eventFactory.createStartElement("", "", name);
        eventWriter.add(tab);
        eventWriter.add(sElement);
        // create Content
        Characters characters = eventFactory.createCharacters(value);
        eventWriter.add(characters);
        // create End node
        EndElement eElement = eventFactory.createEndElement("", "", name);
        eventWriter.add(eElement);
        eventWriter.add(end);

    }

    public List<String[]> getVid() {
        return vid;
    }

    public void setVid(List<String[]> vid) {
        this.vid = vid;
    }

}
