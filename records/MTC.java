package records;

import java.nio.charset.StandardCharsets;


import converters.BCD;
import converters.HexAscii;

public class MTC {

	public String recordType			= "41";	     																		//0		4			HEX
	public String servedIMSI			= "310410751183685";																//4		12			BCDswap
	public String servedIMEI			= "323";																				//16	8			BCDswap
	public String servedMSISDN			= "0013135060160";																	//24	10			BCDswap
	public String callingNumber			= "110013135060160";																//34	13			BCDswap
	public String calledNumber			= "110017272016335";																//47	13			BCDswap
	public String translatedNumber		= "365214";																				//60	13			BCDswap
	public String connectedNumber		= "254512";																				//73	13			BCDswap
	public String roamingNumber			= "54461";																				//86	10			BCDswap
	public String LTECTEEntity			= "06CCF005  ";																		//96	10			ASCII
	public String nodeAddress			= "61stas-att1.fsimsgroup0-015.ch3il01cvt.ch1il.uvp.els-an.att.net   ";				//106	66			ASCII
	public String nodeAddressLength		= "64";																					//2				ASCII
	public String LTETASNodeID			= "";																					//64			ASCII
	public String RAT					= "6";																				//172	1			ASCII
	public String TAC					= "55";																				//173	4			HEX
	public String eCGI					= "55";																				//177	7			HEX
	public String basicService			= "55";																				//184	2			HEX
	public String transparencyIndicator	= "00";																				//186	4			BCD
	public String supplementaryServices	= "01";																				//190	4			BCD
	public String MSClassmark			= "00";																				//194	4			BCD
	public String seizureTimestamp		= "150110213248";																	//198	6			BCD
	public String answerTimestamp		= "150110213315";																	//204	6			BCD
	public String releaseTimestamp		= "150110213430";																	//210	6			BCD
	public String callDuration			= "55";																				//216	4			HEX
	public String dataVolume			= "55";																				//220	4			HEX
	public String causeforTermination	= "55";																				//224	4			HEX
	public String callReference			= "55";																				//228	4			HEX
	public String sequenceNumber		= "55";																				//232	4			HEX
	public String interExchangeCarrier	= "55";																				//236	4			BCD	
	public String regionalServiceUsed	= "00";																				//240	4			BCD
	public String regionalDepChargeOrig	= "00";																				//244	4			BCD
	public String carrierIdCode			= "55";																				//248	4			BCD Swap
	public String carrierSelectSubstInfo= "55";			//"����";																	//252	4			HEX
	public String otherNumberFullType	= "55";																				//256	1			HEX
	public String otherNumberFull		= "                                                                ";				//257	64			ASCII
	public String callingNumberFull		= "sip:+13135060161@one.att.net;user=phone                         ";				//321	64			ASCII
	public String calledNumberFull		= "sip:+17272016336@one.att.net;user=phone                         ";				//385	64			ASCII
	public String typeOfCharge			= "55";																				//449	1			HEX
	public String AMAslpId 				= "55";																				//450	1			HEX
	public String ADCIndication			= "55";																				//451	1			HEX
	public String UTCTimeOffset			= "";																				//452	3			BCD
	public String servingBID			= "";																				//455	3			BCD


	private byte[] recordTypeArray 					= new byte[4];
	private byte[] servedIMSIArray 					= new byte[12];
	private byte[] servedIMEIArray 					= new byte[8];
	private byte[] servedMSISDNArray			 	= new byte[10];
	private byte[] callingNumberArray 				= new byte[13];
	private byte[] calledNumberArray 				= new byte[13];
	private byte[] translatedNumberArray 			= new byte[13];
	private byte[] connectedNumberArray 			= new byte[13];
	private byte[] roamingNumberArray 				= new byte[10];
	private byte[] LTECTEEntityArray 				= new byte[10];
	private byte[] nodeAddressArray 				= new byte[66];
	private byte[] nodeAddressLengthArray 			= new byte[2];
	private byte[] LTETASNodeIDArray 				= new byte[64];
	private byte[] RATArray 						= new byte[1];
	private byte[] TACArray 						= new byte[4];
	private byte[] eCGIArray 						= new byte[7];
	private byte[] basicServiceArray 				= new byte[2];
	private byte[] transparencyIndicatorArray 		= new byte[4];
	private byte[] supplementaryServicesArray 		= new byte[4];
	private byte[] MSClassmarkArray 				= new byte[4];
	private byte[] seizureTimestampArray 			= new byte[6];
	private byte[] answerTimestampArray 			= new byte[6];
	private byte[] releaseTimestampArray 			= new byte[6];
	private byte[] callDurationArray 				= new byte[4];
	private byte[] dataVolumeArray 					= new byte[4];
	private byte[] causeforTerminationArray 		= new byte[4];
	private byte[] callReferenceArray 				= new byte[4];
	private byte[] sequenceNumberArray 				= new byte[4];
	private byte[] interExchangeCarrierArray 		= new byte[4];
	private byte[] regionalServiceUsedArray 		= new byte[4];
	private byte[] regionalDepChargeOrigArray 		= new byte[4];
	private byte[] carrierIdCodeArray 				= new byte[4];
	private byte[] carrierSelectSubstInfoArray 		= new byte[4];
	private byte[] otherNumberFullTypeArray 		= new byte[1];
	private byte[] otherNumberFullArray 			= new byte[64];
	private byte[] callingNumberFullArray 			= new byte[64];
	private byte[] calledNumberFullArray 			= new byte[64];
	private byte[] typeOfChargeArray 				= new byte[1];
	private byte[] AMAslpIdArray 					= new byte[1];
	private byte[] ADCIndicationArray 				= new byte[1];
//	private byte[] UTCTimeOffsetArray 				= new byte[3];
//	private byte[] servingBIDArray 					= new byte[3];

	private byte[] finalMOC = new byte[452];
	private char filler = 'F';
	
	public byte[] getMOC()
	{

		
		recordTypeArray 		= HexAscii.hexStringToByteArray(HexAscii.asciiToHex(this.recordType));//padded
		servedIMSIArray 		= BCD.DecimalTofilledBCDSwap(servedIMSI, 		filler, 12);
		servedIMEIArray 		= BCD.DecimalTofilledBCDSwap(servedIMEI, 		filler, 8);
		servedMSISDNArray		= BCD.DecimalTofilledBCDSwap(servedMSISDN, 		filler, 10);
		callingNumberArray 		= BCD.DecimalTofilledBCDSwap(callingNumber, 	filler, 13);
		calledNumberArray 		= BCD.DecimalTofilledBCDSwap(calledNumber, 		filler, 13);
		translatedNumberArray 	= BCD.DecimalTofilledBCDSwap(translatedNumber, 	filler, 13);
		connectedNumberArray	= BCD.DecimalTofilledBCDSwap(connectedNumber, 	filler, 13);
		roamingNumberArray		= BCD.DecimalTofilledBCDSwap(roamingNumber, 	filler, 10);
		LTECTEEntityArray		= this.LTECTEEntity.getBytes(StandardCharsets.US_ASCII); //unpadded					//96	10			ASCII
		nodeAddressArray		= this.nodeAddress.getBytes(StandardCharsets.US_ASCII);								//106	66			ASCII
		System.out.println("passed 1");
		//LTETASNodeIDArray		= this.LTETASNodeID.getBytes(StandardCharsets.US_ASCII);							//64			ASCII
		RATArray				= this.RAT.getBytes(StandardCharsets.US_ASCII);										//172	1			ASCII
		TACArray				= HexAscii.hexStringToByteArray(HexAscii.asciiToHex(this.TAC));					//173	4			HEX
		eCGIArray				= HexAscii.hexStringToByteArray(HexAscii.asciiToHex(this.eCGI),7);				//177	7			HEX
		basicServiceArray		= HexAscii.hexStringToByteArray(HexAscii.asciiToHex(this.basicService));		//184	2			HEX
		transparencyIndicatorArray	= BCD.DecimalTofilledBCD(transparencyIndicator, 		filler, 4);				//186	4			BCD
		supplementaryServicesArray	= BCD.DecimalTofilledBCD(supplementaryServices, 		filler, 4);				//190	4			BCD
		MSClassmarkArray			= BCD.DecimalTofilledBCD(MSClassmark, 		filler, 4);							//194	4			BCD
		seizureTimestampArray		= BCD.DecimalTofilledBCD(seizureTimestamp, 		filler, 6);						//198	6			BCD
		answerTimestampArray		= BCD.DecimalTofilledBCD(answerTimestamp, 		filler, 6);						//204	6			BCD
		releaseTimestampArray		= BCD.DecimalTofilledBCD(releaseTimestamp, 		filler, 6);						//210	6			BCD
		callDurationArray			= HexAscii.hexStringToByteArray(HexAscii.asciiToHex(this.callDuration));	//216	4			HEX
		dataVolumeArray			= HexAscii.hexStringToByteArray(HexAscii.asciiToHex(this.dataVolume));			//220	4			HEX
		causeforTerminationArray	=HexAscii.hexStringToByteArray(HexAscii.asciiToHex(this.causeforTermination));//224	4			HEX
		callReferenceArray			= HexAscii.hexStringToByteArray(HexAscii.asciiToHex(this.callReference));	//228	4			HEX
		sequenceNumberArray		= HexAscii.hexStringToByteArray(HexAscii.asciiToHex(this.sequenceNumber));		//232	4			HEX
		interExchangeCarrierArray	= BCD.DecimalTofilledBCD(interExchangeCarrier, 		filler, 4);					//236	4			BCD	
		regionalServiceUsedArray	= BCD.DecimalTofilledBCD(regionalServiceUsed, 		filler, 4);					//240	4			BCD
		regionalDepChargeOrigArray	= BCD.DecimalTofilledBCD(regionalDepChargeOrig, 		filler, 4);				//244	4			BCD
		carrierIdCodeArray			= BCD.DecimalTofilledBCD(carrierIdCode, 		filler, 4);						//248	4			BCD Swap
		carrierSelectSubstInfoArray= HexAscii.hexStringToByteArray(HexAscii.asciiToHex(this.carrierSelectSubstInfo));//252	4			HEX
		otherNumberFullTypeArray	= HexAscii.hexStringToByteArray(HexAscii.asciiToHex(this.otherNumberFullType));	//256	1			HEX
		otherNumberFullArray		= this.otherNumberFull.getBytes(StandardCharsets.US_ASCII);						//257	64			ASCII
		callingNumberFullArray		= this.callingNumberFull.getBytes(StandardCharsets.US_ASCII);					//321	64			ASCII
		calledNumberFullArray		= this.calledNumberFull.getBytes(StandardCharsets.US_ASCII);					//385	64			ASCII
		typeOfChargeArray			= HexAscii.hexStringToByteArray(HexAscii.asciiToHex(this.typeOfCharge));	//449	1			HEX
		AMAslpIdArray 				= HexAscii.hexStringToByteArray(HexAscii.asciiToHex(this.AMAslpId));		//450	1			HEX
		ADCIndicationArray			= HexAscii.hexStringToByteArray(HexAscii.asciiToHex(this.ADCIndication));																				//451	1			HEX
		//UTCTimeOffset			= "";																				//452	3			BCD
		//servingBID			= "";																				//455	3			BCD


	    
		appendArrays();
		return finalMOC ;
		
	}
	
	public void appendArrays()
	{

		//public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
		//src -- This is the source array.
		//srcPos -- This is the starting position in the source array.
		//dest -- This is the destination array.
		//destPos -- This is the starting position in the destination data.
		//length -- This is the number of array elements to be copied.
		
	    System.arraycopy(recordTypeArray			, 0, finalMOC, 0	,4	);
  		System.arraycopy(servedIMSIArray			, 0, finalMOC, 4	,12	);	
 		System.arraycopy(servedIMSIArray			, 0, finalMOC, 4	,12	);
	    System.arraycopy(servedIMEIArray			, 0, finalMOC, 16	,8	);
	    System.arraycopy(servedMSISDNArray			, 0, finalMOC, 24	,10	);
	    System.arraycopy(callingNumberArray			, 0, finalMOC, 34	,13	);
	    System.arraycopy(calledNumberArray			, 0, finalMOC, 47	,13	);
	    System.arraycopy(translatedNumberArray		, 0, finalMOC, 60	,13	);
	    System.arraycopy(connectedNumberArray		, 0, finalMOC, 73	,13	);
	    System.arraycopy(roamingNumberArray			, 0, finalMOC, 86	,10	);
	    System.arraycopy(LTECTEEntityArray			, 0, finalMOC, 96	,10	);
	    System.arraycopy(nodeAddressArray			, 0, finalMOC, 106	,66	);
	    System.arraycopy(RATArray					, 0, finalMOC, 172	,1	);
	    System.arraycopy(TACArray					, 0, finalMOC, 173	,4	);
	    System.arraycopy(eCGIArray					, 0, finalMOC, 177	,7	);
	    System.arraycopy(basicServiceArray			, 0, finalMOC, 184	,2	);
	    System.arraycopy(transparencyIndicatorArray	, 0, finalMOC, 186	,4	);
	    System.arraycopy(supplementaryServicesArray	, 0, finalMOC, 190	,4	);
	    System.arraycopy(MSClassmarkArray			, 0, finalMOC, 194	,4	);
	    System.arraycopy(seizureTimestampArray		, 0, finalMOC, 198	,6	);
	    System.arraycopy(answerTimestampArray		, 0, finalMOC, 204	,6	);
	    System.arraycopy(releaseTimestampArray		, 0, finalMOC, 210	,6	);
	    System.arraycopy(callDurationArray			, 0, finalMOC, 216	,4	);
	    System.arraycopy(dataVolumeArray			, 0, finalMOC, 220	,4	);
	    System.arraycopy(causeforTerminationArray	, 0, finalMOC, 224	,4	);
	    System.arraycopy(callReferenceArray			, 0, finalMOC, 228	,4	);
	    System.arraycopy(sequenceNumberArray		, 0, finalMOC, 232	,4	);
	    System.arraycopy(interExchangeCarrierArray	, 0, finalMOC, 236	,4	);
	    System.arraycopy(regionalServiceUsedArray	, 0, finalMOC, 240	,4	);
	    System.arraycopy(regionalDepChargeOrigArray	, 0, finalMOC, 244	,4	);
	    System.arraycopy(carrierIdCodeArray			, 0, finalMOC, 248	,4	);
	    System.arraycopy(carrierSelectSubstInfoArray, 0, finalMOC, 252	,4	);
	    System.arraycopy(otherNumberFullTypeArray	, 0, finalMOC, 256	,1	);
	    System.arraycopy(otherNumberFullArray		, 0, finalMOC, 257	,64	);
	    System.arraycopy(callingNumberFullArray		, 0, finalMOC, 321	,64	);
	    System.arraycopy(calledNumberFullArray		, 0, finalMOC, 385	,64	);
	    System.arraycopy(typeOfChargeArray			, 0, finalMOC, 449	,1	);
	    System.arraycopy(AMAslpIdArray				, 0, finalMOC, 350	,1	);
	    System.arraycopy(ADCIndicationArray			, 0, finalMOC, 451	,1	);
	/*    System.arraycopy(UTCTimeOffsetArray			, 0, finalMOC, 452	,3	);
	    System.arraycopy(servingBIDArray			, 0, finalMOC, 455	,3	);*/


	   
	
	}
	
	
	/**
	 *2017
	 * @author Karam
	 */	
}
