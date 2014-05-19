package RSSep;
/**

 * @author Capokantil
 *
 */

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

public class RSSFeedParser {
	
	/*
	 * Attributes of RSSParser in constant string 
	 */
  static final String TITLE = "title";
  static final String DESCRIPTION = "description";
  static final String CHANNEL = "channel";
  static final String LANGUAGE = "language";
  static final String COPYRIGHT = "copyright";
  static final String LINK = "link";
  static final String AUTHOR = "author";
  static final String ITEM = "item";
  static final String PUB_DATE = "pubDate";
  static final String GUID = "guid";
  
  static URL curUrl;

  final List<URL> url = new ArrayList<URL>();

  /**
   * Constructor with param
   * @param feedUrl
   */
  public RSSFeedParser(List<String> feedUrl) {
    try {
      
      for(String s : feedUrl){
    	  this.url.add(new URL(s));}
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Function to read feed from any URL in URL list and return the feed
   * @return feed
   */
  public Feed readFeed() {
    Feed feed = null;
    try {
      boolean isFeedHeader = true;
      // Header is empty
      String description = "";
      String title = "";
      String link = "";
      String language = "";
      String copyright = "";
      String author = "";
      String pubdate = "";
      String guid = "";

      // Create new XMLInputFactory
      XMLInputFactory inputFactory = XMLInputFactory.newInstance();
      
      for(URL s : url){
    	  
	      // Setup eventReader
          curUrl = s;
	      InputStream in = read();
	      XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
	      
      	  // read the XML
	      while (eventReader.hasNext()) {
	        XMLEvent event = eventReader.nextEvent();
	        if (event.isStartElement()) {
	          String localPart = event.asStartElement().getName()
	              .getLocalPart();
	          switch (localPart) {
	          case ITEM:
	            if (isFeedHeader) {
	              isFeedHeader = false;
	              feed = new Feed(title, link, description, language,
	                  copyright, pubdate);
	            }
	            event = eventReader.nextEvent();
	            break;
	          case TITLE:
	            title = getCharacterData(event, eventReader);
	            break;
	          case DESCRIPTION:
	            description = getCharacterData(event, eventReader);
	            break;
	          case LINK:
	            link = getCharacterData(event, eventReader);
	            break;
	          case GUID:
	            guid = getCharacterData(event, eventReader);
	            break;
	          case LANGUAGE:
	            language = getCharacterData(event, eventReader);
	            break;
	          case AUTHOR:
	            author = getCharacterData(event, eventReader);
	            break;
	          case PUB_DATE:
	            pubdate = getCharacterData(event, eventReader);
	            break;
	          case COPYRIGHT:
	            copyright = getCharacterData(event, eventReader);
	            break;
	          }
	        } else if (event.isEndElement()) {
	          if (event.asEndElement().getName().getLocalPart() == (ITEM)) {
	            FeedMessage message = new FeedMessage();
	            message.setDescription(description);
	            message.setLink(link);
	            message.setTitle(title);
	            feed.getMessages().add(message);
	            event = eventReader.nextEvent();
	            continue;
	          }
	        }
	      }
      }
      
      
    } catch (XMLStreamException e) {
      throw new RuntimeException(e);
    }
    
    return feed;
  }

  /**
   * Function to fetch string from XML
   * @param event
   * @param eventReader
   * @return result
   * @throws XMLStreamException
   */
  private String getCharacterData(XMLEvent event, XMLEventReader eventReader)
      throws XMLStreamException {
    String result = "";
    event = eventReader.nextEvent();
    if (event instanceof Characters) {
      result = event.asCharacters().getData();
    }
    return result;
  }

  /**
   * Function to read URL
   * @return curUrl.openstream()
   */
  private InputStream read() {
    try {
      return curUrl.openStream();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
} 