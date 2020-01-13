package TestVagrant.TestVagrant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Base {
	public static String weekdayName(int day) throws ParseException {
		Calendar cal = Calendar.getInstance();
		Date today = new Date();
		cal.setTime(today); // don't forget this if date is arbitrary
		int month = cal.get(Calendar.DAY_OF_MONTH);
		int year = cal.get(Calendar.DAY_OF_YEAR);

		// First convert to Date. This is one of the many ways.
		String dateString = String.format("%d-%d-%d", year, month, day);
		Date date = new SimpleDateFormat("yyyy-M-d").parse(dateString);

		// Then get the day of week from the Date based on specific locale.
		String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);

		return dayOfWeek;
	}
}
