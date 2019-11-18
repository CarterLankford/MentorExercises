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
		System.out.println("2100, " + calcFirstDayOfYear(2100));
		System.out.println("2200, " + calcFirstDayOfYear(2200));
		System.out.println("2500, " + calcFirstDayOfYear(2500));
		// System.out.println(101%2==0);

		//GOAL: calculate day of week for 1/1/y = year
		//x=?
		//where x is day of week
		//1.) calculate initial offset
		//2.) isLeapYear
		//3.) number of days from start of the year until x
		//4.) x % 7



	}

	//calculate first day of year
	public static String calcFirstDayOfYear(int year) {
		int leapYearCount;
		int realativeYear;

		realativeYear = year - 1900; //We consider 1900 the first year ever
		leapYearCount = (realativeYear - 1) / 4; //Calculate number of leap years

		//Loop to check for tricky centry leap years, we are asking for at least 2100
		if (realativeYear >= 200) {

			//realiveYear since 2100 without the intended year
			int realitiveYearPost2k = realativeYear - 100 - 1;

			//we get the century years (which are already divisible by 4 but shouldn't be counted as leap years -- note that this include also the four-hundred years)
			int leapCenturyYears = realitiveYearPost2k / 100;

			//we get the multiples of four-hundred (which should actually be counted as leap) 
			int leap4CenturyYears = realitiveYearPost2k / 400;

			//we do an intermediate calculation (to determine how many leap years we counted wrong)
			int invalidLeapYears = leapCenturyYears - leap4CenturyYears;

			//then we subtract those from the valid number of leap years
			leapYearCount -= invalidLeapYears;

		}
		
		realativeYear += leapYearCount + 1; //Calculate date offset since 1900
		realativeYear %= 7; //By doing modulas of 7 and gaining the ramainder we will know the day of the week

		return DayOfWeek.values()[realativeYear].longName;
	}

	public static boolean isLeapYear(int year) {
		return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
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