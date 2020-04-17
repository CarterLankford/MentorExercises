package priv.exercises.datetime;

// public enum TimeUnit {
//     SECOND, 
//     MINUTE,
//     HOUR,
//     DAY,
// }

public class TimeUnit {
    private static final int SEC_IN_MIN = 60;
    private static final int SEC_IN_HR = 3600;

    public enum Unit {
        SECOND, 
        MINUTE,
        HOUR,
        DAY,
        ;
    }

    public static long toSeconds(Unit unit, long duration) {
        if (duration > 0) {
            switch(unit) {
                case MINUTE:
                    return duration * SEC_IN_MIN;
                case HOUR:
                    return duration * SEC_IN_HR;
                default:
                    return duration;
            }
        } else {
            throw new IllegalArgumentException("All numbers must be greater than 0");
        }
    }

    public static long toMinutes(Unit unit, long duration) {
        if (duration > 0) {
            switch(unit) {
                case SECOND:
                    return duration / SEC_IN_MIN;
                case HOUR:
                    return duration * SEC_IN_MIN;
                default:
                    return duration;
            }
        } else {
            throw new IllegalArgumentException("All numbers must be positive");
        }
    }

    private long toHours() {
        return 0l;
    }

    public long convertTo(Unit sourceUnit, Unit payloadUnit, long duration) {
        return 0l;
    }


    //     // switch(timeUnit) {
    //     //     case SECOND:
    //     //         return new Time(this.seconds - convToSeconds(0, 0, duration));
    //     //     case MINUTE:
    //     //         return new Time(this.seconds - convToSeconds(0, duration, 0));
    //     //     case HOUR:
    //     //         return new Time(this.seconds - convToSeconds(duration, 0, 0));
    //     //     default:
    //     //         return null;
    //     // }
    // }

}