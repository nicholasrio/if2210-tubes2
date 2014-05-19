package RSSep;

/**
 * @author Capokantil
 *
 */


public class FeedMessage {

	  String title;  // title of Feed
	  String description; // description of feed
	  String link; // link of feed
	  
	  /**
	   * return title of feed
	   * @return
	   */
	  public String getTitle() {
	    return title;
	  }

	  /**
	   * set title
	   * @param title
	   */
	  public void setTitle(String title) {
	    this.title = title;
	  }

	  /**
	   * return description of feed
	   * @return
	   */
	  public String getDescription() {
	    return description;
	  }

	  /**
	   * set description of feed
	   * @param description
	   */
	  public void setDescription(String description) {
	    this.description = description;
	  }

	  /**
	   * return link of feed
	   * @return
	   */
	  public String getLink() {
	    return link;
	  }

	  /**
	   * set link of feed
	   * @param link
	   */
	  public void setLink(String link) {
	    this.link = link;
	  }

	  @Override
	  public String toString() {
	    return "FeedMessage [title=" + title + ", description=" + description
	        + ", link=" + link
	        + "]";
	  }
}
