public class Date{
    private static final int DAYS_IN_REG_YEAR = 365;
    private static final int DAYS_IN_LEAP_YEAR = 366;
    private static final int LEAP_YEAR_START = 1900;

    public static long convToDays(int year, int month, int day){
        int y = LEAP_YEAR_START;
        Month m = Date.Month.values()[month - 1];
        long payload = (long)day;


        //Process Year Value
        if (year >= LEAP_YEAR_START){
            while (y < year){
               if (isLeapYear(y)){
                    payload += (long)DAYS_IN_LEAP_YEAR;
                } else {
                    payload += (long)DAYS_IN_REG_YEAR;
                } 
                y++;
            }
        } else {
            throw new IllegalArgumentException("Invalid Year entered");
        }

        //Process Month Value
        for (int i = 0; i < month - 1;i++){
            if(isLeapYear(year) && Date.Month.values()[i] == Month.FEB){
                payload += Date.Month.values()[i].days + 1;
            } else {
                payload += Date.Month.values()[i].days;
            }
        }
        return payload;
    }

    public static boolean isLeapYear(int year){
        if(year >= 1900 && (year % 4 == 0 && year % 100 != 0)){
            return true;
        } else {
            return false;
        }
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

        //CAL~Already exists under enum class[compareTO] made class to see how we would implement if required
        // public int diff(Month input){
        //     return this.ordinal() - input.ordinal();

        //     // if (this.ordinal() == input.ordinal()) {
        //     //     return 0;
        //     // } else if (this.ordinal() > input.ordinal()){
        //     //     return 1;
        //     // } else {
        //     //     return -1;
        //     // }
        // }
    }

    private int dayspan;
    private int year;
    private Month month;
    private int day;

// Constructors
    private Date(){
        this.dayspan = 0;
    }

    // new Date(2019, Month.AUG, 27); // absolute  CAL:(this is an absolute day, can you question what day this is?)
    public Date(int year, Month month, int day){
        this.year = year;
        this.day = day;
        this.month = month;
    }

    public Date(Month month){
        setMonth(month);
    }

    public Date(int input){
        this.dayspan = input;
    }
// End Constructors

// Methods
    public Date subtract(Date input){
        return null;
    }

    public Date subtract(int years, int months, int days){

        return null;
    }

    public Date diff(Date input){
        return null;
    }

    public Date add(int years, int months, int days){
        int y;
        int m;
        int d;

        // while (days > 31 && )

        return new Date(this.year + years);
    }

    public static void convFromDays(int days){

        int y = LEAP_YEAR_START;
        Month m = Month.JAN;

        while (days > DAYS_IN_REG_YEAR){
            if (isLeapYear(y)){
                days -= DAYS_IN_LEAP_YEAR;
            } else {
                days -= DAYS_IN_REG_YEAR;
            }
            y++;
        }

        while (days > 28){
            int mdays = m.days;
            if (isLeapYear(y) && m == Month.FEB){
                mdays += 1;
            }

            if (days - mdays > 0) {
                days -= mdays;
                m = Date.Month.values()[m.ordinal() + 1];
            } else {
                break;
            }
        }

        System.out.println(String.format("Y:%d, M:%s, D:%d", y, m.shortName, days ));
    }
// End Methods
    
// Getters and setters
    public int getDayspan(){
        return this.dayspan;
    }

    public int getYear(){
        return this.year;
    }

    public Month getMonth(){
        return this.month;
    }

    public int getDay(){
        return this.day;
    }

    public void setDayspan(int days){
        this.dayspan = days;
    }

    private void setYear(int year){
        this.year = year;
    }

    private void setMonth(Month month){
        this.month = month;
    }
// End Getters and setters

    @Override  
    public String toString(){
        // CAL: The below shows simplification 
        // return String.format("%s/%s/%s", this.year, String.valueOf(this.month.ordinal() + 1), this.day);
        // return this.getClass().getName() + '@' + Integer.toHexString(this.hashCode()) + '[' + this.year + "/" + String.valueOf(this.month.ordinal() + 1) + "/" + this.day + ']';
        // return this.getClass().getName() + '@' + Integer.toHexString(this.hashCode()) + '[' + String.format("%d/%d/%d", this.year, this.month.ordinal() + 1, this.day) + ']';
        return String.format("%s@%s[%4d/%02d/%02d]", this.getClass().getName(), Integer.toHexString(this.hashCode()), this.year, this.month.ordinal() + 1, this.day);
    }

    //TODO:
    //[] Update UML
    //[] Add getters
    //[] Add setters
    //[] Add ability to subtract dates(8/20/19) by (9/10/20, days)
    //[] Add ability to get the new date (8/20/19) if increased by days
    //[] Add ability to add/subtract days by days
    //[x] Add isLeapYear Method, to return boolean based on year entered
    //[x] Convert from days to date, need it to add/subtract

    /*
    - [x] Date will be set by year, month and day.
    - [x] The date can be set by year, month and date individually or as a whole.
    - [] Addition of years, months or days or another date to the current established date.
    - [] Any number of years, months or days can be added.
    - [] Subtraction of years, months, days or another date to the current established date.
    - [] Any number of years, months or days can be subtracted.
    - [] Difference in days between current established date and another given date.
    - [] Comparison between current established date and another given date.
        -1 if current established date is less than the other date.
        0 if both are equal.
        1 if current established date is greater than the other time.
    - [x] Conversion of a date to number of days.

    */


    //#################
    //#### Removed ####
    //#################

    // public Date add(Date input){
    //     return null;
    // }

    //CAL: Removed because you can't add two absolute Dates
    // public Date add(int years, int months, int days){
    //     return null;
    // }

}