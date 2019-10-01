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

    private long days;

    private int year;
    private Month month;
    private int day;

    private Date(){
        this.days = 0l;
    }

// new Date(2019, Month.AUG, 27); // absolute  CAL:(this is an absolute day, can you question what day this is?)
    private Date(int year, Month month, int day){
        //TODO: think on how to tackel this....best I can do right now...at least it's "something"?
    }

// new Date(90); CAL(a span of time)
    public Date(long days){
        this.days = days;
    }

// new Date(3, 4, 2); // relative CAL:(remember the definition of relative, this depends on something else to makes sense/ do you know if leap or which months?)
    public Date(int years, int months, int days){
        //TODO:
        //[] Month will need to be translated into Month, use month number -1 with index to achieve
        this.year = years;
        setMonth(months);
        this.day = days;
    }

    public Date subtract(Date input){
        return null;
    }

    public Date subtract(int years, int months, int days){
        return null;
    }

    public Date diff(Date input){
        return null;
    }

    public Date add(Date input){
        return new Date(this.days + input.days);
    }

    public long getDays(){
        return this.days;
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

    private void setDays(long days){
        this.days = days;
    }

    private void setYear(int year){
        this.year = year;
    }

    private void setMonth(int months){
        if (months <= 12 && months >= 1) {
            this.month = Month.values()[months-1];
        }
    }

    private void setDay(int day){
        this.day = day;
    }



    @Override  
    public String toString(){
        return Integer.toString(this.month.ordinal() + 1) + "/" + this.day + "/" + this.year;
    }

    //TODO:
    //[] Update UML
    //[] Add getters
    //[] Add setters
    //[] Add ability to subtract dates(8/20/19) by (9/10/20, days)
    //[] Add ability to get the new date (8/20/19) if increased by days
    //[] Add ability to add/subtract days by days
    //[] Add isLeapYear Method, to return boolean based on year entered


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