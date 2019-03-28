class Palindrome{

    public static void main(String[] args){
        String strStartingString = "aabbccddccbaa";
        String strNewString = "";  
        boolean isPalindrome = false;
        int b = strStartingString.length() - 1;

        while (b >= 0){
            //System.out.println(strStartingString.charAt(b));
            strNewString = strNewString + strStartingString.charAt(b);
            b--;
        }

        isPalindrome = strStartingString.equals(strNewString);

        if (isPalindrome){
            System.out.println(strStartingString + " is a palindrome.");
        } else {
            System.out.println(strStartingString + " is not a palindrome.");
        }

    }
}
