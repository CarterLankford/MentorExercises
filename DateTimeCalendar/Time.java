public class Time {
    private static final int SEC_IN_MIN = 60;
    private static final int SEC_IN_HR = 3600;

    public static long convToSeconds(int hours, int minutes, int seconds){
        return ((hours*SEC_IN_HR) + (minutes*SEC_IN_MIN)) + seconds;
    }

    //TODO:
    //[] Add method for Equals, must override from obj
    //[] Add logic to Diff Method

    private final long seconds;

    private Time(){

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

    public Time subtract(int hours, int minutes, int seconds){
        return new Time(this.seconds - convToSeconds(hours, minutes, seconds));
    }

    public int compareTo(Time input){
        if(this.seconds == input.seconds) {
            return 0;
        } else if(this.seconds > input.seconds) {
            return 1;
        } else {
            return -1;
        } 
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