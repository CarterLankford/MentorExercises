class PalindromeV5{
    public static void main(String[] args){
        boolean isPanlindrome = true;
        String myString = "A man, a plan, a canal - Panama";
        char[] chkStringChar = myString.toCharArray();      

        // had to count how many valid char before creating array, other wise array would 
        // have some null values.

        // int q = 0; // Will count the ammount of times a alpha numberic value appears
        // for (int i = 0; i < chkStringChar.length; i++) {
        //  int targetChar = Sanitize(chkStringChar[i]);
        //  if(targetChar != -1) {
        //      q++;
        //  }
        // }

        char[] sanitizedStringChar = new char[chkStringChar.length]; 

        int j = 0; //Keep track of the sanitized array size
        for (int i = 0; i < chkStringChar.length; i++) {
            int targetChar = Sanitize(chkStringChar[i]);
            if(targetChar != -1) {
                sanitizedStringChar[j++] = (char)targetChar;
            }
        }

        int x = j; //need to know max ammount of times to count
        int y = (int)Math.floor((double)x / 2); // to show halfway point
        x -= 1;
        for (int i = 0; i < y; i++) {
            int last = x - i;
            // could add an if to check if either is null and if so bypass the if check and
            // then dn't check until its two valid char, could do a -- for the non null, to 
            // keep it in the same spot
            if (sanitizedStringChar[i] != sanitizedStringChar[last]) {
                isPanlindrome = false;
                break;
            }
        }
        System.out.println("Is Palindrome: " + isPanlindrome);

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
