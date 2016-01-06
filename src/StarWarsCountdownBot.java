import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.TwitterFactory;
import twitter4j.TwitterException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import twitter4j.Twitter;


public class StarWarsCountdownBot {
	public static void main(String[] args) throws 
			InterruptedException, ParseException {
		Twitter twitter = TwitterFactory.getSingleton();
		Calendar cal = Calendar.getInstance();
		while (true) {
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
			int temp = daysBetween(Calendar.getInstance().getTime(),
					sdf.parse("16122016"));
			int hour = cal.get(Calendar.HOUR_OF_DAY);
			if (hour==12)
			{
			try {
				twitter.updateStatus(temp + " days until #RogueOne!");
			} catch (TwitterException e) {
				// TODO Auto-generated catch block
			}
			}
		Query query = new Query("@SW_Countdown");
		QueryResult result;
		try 
		{
			result = twitter.search(query);
			Status tweetResult = result.getTweets().get(0);
			StatusUpdate statusUpdate = new StatusUpdate(".@" + tweetResult.getUser().getScreenName() + " It's working. It's working!!!");
			statusUpdate.inReplyToStatusId(tweetResult.getId());
			Status status = twitter.updateStatus(statusUpdate);
		} 
		catch (TwitterException e) 
		{
		}
		}

	}

	private static int daysBetween(Date d1, Date d2) {
		// TODO Auto-generated method stub
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}
}