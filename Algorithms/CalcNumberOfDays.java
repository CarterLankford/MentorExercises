public class CalcNumberOfDays{
	private static final int LEAPYEAR = 366;
	private static final int STANDARDYEAR = 365;
	//TODO :: 
	//1. Take user input for two values
	//2. Get the difference
	//3. 

	//**Math notes**
	// if divisable by <4,100,400> with no remainder is leap year

	//**Requirements**
	//year can't be below 1900
	//years can be input in any order

	//**Questions**
	// Is leap year? - contains how many leap years
	// Is at least one year difference?
	// Older than 1900?

	public static void main(String[] args) {
		int inputOne = Integer.parseInt(args[0]);
		int inputTwo = Integer.parseInt(args[1]);


		//Must only be two args, that aren't the same value, that are above 1900
		if (args.length == 2){
			if (inputOne >= 1900 && inputTwo >= 1900 && inputOne != inputTwo) {
				System.out.println("Valid input, good job fool");
				//from start to end increase a count for how many leap years
				// Here we will set the larger of the two input values to inputTwo. 
				// This will keep our variable creation low. 
				int lowerYear = 0;
				int higherYear = 0;
				int leapYearCount = 0;
				int regularYearCount = 0;


				if (inputOne > inputTwo)
				{
					inputOne = inputOne + inputTwo;
					inputTwo = inputOne - inputTwo;
					inputOne = inputOne - inputTwo;

				} 

				while(inputOne < inputTwo){
					if (inputOne % 4 == 0 && inputOne % 100 != 0){
						System.out.println(inputOne + " is learp year");
						leapYearCount++;
					} else {
						System.out.println(inputOne + " is normal year");
						regularYearCount++;
					}
					inputOne++;
				}

				System.out.println("Days: " + ((leapYearCount * LEAPYEAR) + (regularYearCount * STANDARDYEAR)) );

			} else {
				System.out.println("Illegal Vriable(s) Used" + "\nHint: (Var1 != Var2 && Var >= 1900)");
			}
		} else {
			System.out.println("Illegal ammout of varbiles entered (only enter two years)");
		}

		// if (inputOne >= 1900 && inputTwo >= 1900){

		// } else {
		// 	System.out.println("One of the val")
		// }


		// System.out.println("inputOne: " + args[0] + " " + "inputTwo: " + args[1]);

	}
}

