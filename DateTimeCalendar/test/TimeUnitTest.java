package priv.exercises.datetime;

public class TimeUnitTest {

    public static void unitTestTimeUnitToSeconds(ShowTestOutput selectedTypeOfOutput) {
        /* Notes
        *  In -> Unit unit, long duration
        *  Out -> long
        *  Expected -> long
        */

        final long base = 60l;
        final long expectedException = -1l;

        TimeUnitTestCase[] testCases = new TimeUnitTestCase[5];
        testCases[0] = new TimeUnitTestCase(TimeUnit.Unit.SECOND, 60l, 60l);
        testCases[1] = new TimeUnitTestCase(TimeUnit.Unit.MINUTE, 1l, 60l);
        testCases[2] = new TimeUnitTestCase(TimeUnit.Unit.HOUR, 1l, 3600l);
        testCases[3] = new TimeUnitTestCase(TimeUnit.Unit.HOUR, 24l, 86400l);
        testCases[4] = new TimeUnitTestCase(TimeUnit.Unit.MINUTE, -1l, -1l); 
        //Note: Didn't test for null, as method is expecting in, if null is entered there is a compiler error. 

        for (TimeUnitTestCase testCase : testCases) {
            boolean testPass = false;
            long result;

            try {
                result = TimeUnit.toSeconds(testCase.getInputUnit(), testCase.getInputDuration());
                testPass = testCase.getExpectedOutput() == result;
                if (selectedTypeOfOutput == selectedTypeOfOutput.ALL) {
                    System.out.println(String.format("Test TimeUnit.toSeconds() %s A: %s // TestPass: %s", testCase.toString(), result, testPass));              
                } else if (selectedTypeOfOutput == ShowTestOutput.ON_ERROR && !testPass) {
                    System.out.println(String.format("Test TimeUnit.toSeconds() %s A: %s // TestPass: %s", testCase.toString(), result, testPass));   
                }
            } catch (IllegalArgumentException exception) {
                testPass = testCase.getExpectedOutput() == expectedException;

                if (selectedTypeOfOutput == ShowTestOutput.ALL && testPass) {
                    System.out.println(String.format("Test TimeUnit.toSeconds() %s A: %s // TestPass: %s", testCase.toString(), expectedException, testPass));
                }
                if (selectedTypeOfOutput == ShowTestOutput.ON_ERROR && !testPass) {
                    System.out.println("Test TimeUnit.toSeconds() " + exception);
                }
            }
        }
    }

    public static void unitTestTimeUnitToMinutes(ShowTestOutput selectedTypeOfOutput) {
        /* Notes
        *  In -> Unit unit, long duration
        *  Out -> long
        *  Expected -> long
        */

        final long base = 60l;
        final long expectedException = -1l;

        TimeUnitTestCase[] testCases = new TimeUnitTestCase[5];
        testCases[0] = new TimeUnitTestCase(TimeUnit.Unit.SECOND, 0l, -1l);
        testCases[1] = new TimeUnitTestCase(TimeUnit.Unit.SECOND, 9223372036854775807l, 153722867280912930l);
        testCases[2] = new TimeUnitTestCase(TimeUnit.Unit.SECOND, -1l, -1l);
        testCases[3] = new TimeUnitTestCase(TimeUnit.Unit.SECOND, 60l, 1l);
        testCases[4] = new TimeUnitTestCase(TimeUnit.Unit.SECOND, 3600l, 60l);
        
        // testCases[2] = new TimeUnitTestCase(TimeUnit.Unit.HOUR, 1l, 3600l);
        // testCases[3] = new TimeUnitTestCase(TimeUnit.Unit.HOUR, 24l, 86400l);
        // testCases[4] = new TimeUnitTestCase(TimeUnit.Unit.MINUTE, -1l, -1l); 
        //Note: Didn't test for null, as method is expecting in, if null is entered there is a compiler error. 

        for (TimeUnitTestCase testCase : testCases) {
            boolean testPass = false;
            long result;

            try {
                result = TimeUnit.toMinutes(testCase.getInputUnit(), testCase.getInputDuration());
                testPass = testCase.getExpectedOutput() == result;
                if (selectedTypeOfOutput == selectedTypeOfOutput.ALL) {
                    System.out.println(String.format("Test TimeUnit.toMinutes() %s A: %s // TestPass: %s", testCase.toString(), result, testPass));              
                } else if (selectedTypeOfOutput == ShowTestOutput.ON_ERROR && !testPass) {
                    System.out.println(String.format("Test TimeUnit.toMinutes() %s A: %s // TestPass: %s", testCase.toString(), result, testPass));   
                }
            } catch (IllegalArgumentException exception) {
                testPass = testCase.getExpectedOutput() == expectedException;

                if (selectedTypeOfOutput == ShowTestOutput.ALL && testPass) {
                    System.out.println(String.format("Test TimeUnit.toMinutes() %s A: %s // TestPass: %s", testCase.toString(), expectedException, testPass));
                }
                if (selectedTypeOfOutput == ShowTestOutput.ON_ERROR && !testPass) {
                    System.out.println("Test TimeUnit.toMinutes() " + exception);
                }
            }
        }
    }

    private static class TimeUnitTestCase{
        private final TimeUnit.Unit inputUnit;
        private final long inputDuration;
        private final long expectedOutput;

        private TimeUnitTestCase(final TimeUnit.Unit inputUnit, final long inputDuration, final long expectedOutput) {
            this.inputUnit = inputUnit;
            this.inputDuration = inputDuration;
            this.expectedOutput = expectedOutput;
        }

        TimeUnit.Unit getInputUnit() {
            return this.inputUnit;
        }

        long getInputDuration() {
            return this.inputDuration;
        }

        long getExpectedOutput() {
            return this.expectedOutput;
        }

        @Override
        public String toString() {
            return String.format("Input:(TimeUnit.Unit: %s, long duration: %s) // E: %s,",  this.inputUnit, this.inputDuration, this.expectedOutput); 
        }
    }

}