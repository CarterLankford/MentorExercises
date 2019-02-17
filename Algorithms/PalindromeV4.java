class PalindromeV4{
	public static void main(String[] args){
		boolean isPanlindrome = true;
		//Clean up the string
		String myString = "A man, a plan, a canal - Panama"; //Start here
		char chkString[] = myString.toCharArray();

		int x = myString.length();
		int y = (int)Math.floor((double)x / 2);


		int first = 0;
		int last = x - 1;

		while (first < y && last > first){ 

			while (Sanitize((int)chkString[first]) == -1){
				first++;
			}

			while(Sanitize((int)chkString[last]) == -1){
				last--;
			}

			System.out.println((char)Sanitize(chkString[first]) + " " + (char)Sanitize(chkString[last]) );
			System.out.println("when values are compared at the end, it will be first:" + first + " Last:" + last + "\n" );


			if (Sanitize(chkString[first]) != Sanitize(chkString[last])){
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
