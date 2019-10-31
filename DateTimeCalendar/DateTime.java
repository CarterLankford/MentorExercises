public class DateTime{
    //GOAL
    /*
    [x] A date time is given by a date (defined by year, month and day) and a time 
       (in hours, minutes and seconds).
    [x] Set of date or time can be done individually or as a whole.
    [x] Addition to the current established DateTime by years, months, days, hours, 
       minutes or seconds or another DateTime.
    [] Subtraction to the current established DateTime by years, months, days, hours, 
        minutes or seconds or another DateTime.
    [] Given two DateTimes calculate the difference between them.
    */

    private Date date;
    private Time time;
    
    private DateTime(){

    }

//Constructors
    public DateTime(int year, Date.Month month, int day, int hour, int minute, int second) {
        setDate(year, month, day);
        setTime(hour, minute, second);
    }

    public DateTime (Date date, Time time) {
        setDate(date);
        setTime(time);
    }

    public DateTime(int year, Date.Month month, int day) {
        setDate(year, month, day);
    }

    public DateTime(int hour, int minute, int second) {
        setTime(hour, minute, second);
    }

    public DateTime(Date date) {
        setDate(date);
    }

    public DateTime(Time time) {
        setTime(time);
    }
//

//Methods
    //Won't do this, similar to design decision made in Date.add() at best this is arbitrary
    // public DateTime add(DateTime dateTime) {
    //     return null;
    // }

    public DateTime add(int years, int months, int days, int hours, int minutes, int seconds) {
        int combindSeconds = time.getSecond(true) + (hours * 3600 + minutes * 60 + seconds);
        int additionalDays = 0;

        if ( combindSeconds >= 86400) {
            //Obtain full "Days" from the total amount of seconds
            additionalDays += combindSeconds / 86400;
            //Obtain the remaining seconds
            combindSeconds = combindSeconds % 86400;
        }

        Time timeOutput = new Time(0, 0, combindSeconds);
        Date dateOutput = this.date.add(years, months, days + additionalDays);

        return new DateTime(dateOutput, timeOutput);
    }

    public DateTime subtract(int years, int months, int days, int hours, int minutes, int seconds) {
        //TODO: add logic
        return null;
    }

    public String diff(DateTime dateTime) {
        //TODO: add logic
        return null;
    }

    public int compareTo(DateTime input) {
        int payload = this.date.compareTo(input.date);

        if (payload == 0) {
            payload = this.time.compareTo(input.time);
        }

        return payload;
    }
//

//Getters & Setters
    public Date getDate() {
        return this.date;
    }

    public Time getTime() {
        return this.time;
    }

    private void setDate(int year, Date.Month month, int day) {
        this.date = new Date(year, month, day);
    }

    private void setDate(Date date) {
        this.date = new Date(date.getYear(), date.getMonth(), date.getDay());
    }

    private void setTime(int hour, int minute, int second) {
        this.time = new Time(hour, minute, second);
    }

    private void setTime(Time time) {
        this.time = new Time(time.getHour(), time.getMinute(), time.getSecond());
    }
//

//Overrides
    @Override
    public String toString() {
        return String.format("[%s]:[%s]", this.date.toString(), this.time.toString() );
        // return String.format("%s@%s[%4d/%02d/%02d]:[%d:%d:%d]", this.getClass().getName(), Integer.toHexString(this.hashCode()), this.date.getYear(), this.date.getMonth().ordinal() + 1, this.date.getDay(), this.time.getHour(), this.time.getMinute(), this.time.getSecond());
    }
//


    //add Date Date
    //add Time time
    //add DateTime datetime
    //Subtract Date Date
    //Subtract Time time
    //Subtract DateTime datetime
    //Diff DateTime DateTime

    //toString()
}