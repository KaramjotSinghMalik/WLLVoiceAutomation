package converters;


import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateTimes {

	public static String getNewDate(String YYMMDDhhmmss, int secondsIncrement) {
		GregorianCalendar gcal = null;
		try{
			
	//Date convertedDate = null;
	//DateFormat formatter =new SimpleDateFormat("YYMMDDhhmmss");
    //convertedDate =(Date) formatter.parse(YYMMDDhhmmss);
    
    int [] broken = breaker(YYMMDDhhmmss);
     gcal = new GregorianCalendar(broken[0],broken[1],broken[2],broken[3],broken[4],broken[5]);
    //gcal.setTime(convertedDate);
    
    gcal.add(Calendar.SECOND, secondsIncrement);
    
    //int years = gcal.get(Calendar.YEAR)%2000;
    //System.out.println(years);
    //convertedDate = gcal.getTime();
    //System.out.println("New Date in Java : " + convertedDate);
   
		}
		catch(Exception e)
		{
			System.out.println("Error while parsing the date");
		}
		
		 return appender(gcal);
	}

public static int[] breaker(String YYMMDDhhmmss)
{
	int [] broken = new int[6];
	
	for (int i = 0; i < 6; i++)
	{
		broken[i] = Integer.parseInt(YYMMDDhhmmss.substring(2*i, 2*i+2));
	}
	
	return broken;
	
}
public static String appender(GregorianCalendar gcal)
{
	String returnString = "";
	int [] values = new int[6];
	
	values[0] = gcal.get(Calendar.YEAR)%2000;
	values[1] = gcal.get(Calendar.MONTH);
	values[2] = gcal.get(Calendar.DATE);
	values[3] = gcal.get(Calendar.HOUR_OF_DAY);
	values[4] = gcal.get(Calendar.MINUTE);
	values[5] = gcal.get(Calendar.SECOND);
	

	for(int i = 0;i<6;i++)
	{
	if(values[i]/10 == 0)
	{
		returnString += "0";
		returnString += (Integer.toString(values[i]));
	}
	else
	{
		returnString += (Integer.toString(values[i]));
	}
	}
	return returnString;
}


	public static String getCurrentDate()
	{
		GregorianCalendar cal = (GregorianCalendar) Calendar.getInstance();

		cal.add(Calendar.MONTH, 1);

		String currentDate = "20" + appender(cal);
		return currentDate;
		
		
	}

	/**
	 *2017
	 * @author Karam
	 */	
}
