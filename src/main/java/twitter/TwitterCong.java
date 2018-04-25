package twitter;

import java.util.List;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;


public class TwitterCong {



	private Twitter twitter;
	private TwitterFactory tf;
	private ConfigurationBuilder cb;

	public TwitterCong() {
		this.setTwitter(null);
		this.setTf(null);
		connect();

	}


	public void connect() {
		this.cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("h0AME437OPwRGh2MXArPdyJ6E")
				.setOAuthConsumerSecret("OGxfkkNLqurtFRYD8YwBZonKdeDEtL6MiR8GDzH2XLXOct3Q2j")
				.setOAuthAccessToken("989107440976322560-eUHJEPHoejisS7AcRusWMWUmprEMIl7")
				.setOAuthAccessTokenSecret("SyunbCpgYXfPFqclc7cbTsK9X4yW9Vs8JwEupxqkSEbHv");
		//this.tf = new TwitterFactory(cb.build());
		//this.setTwitter(tf.getInstance());

	}
	public void getLastTweets()
	{
		 StatusListener listener = new StatusListener(){
		        public void onStatus(Status status) {
		            System.out.println(status.getUser().getName() + " : " + status.getText());
		        }
		        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
		        	System.out.println(statusDeletionNotice.getStatusId() + "is removed");
		        }
		        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {

		        }
		        public void onException(Exception ex) {
		            ex.printStackTrace();
		        }
				public void onScrubGeo(long arg0, long arg1) {
					// TODO Auto-generated method stub

				}
				public void onStallWarning(StallWarning arg0) {
					// TODO Auto-generated method stub

				}
		    };

		    TwitterStream twitterStream = new TwitterStreamFactory(this.cb.build()).getInstance();
		    twitterStream.addListener(listener);
		    // sample() method internally creates a thread which manipulates TwitterStream and calls these adequate listener methods continuously.
		    twitterStream.filter("apple");

	}


	public Twitter getTwitter() {
		return twitter;
	}


	public void setTwitter(Twitter twitter) {
		this.twitter = twitter;
	}


	public TwitterFactory getTf() {
		return tf;
	}


	public void setTf(TwitterFactory tf) {
		this.tf = tf;
	}

}
