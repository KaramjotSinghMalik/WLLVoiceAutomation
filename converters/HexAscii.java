package converters;

public class HexAscii {

	public static final int PAD_LIMIT = 8192;
	public static final String EMPTY = "";
	


	public static String asciiToHex(String asciiValue)
	{	
		
	      int num =Integer.parseInt(asciiValue);
	        
	      // calling method toHexString()
	      String str = Integer.toHexString(num);
	      str = leftPad(str, 8, '0');
	      
	      //System.out.println("Decimal to hexadecimal: "+str);
	    
	
	      return str.toString();
	}
	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	   // System.out.println(data);
	    return data;
	}
	
	public static byte[] hexStringToByteArray(String s,int size) {
		int len = s.length();
		byte[] data = new byte[size];//											byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	   // System.out.println(data);
	    return data;
	
	}
	
	// from StringUtils lib
	 public static String leftPad(final String str, final int size, final char padChar) {
		        if (str == null) {
		            return null;
		        }
		        final int pads = size - str.length();
		        if (pads <= 0) {
		            return str; // returns original String when possible
		        }
		        return repeat(padChar, pads).concat(str);
		    }
	 public static String repeat(final String str, final int repeat) {
		        // Performance tuned for 2.0 (JDK1.4)
		
		        if (str == null) {
		            return null;
		        }
		        if (repeat <= 0) {
		            return HexAscii.EMPTY;
		        }
		        final int inputLength = str.length();
		        if (repeat == 1 || inputLength == 0) {
		            return str;
		        }
		        if (inputLength == 1 && repeat <= HexAscii.PAD_LIMIT) {
		            return repeat(str.charAt(0), repeat);
		        }
		
		        final int outputLength = inputLength * repeat;
		        switch (inputLength) {
		            case 1 :
		                return repeat(str.charAt(0), repeat);
		            case 2 :
		                final char ch0 = str.charAt(0);
		                final char ch1 = str.charAt(1);
		                final char[] output2 = new char[outputLength];
		                for (int i = repeat * 2 - 2; i >= 0; i--, i--) {
		                    output2[i] = ch0;
		                    output2[i + 1] = ch1;
		                }
		                return new String(output2);
		            default :
		                final StringBuilder buf = new StringBuilder(outputLength);
		                for (int i = 0; i < repeat; i++) {
		                    buf.append(str);
		                }
		                return buf.toString();
		        }
		    }
	 public static String repeat(final char ch, final int repeat) {
		         if (repeat <= 0) {
		             return HexAscii.EMPTY;
		         }
		         final char[] buf = new char[repeat];
		         for (int i = repeat - 1; i >= 0; i--) {
		             buf[i] = ch;
		         }
		         return new String(buf);
		     }
	 public static String rightPad(final String str, final int size, final char padChar) {
		         if (str == null) {
		             return null;
		         }
		         final int pads = size - str.length();
		         if (pads <= 0) {
		             return str; // returns original String when possible
		         }
		         return str.concat(repeat(padChar, pads));
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
	        return Long.valueOf(HexAscii.BCDtoString(bcd));
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
	        HexAscii.testForValue(1L,        "00000001");
	        HexAscii.testForValue(11L,       "00010001");
	        HexAscii.testForValue(111L,      "0000000100010001");
	        HexAscii.testForValue(1111L,     "0001000100010001");
	        HexAscii.testForValue(11111L,    "000000010001000100010001");
	        HexAscii.testForValue(42,        "01000010");
	        HexAscii.testForValue(112233L,   "000100010010001000110011");
	        HexAscii.testForValue(12345L,    "000000010010001101000101");
	        HexAscii.testForValue(150110213312L,        "000101010000000100010000001000010011001100010010");
	        System.out.println("\nTesting two way conversion using DecimalToBCD and back using BCDToDecimal:");
	        HexAscii.testForValue(1L);
	        HexAscii.testForValue(11L);
	        HexAscii.testForValue(111L);
	        HexAscii.testForValue(1111L);
	        HexAscii.testForValue(11111L);
	        HexAscii.testForValue(12983283L);
	        HexAscii.testForValue(9832098349L);
	        HexAscii.testForValue(150110213312L);
	        
	    }
	    
	    public static void testForValue(long val, String expected) {
	        String binaryString = HexAscii.byteArrayToBinaryString(HexAscii.DecimalToBCD(val));
	        System.out.print(String.format("Testing: %10d -> %30s %4s\n", val, binaryString, binaryString.equals(expected) ? "[OK]" : "[FAIL]"));
	    }
	    
	    public static void testForValue(long val) {
	        long newVal = HexAscii.BCDToDecimal(HexAscii.DecimalToBCD(val));
	        
	        System.out.print(String.format("Testing: %10d -> %30d %4s\n", val, newVal, newVal == val ? "[OK]" : "[FAIL]"));
	    }
	    
	    public static String byteArrayToBinaryString(byte[] bytes) {
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
