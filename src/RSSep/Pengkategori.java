package RSSep;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Capokantil
 *
 */
public class Pengkategori {
	List<FeedMessage> ListAll = new ArrayList<FeedMessage>(); // List of all Feed Message
	List<FeedMessage> ListWorld = new ArrayList<FeedMessage>(); // Feed Message international category list 
    List<FeedMessage> ListTech = new ArrayList<FeedMessage>(); // Feed Message technology category list 
    List<FeedMessage> ListSport = new ArrayList<FeedMessage>(); // Feed Message sport category list 
    List<FeedMessage> ListBusiness = new ArrayList<FeedMessage>(); // Feed Message business category list 
    List<FeedMessage> ListEnt = new ArrayList<FeedMessage>(); // Feed Message entertainment category list 
    List<FeedMessage> ListOther = new ArrayList<FeedMessage>(); // Feed Message other category list besides international, technology 
    
    /**
     * Constructor
     */
    public Pengkategori()
    {
    	isiKategori();
    }
    
    /**
     * add message to each List
     */
    public void isiKategori()
    {
	    List<String> ListUrl = new ArrayList<String>();
		ListUrl.add("http://rss.cnn.com/rss/edition_world.rss");
		ListUrl.add("http://rss.cnn.com/rss/edition_technology.rss");
		ListUrl.add("http://rss.cnn.com/rss/edition_sport.rss");
		ListUrl.add("http://rss.cnn.com/rss/edition_business.rss");
		ListUrl.add("http://rss.cnn.com/rss/edition_entertainment.rss");
	    RSSFeedParser parser = new RSSFeedParser(ListUrl);
	    
	    Feed feed = parser.readFeed();
	    
	    for (FeedMessage message : feed.getMessages()) {
	    	  ListAll.add(message);
		      if(message.getTitle().toLowerCase().contains("world") && 
		    		  !message.getDescription().contains("<") &&
		    		  !message.getDescription().contains(">")){
		    	  ListWorld.add(message);
		      }else if(message.getTitle().toLowerCase().contains("tech") && 
		    		  !message.getDescription().contains("<") &&
		    		  !message.getDescription().contains(">")){
		    	  ListTech.add(message);
		      }else if(message.getTitle().toLowerCase().contains("sport") && 
		    		  !message.getDescription().contains("<") &&
		    		  !message.getDescription().contains(">")){
		    	  ListSport.add(message);
		      }else if(message.getTitle().toLowerCase().contains("business") && 
		    		  !message.getDescription().contains("<") &&
		    		  !message.getDescription().contains(">")){
		    	  ListBusiness.add(message);
		      }else if(message.getTitle().toLowerCase().contains("ent") && 
		    		  !message.getDescription().contains("<") &&
		    		  !message.getDescription().contains(">")){
		    	  ListEnt.add(message);
		      }else{
		    	  ListOther.add(message);
		      }	
	    }
    }
}
