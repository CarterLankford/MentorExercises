class PalindromeV2{
//Goal is to rewrite this algorithm with less created objects. 

/* TODO

• will need to compare first and last char and then move to the center of the word. 
• will need to know if string is even or odd
• which loops will be used most, try to base the first checks based on this. 
 :: Remember ::
 Use the right tool for the job to remove the most waste first. 

*/
	public static void main(String[] args){
		String strStartingString = "aabbccdccbbaa";
		boolean isPalindrom = true;

		int checkLeft = 0;
		int checkRight = strStartingString.length() - 1;
		//  A B B A
		// A B C B A
		// checkRight = 4 - 1 = 3

		/*
		int charsToCompare = Math.floor(strStartingString.length() / 2);

		//if (strStartingString.length() % 2 == 0){
		//	charsToCompare = strStartingString.length() / 2;
		//} else {
		//	charsToCompare = Math.floor(strStartingString.length() / 2);
		// 2.5 = 2
		//	2.8 = 2
		//	2.0 = 2
		//}

		for int i=0; i<charsToCompare; i++){
			if (checkString[checkLeft] == checkString[checkRight]) {
				// System.out.println(checkString[checkLeft] + " " + checkString[checkRight]);
				checkLeft++;
				checkRight--;
			} else {
				isPalindrom = false;
				break;
			}
		}
		*/


		char checkString[] = strStartingString.toCharArray(); 

		if ((checkRight % 2) > 0){
			//For odd length strings

			while(checkLeft < checkRight){
				if (checkString[checkLeft] == checkString[checkRight]) {
					// System.out.println(checkString[checkLeft] + " " + checkString[checkRight]);
					checkLeft++;
					checkRight--;
				} else {
					isPalindrom = false;
					break;
				}
			}
			System.out.println("Is Panindrome= " + isPalindrom);	
		} else {
			//For even length strings
			System.out.println("String length is even");
			while(checkLeft <= checkRight){
				if (checkString[checkLeft] == checkString[checkRight]) {
					// System.out.println(checkString[checkLeft] + " " + checkString[checkRight]);
					checkLeft++;
					checkRight--;
				} else {
					isPalindrom = false;
					break;
				}
			}
			System.out.println("Is Panindrome= " + isPalindrom);	
		}

		for(checkLeft = 0, checkRight = str.length() - 1; checkLeft < checkRight; checkLeft++, checkRight--){
			if (checkString[checkLeft] != checkString[checkRight]) {
				isPalindrom = false;
				break;
			}
		}
	}
}
