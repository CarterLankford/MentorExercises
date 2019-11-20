public class Calendar{
    /*
    Goals:
    - When created, indicate date and current day of the week (Monday, Tuesday, Wednesday, etc…)
    - Given another date tell which day of the week it was or it will be.
    - Calculate number of weeks within a month of a certain year. A week counts if all seven 
    days (monday to sunday) happen within the same month; if the month starts in the middle of 
    the week that week is not considered for the number returned by this method.
    */ 

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

    private int currentDayOfWeek;
    private Date date;

    private Calendar(){

    }

    public Calendar(Date date){
        setDate(date);
        setCurrentDayOfTheWeek(date);
    }

    public static int calcWeeksInMonth(Date date){
        //a week is considered mon-sun
        
        //Example: 3/1/1900
        int monthDayCount = date.getMonth().days; // 31

        //check for month feb and for leap year
        if (date.getMonth().ordinal() == 1 && Date.isLeapYear(date.getYear())) {
            monthDayCount++;
        }

        Date firstOfTheMonth = new Date(date.getYear(), date.getMonth(), 1); // creating obj to represent first of the month
        int firstWeekDayOfMonth = calcDayOfWeek(firstOfTheMonth); // calculate first week day of the month -> 4 (Thursday)

        //want to use first day of the month as a place holder while we tick ahead to tell us the day of the first monday
        int firstMondayOfMonth = 1; //Every month starts on day 1
        int dayCountToFirstMonday = firstWeekDayOfMonth; //want to preserve firstWeekDayOfMonth but need to have a value to incremtnt.

        //Validate if input isn't already 1 (Monday)
        if (firstWeekDayOfMonth != 1) {
            //counting until reaching Monday, since it includes 7, that would be equivelent on <= sunday. will run again equaling monday
            while (dayCountToFirstMonday <= 7) {
                firstMondayOfMonth++;
                dayCountToFirstMonday++;
            }
        }
        return (monthDayCount - firstMondayOfMonth) / 7; // full count minus the ammount of days until the first monday, then divid by 7 to get full week count
    }

    public static int calcDayOfWeek(Date date){
        int leapYearCount;
        int realativeYear;

        realativeYear = date.getYear() - 1900; //We consider 1900 the first year ever
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
        realativeYear %= 7; //By doing modulas of 7 and gaining the ramainder we will know the day of the week for the first day of the year

        //the above works only til the start of the year, this is what comes after if it's not 1/1
        if (date.getDay() > 1 || date.getMonth().ordinal() > 0) {
            int daysUntilCurrentDay = 0;

            //Count full count of days in each month until our partial month
            for (int i = 0; i < date.getMonth().ordinal(); i++) {
                daysUntilCurrentDay += Date.Month.values()[i].days;
            }

            //check for leap year and add a day if true
            if (Date.isLeapYear( date.getYear() ) && date.getMonth().ordinal() > 1 ) {
                daysUntilCurrentDay += date.getDay() + 1;
            } else {
                daysUntilCurrentDay += date.getDay();
            }

            //if the day is the first it will be added, here we trim that off so that our count is accurate. 
            realativeYear += daysUntilCurrentDay - 1;
            //adding to realitive and then taking the mod we can get an accurate day of the week
            realativeYear %= 7;
        }
        return realativeYear;
    }

    public Date getDate(){
        return this.date;
    }

    public int getCurrentDayOfTheWeek(){
        return this.currentDayOfWeek;
    }

    private void setDate(Date date){
        this.date = date;
    }

    private void setCurrentDayOfTheWeek(Date date){
        this.currentDayOfWeek = calcDayOfWeek(date);
    }
}