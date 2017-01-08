The eventcreator.jar currently can be used to create WLL Voice event file for OFCA.

command usage

java -jar eventcreator.jar <properties file path> <output file path>


Input for this are 
1. Properties file which contain the attributes to be added to WLLVoice File
2. Output Dir path where the WLLVoice file will be crated


---Format of MOC record---

Properties file is a comma seperated file as below
<Served MSISDN> , <Calling Number> , <Called Number> , <Seizure Timestamp> , <Call Duration> ,[repetition]

Record Type Name		: "MOC"
Served MSISDN			: TON (.5) + NPI (.5) + MSISDN (9), size 10B
Calling Number  		: length (1 byte) + ton (0.5) + npi (0.5) + number (11), size 13B
Called Number			: length (1 byte) + ton (0.5) + npi (0.5) + number (11), size 13B
Seizure Timestamp		: YYMMDDHHMMSS, size 6B
Call Duration			: SSSSSSSS, size 4B
Repetition			: number of time the same record to be created. This parameter is Optional

--------------------------------------



---Format of MTC record---

Properties file is a comma seperated file as below
<Served MSISDN> , <Calling Number> , <Connected Number> , <Seizure Timestamp> , <Call Duration> ,[repetition]

Record Type Name		: "MTC"
Served MSISDN			: resource value in case of HSIA
Calling Number  		: Start date when the event occured. Required date format is YYYYMMDDHHMMSS
Connected Number		: End event date for the event. Required date format is YYYYMMDDHHMMSS
Seizure Timestamp		: upload data usage for the event
Call Duration			: Download data usage for the event
Repetition				: number of time the same record to be created. This parameter is Optional

--------------------------------------

Example :

MOC,987665432,9988776655,9966554477,170105143215,156
MOC,963852741,9988552233,9966554477,170105143305,254,10
