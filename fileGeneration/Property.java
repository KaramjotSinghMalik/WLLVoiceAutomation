package fileGeneration;

import java.util.List;

public class Property {
	//TODO code for dup-check

	
	public int CheckProperty(List<String> propertyList) throws Exception {
		int recordnumber=0;
		String recordType;
		String servedMSISDN;
		String callingNumber;
		String calledNumber;
		String seizureTime;
		String callDuration;
		int repetition = 1;
		int propertyCount = 0;
		try{
			
			for (String property : propertyList)
			{
			String [] properties = property.split(",");
			
			recordType = properties[0];
			servedMSISDN= properties[1];
			callingNumber= properties[2];
			calledNumber= properties[3];
			seizureTime= properties[4];
			callDuration= properties[5];
			if (properties.length == 7) 
			{//add check for 0/negative vslue of repetitions
					repetition = Integer.parseInt(properties[6]);
			} 
			recordnumber +=repetition;
			repetition = 1;
		}
		}
				catch (NumberFormatException nfe) {
					System.out.println("number of repitition of record in properties file is non numeric");
					nfe.printStackTrace();
					throw nfe;
				}	
				catch(Exception e)
		{
			//also send the property number where the exception is thrown.. so that the person can correct it easily
					throw e;
		}
		
		return recordnumber;
	}
	/**
	 *2017
	 * @author Karam
	 */
}
