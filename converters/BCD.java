package converters;

public class BCD {

	public static byte[] 	DecimalTofilledBCD2(long num,char filler,int size) {
        int digits = 0;
        int size2 = 2*size;
        
        long temp = num;
        while (temp != 0) {
            digits++;
            temp /= 10;
        }
        temp = num;
        //Manage more fillers
        //char byteLen = digits % 2 == 0 ? 'E' : 'O';

        byte bcd[] = new byte[size];
        
        int i = 0;
        for (i = 0; i < digits; i++) {
            byte tmp = (byte) (num % 10);

            if (i % 2 == 0) {
            	bcd[i / 2] = (byte) ((tmp<<4));
            } else {
            	bcd[i / 2] |= (byte) (tmp);
            }

            num /= 10;
        }
//        System.out.println();
        for(int t=0;t<size;t++)
        {
//        	System.out.print("-"+BCDtoString(bcd[t]));
        }
//        System.out.println();
        
         
        
        byte [] t1 = HexAscii.hexStringToByteArray(HexAscii.asciiToHex("255").substring(6));
        byte tmp = t1[0];
        byte t2s = (byte) (tmp<<4);
        byte t3s = (byte) ~t2s ;
        
//        System.out.println(BCDtoString(t3s));
        for (int j = i; j < size2; j++) {
            
            if (j % 2 == 0) {
            	bcd[j / 2] = tmp;
            	j++;
            } else {
            	bcd[j / 2] |= (byte) (t3s);
            }

            }
        for(int t=0;t<size;t++)
        {
//        	System.out.print("-"+BCDtoString(bcd[t]));
//        }System.out.println();

        }
        return bcd;
    }
    public static byte[] 	DecimalTofilledBCD(String number,char filler,int size) {
    	Long num = Long.parseLong(new StringBuilder(number).reverse().toString());
        int digits = 0;
        int size2 = 2*size;
        
        long temp = num;
        while (temp != 0) {
            digits++;
            temp /= 10;
        }
        temp = num;
        //Manage more fillers
        //char byteLen = digits % 2 == 0 ? 'E' : 'O';

        byte bcd[] = new byte[size];
        
        int i = 0;
        for (i = 0; i < digits; i++) {
            byte tmp = (byte) (num % 10);

            if (i % 2 == 0) {
                bcd[i / 2] = tmp;
            } else {
                bcd[i / 2] |= (byte) (tmp << 4);
            }

            num /= 10;
        }
//        System.out.println();
        for(int t=0;t<size;t++)
        {
//        	System.out.print("-"+BCDtoString(bcd[t]));
        }
//        System.out.println();
        //make a hexStringToByte func
        
        /*String full = Converters.asciiToHex("255");
	    String quater = full.substring(6);
	    byte [] t1 = Converters.hexStringToByteArray(quater);*/
        
        byte [] t1 = HexAscii.hexStringToByteArray(HexAscii.asciiToHex("255").substring(6));
        byte tmp = t1[0];
        
        for (int j = i; j < size2; j++) {
            
            if (j % 2 == 0) {
            	bcd[j / 2] = tmp;
            } else {
            	bcd[j / 2] |= (byte) (tmp << 4);
            }

            }
        for(int t=0;t<size;t++)
        {
//        	System.out.print("-"+BCDtoString(bcd[t]));
        }//System.out.println();

        for (int l=0;l<size;l++)
        {
        	byte m = (byte)(bcd[l]);
        	byte n = (byte)(bcd[l]);
        	byte a = (byte)(m<<4);
        	byte b = (byte)(n>>>4);
//        	System.out.print("before"+BCDtoString(bcd[l]));
        	bcd[l] = (byte) (a|b);
//        	System.out.print(" a - "+BCDtoString(a)+" b - "+BCDtoString(b)+" byte after- "+BCDtoString(bcd[l]));
//        	System.out.println();
        	
        }
        for(int t=0;t<size;t++)
        {
//        	System.out.print("-"+BCDtoString(bcd[t]));
        }
//       System.out.println();
  /*      System.out.println();
 
        for (int k = 0; k < size / 2; k++) {
        	
            byte b = bcd[k];
            bcd[k] = bcd[size - k - 1];
            bcd[size - k - 1] = b;
        }*/
        
/*        for(int t=0;t<size;t++)
        {
        	System.out.print("-"+BCDtoString(bcd[t]));
        }
        System.out.println();
        for (int l=0;l<size;l++)
        {
        	System.out.print("before"+BCDtoString(bcd[l]));
        	byte a = (byte)(bcd[l]<<4);
        	byte b = (byte)(bcd[l]>>4);
        	bcd[l] = (byte) (a|b);
        	System.out.print("a - "+BCDtoString(a)+"b - "+BCDtoString(b)+"byte - "+BCDtoString(bcd[l]));
        	System.out.println();
        }
        for(int t=0;t<size;t++)
        {
        	System.out.print("-"+BCDtoString(bcd[t]));
        }*/

        return bcd;
    }
	
    public static byte[] 	DecimalTofilledBCDSwap(long num,char filler,int size) {
        int digits = 0;
        int size2 = 2*size;
        
        long temp = num;
        while (temp != 0) {
            digits++;
            temp /= 10;
        }
        temp = num;
        //Manage more fillers
        //char byteLen = digits % 2 == 0 ? 'E' : 'O';

        byte bcd[] = new byte[size];
        
        int i = 0;
        for (i = 0; i < digits; i++) {
            byte tmp = (byte) (num % 10);

            if (i % 2 == 0) {
                bcd[i / 2] = tmp;
            } else {
                bcd[i / 2] |= (byte) (tmp << 4);
            }

            num /= 10;
        }
        byte [] t1 = HexAscii.hexStringToByteArray(HexAscii.asciiToHex("255").substring(6));
        byte tmp = t1[0];
        byte t2s = (byte) (tmp<<4);
        
        if(digits%2 != 0)
        {
        	bcd[i / 2] |= (byte) (t2s);
        	i++;
        }
        
        for(int t=0;t<size;t++)
        {
//        	System.out.print("-"+BCDtoString(bcd[t]));
        }
//        System.out.println();
        //make a hexStringToByte func

        
        for (int j = i; j < size2; j++) {
            
        		bcd[j/2] = (byte)tmp;
        		j++;

            }

        for(int t=0;t<size;t++)
        {
//        	System.out.print("-"+BCDtoString(bcd[t]));
        }
//        System.out.println();

        return bcd;
    }
	
    public static byte[] 	DecimalTofilledBCDSwap(String number,char filler,int size)
    {
    	//add code for string null check
    	Long num = Long.parseLong(new StringBuilder(number).reverse().toString());
    	
    	int digits = 0;
        int size2 = 2*size;
        
        long temp = num;
        while (temp != 0) {
            digits++;
            temp /= 10;
        }
        temp = num;
        //Manage more fillers
        //char byteLen = digits % 2 == 0 ? 'E' : 'O';

        byte bcd[] = new byte[size];
        
        int i = 0;
        for (i = 0; i < digits; i++) {
            byte tmp = (byte) (num % 10);

            if (i % 2 == 0) {
                bcd[i / 2] = tmp;
            } else {
                bcd[i / 2] |= (byte) (tmp << 4);
            }

            num /= 10;
        }
        byte [] t1 = HexAscii.hexStringToByteArray(HexAscii.asciiToHex("255").substring(6));
        byte tmp = t1[0];
        byte t2s = (byte) (tmp<<4);
        
        if(digits%2 != 0)
        {
        	bcd[i / 2] |= (byte) (t2s);
        	i++;
        }
        
        for(int t=0;t<size;t++)
        {
//        	System.out.print("-"+BCDtoString(bcd[t]));
        }
//        System.out.println();
        //make a hexStringToByte func

        
        for (int j = i; j < size2; j++) {
            
        		bcd[j/2] = (byte)tmp;
        		j++;

            }

        for(int t=0;t<size;t++)
        {
//        	System.out.print("-"+BCDtoString(bcd[t]));
        }
//        System.out.println();

        return bcd;
    }
    
    public static byte[] 	DecimalToBCD(long num) {
        int digits = 0;

        long temp = num;
        while (temp != 0) {
            digits++;
            temp /= 10;
        }

        int byteLen = digits % 2 == 0 ? digits / 2 : (digits + 1) / 2;

        byte bcd[] = new byte[byteLen];

        for (int i = 0; i < digits; i++) {
            byte tmp = (byte) (num % 10);

            if (i % 2 == 0) {
                bcd[i / 2] = tmp;
            } else {
                bcd[i / 2] |= (byte) (tmp << 4);
            }

            num /= 10;
        }

        for (int i = 0; i < byteLen / 2; i++) {
            byte tmp = bcd[i];
            bcd[i] = bcd[byteLen - i - 1];
            bcd[byteLen - i - 1] = tmp;
        }

        return bcd;
    }

    
    public static byte[] 	DecimalStringToBCD(String number) {
        int digits = 0;
        long num = Long.parseLong(number);
        long temp = num;
        while (temp != 0) {
            digits++;
            temp /= 10;
        }

        int byteLen = digits % 2 == 0 ? digits / 2 : (digits + 1) / 2;

        byte bcd[] = new byte[byteLen];

        for (int i = 0; i < digits; i++) {
            byte tmp = (byte) (num % 10);

            if (i % 2 == 0) {
                bcd[i / 2] = tmp;
            } else {
                bcd[i / 2] |= (byte) (tmp << 4);
            }

            num /= 10;
        }

        for (int i = 0; i < byteLen / 2; i++) {
            byte tmp = bcd[i];
            bcd[i] = bcd[byteLen - i - 1];
            bcd[byteLen - i - 1] = tmp;
        }

        return bcd;
    }

    
    public static long BCDToDecimal(byte[] bcd) {
        return Long.valueOf(BCD.BCDtoString(bcd));
    }
    
    public static String BCDtoString(byte bcd) {
        StringBuffer sb = new StringBuffer();
        
        byte high = (byte) (bcd & 0xf0);
        high >>>= (byte) 4;    
        high = (byte) (high & 0x0f);
        byte low = (byte) (bcd & 0x0f);
        
        sb.append(high);
        sb.append(low);
        
        return sb.toString();
    }
    
    public static String BCDtoString(byte[] bcd) {
        StringBuffer sb = new StringBuffer();
    
        for (int i = 0; i < bcd.length; i++) {
            sb.append(BCDtoString(bcd[i]));
        }
    
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println("Testing DecimalToBCD:");
        BCD.testForValue(1L,        "00000001");
        BCD.testForValue(11L,       "00010001");
        BCD.testForValue(111L,      "0000000100010001");
        BCD.testForValue(1111L,     "0001000100010001");
        BCD.testForValue(11111L,    "000000010001000100010001");
        BCD.testForValue(42,        "01000010");
        BCD.testForValue(112233L,   "000100010010001000110011");
        BCD.testForValue(12345L,    "000000010010001101000101");
        BCD.testForValue(150110213312L,        "000101010000000100010000001000010011001100010010");
        System.out.println("\nTesting two way conversion using DecimalToBCD and back using BCDToDecimal:");
        BCD.testForValue(1L);
        BCD.testForValue(11L);
        BCD.testForValue(111L);
        BCD.testForValue(1111L);
        BCD.testForValue(11111L);
        BCD.testForValue(12983283L);
        BCD.testForValue(9832098349L);
        BCD.testForValue(150110213312L);
        
    }
    
    private static void testForValue(long val, String expected) {
        String binaryString = BCD.byteArrayToBinaryString(BCD.DecimalToBCD(val));
        System.out.print(String.format("Testing: %10d -> %30s %4s\n", val, binaryString, binaryString.equals(expected) ? "[OK]" : "[FAIL]"));
    }
    
    private static void testForValue(long val) {
        long newVal = BCD.BCDToDecimal(BCD.DecimalToBCD(val));
        
        System.out.print(String.format("Testing: %10d -> %30d %4s\n", val, newVal, newVal == val ? "[OK]" : "[FAIL]"));
    }
    
    private static String byteArrayToBinaryString(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (byte i : bytes) {
            String byteInBinary = String.format("%8s", Integer.toBinaryString(i)).replace(' ', '0');
            sb.append(byteInBinary);
        }
        return sb.toString();
    }








	/**
	 *2017
	 * @author Karam
	 */
}
