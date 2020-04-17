package priv.exercises.datetime;

public class DateTest{

    protected static void unitTestDateCompareTo(Date obj1, Date obj2, int expectedOut){
        int result = obj1.compareTo(obj2);
        boolean testPass = false;

        if (result == expectedOut){
            testPass = true;
        }

        System.out.println(String.format("Test Date.compareTo() obj1:%s obj2:%s  ExpectedOut:%d TestPass:%s",obj1.toString(), obj2.toString(), result, testPass ));
    }

    protected static void unitTestDateDiff(ShowTestOutput selectedTypeOfOutput){
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

        // Below is showing how we can access the helper class. 
        // System.out.println(testCasess[9].firstInputYears + " Well hello");
    }

    protected static void unitTestDateAdd(ShowTestOutput selectedTypeOfOutput){
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

    protected static void unitTestDateSubtract(ShowTestOutput selectedTypeOfOutput){
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
}

