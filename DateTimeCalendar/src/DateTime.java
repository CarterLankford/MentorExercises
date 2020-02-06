package priv.exercises.datetime;

public class DateTime{
    private static final int SEC_IN_DAY = 86400;
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
    public DateTime add(int years, int months, int days, int hours, int minutes, int seconds) {
        if (years >= 0 && months >= 0 && days >= 0 && hours >= 0 && minutes >= 0 && seconds >= 0) {
            int combindSeconds = time.getSecond(true) + (hours * 3600 + minutes * 60 + seconds);
            int additionalDays = 0;
    
            if ( combindSeconds >= SEC_IN_DAY) {
                //Obtain full "Days" from the total amount of seconds
                additionalDays += combindSeconds / SEC_IN_DAY;
                //Obtain the remaining seconds
                combindSeconds = combindSeconds % SEC_IN_DAY;
            }
    
            Time timeOutput = new Time(0, 0, combindSeconds);
            Date dateOutput = this.date.add(years, months, days + additionalDays);
            return new DateTime(dateOutput, timeOutput);
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    public DateTime subtract(int years, int months, int days, int hours, int minutes, int seconds) {
        if (years >= 0 && months >= 0 && days >= 0 && hours >= 0 && minutes >= 0 && seconds >= 0) {
            int reduceTimeBySeconds = hours * 3600 + minutes * 60 + seconds;
            int reduceTimeRollover = reduceTimeBySeconds / SEC_IN_DAY;

            Time timeOutput;

            if (time.getSecond(true) - reduceTimeBySeconds % SEC_IN_DAY <= 0) {
                timeOutput = new Time(0, 0, time.getSecond(true));
            } else {
                timeOutput = new Time(0, 0, time.getSecond(true) - (reduceTimeBySeconds % SEC_IN_DAY) );
            }

            // Time timeOutput = new Time(0, 0, time.getSecond(true) - (reduceTimeBySeconds % SEC_IN_DAY) );
            Date dateOutput = this.date.subtract(years, months, days + reduceTimeRollover);
            return new DateTime(dateOutput, timeOutput);

        } else {
            throw new IllegalArgumentException("Invalid input");
        }


        // return null;
    }

    public DateTime diff(DateTime dateTime) {
        Time diffTime;
        Date diffDate;
        long thisToDayspan = Date.convToDays(this.date.getYear(), this.date.getMonth().ordinal() + 1, this.date.getDay());
        long inputToDayspan = Date.convToDays(dateTime.date.getYear(), dateTime.date.getMonth().ordinal() + 1, dateTime.date.getDay());
        
        //calculate diff time
        if (this.time.compareTo(dateTime.time) == 1) {
            diffTime = new Time(0, 0, this.time.getSecond(true) - dateTime.time.getSecond(true));
        } else if (this.time.compareTo(dateTime.time) == -1) {
            diffTime = new Time(0, 0, dateTime.time.getSecond(true) - this.time.getSecond(true));
        } else {
            diffTime = new Time(0, 0, 0);
        }
        
        //calculate diff date
        if (thisToDayspan > inputToDayspan) {
            diffDate = new Date((int)thisToDayspan - (int)inputToDayspan);
            // System.out.println((int)thisToDayspan - (int)inputToDayspan);
        } else if (thisToDayspan < inputToDayspan) {
            diffDate = new Date((int)inputToDayspan - (int)thisToDayspan);
            // System.out.println((int)inputToDayspan - (int)thisToDayspan);
        } else {
            diffDate = new Date(0);
        }

        return new DateTime(diffDate, diffTime);
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
        if (date.getDayspan() > 0) {
            this.date = new Date(date.getDayspan());
        } else {
            this.date = new Date(date.getYear(), date.getMonth(), date.getDay());    
        }
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
    }
//
}