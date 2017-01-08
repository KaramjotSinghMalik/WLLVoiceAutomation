package records;

import java.nio.charset.StandardCharsets;

import converters.HexAscii;


public class Header
{
	
																	//			offset		size
	private String recordType = "95";								//HEX		0			4
	private String standard = "LTE";									//ASCII		4			3	
	private String version = "V 1.0     ";							//ASCII		7			10	
	private String LTECTEEntity = "06CCF005            ";			//ASCII		17			20
	private String supplementaryServiceCount = "147";				//HEX		37			4
	private String numberofRecords = "4";							//HEX		41			4			//needed
	private String fileCreationTimestamp = "150110204600";			//ASCII		45			12
	private String earliestRecordTimstamp = "150111004054";			//ASCII		57			12
	private String latestRecordTimestamp = "150111023314";			//ASCII		69			12
	private String GSMSequenceNumber = "0000";						//ASCII		81			4
	
	
	private byte[] recordTypeArray = new byte[4];
	private byte[] standardArray = new byte[3];
	private byte[] versionArray = new byte[10];
	private byte[] LTECTEEntityArray = new byte[20];
	private byte[] supplementaryServiceCounteArray = new byte[4];
	private byte[] numberofRecordsArray = new byte[4];
	private byte[] fileCreationTimestampArray = new byte[12];
	private byte[] earliestRecordTimstampArray = new byte[12];
	private byte[] latestRecordTimestampArray = new byte[12];
	private byte[] GSMSequenceNumberArray = new byte[4];
	
	private byte[] finalheader = new byte[85];
	
	public byte[] getHeader()
	{
				
		recordTypeArray = HexAscii.hexStringToByteArray(HexAscii.asciiToHex(this.recordType));//padded
		standardArray = this.standard.getBytes(StandardCharsets.US_ASCII); //unpadded
		versionArray = this.version.getBytes(StandardCharsets.US_ASCII); //unpadded
		LTECTEEntityArray = this.LTECTEEntity.getBytes(StandardCharsets.US_ASCII); //unpadded
		supplementaryServiceCounteArray = HexAscii.hexStringToByteArray(HexAscii.asciiToHex(this.supplementaryServiceCount));//padded
		numberofRecordsArray = HexAscii.hexStringToByteArray(HexAscii.asciiToHex(this.numberofRecords));//padded
		fileCreationTimestampArray = this.fileCreationTimestamp.getBytes(StandardCharsets.US_ASCII); //unpadded
		earliestRecordTimstampArray = this.earliestRecordTimstamp.getBytes(StandardCharsets.US_ASCII); //unpadded
		latestRecordTimestampArray = this.latestRecordTimestamp.getBytes(StandardCharsets.US_ASCII); //unpadded
		GSMSequenceNumberArray = this.GSMSequenceNumber.getBytes(StandardCharsets.US_ASCII); //unpadded
		
								
		//add validation check here
		appendArrays();    
	    
		return finalheader ;
		
	}
	
	
	public void appendArrays()
	{
	    System.arraycopy(recordTypeArray, 0, finalheader, 0,4);	 //0, a.length); 
	    System.arraycopy(standardArray, 0, finalheader, 4,3);	 //a.length, b.length); 
	    System.arraycopy(versionArray, 0, finalheader, 7,10);	 //a.length + b.length, c.length); 
	    System.arraycopy(LTECTEEntityArray, 0, finalheader, 17,20); //a.length + b.length + c.length, d.length);
	    System.arraycopy(supplementaryServiceCounteArray, 0, finalheader, 37,4);  //a.length + b.length + c.length + d.length, e.length);
	    System.arraycopy(numberofRecordsArray, 0, finalheader, 41,4);  //a.length + b.length + c.length + d.length + e.length, f.length);
	    System.arraycopy(fileCreationTimestampArray, 0, finalheader, 45,12); //a.length + b.length + c.length + d.length + e.length + f.length, g.length);
	    System.arraycopy(earliestRecordTimstampArray, 0, finalheader, 57,12); //a.length + b.length + c.length + d.length + e.length + f.length + g.length, h.length);
	    System.arraycopy(latestRecordTimestampArray, 0, finalheader, 69,12); //a.length + b.length + c.length + d.length + e.length + f.length + g.length + h.length, i.length);
	    System.arraycopy(GSMSequenceNumberArray, 0, finalheader, 81,4);  //a.length + b.length + c.length + d.length + e.length + f.length + g.length + h.length + i.length, j.length);
	
	}
	
	
	
	
	
	
	 public String getRecordType() {
		return recordType;
	}


	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}


	
	public String getStandard() {
		return standard;
	}


	public void setStandard(String standard) {
		this.standard = standard;
	}


	
	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	
	public String getLTECTEEntity() {
		return LTECTEEntity;
	}


	public void setLTECTEEntity(String lTECTEEntity) {
		LTECTEEntity = lTECTEEntity;
	}


	
	public String getSupplementaryServiceCount() {
		return supplementaryServiceCount;
	}


	public void setSupplementaryServiceCount(String supplementaryServiceCount) {
		this.supplementaryServiceCount = supplementaryServiceCount;
	}



	public String getNumberofRecords() {
		return numberofRecords;
	}


	public void setNumberofRecords(String numberofRecords) {
		this.numberofRecords = numberofRecords;
	}


	
	public String getFileCreationTimestamp() {
		return fileCreationTimestamp;
	}


	public void setFileCreationTimestamp(String fileCreationTimestamp) {
		this.fileCreationTimestamp = fileCreationTimestamp;
	}


	
	public String getEarliestRecordTimstamp() {
		return earliestRecordTimstamp;
	}


	public void setEarliestRecordTimstamp(String earliestRecordTimstamp) {
		this.earliestRecordTimstamp = earliestRecordTimstamp;
	}


	
	public String getLatestRecordTimestamp() {
		return latestRecordTimestamp;
	}


	public void setLatestRecordTimestamp(String latestRecordTimestamp) {
		this.latestRecordTimestamp = latestRecordTimestamp;
	}


	
	public String getGSMSequenceNumber() {
		return GSMSequenceNumber;
	}


	public void setGSMSequenceNumber(String gSMSequenceNumber) {
		GSMSequenceNumber = gSMSequenceNumber;
	}
	
	 
	 
	 
	
	
	/**
	 *2017
	 * @author Karam
	 */
}