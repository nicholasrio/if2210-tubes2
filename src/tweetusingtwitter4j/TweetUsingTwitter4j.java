/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tweetusingtwitter4j;

/**
 *
 * @author ACER
 */
/**
 * How to post a Tweet in Java using Twitter REST API and Twitter4J Library
 * shttp://codeoftheday.blogspot.com/2013/07/how-to-post-tweet-in-java-using-twitter.html
 */

 
import twitter4j.*;
import twitter4j.auth.AccessToken;

 
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
//import tweetusingtwitter4j.Status;
 

public class TweetUsingTwitter4j {
 
    public static void tweetShare() throws IOException, TwitterException {
 
        //Your Twitter App's Consumer Key
        String consumerKey = "E0VDlmdbqjHHc0Qp8i6DAkNuk";
 
        //Your Twitter App's Consumer Secret
        String consumerSecret = "C33Lx9FkqgAyWXYwalDlDTDVfcRK0D7hqin1J4H86pV93Smqbg";
 
        //Your Twitter Access Token
        String accessToken = "77715499-ttYoLBXKTHs5H5LBOMtCRbJenyrEAgdtKcP5iEjN9";
 
        //Your Twitter Access Token Secret
        String accessTokenSecret = "yDthXAvIRrQBXgvcn6h8o6TvdkCImzj6eg6lIDuQgsyHo";
 
        //Instantiate a re-usable and thread-safe factory
        TwitterFactory twitterFactory = new TwitterFactory();
 
        //Instantiate a new Twitter instance
        Twitter twitter = twitterFactory.getInstance();
 
        //setup OAuth Consumer Credentials
        twitter.setOAuthConsumer(consumerKey, consumerSecret);
 
        //setup OAuth Access Token
        twitter.setOAuthAccessToken(new AccessToken(accessToken, accessTokenSecret));
 
        //Instantiate and initialize a new twitter status update
        StatusUpdate statusUpdate = new StatusUpdate("Tes Tubes 2");
                //your tweet or status message, isi dengan string apa aja..
                
        
        
        //tweet or update status
        Status status =  twitter.updateStatus(statusUpdate);
 
        //response from twitter server
       /* System.out.println("status.toString() = " + status.toString());
        System.out.println("status.getInReplyToScreenName() = " + status.getInReplyToScreenName());
        System.out.println("status.getSource() = " + status.getSource());
        System.out.println("status.getText() = " + status.getText());
        System.out.println("status.getContributors() = " + Arrays.toString(status.getContributors()));
        System.out.println("status.getCreatedAt() = " + status.getCreatedAt());
        System.out.println("status.getCurrentUserRetweetId() = " + status.getCurrentUserRetweetId());
        System.out.println("status.getGeoLocation() = " + status.getGeoLocation());
        System.out.println("status.getId() = " + status.getId());
        System.out.println("status.getInReplyToStatusId() = " + status.getInReplyToStatusId());
        System.out.println("status.getInReplyToUserId() = " + status.getInReplyToUserId());
        System.out.println("status.getPlace() = " + status.getPlace());
        System.out.println("status.getRetweetCount() = " + status.getRetweetCount());
        System.out.println("status.getRetweetedStatus() = " + status.getRetweetedStatus());
        System.out.println("status.getUser() = " + status.getUser());
        System.out.println("status.getAccessLevel() = " + status.getAccessLevel());
        System.out.println("status.getHashtagEntities() = " + Arrays.toString(status.getHashtagEntities()));
        System.out.println("status.getMediaEntities() = " + Arrays.toString(status.getMediaEntities())); 
        if(status.getRateLimitStatus() != null)
        {
            System.out.println("status.getRateLimitStatus().getLimit() = " + status.getRateLimitStatus().getLimit());
            System.out.println("status.getRateLimitStatus().getRemaining() = " + status.getRateLimitStatus().getRemaining());
            System.out.println("status.getRateLimitStatus().getResetTimeInSeconds() = " + status.getRateLimitStatus().getResetTimeInSeconds());
            System.out.println("status.getRateLimitStatus().getSecondsUntilReset() = " + status.getRateLimitStatus().getSecondsUntilReset());
            //System.out.println("status.getRateLimitStatus().getRemainingHits() = " + status.getRateLimitStatus().getRemainingHits());
        }
        System.out.println("status.getURLEntities() = " + Arrays.toString(status.getURLEntities()));
        System.out.println("status.getUserMentionEntities() = " + Arrays.toString(status.getUserMentionEntities()));
    } */
    }
    public TweetUsingTwitter4j() {
        try {
        tweetShare();
        }
        catch(IOException e1) {e1.printStackTrace();} 
        catch(TwitterException e2) {e2.printStackTrace();}
    }
}
