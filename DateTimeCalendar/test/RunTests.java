package priv.exercises.datetime;

public class RunTests{
    public static void main(String[] args) {

        //DateTime.Time test
        // TimeTest timeTestSingleVarConstructor = new TimeTest(ShowTestOutput.NONE);
        // TimeTest timeTestMultiVarConstructor = new TimeTest(ShowTestOutput.ALL, ShowTestOutput.ALL, ShowTestOutput.ALL, ShowTestOutput.ALL, ShowTestOutput.ALL);
        TimeTest.unitTestTimeSubtract(ShowTestOutput.ALL);

        //DateTime.Date test
        DateTest.unitTestDateAdd(ShowTestOutput.NONE);
        DateTest.unitTestDateDiff(ShowTestOutput.NONE);
        DateTest.unitTestDateSubtract(ShowTestOutput.NONE);

        //DateTime.DateTime test
        DateTimeTest.unitTestDateTimeConstructors();
        DateTimeTest.unitTestDateTimeAdd(ShowTestOutput.NONE);
        DateTimeTest.unitTestDateTimeSubtract(ShowTestOutput.NONE);
        // DateTimeTest.unitTestDateTimeDiff(ShowTestOutput.ALL);

        //DateTime.Calendar test


        //DateTime.TimeUnit test
        TimeUnitTest.unitTestTimeUnitToSeconds(ShowTestOutput.ON_ERROR);
        TimeUnitTest.unitTestTimeUnitToMinutes(ShowTestOutput.ALL);




        
    }
}