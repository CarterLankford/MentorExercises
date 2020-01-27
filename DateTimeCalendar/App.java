/**
 * TODO: come up with a game plan for what to print if there is an error, if I want to see it vs not. 
 */
public class App{

    public enum ShowTestOutput {
        NONE, 
        ON_ERROR,
        ALL,
    }

    public static void main(String[] args){
        Time tm1;
        Time tm2;
        Time tm3;

        tm1 = new Time(60000);
        tm2 = new Time(2, 20, 10);

        System.out.println(tm1.toString());
        System.out.println(tm2.toString());

        tm3 = tm1.add(tm2);
        System.out.println(tm3.toString());

        tm3 = tm1.subtract(tm2);
        System.out.println(tm3.toString());

        tm1 = new Time(60000);
        tm2 = new Time(350);
        tm3 = tm1.add(tm2);
        System.out.println(tm3.toString());


        System.out.println(Date.Month.DEC.days);
        System.out.println(Date.Month.values()[0]);

        Date dt1 = new Date(201);
        System.out.println(dt1.getDayspan());

        Date dt2 = new Date(1999, Date.Month.FEB, 3);
        // System.out.println(dt2.getYear());
        // System.out.println(dt2.getMonth());
        // System.out.println(Date.Month.DEC.ordinal());
        // System.out.println(Date.Month.DEC.shortName);
        // System.out.println(Date.Month.DEC.longName);
        // System.out.println(Date.Month.DEC.days);
        // System.out.println(dt2.toString());


        Date dt5 = new Date(1994, Date.Month.MAY, 13);
        System.out.println(dt5.toString());

        Date dt9 = dt5.add(1, 1, 1);
        Date dt10 = dt9.add(8, 8, 16);
       
        System.out.println(dt9.toString());
        System.out.println(dt10.toString());
        System.out.println(Date.isLeapYear(2004));

        // unitTestConvToDays();

        System.out.println(Date.Month.values().length);
        System.out.println(Date.Month.values()[0].shortName);

        //Date.compareTo() - Start       
        Date dateTestCompareToControlObj = new Date(1900, Date.Month.JAN, 5);
        Date dateTestCompareToCompareObj1 = new Date(1900, Date.Month.JAN, 5);
        int dateTestComparedToExpectedOut1 = -0;
        // unitTestDateCompareTo(dateTestCompareToControlObj, dateTestCompareToCompareObj1, dateTestComparedToExpectedOut1);

        Date dateTestCompareToCompareObj2 = new Date(1900, Date.Month.JAN, 8);
        int dateTestComparedToExpectedOut2 = -1;
        // unitTestDateCompareTo(dateTestCompareToControlObj, dateTestCompareToCompareObj2, dateTestComparedToExpectedOut2);

        Date dateTestCompareToCompareObj3 = new Date(1900, Date.Month.JAN, 1);
        int dateTestComparedToExpectedOut3 = 1;
        // unitTestDateCompareTo(dateTestCompareToControlObj, dateTestCompareToCompareObj3, dateTestComparedToExpectedOut3);
        //Date.compareTo() - End


        unitTestDateAdd(ShowTestOutput.ALL);
        unitTestDateDiff(ShowTestOutput.ALL);
        unitTestDateSubtract(ShowTestOutput.ON_ERROR);

        //Test DateTime
        unitTestDateTimeConstructors();
        unitTestDateTimeAdd(ShowTestOutput.NONE);
        unitTestDateTimeSubtract(ShowTestOutput.ON_ERROR);
        unitTestDateTimeDiff(ShowTestOutput.NONE);

        DateTime myNewDateTime1 = new DateTime(2019, Date.Month.NOV, 6, 8, 15, 0);
        DateTime myNewDateTime2 = new DateTime(2019, Date.Month.NOV, 6, 16, 40, 0);
        DateTime myNewDateCompare = myNewDateTime1.diff(myNewDateTime2);
        System.out.println(String.format("%d days, %d:h %d:m %d:s", myNewDateCompare.getDate().getDayspan(), myNewDateCompare.getTime().getHour(), myNewDateCompare.getTime().getMinute(false), myNewDateCompare.getTime().getSecond(false) ));

        unitTestCalendarCalcDayOfWeek(ShowTestOutput.ON_ERROR);

        DateTime[] dta = new DateTime[3];
        dta[0] = new DateTime(1900, Date.Month.JAN, 1, 12, 30, 30);
        dta[1] = new DateTime(1900, Date.Month.JAN, 1, 12, 30, 30);
        dta[2] = new DateTime(1900, Date.Month.JAN, 1, 12, 30, 29);

        genericTestMethod(dta, myNewDateTime2);

        Date dt11 = new Date(1900, Date.Month.FEB, 1);
        Date dt12 = dt11.subtract(3000, 1, 1);
        System.out.println(dt2.toString());
        int testInt = 1;
        int testInt1 = 4;
        System.out.println(testInt -= testInt1);
    }

    private static void unitTestDateCompareTo(Date obj1, Date obj2, int expectedOut){
        int result = obj1.compareTo(obj2);
        boolean testPass = false;

        if (result == expectedOut){
            testPass = true;
        }

        System.out.println(String.format("Test Date.compareTo() obj1:%s obj2:%s  ExpectedOut:%d TestPass:%s",obj1.toString(), obj2.toString(), result, testPass ));
    }

    private static void unitTestDateDiff(ShowTestOutput selectedTypeOfOutput){
        final Date base = new Date(1900, Date.Month.JAN, 0);
        DateDiffTestCase[] testCasess = new DateDiffTestCase[10];
        testCasess[0] = new DateDiffTestCase(base, new Date(1900, Date.Month.JAN, 0), 0);
        testCasess[1] = new DateDiffTestCase(base, new Date(1900, Date.Month.JAN, 0), 0);
        testCasess[2] = new DateDiffTestCase(base, new Date(1900, Date.Month.JAN, 1), 1);
        testCasess[3] = new DateDiffTestCase(base, new Date(1900, Date.Month.JAN, -1), 1);
        testCasess[4] = new DateDiffTestCase(base, new Date(0, Date.Month.JAN, 0), -1);
        testCasess[5] = new DateDiffTestCase(base, new Date(1900, Date.Month.JAN, 31), 31);
        testCasess[6] = new DateDiffTestCase(base, new Date(1900, Date.Month.FEB, 28), 59);
        testCasess[7] = new DateDiffTestCase(base, new Date(1900, Date.Month.AUG, 15), 227);
        testCasess[8] = new DateDiffTestCase(base, new Date(1900, Date.Month.DEC, 31), 365);
        testCasess[9] = new DateDiffTestCase(base, new Date(1904, Date.Month.FEB, 29), 1520);

        for (DateDiffTestCase testCase : testCasess) {
            boolean testPass = false;
            int result;

            try {
                result = base.diff(testCase.secondInput);
                testPass = testCase.expected == result;

                if (selectedTypeOfOutput == ShowTestOutput.ALL) {
                    System.out.println(String.format("Test Date.diff() %s AO:%d // TestPass%s", testCase.toString(), result, testPass));
                } else if (selectedTypeOfOutput == ShowTestOutput.ON_ERROR && !testPass) {
                    System.out.println(String.format("Test Date.diff() %s AO:%d // TestPass%s", testCase.toString(), result, testPass));
                }
            } catch (IllegalArgumentException exception) {
                if (selectedTypeOfOutput == ShowTestOutput.ALL || selectedTypeOfOutput == ShowTestOutput.ON_ERROR) {
                    System.out.println(exception);
                }
            }
        }

        System.out.println(testCasess[9].firstInputYears + " Well hello");
    }

    private static void unitTestDateAdd(ShowTestOutput selectedTypeOfOutput){
        DateTestCase[] testCases = new DateTestCase[14];
        testCases[0] = new DateTestCase(0, 0, 1, new Date(1900, Date.Month.JAN, 1));
        testCases[1] = new DateTestCase(0, 0, 31, new Date(1900, Date.Month.JAN, 31));
        testCases[2] = new DateTestCase(0, 0, 41, new Date(1900, Date.Month.FEB, 10));
        testCases[3] = new DateTestCase(0, 0, 60, new Date(1900, Date.Month.MAR, 01));
        testCases[4] = new DateTestCase(0, 0, 500, new Date(1901, Date.Month.MAY, 15));
        testCases[5] = new DateTestCase(0, 0, 1000, new Date(1902, Date.Month.SEP, 27));
        testCases[6] = new DateTestCase(0, 0, 2000, new Date(1905, Date.Month.JUN, 23));
        testCases[7] = new DateTestCase(0, 1, 0, new Date(1900, Date.Month.FEB, 0));
        testCases[8] = new DateTestCase(0, 31, 0, new Date(1902, Date.Month.AUG, 0));
        testCases[9] = new DateTestCase(0, 41, 0, new Date(1903, Date.Month.JUN, 0));
        testCases[10] = new DateTestCase(0, 60, 0, new Date(1905, Date.Month.JAN, 0));
        testCases[11] = new DateTestCase(0, 500, 0, new Date(1941, Date.Month.SEP, 0));
        testCases[12] = new DateTestCase(0, 1000, 0, new Date(1983, Date.Month.MAY, 0));
        testCases[13] = new DateTestCase(0, 2000, 0, new Date(2066, Date.Month.SEP, 0));

        final Date base = new Date(1900, Date.Month.JAN, 0);
        for (DateTestCase testCase : testCases) {
            boolean testPass = false;
            Date result;

            try {
                result = base.add(testCase.years, testCase.months, testCase.days);
                testPass = testCase.expected.compareTo(result) == 0;

                if (selectedTypeOfOutput == ShowTestOutput.ALL) {
                    System.out.println(String.format("Test Date.add() controlObj:%s + %s AO:%s // TestPass:%s", base.toString(), testCase.toString(), result.toString(), testPass));                    
                } else if (selectedTypeOfOutput == ShowTestOutput.ON_ERROR && !testPass) {
                    System.out.println(String.format("Test Date.add() controlObj:%s + %s AO:%s // TestPass:%s", base.toString(), testCase.toString(), result.toString(), testPass));
                }
            } catch (IllegalArgumentException exception) {
                // System.out.println(exception);
            }
        }
    }

    private static void unitTestDateSubtract(ShowTestOutput selectedTypeOfOutput){
        DateTestCase[] testCases = new DateTestCase[24];
        testCases[0]  = new DateTestCase(1, 0, 0, new Date(1949, Date.Month.MAY, 15));
        testCases[1]  = new DateTestCase(0, 0, 0, new Date(1950, Date.Month.MAY, 15));
        testCases[2]  = new DateTestCase(-1, 0, 0, new Date(1900, Date.Month.DEC, 32));
        testCases[3]  = new DateTestCase(10, 0, 0, new Date(1940, Date.Month.MAY, 15));
        testCases[4]  = new DateTestCase(50, 0, 0, new Date(1900, Date.Month.MAY, 15));
        testCases[5]  = new DateTestCase(100, 0, 0, new Date(1900, Date.Month.DEC, 32));
        testCases[6]  = new DateTestCase(0, 1, 0, new Date(1950, Date.Month.APR, 15));
        testCases[7]  = new DateTestCase(0, -1, 0, new Date(1900, Date.Month.DEC, 32));
        testCases[8]  = new DateTestCase(0, 2, 0, new Date(1950, Date.Month.MAR, 15));
        testCases[9]  = new DateTestCase(0, 5, 0, new Date(1949, Date.Month.DEC, 15));
        testCases[10] = new DateTestCase(0, 10, 0, new Date(1949, Date.Month.JUL, 15));
        testCases[11] = new DateTestCase(0, 20, 0, new Date(1948, Date.Month.SEP, 15));
        testCases[12] = new DateTestCase(0, 40, 0, new Date(1947, Date.Month.JAN, 15));
        testCases[13] = new DateTestCase(0, 0, 1, new Date(1950, Date.Month.MAY, 14));
        testCases[14] = new DateTestCase(0, 0, -1, new Date(1900, Date.Month.DEC, 32));
        testCases[15] = new DateTestCase(0, 0, 10, new Date(1950, Date.Month.MAY, 5));
        testCases[16] = new DateTestCase(0, 0, 20, new Date(1950, Date.Month.APR, 25));
        testCases[17] = new DateTestCase(0, 0, 40, new Date(1950, Date.Month.APR, 5));
        testCases[18] = new DateTestCase(0, 0, 80, new Date(1950, Date.Month.FEB, 24));
        testCases[19] = new DateTestCase(0, 0, 160, new Date(1949, Date.Month.DEC, 6));
        testCases[20] = new DateTestCase(1, 1, 1, new Date(1949, Date.Month.APR, 14));
        testCases[21] = new DateTestCase(2, 2, 15, new Date(1948, Date.Month.FEB, 29));
        testCases[22] = new DateTestCase(10, 10, 10, new Date(1939, Date.Month.JUL, 5));
        testCases[23] = new DateTestCase(10, 0, 3000, new Date(1932, Date.Month.FEB, 27));

        final Date base = new Date(1950, Date.Month.MAY, 15);
        final Date expectedException = new Date(1900, Date.Month.DEC, 32);
        for (DateTestCase testCase : testCases) {
            boolean testPass = false;
            Date result;

            try {
                result = base.subtract(testCase.years, testCase.months, testCase.days);
                testPass = testCase.expected.compareTo(result) == 0;

                if (selectedTypeOfOutput == ShowTestOutput.ALL) {
                    System.out.println(String.format("Test Date.subtract() controlObj:%s - %s AO:%s // TestPass:%s", base.toString(), testCase.toString(), result.toString(), testPass));                    
                } else if (selectedTypeOfOutput == ShowTestOutput.ON_ERROR && !testPass) {
                    System.out.println(String.format("Test Date.subtract() controlObj:%s - %s AO:%s // TestPass:%s", base.toString(), testCase.toString(), result.toString(), testPass));
                }
            } catch (IllegalArgumentException exception) {
                testPass = testCase.expected.compareTo(expectedException) == 0;

                if (selectedTypeOfOutput == ShowTestOutput.ALL && testPass) {
                    System.out.println(String.format("Test Date.subtract() controlObj:%s + %s AO:%s // TestPass:%s", base.toString(), testCase.toString(), expectedException.toString(), testPass ));
                } else if (selectedTypeOfOutput == ShowTestOutput.ON_ERROR && !testPass) {
                    System.out.println("Test DateTime.subtract() " + exception);
                }
            }
        }
    }
    
    private static void unitTestDateTimeConstructors() {
        //Main Constructor 
        DateTime dateTimeConstructorsControlObj = new DateTime(1900, Date.Month.JAN, 5, 12, 10, 30);
        // System.out.println(dateTimeConstructorsControlObj.toString());

        //by object
        Time tm1 = new Time(12, 10, 30);
        Date dt1 = new Date(1900, Date.Month.JAN, 5);
        DateTime dateTimeConstructorsWithObjs = new DateTime(dt1, tm1);
        // System.out.println(dateTimeConstructorsWithObjs);

        //by obj individually
        DateTime dateTimeConstructorsWithObjTime = new DateTime(tm1);
        DateTime dateTimeConstructorsWithObjDate = new DateTime(dt1);

        //by var individually
        DateTime dateTimeConstructorsWithVarTime = new DateTime(12, 10, 30);
        DateTime dateTimeConstructorsWithVarDate = new DateTime(1900, Date.Month.JAN, 5);
    }

    private static void unitTestDateTimeAdd(ShowTestOutput selectedTypeOfOutput) {
        final DateTime base = new DateTime(2000, Date.Month.MAY, 15, 12, 30, 30);
        final DateTime expectedException = new DateTime(1900, Date.Month.DEC, 32, 25, 61, 61);

        DateTimeTestCase[] testCases = new DateTimeTestCase[43];
        testCases[0] = new DateTimeTestCase(0, 0, 0, 0, 0, 0, new DateTime(2000, Date.Month.MAY, 15, 12, 30, 30));
        testCases[1] = new DateTimeTestCase(0, 0, 0, 0, 0, 1, new DateTime(2000, Date.Month.MAY, 15, 12, 30, 31));
        testCases[2] = new DateTimeTestCase(0, 0, 0, 0, 0, 10, new DateTime(2000, Date.Month.MAY, 15, 12, 30, 40));
        testCases[3] = new DateTimeTestCase(0, 0, 0, 0, 0, 20, new DateTime(2000, Date.Month.MAY, 15, 12, 30, 50));
        testCases[4] = new DateTimeTestCase(0, 0, 0, 0, 0, 40, new DateTime(2000, Date.Month.MAY, 15, 12, 31, 10));
        testCases[5] = new DateTimeTestCase(0, 0, 0, 0, 0, 80, new DateTime(2000, Date.Month.MAY, 15, 12, 31, 50));
        testCases[6] = new DateTimeTestCase(0, 0, 0, 0, 0, 160, new DateTime(2000, Date.Month.MAY, 15, 12, 33, 10));
        testCases[7] = new DateTimeTestCase(0, 0, 0, 0, 1, 1, new DateTime(2000, Date.Month.MAY, 15, 12, 31, 31));
        testCases[8] = new DateTimeTestCase(0, 0, 0, 0, 10, 10, new DateTime(2000, Date.Month.MAY, 15, 12, 40, 40));
        testCases[9] = new DateTimeTestCase(0, 0, 0, 0, 20, 20, new DateTime(2000, Date.Month.MAY, 15, 12, 50, 50));
        testCases[10] = new DateTimeTestCase(0, 0, 0, 0, 40, 40, new DateTime(2000, Date.Month.MAY, 15, 13, 11, 10));
        testCases[11] = new DateTimeTestCase(0, 0, 0, 0, 80, 80, new DateTime(2000, Date.Month.MAY, 15, 13, 51, 50));
        testCases[12] = new DateTimeTestCase(0, 0, 0, 0, 160, 160, new DateTime(2000, Date.Month.MAY, 15, 15, 13, 10));
        testCases[13] = new DateTimeTestCase(0, 0, 0, 1, 1, 1, new DateTime(2000, Date.Month.MAY, 15, 13, 31, 31));
        testCases[14] = new DateTimeTestCase(0, 0, 0, 10, 10, 10, new DateTime(2000, Date.Month.MAY, 15, 22, 40, 40));
        testCases[15] = new DateTimeTestCase(0, 0, 0, 20, 20, 20, new DateTime(2000, Date.Month.MAY, 16, 8, 50, 50));
        testCases[16] = new DateTimeTestCase(0, 0, 0, 40, 40, 40, new DateTime(2000, Date.Month.MAY, 17, 5, 11, 10));
        testCases[17] = new DateTimeTestCase(0, 0, 0, 80, 80, 80, new DateTime(2000, Date.Month.MAY, 18, 21, 51, 50));
        testCases[18] = new DateTimeTestCase(0, 0, 0, 160, 160, 160, new DateTime(2000, Date.Month.MAY, 22, 7, 13, 10));
        testCases[19] = new DateTimeTestCase(0, 0, 1, 1, 1, 1, new DateTime(2000, Date.Month.MAY, 16, 13, 31, 31));
        testCases[20] = new DateTimeTestCase(0, 0, 10, 10, 10, 10, new DateTime(2000, Date.Month.MAY, 25, 22, 40, 40));
        testCases[21] = new DateTimeTestCase(0, 0, 20, 20, 20, 20, new DateTime(2000, Date.Month.JUN, 5, 8, 50, 50));
        testCases[22] = new DateTimeTestCase(0, 0, 40, 40, 40, 40, new DateTime(2000, Date.Month.JUN, 26, 5, 11, 10));
        testCases[23] = new DateTimeTestCase(0, 0, 80, 80, 80, 80, new DateTime(2000, Date.Month.AUG, 6, 21, 51, 50));
        testCases[24] = new DateTimeTestCase(0, 0, 160, 160, 160, 160, new DateTime(2000, Date.Month.OCT, 29, 7, 13, 10));
        testCases[25] = new DateTimeTestCase(0, 1, 1, 1, 1, 1, new DateTime(2000, Date.Month.JUN, 16, 13, 31, 31));
        testCases[26] = new DateTimeTestCase(0, 10, 10, 10, 10, 10, new DateTime(2001, Date.Month.MAR, 25, 22, 40, 40));
        testCases[27] = new DateTimeTestCase(0, 20, 20, 20, 20, 20, new DateTime(2002, Date.Month.FEB, 5, 8, 50, 50));
        testCases[28] = new DateTimeTestCase(0, 40, 40, 40, 40, 40, new DateTime(2003, Date.Month.OCT, 27, 5, 11, 10));
        testCases[29] = new DateTimeTestCase(0, 80, 80, 80, 80, 80, new DateTime(2007, Date.Month.APR, 8, 21, 51, 50));
        testCases[30] = new DateTimeTestCase(0, 160, 160, 160, 160, 160, new DateTime(2013, Date.Month.MAR, 1, 7, 13, 10));
        testCases[31] = new DateTimeTestCase(1, 1, 1, 1, 1, 1, new DateTime(2001, Date.Month.JUN, 16, 13, 31, 31));
        testCases[32] = new DateTimeTestCase(10, 10, 10, 10, 10, 10, new DateTime(2011, Date.Month.MAR, 25, 22, 40, 40));
        testCases[33] = new DateTimeTestCase(20, 20, 20, 20, 20, 20, new DateTime(2022, Date.Month.FEB, 5, 8, 50, 50));
        testCases[34] = new DateTimeTestCase(40, 40, 40, 40, 40, 40, new DateTime(2043, Date.Month.OCT, 27, 5, 11, 10));
        testCases[35] = new DateTimeTestCase(80, 80, 80, 80, 80, 80, new DateTime(2087, Date.Month.APR, 8, 21, 51, 50));
        testCases[36] = new DateTimeTestCase(160, 160, 160, 160, 160, 160, new DateTime(2173, Date.Month.MAR, 1, 7, 13, 10));
        testCases[37] = new DateTimeTestCase(-1, 0, 0, 0, 0, 0, new DateTime(1900, Date.Month.DEC, 32, 25, 61, 61));
        testCases[38] = new DateTimeTestCase(0, -1, 0, 0, 0, 0, new DateTime(1900, Date.Month.DEC, 32, 25, 61, 61));
        testCases[39] = new DateTimeTestCase(0, 0, -1, 0, 0, 0, new DateTime(1900, Date.Month.DEC, 32, 25, 61, 61));
        testCases[40] = new DateTimeTestCase(0, 0, 0, -1, 0, 0, new DateTime(1900, Date.Month.DEC, 32, 25, 61, 61));
        testCases[41] = new DateTimeTestCase(0, 0, 0, 0, -1, 0, new DateTime(1900, Date.Month.DEC, 32, 25, 61, 61));
        testCases[42] = new DateTimeTestCase(0, 0, 0, 0, 0, -1, new DateTime(1900, Date.Month.DEC, 32, 25, 61, 61));

        for (DateTimeTestCase testCase : testCases) {
            boolean testPass = false;
            DateTime result;

            try {
                result = base.add(testCase.years, testCase.months, testCase.days, testCase.hours, testCase.minutes, testCase.seconds);
                testPass = testCase.expected.compareTo(result) == 0;

                if (selectedTypeOfOutput == ShowTestOutput.ALL) {
                    System.out.println(String.format("Test DateTime.add() controlObj:%s + %s AO:%s // TestPass:%s", base.toString(), testCase.toString(), result.toString(), testPass ));
                } else if (selectedTypeOfOutput == ShowTestOutput.ON_ERROR && !testPass) {
                    System.out.println(String.format("Test DateTime.add() controlObj:%s + %s AO:%s // TestPass:%s", base.toString(), testCase.toString(), result.toString(), testPass ));
                }
            } catch (IllegalArgumentException exception) {
                testPass = testCase.expected.compareTo(expectedException) == 0;

                if (selectedTypeOfOutput == ShowTestOutput.ALL) {
                    System.out.println(String.format("Test DateTime.add() controlObj:%s + %s AO:%s // TestPass:%s", base.toString(), testCase.toString(), expectedException.toString(), testPass ));
                } else {
                    // System.out.println(exception);
                }
            }
        }
    }

    private static void unitTestDateTimeSubtract(ShowTestOutput selectedTypeOfOutput) {
        final DateTime base = new DateTime(2000, Date.Month.MAY, 15, 12, 30, 30);
        final DateTime expectedException = new DateTime(1900, Date.Month.DEC, 32, 25, 61, 61);

        DateTimeTestCase[] testCases = new DateTimeTestCase[43];
        testCases[0]  = new DateTimeTestCase(0, 0, 0, 0, 0, 0, new DateTime(2000, Date.Month.MAY, 15, 12, 30, 30));
        testCases[1]  = new DateTimeTestCase(0, 0, 0, 0, 0, 1, new DateTime(2000, Date.Month.MAY, 15, 12, 30, 29));
        testCases[2]  = new DateTimeTestCase(0, 0, 0, 0, 0, 10, new DateTime(2000, Date.Month.MAY, 15, 12, 30, 20)); 
        testCases[3]  = new DateTimeTestCase(0, 0, 0, 0, 0, 20, new DateTime(2000, Date.Month.MAY, 15, 12, 30, 10));
        testCases[4]  = new DateTimeTestCase(0, 0, 0, 0, 0, 40, new DateTime(2000, Date.Month.MAY, 15, 12, 29, 50));
        testCases[5]  = new DateTimeTestCase(0, 0, 0, 0, 0, 80, new DateTime(2000, Date.Month.MAY, 15, 12, 29, 10));
        testCases[6]  = new DateTimeTestCase(0, 0, 0, 0, 0, 160, new DateTime(2000, Date.Month.MAY, 15, 12, 27, 50));
        testCases[7]  = new DateTimeTestCase(0, 0, 0, 0, 1, 1, new DateTime(2000, Date.Month.MAY, 15, 12, 29, 29)); 
        testCases[8]  = new DateTimeTestCase(0, 0, 0, 0, 10, 10, new DateTime(2000, Date.Month.MAY, 15, 12, 20, 20)); 
        testCases[9]  = new DateTimeTestCase(0, 0, 0, 0, 20, 20, new DateTime(2000, Date.Month.MAY, 15, 12, 10, 10)); 
        testCases[10] = new DateTimeTestCase(0, 0, 0, 0, 40, 40, new DateTime(2000, Date.Month.MAY, 15, 11, 49, 50)); 
        testCases[11] = new DateTimeTestCase(0, 0, 0, 0, 80, 80, new DateTime(2000, Date.Month.MAY, 15, 11, 9, 10)); 
        testCases[12] = new DateTimeTestCase(0, 0, 0, 0, 160, 160, new DateTime(2000, Date.Month.MAY, 15, 9, 47, 50)); 
        testCases[13] = new DateTimeTestCase(0, 0, 0, 1, 1, 1, new DateTime(2000, Date.Month.MAY, 15, 11, 29, 29));
        testCases[14] = new DateTimeTestCase(0, 0, 0, 10, 10, 10, new DateTime(2000, Date.Month.MAY, 15, 2, 20, 20));
        testCases[15] = new DateTimeTestCase(0, 0, 0, 20, 20, 20, new DateTime(2000, Date.Month.MAY, 15, 12, 30, 30));
        testCases[16] = new DateTimeTestCase(0, 0, 0, 40, 40, 40, new DateTime(2000, Date.Month.MAY, 14, 12, 30, 30));
        testCases[17] = new DateTimeTestCase(0, 0, 0, 80, 80, 80, new DateTime(2000, Date.Month.MAY, 12, 3, 9, 10)); 
        testCases[18] = new DateTimeTestCase(0, 0, 0, 160, 160, 160, new DateTime(2000, Date.Month.MAY, 9, 12, 30, 30)); 
        testCases[19] = new DateTimeTestCase(0, 0, 1, 1, 1, 1, new DateTime(2000, Date.Month.MAY, 14, 11, 29, 29));
        testCases[20] = new DateTimeTestCase(0, 0, 10, 10, 10, 10, new DateTime(2000, Date.Month.MAY, 5, 2, 20, 20));
        testCases[21] = new DateTimeTestCase(0, 0, 20, 20, 20, 20, new DateTime(2000, Date.Month.APR, 25, 12, 30, 30));
        testCases[22] = new DateTimeTestCase(0, 0, 40, 40, 40, 40, new DateTime(2000, Date.Month.APR, 4, 12, 30, 30));
        testCases[23] = new DateTimeTestCase(0, 0, 80, 80, 80, 80, new DateTime(2000, Date.Month.FEB, 22, 3, 9, 10));
        testCases[24] = new DateTimeTestCase(0, 0, 160, 160, 160, 160, new DateTime(1999, Date.Month.DEC, 1, 12, 30, 30));
        testCases[25] = new DateTimeTestCase(0, 1, 1, 1, 1, 1, new DateTime(2000, Date.Month.APR, 14, 11, 29, 29));
        testCases[26] = new DateTimeTestCase(0, 10, 10, 10, 10, 10, new DateTime(1999, Date.Month.JUL, 5, 2, 20, 20));
        testCases[27] = new DateTimeTestCase(0, 10, 20, 20, 20, 20, new DateTime(1999, Date.Month.JUN, 25, 12, 30, 30));
        testCases[28] = new DateTimeTestCase(0, 40, 40, 40, 40, 40, new DateTime(1996, Date.Month.DEC, 5, 12, 30, 30));
        testCases[29] = new DateTimeTestCase(0, 80, 80, 80, 80, 80, new DateTime(1993, Date.Month.JUN, 24, 3, 9, 10));
        testCases[30] = new DateTimeTestCase(0, 160, 160, 160, 160, 160, new DateTime(1986, Date.Month.AUG, 2, 12, 30, 30));
        testCases[31] = new DateTimeTestCase(1, 1, 1, 1, 1, 1, new DateTime(1999, Date.Month.APR, 14, 11, 29, 29)); 
        testCases[32] = new DateTimeTestCase(10, 10, 10, 10, 10, 10, new DateTime(1989, Date.Month.JUL, 5, 2, 20, 20));
        testCases[33] = new DateTimeTestCase(20, 20, 20, 20, 20, 20, new DateTime(1978, Date.Month.AUG, 26, 12, 30, 30));
        testCases[34] = new DateTimeTestCase(40, 40, 40, 40, 40, 40, new DateTime(1956, Date.Month.DEC, 5, 12, 30, 30));
        testCases[35] = new DateTimeTestCase(80, 80, 80, 80, 80, 80, new DateTime(1913, Date.Month.JUN, 24, 3, 9, 10));
        testCases[36] = new DateTimeTestCase(160, 160, 160, 160, 160, 160, new DateTime(1900, Date.Month.DEC, 32, 25, 61, 61));
        testCases[37] = new DateTimeTestCase(-1, 0, 0, 0, 0, 0, new DateTime(1900, Date.Month.DEC, 32, 12, 30, 30));
        testCases[38] = new DateTimeTestCase(0, -1, 0, 0, 0, 0, new DateTime(1900, Date.Month.DEC, 32, 12, 30, 30));
        testCases[39] = new DateTimeTestCase(0, 0, -1, 0, 0, 0, new DateTime(1900, Date.Month.DEC, 32, 12, 30, 30));
        testCases[40] = new DateTimeTestCase(0, 0, 0, -1, 0, 0, new DateTime(1900, Date.Month.DEC, 32, 12, 30, 30));
        testCases[41] = new DateTimeTestCase(0, 0, 0, 0, -1, 0, new DateTime(1900, Date.Month.DEC, 32, 12, 30, 30));
        testCases[42] = new DateTimeTestCase(0, 0, 0, 0, 0, -1, new DateTime(1900, Date.Month.DEC, 32, 12, 30, 30));

        for (DateTimeTestCase testCase : testCases) {
            boolean testPass = false;
            DateTime result;

            try {
                result = base.subtract(testCase.years, testCase.months, testCase.days, testCase.hours, testCase.minutes, testCase.seconds);
                testPass = testCase.expected.compareTo(result) == 0;

                if (selectedTypeOfOutput == ShowTestOutput.ALL) {
                    System.out.println(String.format("Test DateTime.subtract() controlObj:%s + %s AO:%s // TestPass:%s", base.toString(), testCase.toString(), result.toString(), testPass ));
                } else if (selectedTypeOfOutput == ShowTestOutput.ON_ERROR && !testPass) {
                    System.out.println(String.format("Test DateTime.subtract() controlObj:%s + %s AO:%s // TestPass:%s", base.toString(), testCase.toString(), result.toString(), testPass ));
                }
            } catch (IllegalArgumentException exception) {
                testPass = testCase.expected.compareTo(expectedException) == 0;

                if (selectedTypeOfOutput == ShowTestOutput.ALL && testPass) {
                    System.out.println(String.format("Test DateTime.subtract() controlObj:%s + %s AO:%s // TestPass:%s", base.toString(), testCase.toString(), expectedException.toString(), testPass ));
                } else if (selectedTypeOfOutput == ShowTestOutput.ON_ERROR && !testPass) {
                    // System.out.println("Test DateTime.subtract() " + exception);
                }
            }
        }
    }

    private static void unitTestDateTimeDiff(ShowTestOutput selectedTypeOfOutput) {
        DateTime dateTimeDiffControlObj = new DateTime(2000, Date.Month.MAY, 15, 12, 30, 30);
        dateTimeDiffControlObj.getDate().setDayspan(0);
        DateTime valueToCheckForException = new DateTime(1900, Date.Month.DEC, 32, 12, 0, 0);

        // DateTime checkValue1 = new DateTime(2000, Date.Month.MAY, 15, 12, 30, 29);

        DateTime[] diffBy = new DateTime[9];
        diffBy[0] = new DateTime(2000, Date.Month.MAY, 15, 12, 30, 29);
        diffBy[1] = new DateTime(2000, Date.Month.MAY, 15, 12, 30, 31);
        diffBy[2] = new DateTime(2000, Date.Month.MAY, 15, 12, 30, 30);
        diffBy[3] = new DateTime(2000, Date.Month.MAY, 15, 12, 30, 20);
        diffBy[4] = new DateTime(2000, Date.Month.MAY, 15, 12, 30, 40);
        diffBy[5] = new DateTime(2000, Date.Month.MAY, 17, 12, 20, 40);
        diffBy[6] = new DateTime(2000, Date.Month.MAY, 20, 12, 20, 40);
        diffBy[7] = new DateTime(2000, Date.Month.JUN, 20, 12, 20, 40);
        diffBy[8] = new DateTime(2004, Date.Month.MAY, 15, 12, 30, 30);


        for (int i = 0; i < diffBy.length; i++) {
            DateTime checkDiff = dateTimeDiffControlObj.diff(diffBy[i]);
            System.out.println(String.format("%d days, %d:h %d:m %d:s", checkDiff.getDate().getDayspan(), checkDiff.getTime().getHour(), checkDiff.getTime().getMinute(true), checkDiff.getTime().getSecond(false) ));
            // System.out.println(diffBy[i].getDate().getDayspan());
            // System.out.println(checkDiff.getDate().getDayspan());

        }
        // System.out.println(dateTimeDiffControlObj.getDate().getDayspan());

        // DateTime checkDiff = dateTimeDiffControlObj.diff(diffBy[0]);

        // System.out.println(String.format("D:, H:, M:, S:%d", checkDiff.getTime().getSecond(false) ));
    }

    private static void unitTestCalendarCalcDayOfWeek(ShowTestOutput selectedTypeOfOutput){
      //1.) Provide a date
      //2.) Give an expected int day of the week value
      //3.) Check for match

      Date[] inputValues = new Date[10];
      inputValues[0] = new Date(1900, Date.Month.JAN, 1);
      inputValues[1] = new Date(1900, Date.Month.JAN, 2);
      inputValues[2] = new Date(1900, Date.Month.FEB, 1);
      inputValues[3] = new Date(1900, Date.Month.MAR, 1);
      inputValues[4] = new Date(1900, Date.Month.DEC, 30);
      inputValues[5] = new Date(1904, Date.Month.JAN, 1);
      inputValues[6] = new Date(1904, Date.Month.JAN, 2);
      inputValues[7] = new Date(1904, Date.Month.FEB, 1);
      inputValues[8] = new Date(1904, Date.Month.MAR, 1);
      inputValues[9] = new Date(1904, Date.Month.DEC, 30);

      int[] expectedValue = new int[10];
      expectedValue[0] = 1;
      expectedValue[1] = 2;
      expectedValue[2] = 4;
      expectedValue[3] = 4;
      expectedValue[4] = 0;
      expectedValue[5] = 5;
      expectedValue[6] = 6;
      expectedValue[7] = 1;
      expectedValue[8] = 2;
      expectedValue[9] = 5;

      for (int i = 0; i < inputValues.length; i++) {
        boolean testPass = false;
        int payload = Calendar.calcDayOfWeek(inputValues[i]);
        //testing print statement
        Calendar.calcWeeksInMonth(inputValues[i]);

        if (expectedValue[i] == payload) {
          testPass = true;
        }

        if (selectedTypeOfOutput == ShowTestOutput.ALL) {
          System.out.println(String.format("Test Calendar.calcDayOfWeek() inputValue:%s// EO:%d AO:%d // TestPass:%s", inputValues[i].toString(), expectedValue[i], payload, testPass));
        } else if (selectedTypeOfOutput == ShowTestOutput.ON_ERROR && !testPass) {
          System.out.println(String.format("Test Calendar.calcDayOfWeek() inputValue:%s// EO:%d AO:%d // TestPass:%s", inputValues[i].toString(), expectedValue[i], payload, testPass));          
        } 
      }
    }

    private static void genericTestMethod(Object[] input, Object expectedOutput) {
        //I want to test <(input), (expectedOutput), (class to test in), (method to use)>
        //current thinking: since I can find the class that is input, should I have an override for equals in each of my classes to make testing easier
        System.out.println(input[0].toString());
        System.out.println(input[0].getClass());
        System.out.println(input[1].hashCode());
    }

    private static class DateTestCase {
        private final int years;
        private final int months;
        private final int days;
        private final Date expected;

        private DateTestCase(final int years, final int months, final int days, final Date expected) {
            this.years = years;
            this.months = months;
            this.days = days;
            this.expected = expected;
        }

        int getYears() {
            return this.years;
        }

        int getMonths() {
            return this.months;
        }

        int getDays() {
            return this.days;
        }

        @Override
        public String toString() {
            return String.format("(%d/%d/%d) // E):%s", this.years, this.months, this.days, this.expected.toString());
        }
    }

    private static class DateDiffTestCase {
        private final Date firstInput;
        private final Date secondInput;
        private final int firstInputYears;
        private final int firstInputMonths;
        private final int firstInputDays;
        private final int secondInputYears;
        private final int secondInputMonths;
        private final int secondInputDays;
        private final int expected;

        private DateDiffTestCase(final Date firstInput, final Date secondInput, final int expected) {
            this.firstInput = firstInput;
            this.secondInput = secondInput;
            this.firstInputYears = firstInput.getYear();
            this.firstInputMonths = firstInput.getMonth().ordinal() + 1;
            this.firstInputDays = firstInput.getDay();
            this.secondInputYears = secondInput.getYear();
            this.secondInputMonths = secondInput.getMonth().ordinal() + 1;
            this.secondInputDays = secondInput.getDay();

            this.expected = expected;
        }

        Date getFirstInput() {
            return this.firstInput;
        }

        Date getSecondInput() {
            return this.secondInput;
        }

        int getFirstInputYears() {
            return this.firstInputYears;
        }

        int getFirstInputMonths() {
            return this.firstInputMonths;
        }

        int getFirstInputDays() {
            return this.firstInputDays;
        }

        int getSecondInputYears() {
            return this.secondInputYears;
        }

        int getSecondInputMonths() {
            return this.secondInputMonths;
        }

        int getSecondInputDays() {
            return this.secondInputDays;
        }

        @Override
        public String toString() {
            return String.format("baseOBJ:%d/%d/%d diffOBJ:%d/%d/%d // EO:%d", this.firstInputYears, this.firstInputMonths, this.firstInputDays, this.secondInputYears, this.secondInputMonths, this.secondInputDays, this.expected);
        }
    }

    private static class DateTimeTestCase {
        private final int years;
        private final int months;
        private final int days;
        private final int hours;
        private final int minutes;
        private final int seconds;
        private final DateTime expected;

        private DateTimeTestCase(final int years, final int months, final int days, final int hours, final int minutes, final int seconds, final DateTime expected) {
            this.years = years;
            this.months = months;
            this.days = days;
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            this.expected = expected;
        }

        int getYears() {
            return this.years;
        }

        int getMonths() {
            return this.months;
        }

        int getDays() {
            return this.days;
        }

        int getHours() {
            return this.hours;
        }

        int getMinutes() {
            return this.minutes;
        }

        int getSeconds() {
            return this.seconds;
        }

        //TODO: Update values to include Time
        @Override
        public String toString() {
            return String.format("(%d/%d/%d %d:%d:%d) // E:%s", this.years, this.months, this.days, this.hours, this.minutes, this.seconds, this.expected.toString());
            // System.out.println(String.format("Test DateTime.add() controlObj:%s modifier:%d/%d/%d %d:%d:%d // EO:%s AO:%s // TestPass:%s", dateTimeAddControlObj.toString(), addBy[i][0], addBy[i][1], addBy[i][2], addBy[i][3], addBy[i][4], addBy[i][5], expectedResult[i].toString(), actualResult.toString(), testPass ));
        }
    }
}