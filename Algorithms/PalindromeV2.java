class PalindromeV2{
	public static void main(String[] args){
		String strStartingString = "aabbccddccbbaa";
		boolean isPalindrom = true;
		int checkLeft = 0; //will be used to check letters on the left side of the string
		int checkRight = 0; //will be used to check letters on the right side of the string
		char checkString[] = strStartingString.toCharArray(); 

        //will start with the outskirts and work its way in, if ever false will fail out and adjust the boolean value
		for(checkLeft = 0, checkRight = strStartingString.length() - 1; checkLeft < checkRight; checkLeft++, checkRight--){
			if (checkString[checkLeft] != checkString[checkRight]) {
				isPalindrom = false;
				break;
			}
		}

		System.out.println("Is Palindrome: " + isPalindrom);
		
	}
}
