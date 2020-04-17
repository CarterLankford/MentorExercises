package priv.exercises.datetime;

public class DateTimeTest{
    //TODO: Work on DateTimeTest.unitTestDateTimeDiff with vic
    protected static void unitTestDateTimeConstructors() {
        //Main Constructor 
        DateTime dateTimeConstructorsControlObj = new DateTime(1900, Date.Month.JAN, 5, 12, 10, 30);

        //by object
        Time tm1 = new Time(12, 10, 30);
        Date dt1 = new Date(1900, Date.Month.JAN, 5);
        DateTime dateTimeConstructorsWithObjs = new DateTime(dt1, tm1);

        //by obj individually
        DateTime dateTimeConstructorsWithObjTime = new DateTime(tm1);
        DateTime dateTimeConstructorsWithObjDate = new DateTime(dt1);

        //by var individually
        DateTime dateTimeConstructorsWithVarTime = new DateTime(12, 10, 30);
        DateTime dateTimeConstructorsWithVarDate = new DateTime(1900, Date.Month.JAN, 5);
    }

    protected static void unitTestDateTimeAdd(ShowTestOutput selectedTypeOfOutput) {
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

    protected static void unitTestDateTimeSubtract(ShowTestOutput selectedTypeOfOutput) {
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

    protected static void unitTestDateTimeDiff(ShowTestOutput selectedTypeOfOutput) {
        //this tests if it's above or below correctly but not if the output is correct

        final DateTime base = new DateTime(2000, Date.Month.MAY, 15, 12, 30, 30);
        final int expectedException = 2;
        DateTimeDiffTestCase[] testCases = new DateTimeDiffTestCase[1];
        testCases[0] = new DateTimeDiffTestCase(base, new DateTime(2000, Date.Month.MAY, 15, 12, 30, 30), new DateTime(new Date(2020, Date.Month.MAY, 15), new Time(12, 12, 2)));
        
        //use below logic to test for pass/fail
        DateTime jk = new DateTime(new Date(2020, Date.Month.MAY, 15), new Time(12, 12, 12));
        System.out.println(base.compareTo(jk) + " here");

        //use compareTo to check the validaity of tihs

        for (DateTimeDiffTestCase testCase : testCases) {
            boolean testPass = false;
            DateTime result;

            try {
            
                DateTime test1 = base.diff(base);
                System.out.println(test1.toString());
                //Start with the base and work up from there
                // System.out.println(base.getDate().toString() + " " + base.getTime().toString());
                // DateTime dtTest =  base.diff(new DateTime(2000, Date.Month.MAY, 15, 12, 30,35));
                //System.out.println(String.format("%d days, %d:h %d:m %d:s", checkDiff.getDate().getDayspan(), checkDiff.getTime().getHour(), checkDiff.getTime().getMinute(true), checkDiff.getTime().getSecond(false) ));
                // System.out.println(dtTest.getDate().getDayspan() + " " + dtTest.getTime().getSecond(false)); // how to test against this? two ints? 
                
                //days -= isLeapYear(modifiedYear) ? DAYS_IN_LEAP_YEAR : DAYS_IN_REG_YEAR;
                // if (selectedTypeOfOutput == ShowTestOutput.ALL) {
                //     System.out.println(String.format("Test DateTime.diff() controlObj:%s + diff:%s // EO:%s AO:%s // TestPass:%s", testCase.getFirstInput().toString(), testCase.getSecondInput(), testCase.getExpected(), testCase.getExpected(), testPass));
                // } else if (selectedTypeOfOutput == ShowTestOutput.ON_ERROR && !testPass) {
                //     // System.out.println(String.format("Test DateTime.diff() controlObj:%s + diff:%s // EO:%s AO:%s // TestPass:%s", testCase.getFirstInput().toString(), testCase.getSecondInput(), testCase.getExpected(), result, testPass));
                // }
            } catch (IllegalArgumentException exception) {
                // testPass = testCase.expected == 2;

                //Not sure how to work this logic, but I've added it in case it pops up with a helpful reminder to work on it once a case has presented itself. 
                // if (selectedTypeOfOutput == ShowTestOutput.ALL && testPass) {
                //     System.out.println("There is not a failure message for what you did. Collect your input and add it to the tests.");
                // } else if (selectedTypeOfOutput == ShowTestOutput.ON_ERROR && !testPass) {
                //     System.out.println("There is not a failure message for what you did. Collect your input and add it to the tests.");
                // }
            }
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

    private static class DateTimeDiffTestCase {
        private final DateTime firstInput;
        private final DateTime secondInput;
        private final DateTime expected;

        private DateTimeDiffTestCase(final DateTime firstInput, final DateTime secondInput, final DateTime expected) {
            this.firstInput = firstInput;
            this.secondInput = secondInput;
            this.expected = expected;
        }

        DateTime getFirstInput() {
            return this.firstInput;
        }

        DateTime getSecondInput() {
            return this.secondInput;
        }

        DateTime getExpected() {
            return this.expected;
        }
    }
}