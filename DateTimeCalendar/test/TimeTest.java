package priv.exercises.datetime;

public class TimeTest{
    public static void main(String[] args) {
        Time t1 = new Time(60l);
    }

    public TimeTest(ShowTestOutput selectedTypeOfOutput) {
        unitTestTimeConstructures(selectedTypeOfOutput);
        unitTestTimeAdd(selectedTypeOfOutput);
        unitTestTimeSubtract(selectedTypeOfOutput);
        unitTestTimeCompareTo(selectedTypeOfOutput);
        unitTestTimeConvToSeconds(selectedTypeOfOutput);
    }

    public TimeTest(ShowTestOutput constructuresOutput, ShowTestOutput addOutput, ShowTestOutput subtractOutput, ShowTestOutput compareToOutput, ShowTestOutput convToSecondsOutput) {
        unitTestTimeConstructures(constructuresOutput);
        unitTestTimeAdd(addOutput);
        unitTestTimeSubtract(subtractOutput);
        unitTestTimeCompareTo(compareToOutput);
        unitTestTimeConvToSeconds(convToSecondsOutput);
    }

    public static void unitTestTimeConstructures(ShowTestOutput selectedTypeOfOutput) {
        // System.out.println("Constructors");
    }

    public static void unitTestTimeAdd(ShowTestOutput selectedTypeOfOutput) {
        final Time base = new Time(43200l);
        TimeAddTestCase[] testCasess = new TimeAddTestCase[14];
        testCasess[0] = new TimeAddTestCase(base, new Time(0l), new Time(43200l));
        testCasess[1] = new TimeAddTestCase(base, new Time(1l), new Time(43201l));
        testCasess[2] = new TimeAddTestCase(base, new Time(10l), new Time(43210l));
        testCasess[3] = new TimeAddTestCase(base, new Time(1000l), new Time(44200l));
        testCasess[4] = new TimeAddTestCase(base, new Time(-1l), new Time(43199l));
        testCasess[5] = new TimeAddTestCase(base, new Time(0, 0, 1), new Time(43201l));
        testCasess[6] = new TimeAddTestCase(base, new Time(0, 0, 10), new Time(43210l));
        testCasess[7] = new TimeAddTestCase(base, new Time(0, 0, 1000), new Time(44200l));
        testCasess[8] = new TimeAddTestCase(base, new Time(0, 1, 0), new Time(43260l));
        testCasess[9] = new TimeAddTestCase(base, new Time(0, 10, 0), new Time(43800l));
        testCasess[10] = new TimeAddTestCase(base, new Time(0, 1000, 0), new Time(103200l));
        testCasess[11] = new TimeAddTestCase(base, new Time(1, 0, 0), new Time(46800l));
        testCasess[12] = new TimeAddTestCase(base, new Time(10, 0, 0), new Time(79200l));
        testCasess[13] = new TimeAddTestCase(base, new Time(1000, 0, 0), new Time(3643200l));
        

        for (TimeAddTestCase testCase : testCasess) {
            boolean testPass = false;
            Time result;

            try {
                result = base.add(testCase.secondInput);
                testPass = testCase.getExpected() == result.getSecond(true);
                if (selectedTypeOfOutput == ShowTestOutput.ALL) {
                    System.out.println(String.format("Test Time.add() %s AO:%s // TestPass:%s", testCase.toString(), result.getSecond(true), testPass));
                } else if (selectedTypeOfOutput == ShowTestOutput.ON_ERROR && !testPass) {
                    System.out.println(String.format("Test Time.add() %s AO:%s // TestPass:%s", testCase.toString(), result.getSecond(true), testPass));
                }
            } catch (IllegalArgumentException exception) {
                if (selectedTypeOfOutput == ShowTestOutput.ALL || selectedTypeOfOutput == ShowTestOutput.ON_ERROR) {
                    System.out.println(exception);
                }
            }
        }
    }

    public static void unitTestTimeSubtract(ShowTestOutput selectedTypeOfOutput) {
        //subtract should only work by a second obj, or by the full obj
        final Time base = new Time(43200l);

        TimeTestCase[] testCases = new TimeTestCase[1];
        testCases[0] = new TimeTestCase(TimeUnit.Unit.SECOND, new Time(0l), new Time(43200l));


        //manual testing to check how to auto test
        Time result;

        result = base.subtract(TimeUnit.Unit.SECOND, 0l);

        System.out.println(base.getSecond(true) + " " +result.getSecond(true));

        result = base.subtract(TimeUnit.Unit.MINUTE, 1l);

        System.out.println(base.getSecond(true) + " " +result.getSecond(true));


        result = base.subtract(TimeUnit.Unit.HOUR, 1l);

        System.out.println(base.getSecond(true) + " " +result.getSecond(true));


        //testing TimeUnit
        System.out.println(TimeUnit.toSeconds(TimeUnit.Unit.SECOND, 1l));
        System.out.println(TimeUnit.toSeconds(TimeUnit.Unit.MINUTE, 1l));
        System.out.println(TimeUnit.toSeconds(TimeUnit.Unit.HOUR, 1l));
        System.out.println(TimeUnit.toSeconds(TimeUnit.Unit.HOUR, 24l));
        



    }

    public static void unitTestTimeCompareTo(ShowTestOutput selectedTypeOfOutput) {
        // System.out.println("CompareTo");
    }

    public static void unitTestTimeConvToSeconds(ShowTestOutput selectedTypeOfOutput) {
        // System.out.println("ConvToSeconds");
    }

    private static class TimeTestCase {
        private final TimeUnit.Unit timeUnit;
        private final Time firstInput;
        private final Time expected;

        private TimeTestCase(final TimeUnit.Unit timeUnit, final Time firstInput, final Time expected) {
            this.timeUnit = timeUnit;
            this.firstInput = firstInput;
            this.expected = expected;
        }

        TimeUnit.Unit getTimeUnit() {
            return this.timeUnit;
        }

        Time getFirstInput() {
            return this.firstInput;
        }

        Time getExpected() {
            return this.expected;
        }

        @Override
        public String toString() {
            // return String.format("baseOBJ:%s // add:%s // EO:%s", firstInput.getSecond(true), secondInput.getSecond(true), expected.getSecond(true));
            return String.format("subtract:%s // EO:%s", getFirstInput(), getExpected());
        }
    }

    private static class TimeAddTestCase {
        private final Time firstInput;
        private final Time secondInput;
        private final Time expected;

        private TimeAddTestCase(final Time firstInput, final Time secondInput, final Time expected) {
            this.firstInput = firstInput;
            this.secondInput = secondInput;
            this.expected = expected;
        }

        float getFirstInput() {
            return this.firstInput.getSecond(true);
        }

        float getSecondInput() {
            return this.secondInput.getSecond(true);
        }

        float getExpected() {
            return this.expected.getSecond(true);
        }

        @Override
        public String toString() {
            // return String.format("baseOBJ:%s // add:%s // EO:%s", firstInput.getSecond(true), secondInput.getSecond(true), expected.getSecond(true));
            return String.format("baseOBJ:%s // add:%s // EO:%s", getFirstInput(), getSecondInput(), getExpected());
        }
    }
}