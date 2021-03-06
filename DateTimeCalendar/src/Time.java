package priv.exercises.datetime;

public class Time {
    private static final int SEC_IN_MIN = 60;
    private static final int SEC_IN_HR = 3600;

    public static long convToSeconds(long hours, long minutes, long seconds){
        return ((hours*SEC_IN_HR) + (minutes*SEC_IN_MIN)) + seconds;
    }

    //TODO:
    //[] Add method for Equals, must override from obj

    private final long seconds;

    private Time(){
        this.seconds = 0;
    }

    public Time(long seconds){
        this.seconds = seconds;
    }

    public Time(int hour, int minute, int second){
        this.seconds = convToSeconds(hour, minute, second);      
    }

    public Time add(Time input){
        return new Time(this.seconds + input.seconds);
    }

    public Time add(int hours, int minutes, int seconds){
        return new Time(this.seconds + convToSeconds(hours, minutes, seconds));
    }

    public Time subtract(Time input){
        return new Time(this.seconds - input.seconds);
    }

    public Time subtract(long hours, long minutes, long seconds){
        return new Time(this.seconds - convToSeconds(hours, minutes, seconds));
    }

    public Time subtract(TimeUnit.Unit timeUnit, long duration) {
        /* Notes
        *  You cann't subtract time by another time, but with this implementation since all time is saved as seconds
        *  it's up to us to remember the difference when moving the code to access subtract rather than diff 
        */
        switch(timeUnit) {
            case SECOND:
                return new Time(this.seconds - convToSeconds(0, 0, duration));
            case MINUTE:
                return new Time(this.seconds - convToSeconds(0, duration, 0));
            case HOUR:
                return new Time(this.seconds - convToSeconds(duration, 0, 0));
            default:
                return null;
        }
    }

    public int compareTo(Time input){
        return Long.compare(this.seconds, input.seconds);
    }

    public int getHour(){
        return (int)(this.seconds / SEC_IN_HR);
    }

    public int getMinute(){
        return this.getMinute(false);
    }

    public int getMinute(boolean isAbsolute){
        int result;
        if(isAbsolute){
            result = (int)(this.seconds / SEC_IN_MIN);
        } else{
            result = (int)(this.seconds % SEC_IN_HR);
            result = (int)(result / SEC_IN_MIN);
        }
        return result;
    }

    public int getSecond(){
        return this.getSecond(false);
    }

    public int getSecond(boolean isAbsolute){
        int result;
        if(isAbsolute){
            return (int)(this.seconds);
        } else {
            result = (int)(this.seconds % SEC_IN_HR);
            result = result % SEC_IN_MIN;
        }
        return result;
    }

    @Override
    public String toString(){
        return this.getHour() + ":" + this.getMinute() + ":" + this.getSecond();
    }
}