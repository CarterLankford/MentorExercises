public class App{
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


        unitTestDateAdd(0);
        unitTestDateDiff(0);
        unitTestDateSubtract(0);

        //Test DateTime
        unitTestDateTimeConstructors(0);
        unitTestDateTimeAdd(0);
        unitTestDateTimeSubtract(0);
        unitTestDateTimeDiff(2);

        DateTime myNewDateTime1 = new DateTime(2019, Date.Month.NOV, 6, 8, 15, 0);
        DateTime myNewDateTime2 = new DateTime(2019, Date.Month.NOV, 6, 16, 40, 0);
        DateTime myNewDateCompare = myNewDateTime1.diff(myNewDateTime2);
        System.out.println(String.format("%d days, %d:h %d:m %d:s", myNewDateCompare.getDate().getDayspan(), myNewDateCompare.getTime().getHour(), myNewDateCompare.getTime().getMinute(false), myNewDateCompare.getTime().getSecond(false) ));

        unitTestCalendarCalcDayOfWeek(0);

        DateTime[] dta = new DateTime[3];
        dta[0] = new DateTime(1900, Date.Month.JAN, 1, 12, 30, 30);
        dta[1] = new DateTime(1900, Date.Month.JAN, 1, 12, 30, 30);
        dta[2] = new DateTime(1900, Date.Month.JAN, 1, 12, 30, 29);

        genericTestMethod(dta, myNewDateTime2);
    }

    private static void unitTestDateCompareTo(Date obj1, Date obj2, int expectedOut){
        int result = obj1.compareTo(obj2);
        boolean testPass = false;

        if (result == expectedOut){
            testPass = true;
        }

        System.out.println(String.format("Test Date.compareTo() obj1:%s obj2:%s  ExpectedOut:%d TestPass:%s",obj1.toString(), obj2.toString(), result, testPass ));
    }

    private static void unitTestDateAdd(int showOutput){
        //showOutput//0 = Show nothing, 1 = show failures, 2 = show all
        Date dateTestAddControlObj = new Date(1900, Date.Month.JAN, 0);
        int[][] mArray = {
                          {0, 0, 1}, 
                          {0, 0, 31},
                          {0, 0, 41},
                          {0, 0, 60},
                          {0, 0, 500},
                          {0, 0, 1000},
                          {0, 0, 2000},
                          {0, 1, 0},
                          {0, 31, 0},
                          {0, 41, 0},
                          {0, 60, 0},
                          {0, 500, 0},
                          {0, 1000, 0},
                          {0, 2000, 0}
                         };

        Date[] expectedResult = new Date[14];
        expectedResult[0] = new Date(1900, Date.Month.JAN, 1);
        expectedResult[1] = new Date(1900, Date.Month.JAN, 31);
        expectedResult[2] = new Date(1900, Date.Month.FEB, 10);
        expectedResult[3] = new Date(1900, Date.Month.MAR, 10);
        expectedResult[4] = new Date(1901, Date.Month.MAY, 15);
        expectedResult[5] = new Date(1902, Date.Month.SEP, 27);
        expectedResult[6] = new Date(1905, Date.Month.JUN, 23);
        expectedResult[7] = new Date(1900, Date.Month.FEB, 0);
        expectedResult[8] = new Date(1902, Date.Month.AUG, 0);
        expectedResult[9] = new Date(1903, Date.Month.JUN, 0);
        expectedResult[10] = new Date(1905, Date.Month.JAN, 0);
        expectedResult[11] = new Date(1941, Date.Month.SEP, 0);
        expectedResult[12] = new Date(1983, Date.Month.MAY, 0);
        expectedResult[13] = new Date(2066, Date.Month.SEP, 0);

        for (int i = 0; i < mArray.length; i++) {
            boolean testPass = false;
            int x;
            //TODO: fix below
            Date result = new Date(1900, Date.Month.JAN, 0);
            try {
                result = dateTestAddControlObj.add(mArray[i][0], mArray[i][1], mArray[i][2]);
                x = expectedResult[i].compareTo(result);
            } catch (IllegalArgumentException exception) {
                x = -1;
            }
            
            
            if (x == 0) {
                testPass = true;
            } 

            if (showOutput == 2) {
                System.out.println(String.format("Test Date.add() controlObj:%s + (%d/%d/%d) // EO:%s AO:%s // TestPass:%s", dateTestAddControlObj.toString(), mArray[i][0], mArray[i][1], mArray[i][2], expectedResult[i].toString(), result.toString(), testPass ));
            } else if (showOutput == 1){
                if (testPass == false){
                    System.out.println(String.format("Test Date.add() controlObj:%s + (%d/%d/%d) // EO:%s AO:%s // TestPass:%s", dateTestAddControlObj.toString(), mArray[i][0], mArray[i][1], mArray[i][2], expectedResult[i].toString(), result.toString(), testPass ));
                }
            }
        }
    }

    private static void unitTestDateDiff(int showOutput){
        //Wondering how to test for exception, and know that's the result I want
        //showOutput//0 = Show nothing, 1 = show failures, 2 = show all
        //expectedResult// -1 = exception thrown
        Date[] testCases = new Date[10]; 
        testCases[0] = new Date(1900, Date.Month.JAN, 0);
        testCases[1] = new Date(1900, Date.Month.JAN, 0);
        testCases[2] = new Date(1900, Date.Month.JAN, 1);
        testCases[3] = new Date(1900, Date.Month.JAN, -1);
        testCases[4] = new Date(0, Date.Month.JAN, 0);
        testCases[5] = new Date(1900, Date.Month.JAN, 31);
        testCases[6] = new Date(1900, Date.Month.FEB, 28);
        testCases[7] = new Date(1900, Date.Month.AUG, 15);
        testCases[8] = new Date(1900, Date.Month.DEC, 31);
        testCases[9] = new Date(1904, Date.Month.FEB, 29);

        int[] expectedResult = new int[10];
        expectedResult[0] = 0;
        expectedResult[1] = 0;
        expectedResult[2] = 1;
        expectedResult[3] = 1;
        expectedResult[4] = -1;
        expectedResult[5] = 31;
        expectedResult[6] = 59;
        expectedResult[7] = 227;
        expectedResult[8] = 365;
        expectedResult[9] = 1520;


        for (int i = 0; i < testCases.length; i++){
            boolean testPass = false;
            int result;
            try {
                result = testCases[0].diff(testCases[i]);
                // System.out.println(testCases[0].diff(testCases[i]));
            } catch (IllegalArgumentException exception){
                result = -1;
            } 
            
            if (result == expectedResult[i]){
                testPass = true;
            }

            //Print output options
            if (showOutput == 2) {
                System.out.println(String.format("Test Date.diff() obj1:%s obj2:%s // EO:%d AO:%d // TestPass:%s", testCases[0].toString(), testCases[i].toString(), expectedResult[i], result, testPass));
            } else if (showOutput == 1){
                if (testPass == false){
                    System.out.println(String.format("Test Date.diff() obj1:%s obj2:%s // EO:%d AO:%d // TestPass:%s", testCases[0].toString(), testCases[i].toString(), expectedResult[i], result, testPass));
                }
            }
        }
    }

    private static void unitTestDateSubtract(int showOutput){
        //showOutput//0 = Show nothing, 1 = show failures, 2 = show all
        Date dateTestSubtractControlObj = new Date(1950, Date.Month.MAY, 15);
        Date valueToCheckForException = new Date(1900, Date.Month.DEC, 32);

        // Date[] subtractBy = new Date[1];
        // subtractBy[0] = new Date(1900, Date.Month.JAN, 14);

        int[][] subtractBy = {
                              {1, 0, 0},
                              {0, 0, 0},
                              {-1, 0, 0},
                              {10, 0, 0},
                              {50, 0, 0},
                              {100, 0, 0},
                              {0, 1, 0},
                              {0, -1, 0},
                              {0, 2, 0},
                              {0, 5, 0},
                              {0, 10, 0},
                              {0, 20, 0},
                              {0, 40, 0},
                              {0, 0, 1},
                              {0, 0, -1},
                              {0, 0, 10},
                              {0, 0, 20},
                              {0, 0, 40},
                              {0, 0, 80},
                              {0, 0, 160},
                              {1, 1, 1},
                              {2, 2, 15},
                              {10, 10, 10}
                             };

        Date[] expectedResult = new Date[23];
        expectedResult[0] = new Date(1949, Date.Month.MAY, 15);
        expectedResult[1] = new Date(1950, Date.Month.MAY, 15);
        expectedResult[2] = new Date(1900, Date.Month.DEC, 32);
        expectedResult[3] = new Date(1940, Date.Month.MAY, 15);
        expectedResult[4] = new Date(1900, Date.Month.MAY, 15);
        expectedResult[5] = new Date(1900, Date.Month.DEC, 32);
        expectedResult[6] = new Date(1950, Date.Month.APR, 15);
        expectedResult[7] = new Date(1900, Date.Month.DEC, 32);
        expectedResult[8] = new Date(1950, Date.Month.MAR, 15);
        expectedResult[9] = new Date(1949, Date.Month.DEC, 15);
        expectedResult[10] = new Date(1949, Date.Month.JUL, 15);
        expectedResult[11] = new Date(1948, Date.Month.SEP, 15);
        expectedResult[12] = new Date(1947, Date.Month.JAN, 15);
        expectedResult[13] = new Date(1950, Date.Month.MAY, 14);
        expectedResult[14] = new Date(1900, Date.Month.DEC, 32);
        expectedResult[15] = new Date(1950, Date.Month.MAY, 5);
        expectedResult[16] = new Date(1950, Date.Month.APR, 25);
        expectedResult[17] = new Date(1950, Date.Month.APR, 5);
        expectedResult[18] = new Date(1950, Date.Month.FEB, 24);
        expectedResult[19] = new Date(1949, Date.Month.DEC, 6);
        expectedResult[20] = new Date(1949, Date.Month.APR, 14);
        expectedResult[21] = new Date(1948, Date.Month.FEB, 29);
        expectedResult[22] = new Date(1939, Date.Month.JUL, 5);

        for (int i = 0; i < subtractBy.length; i++) {
            //as a try catch for invalid input if the date is year/12/32, then that would be a queue to look for for the exception.
            boolean testPass = false;

            try {
                Date actualResult = dateTestSubtractControlObj.subtract(subtractBy[i][0], subtractBy[i][1], subtractBy[i][2]);
                int compareToExpected = expectedResult[i].compareTo(actualResult);

                if (compareToExpected == 0) {
                    testPass = true;
                }

                if (showOutput == 2) {
                    System.out.println(String.format("Test Date.subtract() controlObj:%s modifier:%d/%d/%d // EO:%s AO:%s // TestPass:%s", dateTestSubtractControlObj.toString(), subtractBy[i][0], subtractBy[i][1], subtractBy[i][2], expectedResult[i].toString(), actualResult.toString(), testPass ));
                } else if (showOutput == 1) {
                    if (testPass == false) {

                    }
                }
            } catch (IllegalArgumentException exception) {
                if (expectedResult[i].compareTo(valueToCheckForException) == 0) {
                    testPass = true;
                } 

                if (showOutput == 2) {
                    System.out.println(String.format("Test Date.subtract() controlObj:%s modifier:%d/%d/%d // EO:%s AO:%s // TestPass:%s", dateTestSubtractControlObj.toString(), subtractBy[i][0], subtractBy[i][1], subtractBy[i][2], expectedResult[i].toString(), "Invalid value", testPass ));
                } else if (showOutput == 1) {
                    if (testPass == false) {

                    }
                }
            }
        }
    }

    private static void unitTestDateTimeConstructors(int showOutput) {
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

    private static void unitTestDateTimeAdd(int showOutput) {
        DateTime dateTimeAddControlObj = new DateTime(2000, Date.Month.MAY, 15, 12, 30, 30);
        DateTime valueToCheckForException = new DateTime(1900, Date.Month.DEC, 32, 25, 61, 61);

        int[][] addBy = {
                         {0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 1},
                         {0, 0, 0, 0, 0, 10},
                         {0, 0, 0, 0, 0, 20},
                         {0, 0, 0, 0, 0, 40},
                         {0, 0, 0, 0, 0, 80},
                         {0, 0, 0, 0, 0, 160},
                         {0, 0, 0, 0, 1, 1},
                         {0, 0, 0, 0, 10, 10},
                         {0, 0, 0, 0, 20, 20},
                         {0, 0, 0, 0, 40, 40},
                         {0, 0, 0, 0, 80, 80},
                         {0, 0, 0, 0, 160, 160},
                         {0, 0, 0, 1, 1, 1},
                         {0, 0, 0, 10, 10, 10},
                         {0, 0, 0, 20, 20, 20},
                         {0, 0, 0, 40, 40, 40},
                         {0, 0, 0, 80, 80, 80},
                         {0, 0, 0, 160, 160, 160},
                         {0, 0, 1, 1, 1, 1},
                         {0, 0, 10, 10, 10, 10},
                         {0, 0, 20, 20, 20, 20},
                         {0, 0, 40, 40, 40, 40},
                         {0, 0, 80, 80, 80, 80},
                         {0, 0, 160, 160, 160, 160},
                         {0, 1, 1, 1, 1, 1},
                         {0, 10, 10, 10, 10, 10},
                         {0, 10, 20, 20, 20, 20},
                         {0, 40, 40, 40, 40, 40},
                         {0, 80, 80, 80, 80, 80},
                         {0, 160, 160, 160, 160, 160},
                         {1, 1, 1, 1, 1, 1},
                         {10, 10, 10, 10, 10, 10},
                         {20, 20, 20, 20, 20, 20},
                         {40, 40, 40, 40, 40, 40},
                         {80, 80, 80, 80, 80, 80},
                         {160, 160, 160, 160, 160, 160},
                         {-1, 0, 0, 0, 0, 0},
                         {0, -1, 0, 0, 0, 0},
                         {0, 0, -1, 0, 0, 0},
                         {0, 0, 0, -1, 0, 0},
                         {0, 0, 0, 0, -1, 0},
                         {0, 0, 0, 0, 0, -1}
                        };

        DateTime[] expectedResult = new DateTime[43];
        expectedResult[0] = new DateTime(2000, Date.Month.MAY, 15, 12, 30, 30); //0
        expectedResult[1] = new DateTime(2000, Date.Month.MAY, 15, 12, 30, 31); //1
        expectedResult[2] = new DateTime(2000, Date.Month.MAY, 15, 12, 30, 40); //10
        expectedResult[3] = new DateTime(2000, Date.Month.MAY, 15, 12, 30, 50); //20
        expectedResult[4] = new DateTime(2000, Date.Month.MAY, 15, 12, 31, 10); //40
        expectedResult[5] = new DateTime(2000, Date.Month.MAY, 15, 12, 31, 50); //80
        expectedResult[6] = new DateTime(2000, Date.Month.MAY, 15, 12, 33, 10); //160
        expectedResult[7] = new DateTime(2000, Date.Month.MAY, 15, 12, 31, 31); //0
        expectedResult[8] = new DateTime(2000, Date.Month.MAY, 15, 12, 40, 40); //0
        expectedResult[9] = new DateTime(2000, Date.Month.MAY, 15, 12, 50, 50); //0
        expectedResult[10] = new DateTime(2000, Date.Month.MAY, 15, 13, 11, 10); //0
        expectedResult[11] = new DateTime(2000, Date.Month.MAY, 15, 13, 51, 50); //0
        expectedResult[12] = new DateTime(2000, Date.Month.MAY, 15, 15, 13, 10); //0
        expectedResult[13] = new DateTime(2000, Date.Month.MAY, 15, 13, 31, 31); //0
        expectedResult[14] = new DateTime(2000, Date.Month.MAY, 15, 22, 40, 40); //0
        expectedResult[15] = new DateTime(2000, Date.Month.MAY, 16, 8, 50, 50); //0
        expectedResult[16] = new DateTime(2000, Date.Month.MAY, 17, 5, 11, 10); //0
        expectedResult[17] = new DateTime(2000, Date.Month.MAY, 18, 21, 51, 50); //0
        expectedResult[18] = new DateTime(2000, Date.Month.MAY, 22, 7, 13, 10); //0
        expectedResult[19] = new DateTime(2000, Date.Month.MAY, 16, 13, 31, 31); //0
        expectedResult[20] = new DateTime(2000, Date.Month.MAY, 25, 22, 40, 40); //0
        expectedResult[21] = new DateTime(2000, Date.Month.JUN, 5, 8, 50, 50); //0
        expectedResult[22] = new DateTime(2000, Date.Month.JUN, 26, 5, 11, 10); //0
        expectedResult[23] = new DateTime(2000, Date.Month.AUG, 6, 21, 51, 50); //0
        expectedResult[24] = new DateTime(2000, Date.Month.OCT, 29, 7, 13, 10); //0
        expectedResult[25] = new DateTime(2000, Date.Month.JUN, 16, 13, 31, 31); //0
        expectedResult[26] = new DateTime(2001, Date.Month.MAR, 25, 22, 40, 40); //0
        expectedResult[27] = new DateTime(2001, Date.Month.APR, 5, 8, 50, 50);
        expectedResult[28] = new DateTime(2003, Date.Month.OCT, 27, 5, 11, 10); //0
        expectedResult[29] = new DateTime(2007, Date.Month.APR, 8, 21, 51, 50); //0
        expectedResult[30] = new DateTime(2013, Date.Month.MAR, 1, 7, 13, 10); //0
        expectedResult[31] = new DateTime(2001, Date.Month.JUN, 16, 13, 31, 31); //0
        expectedResult[32] = new DateTime(2011, Date.Month.MAR, 25, 22, 40, 40); //0
        expectedResult[33] = new DateTime(2022, Date.Month.FEB, 5, 8, 50, 50); //0
        expectedResult[34] = new DateTime(2043, Date.Month.OCT, 27, 5, 11, 10); //0
        expectedResult[35] = new DateTime(2087, Date.Month.APR, 8, 21, 51, 50); //0
        expectedResult[36] = new DateTime(1900, Date.Month.DEC, 32, 25, 61, 61);
        expectedResult[37] = new DateTime(1900, Date.Month.DEC, 32, 25, 61, 61);
        expectedResult[38] = new DateTime(1900, Date.Month.DEC, 32, 25, 61, 61);
        expectedResult[39] = new DateTime(1900, Date.Month.DEC, 32, 25, 61, 61);
        expectedResult[40] = new DateTime(1900, Date.Month.DEC, 32, 25, 61, 61);
        expectedResult[41] = new DateTime(1900, Date.Month.DEC, 32, 25, 61, 61);
        expectedResult[42] = new DateTime(1900, Date.Month.DEC, 32, 25, 61, 61);
        
        for (int i = 0; i < addBy.length; i++) {
            boolean testPass = false;
            int compareToExpected;

            try {
                DateTime actualResult = dateTimeAddControlObj.add(addBy[i][0], addBy[i][1], addBy[i][2], addBy[i][3], addBy[i][4], addBy[i][5]);
                compareToExpected = expectedResult[i].compareTo(actualResult);

                if (compareToExpected == 0) {
                    testPass = true;
                }

                if (showOutput == 2) {
                    System.out.println(String.format("Test DateTime.add() controlObj:%s modifier:%d/%d/%d %d:%d:%d // EO:%s AO:%s // TestPass:%s", dateTimeAddControlObj.toString(), addBy[i][0], addBy[i][1], addBy[i][2], addBy[i][3], addBy[i][4], addBy[i][5], expectedResult[i].toString(), actualResult.toString(), testPass ));
                } else if (showOutput == 1) {
                    if (testPass == false) {

                    }
                }

                // System.out.println(actualResult.toString() + " " + actualResult.compareTo(expectedResult[i]));
            } catch (IllegalArgumentException exception) {
                if (expectedResult[i].compareTo(valueToCheckForException) == 0) {
                    testPass = true;
                } 

                if (showOutput == 2) {
                    System.out.println(String.format("Test DateTime.add() controlObj:%s modifier:%d/%d/%d %d:%d:%d // EO:%s AO:%s // TestPass:%s", dateTimeAddControlObj.toString(), addBy[i][0], addBy[i][1], addBy[i][2], addBy[i][3], addBy[i][4], addBy[i][5], expectedResult[i].toString(), "Invalid input", testPass ));
                } else if (showOutput == 1) {
                    if (testPass == false) {
                        System.out.println(String.format("Test DateTime.add() controlObj:%s modifier:%d/%d/%d %d:%d:%d // EO:%s AO:%s // TestPass:%s", dateTimeAddControlObj.toString(), addBy[i][0], addBy[i][1], addBy[i][2], addBy[i][3], addBy[i][4], addBy[i][5], expectedResult[i].toString(), "Invalid input", testPass ));
                    }
                }
            }
        }
        // DateTime actualResult = dateTimeConstructorsControlObj.add(0, 0, 0, 0, 0, 1);
        // System.out.println(actualResult.toString()); 
    }

    private static void unitTestDateTimeSubtract(int showOutput) {
        DateTime dateTimeSubtractControlObj = new DateTime(2000, Date.Month.MAY, 15, 12, 30, 30);
        DateTime valueToCheckForException = new DateTime(1900, Date.Month.DEC, 32, 12, 30, 30);

        int[][] subtractBy = {
                         {0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 1},
                         {0, 0, 0, 0, 0, 10},
                         {0, 0, 0, 0, 0, 20},
                         {0, 0, 0, 0, 0, 40},
                         {0, 0, 0, 0, 0, 80},
                         {0, 0, 0, 0, 0, 160},
                         {0, 0, 0, 0, 1, 1},
                         {0, 0, 0, 0, 10, 10},
                         {0, 0, 0, 0, 20, 20},
                         {0, 0, 0, 0, 40, 40},
                         {0, 0, 0, 0, 80, 80},
                         {0, 0, 0, 0, 160, 160},
                         {0, 0, 0, 1, 1, 1},
                         {0, 0, 0, 10, 10, 10},
                         {0, 0, 0, 20, 20, 20},
                         {0, 0, 0, 40, 40, 40},
                         {0, 0, 0, 80, 80, 80},
                         {0, 0, 0, 160, 160, 160},
                         {0, 0, 1, 1, 1, 1},
                         {0, 0, 10, 10, 10, 10},
                         {0, 0, 20, 20, 20, 20},
                         {0, 0, 40, 40, 40, 40},
                         {0, 0, 80, 80, 80, 80},
                         {0, 0, 160, 160, 160, 160},
                         {0, 1, 1, 1, 1, 1},
                         {0, 10, 10, 10, 10, 10},
                         {0, 10, 20, 20, 20, 20},
                         {0, 40, 40, 40, 40, 40},
                         {0, 80, 80, 80, 80, 80},
                         {0, 160, 160, 160, 160, 160},
                         {1, 1, 1, 1, 1, 1},
                         {10, 10, 10, 10, 10, 10},
                         {20, 20, 20, 20, 20, 20},
                         {40, 40, 40, 40, 40, 40},
                         {80, 80, 80, 80, 80, 80},
                         {160, 160, 160, 160, 160, 160},
                         {-1, 0, 0, 0, 0, 0},
                         {0, -1, 0, 0, 0, 0},
                         {0, 0, -1, 0, 0, 0},
                         {0, 0, 0, -1, 0, 0},
                         {0, 0, 0, 0, -1, 0},
                         {0, 0, 0, 0, 0, -1}
                        };

        DateTime[] expectedResult = new DateTime[43];
        expectedResult[0] = new DateTime(2000, Date.Month.MAY, 15, 12, 30, 30); //0
        expectedResult[1] = new DateTime(2000, Date.Month.MAY, 15, 12, 30, 29); //1
        expectedResult[2] = new DateTime(2000, Date.Month.MAY, 15, 12, 30, 20); //10
        expectedResult[3] = new DateTime(2000, Date.Month.MAY, 15, 12, 30, 10); //20
        expectedResult[4] = new DateTime(2000, Date.Month.MAY, 15, 12, 29, 50); //40
        expectedResult[5] = new DateTime(2000, Date.Month.MAY, 15, 12, 29, 10); //80
        expectedResult[6] = new DateTime(2000, Date.Month.MAY, 15, 12, 27, 50); //160
        expectedResult[7] = new DateTime(2000, Date.Month.MAY, 15, 12, 29, 29); //0
        expectedResult[8] = new DateTime(2000, Date.Month.MAY, 15, 12, 20, 20); //0
        expectedResult[9] = new DateTime(2000, Date.Month.MAY, 15, 12, 10, 10); //0
        expectedResult[10] = new DateTime(2000, Date.Month.MAY, 15, 11, 49, 50); //0
        expectedResult[11] = new DateTime(2000, Date.Month.MAY, 15, 11, 9, 10); //0
        expectedResult[12] = new DateTime(2000, Date.Month.MAY, 15, 9, 47, 50); //160, 160
        expectedResult[13] = new DateTime(2000, Date.Month.MAY, 15, 11, 29, 29); //1, 1, 1
        expectedResult[14] = new DateTime(2000, Date.Month.MAY, 15, 2, 20, 20); //10, 10, 10
        expectedResult[15] = new DateTime(2000, Date.Month.MAY, 15, 12, 30, 30); //20, 20, 20
        expectedResult[16] = new DateTime(2000, Date.Month.MAY, 14, 12, 30, 30); //0
        expectedResult[17] = new DateTime(2000, Date.Month.MAY, 12, 3, 9, 10); 
        expectedResult[18] = new DateTime(2000, Date.Month.MAY, 9, 12, 30, 30); 
        expectedResult[19] = new DateTime(2000, Date.Month.MAY, 14, 11, 29, 29);
        expectedResult[20] = new DateTime(2000, Date.Month.MAY, 5, 2, 20, 20);
        expectedResult[21] = new DateTime(2000, Date.Month.APR, 25, 12, 30, 30);
        expectedResult[22] = new DateTime(2000, Date.Month.APR, 4, 12, 30, 30);
        expectedResult[23] = new DateTime(2000, Date.Month.FEB, 21, 3, 9, 10);
        expectedResult[24] = new DateTime(1999, Date.Month.NOV, 30, 12, 30, 30);
        expectedResult[25] = new DateTime(2000, Date.Month.APR, 14, 11, 29, 29);
        expectedResult[26] = new DateTime(1999, Date.Month.JUL, 5, 2, 20, 20);//
        expectedResult[27] = new DateTime(1999, Date.Month.JUN, 25, 12, 30, 30);//
        expectedResult[28] = new DateTime(1996, Date.Month.DEC, 5, 12, 30, 30);//
        expectedResult[29] = new DateTime(1993, Date.Month.JUN, 24, 3, 9, 10);//
        expectedResult[30] = new DateTime(1986, Date.Month.AUG, 2, 12, 30, 30);//
        expectedResult[31] = new DateTime(1999, Date.Month.APR, 14, 11, 29, 29); //
        expectedResult[32] = new DateTime(1989, Date.Month.JUL, 5, 2, 20, 20);//
        expectedResult[33] = new DateTime(1978, Date.Month.AUG, 26, 12, 30, 30);//
        expectedResult[34] = new DateTime(1956, Date.Month.DEC, 5, 12, 30, 30);//
        expectedResult[35] = new DateTime(1913, Date.Month.JUN, 24, 3, 9, 10);//
        expectedResult[36] = new DateTime(1900, Date.Month.DEC, 32, 12, 30, 30);
        expectedResult[37] = new DateTime(1900, Date.Month.DEC, 32, 12, 30, 30);
        expectedResult[38] = new DateTime(1900, Date.Month.DEC, 32, 12, 30, 30);
        expectedResult[39] = new DateTime(1900, Date.Month.DEC, 32, 12, 30, 30);
        expectedResult[40] = new DateTime(1900, Date.Month.DEC, 32, 12, 30, 30);
        expectedResult[41] = new DateTime(1900, Date.Month.DEC, 32, 12, 30, 30);
        expectedResult[42] = new DateTime(1900, Date.Month.DEC, 32, 12, 30, 30);
        
        for (int i = 0; i < subtractBy.length; i++) {
            boolean testPass = false;
            int compareToExpected;

            try {
                DateTime actualResult = dateTimeSubtractControlObj.subtract(subtractBy[i][0], subtractBy[i][1], subtractBy[i][2], subtractBy[i][3], subtractBy[i][4], subtractBy[i][5]);
                compareToExpected = expectedResult[i].compareTo(actualResult);

                if (compareToExpected == 0) {
                    testPass = true;
                }

                if (showOutput == 2) {
                    System.out.println(String.format("Test DateTime.add() controlObj:%s modifier:%d/%d/%d %d:%d:%d // EO:%s AO:%s // TestPass:%s", dateTimeSubtractControlObj.toString(), subtractBy[i][0], subtractBy[i][1], subtractBy[i][2], subtractBy[i][3], subtractBy[i][4], subtractBy[i][5], expectedResult[i].toString(), actualResult.toString(), testPass ));
                } else if (showOutput == 1) {
                    if (testPass == false) {
                        System.out.println(String.format("Test DateTime.add() controlObj:%s modifier:%d/%d/%d %d:%d:%d // EO:%s AO:%s // TestPass:%s", dateTimeSubtractControlObj.toString(), subtractBy[i][0], subtractBy[i][1], subtractBy[i][2], subtractBy[i][3], subtractBy[i][4], subtractBy[i][5], expectedResult[i].toString(), actualResult.toString(), testPass ));
                    }
                }

                // System.out.println(actualResult.toString() + " " + actualResult.compareTo(expectedResult[i]));
            } catch (IllegalArgumentException exception) {
                if (expectedResult[i].compareTo(valueToCheckForException) == 0) {
                    testPass = true;
                } 

                if (showOutput == 2) {
                    System.out.println(String.format("Test DateTime.add() controlObj:%s modifier:%d/%d/%d %d:%d:%d // EO:%s AO:%s // TestPass:%s", dateTimeSubtractControlObj.toString(), subtractBy[i][0], subtractBy[i][1], subtractBy[i][2], subtractBy[i][3], subtractBy[i][4], subtractBy[i][5], expectedResult[i].toString(), "Invalid input", testPass ));
                } else if (showOutput == 1) {
                    if (testPass == false) {
                        System.out.println(String.format("Test DateTime.add() controlObj:%s modifier:%d/%d/%d %d:%d:%d // EO:%s AO:%s // TestPass:%s", dateTimeSubtractControlObj.toString(), subtractBy[i][0], subtractBy[i][1], subtractBy[i][2], subtractBy[i][3], subtractBy[i][4], subtractBy[i][5], expectedResult[i].toString(), "Invalid input", testPass ));
                    }
                }
            }
        }
        // DateTime actualResult = dateTimeConstructorsControlObj.add(0, 0, 0, 0, 0, 1);
        // System.out.println(actualResult.toString()); 
    }

    private static void unitTestDateTimeDiff(int showOutput) {
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

    private static void unitTestDateConvToDays(){

    }

    private static void unitTestCalendarCalcDayOfWeek(int showOutput){
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

        if (showOutput == 2) {
          System.out.println(String.format("Test Calendar.calcDayOfWeek() inputValue:%s// EO:%d AO:%d // TestPass:%s", inputValues[i].toString(), expectedValue[i], payload, testPass));
        } else if (showOutput ==1 && testPass == false) {
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
}