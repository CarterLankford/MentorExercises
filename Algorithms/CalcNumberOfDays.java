public class CalcNumberOfDays{
	private static final int LEAPYEAR = 366;
	private static final int STANDARDYEAR = 365;

	// java CalcNumberOfDays 1800 2000 1>output.txt 2>error.txt

	public static void main(String[] args) {
		int inputOne = Integer.parseInt(args[0]);
		int inputTwo = Integer.parseInt(args[1]);


		//Must only be two args, that aren't the same value, that are above 1900
		if (args.length == 2){
			if (inputOne >= 1900 && inputTwo >= 1900 && inputOne != inputTwo) {
				int leapYearCount = 0;
				int regularYearCount = 0;

				// This is another possibility:
				// inputOne = Math.min(inputOne, inputTwo);
				// inputTwo = Math.max(inputOne, inputTwo);

				//Rather than creating additional variables, inputOne will be set to the lower year
				//and inputTwo will become the higher year. 
				if (inputOne > inputTwo)
				{
					inputOne = inputOne + inputTwo;
					inputTwo = inputOne - inputTwo;
					inputOne = inputOne - inputTwo;
				} 

				//Genearating how many normal/leap years will be included
				//Leap year calculation  year divisable by 4 without remainder and divisable by 100 with remainder
				while(inputOne < inputTwo){
					if (inputOne % 4 == 0 && inputOne % 100 != 0){
						leapYearCount++;
					} else {
						regularYearCount++;
					}
					inputOne++;
				}
				System.out.println("Days: " + ((leapYearCount * LEAPYEAR) + (regularYearCount * STANDARDYEAR)) );
			} else {
				//Error message response
				System.err.println("Illegal Vriable(s) Used" + "\nHint: (Var1 != Var2 && Var >= 1900)");
			}
		} else {
			//Error message response
			System.err.println("Illegal ammout of variables entered (only enter two years)");
		}
	}
}

