package gigamen;

import java.util.*;
import java.io.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

@XmlRootElement

public class PlaylistManager {

    private ArrayList<Playlist> collection;

    public PlaylistManager() {
        collection = new ArrayList<>();
    }

    public void AddPlaylist() {
        Playlist p = new Playlist();
        collection.add(p);
    }

    public void DelPlayList(Playlist playlist) {

        collection.remove(playlist);
    }

    public ArrayList<Playlist> getCollection() {
        return collection;
    }
    @XmlElement(name="playlist")
    public void setCollection(ArrayList<Playlist> collection) {
        this.collection = collection;
    }

    public static void Export(PlaylistManager list) {
        try {
            // create JAXB context and initializing Marshaller  
            JAXBContext jaxbContext = JAXBContext.newInstance(PlaylistManager.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // for getting nice formatted output  
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //specify the location and name of xml file to be created  
            File XMLfile = new File("all_songs.xml");

            // Writing to XML file  
            jaxbMarshaller.marshal(list, XMLfile);
            // Writing to console  
            jaxbMarshaller.marshal(list, System.out);

        } catch (JAXBException e) {
            // some exception occured  
            e.printStackTrace();
        }
    }

    public static PlaylistManager Import() {

        PlaylistManager pm = new PlaylistManager();
        try {
            // create JAXB context and initializing Marshaller  
            JAXBContext jaxbContext = JAXBContext.newInstance(PlaylistManager.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // specify the location and name of xml file to be read  
            File XMLfile = new File("all_songs.xml");

            // this will create Java object - song from the XML file  
            pm = (PlaylistManager) jaxbUnmarshaller.unmarshal(XMLfile);

        } catch (JAXBException e) {
            // some exception occured  
            e.printStackTrace();
        }
        return pm;
    }

}
