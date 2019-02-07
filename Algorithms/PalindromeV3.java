class PalindromeV3{
	public static void main(String[] args){
		//Clean up the string
		String myString = "A man, a plan, a canal !- Panama"; //Start here
		String myOtherString = ""; // Initialize the string that will hold the cleaned up version of the myString value
		boolean isPalindrome = true; // Let's start by being optimistic 

		//Clean up myString value, removin all but alpha-numeric and add char to myOtherString
		for (char a : myString.toLowerCase().toCharArray()){
			if ((int)a >= 0x61 && (int)a <= 0x7A || (int)a >= 0x30 && (int)a <= 0x39) {
				// System.out.println(a);
				myOtherString = myOtherString + a;
			}
		}

		char chkString[] = myOtherString.toCharArray(); // Break apart cleaned string into char array to compare
		int x = myOtherString.length(); 
		int y = (int)Math.floor((double)x / 2); // finds if there is a remainder when spliting the string in half

		// Compare first and last char to see if they are the same, if so will move inward.
		for (int i = 0; i < y; i++) {
			int last = x - 1 - i;
			if (chkString[i] != chkString[last]) {
				isPalindrome = false;
				break;
			}
		}
		System.out.println("Is Palindrome: " + isPalindrome);








		// This is a copy of the above to show my original version before it's been reviewed. Goal is to compare before and after a little easier. 
		/*


		//Clean up the string
		String myString = "A man, a plan, a canal !- Panama"; //Start here
		String myOtherString = ""; // Initialize the string that will hold the cleaned up version of the myString value
		boolean isPalindrome = true; // Let's start by being optimistic 

		//Clean up myString value, removin all but alpha-numeric and add char to myOtherString
		for (char a : myString.toLowerCase().toCharArray()){
			if ((int)a >= 0x61 && (int)a <= 0x7A || (int)a >= 0x30 && (int)a <= 0x39) {
				// System.out.println(a);
				myOtherString = myOtherString + a;
			}
		}

		char chkString[] = myOtherString.toCharArray(); // Break apart cleaned string into char array to compare
		int x = myOtherString.length(); 
		int y = (int)Math.floor((double)x / 2); // finds if there is a remainder when spliting the string in half

		// Compare first and last char to see if they are the same, if so will move inward.
		for (int i = 0; i < y; i++) {
			int last = x - 1 - i;
			if (chkString[i] != chkString[last]) {
				isPalindrome = !isPalindrome;
				break;
			}
		}
		System.out.println("Is Palindrome: " + isPalindrome);

		
		*/
	}
}
