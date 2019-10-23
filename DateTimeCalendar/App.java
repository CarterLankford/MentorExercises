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

        
//Date.Add() - Start
        //Days
        Date dateTestAddControlObj = new Date(1900, Date.Month.JAN, 0);
        Date dateTestAddExpectedOut1 = new Date(1900, Date.Month.JAN, 1);
        unitTestDateAdd(dateTestAddControlObj, 0, 0, 1, dateTestAddExpectedOut1);

        Date dateTestAddExpectedOut2 = new Date(1900, Date.Month.JAN, 31);
        unitTestDateAdd(dateTestAddControlObj, 0, 0, 31, dateTestAddExpectedOut2);

        Date dateTestAddExpectedOut3 = new Date(1900, Date.Month.FEB, 10);
        unitTestDateAdd(dateTestAddControlObj, 0, 0, 41, dateTestAddExpectedOut3);

        Date dateTestAddExpectedOut4 = new Date(1900, Date.Month.MAR, 1);
        unitTestDateAdd(dateTestAddControlObj, 0, 0, 60, dateTestAddExpectedOut4);

        Date dateTestAddExpectedOut5 = new Date(1901, Date.Month.MAY, 15);
        unitTestDateAdd(dateTestAddControlObj, 0, 0, 500, dateTestAddExpectedOut5);

        Date dateTestAddExpectedOut6 = new Date(1902, Date.Month.SEP, 27);
        unitTestDateAdd(dateTestAddControlObj, 0, 0, 1000, dateTestAddExpectedOut6);

        Date dateTestAddExpectedOut7 = new Date(1905, Date.Month.JUN, 23);
        unitTestDateAdd(dateTestAddControlObj, 0, 0, 2000, dateTestAddExpectedOut7);

        //Months
        Date dateTestAddExpectedOut8 = new Date(1900, Date.Month.FEB, 0);
        unitTestDateAdd(dateTestAddControlObj, 0, 1, 0, dateTestAddExpectedOut8);

        Date dateTestAddExpectedOut9 = new Date(1902, Date.Month.AUG, 0);
        unitTestDateAdd(dateTestAddControlObj, 0, 31, 0, dateTestAddExpectedOut9);

        Date dateTestAddExpectedOut10 = new Date(1903, Date.Month.JUN, 0);
        unitTestDateAdd(dateTestAddControlObj, 0, 41, 0, dateTestAddExpectedOut10);

        Date dateTestAddExpectedOut11 = new Date(1905, Date.Month.JAN, 0);
        unitTestDateAdd(dateTestAddControlObj, 0, 60, 0, dateTestAddExpectedOut11);

        Date dateTestAddExpectedOut12 = new Date(1941, Date.Month.SEP, 0);
        unitTestDateAdd(dateTestAddControlObj, 0, 500, 0, dateTestAddExpectedOut12);

        Date dateTestAddExpectedOut13 = new Date(1983, Date.Month.MAY, 0);
        unitTestDateAdd(dateTestAddControlObj, 0, 1000, 0, dateTestAddExpectedOut13);

        Date dateTestAddExpectedOut14 = new Date(2066, Date.Month.SEP, 0);
        unitTestDateAdd(dateTestAddControlObj, 0, 2000, 0, dateTestAddExpectedOut14);



        try {
            unitTestDateAdd(dateTestAddControlObj, 0, 0, -1, dateTestAddControlObj);
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }

        try {
            unitTestDateAdd(dateTestAddControlObj, 0, -1, 0, dateTestAddControlObj);
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }

        try {
            unitTestDateAdd(dateTestAddControlObj, -1, 0, 0, dateTestAddControlObj);
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
//Date.Add() - End       

//Date.compareTo() - Start       
        Date dateTestCompareToControlObj = new Date(1900, Date.Month.JAN, 5);
        Date dateTestCompareToCompareObj1 = new Date(1900, Date.Month.JAN, 5);
        int dateTestComparedToExpectedOut1 = -0;
        unitTestDateCompareTo(dateTestCompareToControlObj, dateTestCompareToCompareObj1, dateTestComparedToExpectedOut1);

        Date dateTestCompareToCompareObj2 = new Date(1900, Date.Month.JAN, 8);
        int dateTestComparedToExpectedOut2 = -1;
        unitTestDateCompareTo(dateTestCompareToControlObj, dateTestCompareToCompareObj2, dateTestComparedToExpectedOut2);

        Date dateTestCompareToCompareObj3 = new Date(1900, Date.Month.JAN, 1);
        int dateTestComparedToExpectedOut3 = 1;
        unitTestDateCompareTo(dateTestCompareToControlObj, dateTestCompareToCompareObj3, dateTestComparedToExpectedOut3);
//Date.compareTo() - End
    }

    private static void unitTestDateCompareTo(Date obj1, Date obj2, int expectedOut){
        int result = obj1.compareTo(obj2);
        boolean testPass = false;

        if (result == expectedOut){
            testPass = true;
        }

        System.out.println(String.format("Test Date.compareTo() obj1:%s obj2:%s  ExpectedOut:%d TestPass:%s",obj1.toString(), obj2.toString(), result, testPass ));
    }

    private static void unitTestDateAdd(Date obj1, int years, int months, int days, Date expectedOut){
        Date result = obj1.add(years, months, days);
        boolean testPass = false;
        int x = expectedOut.compareTo(result);

        if (x == 0){
            testPass = true;
        }

        System.out.println(String.format("Test Date.add() obj1:%s + (%d/%d/%d) // EO:%s AO:%s // TestPass:%s", obj1.toString(), years, months, days, expectedOut.toString(), result.toString(), testPass ));
    }

    private static void unitTestDateSubtract(){

    }

    private static void unitTestDateConvToDays(){

    }

    //TODO:
    //[] Add test for isLeapYear
}