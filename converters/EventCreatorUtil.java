package converters;

public class EventCreatorUtil {

	public static String padField( String field, int length , String paddingCharacter , String alingment)
	{
		if( alingment.equalsIgnoreCase("right"))
		{
			return String.format("%"+length+"s", field).replace(" ", paddingCharacter);
		}
		else
		{
			return String.format("%-"+length+"s", field).replace(" ", paddingCharacter);
		}
		
	}

}
