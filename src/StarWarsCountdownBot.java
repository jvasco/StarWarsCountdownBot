import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.TwitterFactory;
import twitter4j.TwitterException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
			for (int j = 0; j<=24; j++)
			{
				if (hour==j)
				{
					System.out.println(hour);
				}
			}
		
		try 
		{	
			Query query = new Query("\"@SW_Countdown\"");
			QueryResult result;
			result = twitter.search(query);
			result.getTweets();
			List<String> replies = new ArrayList<String>();
	        replies.add( " Now this is podracing!");
	        replies.add(" I'm a person and my name is Anakin!");
	        replies.add(" Yippee!");
	        replies.add(" It's working. It's working!!!!!");
	        int i = 0;
			Status tweet=result.getTweets().get(0);
				StatusUpdate statusUpdate = new StatusUpdate(".@" + tweet.getUser().getScreenName() + replies.get((int)(replies.size()*Math.random())));
				i++;
				statusUpdate.inReplyToStatusId(tweet.getId());
				twitter.updateStatus(statusUpdate);
				System.out.println("YES");
				if (i==replies.size()-1)
				{
					i=0;
				}
	
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