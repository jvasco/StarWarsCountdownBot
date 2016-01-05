import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import twitter4j.Twitter;


public class StarWarsCountdownBot {
	public static void main(String[] args) throws InterruptedException {

		int i = 15;
		while (true) {
			System.out.println(i);
			i++;
			Twitter.class.getClass();
			Thread.sleep(8000);
		}

	}

	private static int daysBetween(Date d1, Date d2) {
		// TODO Auto-generated method stub
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}
}