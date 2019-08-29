public class Date{
    private static final int DAYS_IN_REG_YEAR = 365;
    private static final int DAYS_IN_LEAP_YEAR = 366;
    private static final int LEAP_YEAR_START = 1900;

    public static long convToDays(int year, int month, int day){
        return 0l;
    }

    public enum Month {
        JAN("Jan", "January", 31),
        FEB("Feb", "Febuary", 28),
        MAR("Mar", "March", 31),
        APR("Apr", "April", 30),
        MAY("May", "May", 31),
        JUN("Jun", "June", 30),
        JUL("Jul", "July", 31),
        AUG("Aug", "August", 31),
        SEP("Sep", "September", 30),
        OCT("Oct", "October", 31),
        NOV("Nov", "November", 30),
        DEC("Dec", "December", 31),
        ;

        public final String shortName;
        public final String longName;
        public final int days;

        private Month(final String shortName, final String longName, final int days){
            this.shortName = shortName;
            this.longName = longName;
            this.days = days;
        }
    }

    private long days;
    private int year;

    private Date(){

    }

// new Date(2019, Month.AUG, 27); // absolute  CAL:(this is an absolute day, can you question what day this is?)
    private Date(int year, Month month, int day){

    }

// new Date(90); CAL(a span of time)
    public Date(long days){

    }

// new Date(3, 4, 2); // relative CAL:(remember the definition of relative, this depends on something else to makes sense/ do you know if leap or which months?)
    public Date(int years, int months, int days){

    }

    // public Date add(Date input){
    //     return null;
    // }

    public Date add(int years, int months, int days){
        return null;
    }

    public Date subtract(Date input){
        return null;
    }

    public Date subtract(int years, int months, int days){
        return null;
    }
}