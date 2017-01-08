package records;

import java.nio.charset.StandardCharsets;

import converters.HexAscii;


public class Trailer {
	
	public String recordType = "96";								//HEX		0			4
	public String standard = "LTE";									//ASCII		4			3	
	public String version = "V 1.0     ";							//ASCII		7			10	
	public String fileCreationTimestamp = "150110204600";			//ASCII		17			12
	public String numberofRecords = "4";							//HEX		29			4			//needed
	
	
	
	
	public byte[] getTrailer()
	{
		//byte[] data = new byte[7];	//85
		
		byte[] a = HexAscii.hexStringToByteArray(HexAscii.asciiToHex(this.recordType));//padded
		byte[] b = this.standard.getBytes(StandardCharsets.US_ASCII); //unpadded
		byte[] c = this.version.getBytes(StandardCharsets.US_ASCII); //unpadded
		byte[] d = this.fileCreationTimestamp.getBytes(StandardCharsets.US_ASCII); //unpadded
		byte[] e = HexAscii.hexStringToByteArray(HexAscii.asciiToHex(this.numberofRecords));//padded

		
		byte[] data = new byte[33];					//[a.length + b.length + c.length + d.length + e.length];
		
	    System.arraycopy(a, 0, data, 0	,4	);	 //0, a.length); 
	    System.arraycopy(b, 0, data, 4	,3	);	 //a.length, b.length); 
	    System.arraycopy(c, 0, data, 7	,10	);	 //a.length + b.length, c.length); 
	    System.arraycopy(d, 0, data, 17	,12	); //a.length + b.length + c.length, d.length);
	    System.arraycopy(e, 0, data, 29	,4	);  //a.length + b.length + c.length + d.length, e.length);
	    
	    
		return data ;
		
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
	public String getFileCreationTimestamp() {
		return fileCreationTimestamp;
	}
	public void setFileCreationTimestamp(String fileCreationTimestamp) {
		this.fileCreationTimestamp = fileCreationTimestamp;
	}
	public String getNumberofRecords() {
		return numberofRecords;
	}
	public void setNumberofRecords(int i) {
		String number = Integer.toString(i);
		this.numberofRecords = number;
	}
	
	
	
	
	
	
	
	
	/**
	 *2017
	 * @author Karam
	 */	
}
