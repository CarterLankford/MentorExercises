public class CalcNumberOfDays{
    private static final int LEAPYEAR = 366;
    private static final int STANDARDYEAR = 365;

    // java CalcNumberOfDays 1800 2000 1>output.txt 2>error.txt

    public static void main(String[] args) {
        //Validate that only two arguments are entered
        if (args.length <= 1 || args.length >= 3) {
            throw new IllegalArgumentException("Illegal amout of variables entered. \nHint: Can compare only two year values");
        } else {
            int inputOne = 0;
            int inputTwo = 0;

            //Validates that arguments entered are in int format
            try {
                inputOne = Integer.parseInt(args[0]);
                inputTwo = Integer.parseInt(args[1]);
            } catch (NumberFormatException exception) {
                // exception.printStackTrace();
                throw new IllegalArgumentException("Illegal Variable(s) format. \nHint: Expecting two int values at or above 1900");
            }

            if (inputOne >= 1900 && inputTwo >= 1900) {
                int leapYearCount = 0;
                int regularYearCount = 0;

                // This is another possibility:  (CNote: when doing the transition both variables aren't being carried over)
                // System.out.println("I1: " + inputOne + "\tI2: " + inputTwo);
                // inputOne = Math.min(inputOne, inputTwo);
                // inputTwo = Math.max(inputOne, inputTwo);
                // System.out.println("I1: " + inputOne + "\tI2: " + inputTwo);

                //Rather than creating additional variables, inputOne will be set to the lower year
                //and inputTwo will become the higher year.
                if (inputOne > inputTwo) {
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
                throw new IllegalArgumentException("Illegal Vriable(s) Used \nHint: (Var >= 1900)");
            }

        }
    }
    /*
    // Unit testing commands; to be run in cmd.  
    // QUESTION: How can I make a class to do this?
    // coverage min, middle, max, negative, zero, float, string, to many input, not enough input

    java CalcNumberOfDays 1900 1900;  echo ""; echo ""; java CalcNumberOfDays 1900 2005; echo ""; echo ""; java CalcNumberOfDays 1899 1899; echo ""; echo ""; java CalcNumberOfDays 0 0; echo ""; echo ""; java CalcNumberOfDays -1 -1; echo ""; echo ""; java CalcNumberOfDays 1900 1900000; echo ""; echo ""; java CalcNumberOfDays 1900.2 1900.1; echo ""; echo ""; java CalcNumberOfDays bob jerry; echo ""; echo ""; java CalcNumberOfDays 1900 1900 2005; echo ""; echo ""; java CalcNumberOfDays 1900; echo ""; echo "";

    */
}

