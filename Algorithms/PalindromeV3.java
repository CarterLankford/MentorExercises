class PalindromeV3{
	public static void main(String[] args){
		String strStartingString = "a man a plan a canal panama";
		boolean isPalindrom = true;
		char checkString[] = strStartingString.toCharArray(); 
		int n = strStartingString.length();
		int j = (int)Math.floor((double)strStartingString.length() / 2);

		for (int i = 0; i < j; i++){
			int last = n - 1 - i;
			if (checkString[i] != checkString[last]){
				isPalindrom = !isPalindrom;
				break;
			}
		}
		System.out.println("Is Palindrome: " + isPalindrom);
	}
}
