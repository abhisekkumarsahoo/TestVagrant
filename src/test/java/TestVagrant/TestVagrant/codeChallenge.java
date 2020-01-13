package TestVagrant.TestVagrant;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

public class codeChallenge extends Base{

	public static void main(String[] args) throws ParseException {
		dataprovider data = new dataprovider();
		float MonthlyExpenses = 0, price=0;
		String houseHoldName="Books";
		ArrayList<String> newspaperList = new ArrayList<String>();
		newspaperList.add("TOI");
		newspaperList.add("BM");
	
		Calendar cal = Calendar.getInstance();
		int lastDayOfMoth = cal.getActualMaximum(Calendar.DATE);

		for (String newspapername : newspaperList) {
			for (int i = 1; i <= lastDayOfMoth; i++) {
				String dayOfWeek = weekdayName(i);
				try {
					price = Float.parseFloat(data.getDataByColName(houseHoldName, dayOfWeek, newspapername));
					MonthlyExpenses = MonthlyExpenses + price;
				}catch(Exception e) {
					System.out.println("there is no subscription for today for item "+ newspapername);
				}
				
			}
		}
		System.out.println("Total monthly expense is - " + MonthlyExpenses);
	}

	
}
