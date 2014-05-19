package RSSep;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Capokantil
 */

public class Feed {

	  private static final String Null = null;
	  final String title;
	  final String link;
	  final String description;
	  final String language;
	  final String copyright;
	  final String pubDate;

	  final List<FeedMessage> entries = new ArrayList<FeedMessage>();

	  /**
	   * Feed constructor with param
	   * @param title
	   * @param link
	   * @param description
	   * @param language
	   * @param copyright
	   * @param pubDate
	   */
	  public Feed(String title, String link, String description, String language,
	      String copyright, String pubDate) {
	    this.title = title;
	    this.link = link;
	    this.description = description;
	    this.language = language;
	    this.copyright = copyright;
	    this.pubDate = pubDate;
	  }

	  /**
	   * Getter get messages
	   * @return entries
	   */
	  public List<FeedMessage> getMessages() {
	    return entries;
	  }

	  /**
	   * Getter get title
	   * @return title
	   */
	  public String getTitle() {
	    return title;
	  }

	  /**
	   * Getter get link
	   * @return link
	   */
	  public String getLink() {
	    return link;
	  }

	  /**
	   * Getter get description
	   * @return description
	   */
	  public String getDescription() {
	    return description;
	  }

	  /**
	   * Getter get language
	   * @return language
	   */
	  public String getLanguage() {
	    return language;
	  }

	  /**
	   * Getter get copyright
	   * @return copyright
	   */
	  public String getCopyright() {
	    return copyright;
	  }

	  /**
	   * Getter get pubdate
	   * @return pubDate
	   */
	  public String getPubDate() {
	    return pubDate;
	  }

	  @Override
	  public String toString() {
	    return "Feed [copyright=" + copyright + ", description=" + description
	        + ", language=" + language + ", link=" + link + ", pubDate="
	        + pubDate + ", title=" + title + "]";
	  }
}
