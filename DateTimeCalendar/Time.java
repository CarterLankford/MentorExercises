public class Time{
    private static final int BASESIXTY = 60;
    private int hour;
    private int minute;
    private int second;
    private boolean isMilitary;

    public Time(){

    }

    public Time(int hour, int minute, int second, String amPM){
        setHour(hour);
        setMinute(minute);
        setSecond(second);
        System.out.println(amPM);
    }

    public boolean addTime(int hours, int minutes, int seconds){
        return true;
    }

    public boolean subtractTime(int hours, int minutes, int seconds){
        return true;
    }

    public int[] diffTime(int hours, int minutes, int seconds){
        int[] x = new int[3];
        int currentTime = convToSeconds(this.hour, this.minute, this.second);
        int inputTime = convToSeconds(hours, minutes, seconds); 
        if(currentTime > inputTime){
            //TODO:
            //[] Make diff able to accept an array and return it
            int diff = currentTime - inputTime;
        } else if(currentTime < inputTime){
            //TODO:
            //[] Make diff able to accept an array and return it
            int diff = inputTime - currentTime;
        } else if (currentTime == inputTime){
            x[0] = 0;
            x[1] = 0;
            x[2] = 0;
            return x;
        } else {
            throw new IllegalArgumentException("Something Broke");
        }
        
        return x;
    }

    public int compTime(int hours, int minutes, int seconds){
        int currentTime = convToSeconds(this.hour, this.minute, this.second);
        int inputTime = convToSeconds(hours, minutes, seconds); 

        if(currentTime == inputTime){
            return 0;
        } else if(currentTime > inputTime){
            return 1;
        } else if(currentTime < inputTime){
            return -1;
        } else{
            throw new IllegalArgumentException("Incorrect value entered");
        }
    }

    public int convToSeconds(int hours, int minutes, int seconds){
        int payload = (((hours*BASESIXTY)*BASESIXTY) + (minutes*BASESIXTY)) + seconds;
        return payload;
    }

    public int[] convFromSeconds(int seconds){
        int[] x = new int[3];
        x[0] = 0;
        x[1] = 0;
        x[2] = 0;
        return x;
    }

    // public int convHourFormat(int hours, int minutes, int seconds){
    //     //TODO: 
    //     // This is for converting 
    // }

    public int getHour(){
        return this.hour;
    }

    public int getMinute(){
        return this.minute;
    }

    public int getSecond(){
        return this.second;
    }

    public void setHour(int hours){
        this.hour = hours;
    }

    public void setMinute(int minutes){
        this.minute = minutes;
    }

    public void setSecond(int seconds){
        this.second = seconds;
    }

    private void isMilitary(int hour){
        if(hour >= 13){
            isMilitary = true;
        } else {
            isMilitary = false;
        }
    }
}