class PalindromeV4{
	public static void main(String[] args){
		boolean isPanlindrome = true;
		//Clean up the string
		String myString = "A man, a plan, a canal - Panama"; //Start here
		char chkString[] = myString.toCharArray();

		int x = myString.length();
		int y = (int)Math.floor((double)x / 2);

		/*...
		char[] myStringChr = myString.toCharArray();

		char[] cleanString = new char[](myStringChr.length);

		int j = 0;
		for (i = 0; myStringChr; i++) { 
			int cleanChar = Sanitize(myStringChr[i]);
			if(cleanChar != -1){
				cleanString[j++] = cleanChar;
			}
		}

		
		...*/


		int first = 0;
		int last = x - 1;

		while (first < y && last > first){ 

			int firstSanitized = Sanitize((int)chkString[first]);
			int lastSanitized = Sanitize((int)chkString[last])

			while (firstSanitized == -1){
				first++;
				firstSanitized = Sanitize((int)chkString[first]);
			}

			while(lastSanitized == -1){
				last--;
				lastSanitized = Sanitize((int)chkString[last])
			}

			System.out.println((char)firstSanitized + " " + (char)lastSanitized );
			System.out.println("when values are compared at the end, it will be first:" + first + " Last:" + last + "\n" );

			if (firstSanitized != lastSanitized){
				isPanlindrome = false;
				break;
			}

			first++;
			last--;
		}
		System.out.println(isPanlindrome);
	}

	private static int Sanitize(int inputChar){
		//To return lower case letter, 0-9, or -1
		int outputChar = inputChar;
		if (inputChar >= 48 && inputChar <= 122) {
			if(inputChar >= 65 && inputChar <= 90){
				//From Upper to Lower
				outputChar = inputChar + 32;
			} else if (inputChar >= 97 && inputChar <= 122 || inputChar >= 48 && inputChar <= 57) {
				//Returns lower or 0-9
				outputChar = inputChar;
			} else {
				//All other char will return -1
				outputChar = -1;
			}

			return outputChar;
		} else {
			return -1;
		}
	}
}
