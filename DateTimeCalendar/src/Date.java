package priv.exercises.datetime;

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

        // //Process Month Value
        for (int i = 0; i < month - 1; i++){
            if(isLeapYear(year) && Date.Month.values()[i] == Month.FEB){
                payload += Date.Month.values()[i].days + 1;
            } else {
                payload += Date.Month.values()[i].days;
            }
        }

        return payload;
    }

    public static boolean isLeapYear(int year){
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
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

    public Date(int year, Month month, int day){
        setYear(year);
        setDay(day);
        setMonth(month);
    }

    public Date(Month month){
        setMonth(month);
    }

    public Date(int input){
        setDayspan(input);
    }
// End Constructors

// Methods
    public Date subtract(int years, int months, int days){
        //what if any number goes below zero?
        /*
        Order of opperation
        need to remove years -> months -> days
        - No negatives for input
        - should I make multiple objects and do years/months/days one by one or just have the extra logic
        - are the days greater than 365?
        */
        final int monthsInYear = 12;
        int modifiedYear = this.year;
        int modifiedMonth = this.month.ordinal() + 1;
        int modifiedDay = this.day;

        if (years >= 0 && months >= 0 && days >= 0) {
            //years
            //remove full years, from days that are greater than 366 and months greater than 12

            modifiedYear -= years;
            years = 0;
            while (years > 0 || months > 12 || days > 366) {
                if (months > monthsInYear) {
                    modifiedYear -= months / monthsInYear; // calculate how many full years to remove
                    months = months % monthsInYear;
                }

                if (isLeapYear(modifiedYear) && days >= DAYS_IN_LEAP_YEAR || !this.isLeapYear() && days >= DAYS_IN_REG_YEAR) {
                    days -= isLeapYear(modifiedYear) ? DAYS_IN_LEAP_YEAR : DAYS_IN_REG_YEAR;
                    modifiedYear--;
                }
            }

            //months
            //if subtraction takes us back a year
            if (modifiedMonth - months < 1) {
                modifiedYear--;
                modifiedMonth = (modifiedMonth - months) + monthsInYear; // I wanted to use the cool new if statement, but couldn't figure out how to do modulas plus subtract a year. 
            } else {
                modifiedMonth -= months;
            }

            //days
            //lets make it simple and just remove month by month, can simplify later
            // May/5/1950 - 0, 0, 50
            while (days > 0) {
                int currentDaysInMonth = isLeapYear(modifiedYear) && modifiedMonth == 2 ? Date.Month.values()[modifiedMonth - 1].days + 1 : Date.Month.values()[modifiedMonth - 1].days;

                //5 - 50 !> 0
                if (modifiedDay - days > 0){
                    modifiedDay -= days;
                    break;
                } else if (days - modifiedDay > 0 || modifiedDay == days) {
                    //If there are more days than are days in this month or if modified days and days to subtract are the same, which would cause it to roll back to the end of the prior month
                    days -= modifiedDay; //50 - 5 = 45 days

                    //reduce month by 1
                    if (modifiedMonth - 1 < 1) {
                        //if month goes from JAN to DEC
                        modifiedYear--;
                        modifiedMonth = monthsInYear;
                    } else {
                        modifiedMonth--;
                    }
                    //New date for full amount of days in APR 1950
                    modifiedDay = isLeapYear(modifiedYear) && modifiedMonth == 2 ? Date.Month.values()[modifiedMonth - 1].days + 1 : Date.Month.values()[modifiedMonth - 1].days;

                } 
            }




            // //original
            // while (days > 0) {
            //     int currentDaysInMonth = isLeapYear(modifiedYear) && modifiedMonth == 2 ? Date.Month.values()[modifiedMonth - 1].days + 1 : Date.Month.values()[modifiedMonth - 1].days;
            //     if (modifiedDay - 1 == 0) {
            //         if (modifiedMonth - 1 < 1) {
            //             modifiedYear--;
            //             modifiedMonth = monthsInYear;
            //         } else {
            //             modifiedMonth--;
            //         }
            //         currentDaysInMonth = isLeapYear(modifiedYear) && modifiedMonth == 2 ? Date.Month.values()[modifiedMonth - 1].days + 1 : Date.Month.values()[modifiedMonth - 1].days;   
            //         modifiedDay = currentDaysInMonth; 
            //     } else {
            //         modifiedDay--;
            //     }
            //     days--;
            // }

            // modifiedDay -= days;
            return new Date(modifiedYear, Date.Month.values()[modifiedMonth - 1], modifiedDay);
        } else {
            throw new IllegalArgumentException("Invalid integer entered");
        }
        // return new Date(modifiedYear, Date.Month.values()[modifiedMonth - 1], modifiedDay);

        // int y = this.year;
        // int m = this.month.ordinal() + 1;
        // int d = this.day;


        // if (years >= 0 && months >= 0 && days >= 0) {
        //     y -= years;
            
        //     if (m - months < 1){
        //         while (m - months < 1){
        //             y--;
        //             months -= 12;
        //         }
        //     }
        //     m -= months;

        //     if (d - days < 1){
        //         while(d - days < 1) {
        //             if (m - 1 < 1){
        //                 y--;
        //                 m = 12;
        //             } else {
        //                 m--;
        //             }

        //             if (m == 2) {
        //                 if (isLeapYear(y)) {
        //                     days -= Date.Month.values()[m - 1].days + 1;
        //                 }
        //             } 

        //             days -= Date.Month.values()[m - 1].days;
        //         }
        //     } 
        //     d -= days;
        // } else {
        //     throw new IllegalArgumentException("Invalid input");
        // }
        
        //Returning new object is a design decision. Unsure if new object or reference would be needed, to play it safe returning new obj. Example: returning vacation days might need to be a new hash.
        // return new Date(y, Date.Month.values()[m - 1], d);
    }

    public int diff(Date input){
        //return in value of days
        int payload = 0;
        int currentDays = (int)convToDays(this.year, this.month.ordinal() + 1, this.day);
        int inputDays = (int)convToDays(input.year, input.month.ordinal() + 1, input.day);

        payload = Math.abs(currentDays - inputDays);
        return payload;
    }

    public Date add(int years, int months, int days){

        if (years >= 0 && months >= 0 && days >= 0){
            years += this.year;
            months += this.month.ordinal() + 1;
            days += this.day;

            //handle Months
            if (months > 12) {
                years += months / 12;
                months = months % 12;
            }
            //set months back to 0-11
            months--;

            while (days > 27){
                int currentMonthDayCount = Date.Month.values()[months].days;
                if (months == 1 && Date.isLeapYear(years)){
                    currentMonthDayCount++;
                }

                if (days > currentMonthDayCount){
                    if (days > DAYS_IN_REG_YEAR){
                        days -= isLeapYear(years) ? DAYS_IN_LEAP_YEAR : DAYS_IN_REG_YEAR;
                        years++;
                    } else {
                        days -= currentMonthDayCount;
                        months = (months + 1) % 12;
                    }
                } else {
                    break;
                }
            }
            return new Date(years, Date.Month.values()[months], days);
        } else {
            throw new IllegalArgumentException("Invalid integer entered");
        }
    }

    public Date convFromDays(int days){

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

        // System.out.println(String.format("Y:%d, M:%s, D:%d", y, m.shortName, days ));
        return new Date(y, m, days);
    }

    public int compareTo(Date input){
        long thisDays = convToDays(this.year, this.month.ordinal() + 1, this.day);
        long inputDays = convToDays(input.year, input.month.ordinal() + 1, input.day);

        if (thisDays == inputDays){
            return 0;
        } else if (thisDays > inputDays){
            return 1;
        } else {
            return -1;
        }
    }

    public boolean isLeapYear(){
        return this.year % 4 == 0 && (this.year % 100 != 0 || this.year % 400 == 0);
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

    private void setDay(int day) {
        this.day = day;
    }
// End Getters and setters

    @Override  
    public String toString(){
        // CAL: The below shows simplification 
        // return String.format("%s/%s/%s", this.year, String.valueOf(this.month.ordinal() + 1), this.day);
        // return this.getClass().getName() + '@' + Integer.toHexString(this.hashCode()) + '[' + this.year + "/" + String.valueOf(this.month.ordinal() + 1) + "/" + this.day + ']';
        // return this.getClass().getName() + '@' + Integer.toHexString(this.hashCode()) + '[' + String.format("%d/%d/%d", this.year, this.month.ordinal() + 1, this.day) + ']';

        //Removed the has part, it's crowding all my tests with garbage. 
        // return String.format("%s@%s[%4d/%02d/%02d]", this.getClass().getName(), Integer.toHexString(this.hashCode()), this.year, this.month.ordinal() + 1, this.day);
        return String.format("[%4d/%02d/%02d]", this.year, this.month.ordinal() + 1, this.day);
    }

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

    // public Date subtract(Date input){
    //     //return new date obj
    //     //translate both into days, subtract and convert back to date. 
    //     // This is the same as diff, removing this and keeping diff
    //     return null;
    // }

}