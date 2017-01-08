package fileGeneration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import converters.DateTimes;
import records.Header;
import records.MOC;
import records.Trailer;

public class VoiceEventCreator {

	private int numberOfRecords = 0;
	private String fileNameConst = "SCCF005_FGSM1205G02_WLL_ID0001_T20161220170920_SOU.DAT";
	private int incrementalSeconds = 1; // Second(s) for now
	private File eventFile = null;
	private List<String> propertyList = new ArrayList<String>();

	public void createFileFromProperties(String propertiesFile, String outputLocation) {

		int propertyCount = 0;
		String property;

		try {

			BufferedReader reader = new BufferedReader(new FileReader(propertiesFile));

			while ((property = reader.readLine()) != null) {
				propertyList.add(propertyCount, property);
				propertyCount++;
			}

			reader.close();

			System.out.println("propertyCount = " + propertyCount);

			numberOfRecords = new Property().CheckProperty(propertyList);
			System.out.println("numberOfRecords  : " + numberOfRecords);

			// At this point, we know the properties are correct, no. of records
			// to be made

			// fileNameConst =
			// "SCCF005_FGSM1205G02_WLL_ID0001_T"+DateTimes.getCurrentDate()+"_SOU.DAT";
			eventFile = new File(outputLocation + "/" + fileNameConst);
			if (!eventFile.exists()) {
				eventFile.createNewFile();
			}
			OutputStream writer = new FileOutputStream(eventFile);

			// Inserting Header
			
			Header header = new Header();
			header.setNumberofRecords(Integer.toString(numberOfRecords));
			byte[] CDRIVESH = header.getHeader();
			writer.write(CDRIVESH);

			// Inserting MOC,MTC records

			for (String property2 : propertyList) {
				String[] properties = property2.split(",");
				if (properties.length == 7) {
					switch (properties[0]) {
					case "MOC": {
						int number = Integer.valueOf(properties[6]);
						for (int i = 0; i < number; i++) {

							MOC moc = new MOC();
							moc.setServedMSISDN(properties[1]);
							moc.setCallingNumber(properties[2]);
							moc.setCalledNumber(properties[3]);
							moc.setSeizureTimestamp(DateTimes.getNewDate(properties[4], incrementalSeconds));
							incrementalSeconds += incrementalSeconds;
							moc.setCallDuration(properties[5]);

							byte[] CDRIVESMOC = moc.getMOC();
							writer.write(CDRIVESMOC);
						}
						incrementalSeconds = 1;
					}
					case "MTC": {
						/*
						 * int number = Integer.valueOf(properties[6]); for (int
						 * i = 0; i < number; i++) { MTC mtc = new MTC(); MOC
						 * moc = new MOC(); moc.setServedMSISDN(properties[1]);
						 * moc.setCallingNumber(properties[2]);
						 * moc.setCalledNumber(properties[3]);
						 * moc.setSeizureTimestamp(DateTimes.getNewDate(
						 * properties[4], incrementalSeconds));
						 * incrementalSeconds += incrementalSeconds;
						 * moc.setCallDuration(properties[5]);
						 * 
						 * byte[] CDRIVESMOC = moc.getMOC();
						 * writer.write(CDRIVESMOC); } incrementalSeconds = 1;
						 */ }
					}
				} else {
					switch (properties[0]) {
					case "MOC": {

						MOC moc = new MOC();
						moc.setServedMSISDN(properties[1]);
						moc.setCallingNumber(properties[2]);
						moc.setCalledNumber(properties[3]);
						moc.setSeizureTimestamp(DateTimes.getNewDate(properties[4], 0));//make sure the format's correct 
						moc.setCallDuration(properties[5]);

						byte[] CDRIVESMOC = moc.getMOC();
						writer.write(CDRIVESMOC);
					}
					case "MTC": {

						/*
						 * MTC mtc = new MTC(); MOC moc = new MOC();
						 * moc.setServedMSISDN(properties[1]);
						 * moc.setCallingNumber(properties[2]);
						 * moc.setCalledNumber(properties[3]);
						 * moc.setSeizureTimestamp(DateTimes.getNewDate(
						 * properties[4], 0));//incrementalSeconds));//Format
						 * moc.setCallDuration(properties[5]);
						 * 
						 * byte[] CDRIVESMOC = moc.getMOC();
						 * writer.write(CDRIVESMOC);
						 */

					}
					}
				}
			}

			Trailer trailer = new Trailer();
			trailer.setNumberofRecords(numberOfRecords + 2); // +2 for H+T as in
																// xcl
			byte[] CDRIVEST = trailer.getTrailer();
			writer.write(CDRIVEST);

			writer.close();

			System.out.println("File created with : " + numberOfRecords + " Binary records !");
		} catch (IOException ioe) {
			System.out.println("Problem opening properties file ioException");
			ioe.printStackTrace();
			deleteFile(eventFile);

		} catch (Exception exp) {
			System.out.println("Problem reading properties file");
			exp.printStackTrace();
			deleteFile(eventFile);
		}

	}

	public static void deleteFile(File file) {
		if (file.delete()) {

		} else {
			System.out.println("Problem deleting file");
		}
	}
	/**
	 *2017
	 * @author Karam
	 */
}