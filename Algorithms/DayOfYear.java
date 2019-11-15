class DayOfYear{
	public static void main(String[] args) {
		for (int i = 1980; i <= 2000; i++) {
			// System.out.println(i + ", " + i%7);
			// System.out.println(i + ", " + isLeapYear(i));
		}
		// System.out.println("1900, " + isLeapYear(1900));
		// System.out.println("2100, " + isLeapYear(2100));
		// System.out.println("2200, " + isLeapYear(2200));
		// System.out.println("2300, " + isLeapYear(2300));
		// System.out.println("2400, " + isLeapYear(2400));

		// System.out.println(DayOfWeek.values()[0].longName);

		System.out.println("1900, " + calcFirstDayOfYear(1900));
		System.out.println("1901, " + calcFirstDayOfYear(1901));
		System.out.println("2005, " + calcFirstDayOfYear(2005));
		System.out.println("2200, " + calcFirstDayOfYear(2200));
		// System.out.println(101%2==0);

		//GOAL: calculate day of week for 1/1/y = year
		//x=?
		//where x is day of week
		//1.) calculate initial offset
		//2.) isLeapYear
		//3.) number of days from start of the year until x
		//4.) x % 7

		//after doing the math to find out how many leap years there will be run a check on 
		//each of them to confirm they are in fact leap years



	}

	//calculate first day of year
	//calcFirstDayOfYear()
	public static String calcFirstDayOfYear(int year) {
		int leapYearCount;
		int payload;

		payload = year - 1900; //We consider 1900 the first year ever
		leapYearCount = payload / 4; //Calculate number of leap years
		
		//validate leapYearCount; 25 leap years puts us at the year 2000
		if (leapYearCount > 25) {
			int validateLeapYearCount = 24; //reduced by one since we are checking 2000 at start

			for (int i = 2000; i <= year; i++) {
				//check to see if divisable by 4 before checking isLeapYear, 
				if (i % 4 == 0) {
					if (isLeapYear(i)) {
						validateLeapYearCount++;
					}
				}
			}

			if (leapYearCount != validateLeapYearCount) {
				leapYearCount = validateLeapYearCount;
			}
		}
		
		payload += leapYearCount + 1; //Calculate date offset since 1900
		payload = payload % 7; //By doing modulas of 7 and gaining the ramainder we will know the day of the week


		// payload = 0;

		return DayOfWeek.values()[payload].longName;
	}

	public static boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public enum DayOfWeek {
		SUN("Sunday"),
		MON("Monday"),
		TUE("Tuesday"),
		WED("Wednesday"),
		THR("Thursday"),
		FRI("Friday"),
		SAT("Saturday"),
		;

		public final String longName;

		private DayOfWeek(final String longName){
			this.longName = longName;
		}
	}
}