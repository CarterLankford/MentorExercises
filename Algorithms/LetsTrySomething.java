public class LetsTrySomething{

	public static void main(String[] args){
		char tmp1 = 'A';
		char tmp2 = 'a';
		char tmp3 = 'Z';
		char tmp4 = 'z';
		char tmp5 = '0';
		char tmp6 = '9';

		System.out.println(tmp1);
		System.out.println((int)tmp1);
		System.out.println(Integer.toHexString((int)tmp1));

		System.out.println(tmp1 + ": " + "int: " + (int)tmp1 + ", hex: " + Integer.toHexString((int)tmp1));
		System.out.println(tmp2 + ": " + "int: " + (int)tmp2 + ", hex: " + Integer.toHexString((int)tmp2));
		System.out.println(tmp3 + ": " + "int: " + (int)tmp3 + ", hex: " + Integer.toHexString((int)tmp3));
		System.out.println(tmp4 + ": " + "int: " + (int)tmp4 + ", hex: " + Integer.toHexString((int)tmp4));
		System.out.println(tmp5 + ": " + "int: " + (int)tmp5 + ", hex: " + Integer.toHexString((int)tmp5));
		System.out.println(tmp6 + ": " + "int: " + (int)tmp6 + ", hex: " + Integer.toHexString((int)tmp6));
		


		char testFunctionVar = tmp1;
		System.out.println(testFunctionVar);
		if ((int)testFunctionVar >= 65 && (int)testFunctionVar <= 90){
			//capital to lower
			System.out.println("Capatal");
			System.out.println("Before: " + testFunctionVar + " After: " + (char)((int)testFunctionVar + 32));
		} else if ((int)testFunctionVar >= 97 && (int)testFunctionVar <= 122) {
			//lower to capital
			System.out.println("Lower case");
		} else {
			System.out.println("Other");
		}

		int tstChar = Sanitize((int)tmp6);
		System.out.println((char)tstChar);


		//creating test loop for sanitize function
		for (int i=0; i <= 255; i++){
			if (Sanitize(i) != -1){
				System.out.println("I is equal to: " + i + " Sanitized:" + (char)Sanitize(i));	
			} else {
				System.out.println("I is equal to: " + i + " Sanitized:" + Sanitize(i));	
			}
			
		}


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