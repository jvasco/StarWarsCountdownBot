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
		Status firsttweet=null;
		while (true) {
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
			int temp = daysBetween(Calendar.getInstance().getTime(),
					sdf.parse("16122016"));
			int hour = cal.get(Calendar.HOUR_OF_DAY);
			if (hour==22)
			{
				System.out.println("Step 1");
				try 
				{
					System.out.println("about to tweet");
					twitter.updateStatus("Reminder: " + temp + " days until #RogueOne!!");
				System.out.println("should have tweeted by now");
				} catch (TwitterException e) 
				{
				}
			}
			if (hour==12)
			{
				try 
				{
					System.out.println("about to tweet");
					twitter.updateStatus(temp + " days until #RogueOne!!");
				System.out.println("should have tweeted by now");
				} catch (TwitterException e) 
				{
				}
			}
			if (hour==24)
			{
				try
				{
					twitter.updateStatus("Good night, Twitter.");
				}
				catch( TwitterException e)
				{
					
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
	        replies.add(" Are you an angel?");
	        replies.add(" Name's Lars. Shmi's my wife.");
	        replies.add(" I know we're in trouble just hang on!");
	        replies.add(" From my point of view the Jedi are evil!");
	        replies.add(" You underestimate my powers!");
	        replies.add(" Let's try spinning, that's a good trick!");
	        replies.add(" But I was gonna go to the Tosche Station to pick up some power converters!");
	        replies.add(" Some moof milker put a compressor on the hyperdrive.");
	        replies.add(" Only a Sith deals in absolutes.");
	        replies.add(" Never tell me the odds!");
	        replies.add(" Laugh it up, fuzzball!");
	        replies.add( " It's a trap!");
	        
			Status tweet=result.getTweets().get(0);
			
			if (tweet.equals(firsttweet)==false)
			{
				StatusUpdate statusUpdate = new StatusUpdate(".@" + tweet.getUser().getScreenName() + replies.get((int)(replies.size()*Math.random())));
				statusUpdate.inReplyToStatusId(tweet.getId());
				twitter.updateStatus(statusUpdate);
				System.out.println("YES");
				firsttweet=tweet;
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