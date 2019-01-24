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

		char checkString[] = strStartingString.toCharArray(); 

		if ((checkRight % 2) > 0){
			//For odd length strings

			while(checkLeft < checkRight){
				if (checkString[checkLeft] == checkString[checkRight]) {
					System.out.println(checkString[checkLeft] + " " + checkString[checkRight]);
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
					System.out.println(checkString[checkLeft] + " " + checkString[checkRight]);
					checkLeft++;
					checkRight--;
				} else {
					isPalindrom = false;
					break;
				}
			}
			System.out.println("Is Panindrome= " + isPalindrom);	
		}

	}
}
