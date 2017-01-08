package fileGeneration;


public class WLLVoiceEventCreator {

	public static void main( String[] args)
	{
		try{

			VoiceEventCreator voiceEventCreator = new VoiceEventCreator();
			//voiceEventCreator.createFileFromProperties(args[0], args[1]); 
			voiceEventCreator.createFileFromProperties("/Users/Karam/Development/JavaAutomation_Amdocs2016/WLLV Automation/src/WLLVoiceProperties.txt","/Users/Karam/Desktop/");	
			
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
	/**
	 *2017
	 * @author Karam
	 */
}
