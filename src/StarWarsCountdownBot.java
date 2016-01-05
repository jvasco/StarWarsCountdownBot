import twitter4j.TwitterFactory;
import twitter4j.TwitterException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import twitter4j.Twitter;


public class StarWarsCountdownBot {
	public static void main(String[] args) throws TwitterException,
			InterruptedException, ParseException {
		Twitter twitter = TwitterFactory.getSingleton();
		int i = 19;
		while (true) {
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
			int temp = daysBetween(Calendar.getInstance().getTime(),
					sdf.parse("16122016"));
			twitter.updateStatus(temp + " days until #RogueOne! " + i);
			i++;
			Thread.sleep(8000);
		}

	}

	private static int daysBetween(Date d1, Date d2) {
		// TODO Auto-generated method stub
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}
}