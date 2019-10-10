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

        // Date d1 = new Date(1994, Date.Month.MAY, 23);
        // System.out.println(Date.Month.JUN);

        // TODO: Make the below line compile and run :)
        System.out.println(Date.Month.JUN.compareTo(Date.Month.AUG));
        // System.out.println(Date.Month.JUN.diff(Date.Month.AUG));
        System.out.println(Date.Month.JAN.compareTo(Date.Month.DEC));
        // System.out.println(Date.Month.JAN.diff(Date.Month.DEC));
        System.out.println(Date.Month.SEP.compareTo(Date.Month.SEP));
        // System.out.println(Date.Month.SEP.diff(Date.Month.SEP));
        System.out.println(Date.Month.DEC.compareTo(Date.Month.SEP));
        // System.out.println(Date.Month.DEC.diff(Date.Month.SEP));

        System.out.println(Date.Month.DEC.days);
        System.out.println(Date.Month.values()[0]);

        Date dt1 = new Date(201);
        System.out.println(dt1.getDayspan());

        Date dt2 = new Date(1999, Date.Month.FEB, 3);
        System.out.println(dt2.getYear());
        System.out.println(dt2.getMonth());
        System.out.println(Date.Month.DEC.ordinal());
        System.out.println(Date.Month.DEC.shortName);
        System.out.println(Date.Month.DEC.longName);
        System.out.println(Date.Month.DEC.days);
        System.out.println(dt2.toString());


        Date dt5 = new Date(1994, Date.Month.MAY, 13);
        System.out.println(dt5.toString());

        //testMethods();
        
        //showing how math can be used to get the day count
        System.out.println(Integer.toString((Date.Month.values()[Date.Month.JAN.ordinal() + 5]).days));
        
        System.out.println(Integer.toString((int)Date.convToDays(1960, 1, 1)));

        unitTestConvFromDays();
        unitTestConvToDays();

    }

    private static void unitTestConvToDays(){
        System.out.println("Start: Unit Test convToDays");
        System.out.println(Integer.toString((int)Date.convToDays(1900, 1, 0)));
        System.out.println(Integer.toString((int)Date.convToDays(1900, 1, 1)));
        System.out.println(Integer.toString((int)Date.convToDays(1900, 1, 31)));
        System.out.println(Integer.toString((int)Date.convToDays(1900, 2, 9)));
        System.out.println(Integer.toString((int)Date.convToDays(1900, 3, 1)));
        System.out.println(Integer.toString((int)Date.convToDays(1900, 4, 30)));
        System.out.println(Integer.toString((int)Date.convToDays(1900, 8, 28)));
        System.out.println(Integer.toString((int)Date.convToDays(1900, 12, 31)));
        System.out.println(Integer.toString((int)Date.convToDays(1901, 1, 1)));
        System.out.println(Integer.toString((int)Date.convToDays(1901, 5, 15)));
        System.out.println(Integer.toString((int)Date.convToDays(1903, 12, 31)));
        System.out.println(Integer.toString((int)Date.convToDays(1904, 2, 29)));
        System.out.println(Integer.toString((int)Date.convToDays(1908, 4, 28)));
        System.out.println(Integer.toString((int)Date.convToDays(1916, 8, 24)));
        System.out.println(Integer.toString((int)Date.convToDays(1933, 4, 17)));
        System.out.println(Integer.toString((int)Date.convToDays(1966, 8, 2)));
        System.out.println(Integer.toString((int)Date.convToDays(2033, 3, 4)));
        System.out.println(Integer.toString((int)Date.convToDays(2166, 5, 6)));
        System.out.println("End: Unit Test convToDays\n");
    }

    private static void unitTestConvFromDays(){
        System.out.println("Start: Unit Test convFromDays");
        Date.convFromDays(0);
        Date.convFromDays(1);
        Date.convFromDays(31);
        Date.convFromDays(40);
        Date.convFromDays(60);
        Date.convFromDays(120);
        Date.convFromDays(240);
        Date.convFromDays(365);
        Date.convFromDays(366);
        Date.convFromDays(500);
        Date.convFromDays(1460);
        Date.convFromDays(1520);
        Date.convFromDays(3040);
        Date.convFromDays(6080);
        Date.convFromDays(12160);
        Date.convFromDays(24320);
        Date.convFromDays(48640);
        Date.convFromDays(97280);
        System.out.println("End: Unit Test convFromDays\n");
    }

    private static void testMethods(){
        //Testing Date.isLeapYear(int year)
        for (int i = 1900; i <= 1950; i++) {
            System.out.println(String.format("%d %s:%s", i, "isLeap", Date.isLeapYear(i)));
        }
        
        for (int i = 1900; i <= 2000; i++){
            int x = (int)Date.convToDays(i, 5, 1);
            System.out.println(String.format("Year:%d ConvToDays:%s ", i, Integer.toString((int)Date.convToDays(i, 1, 1))));
            Date.convFromDays(x);
        }
        
    }

    private static void howToDo(){
        int x = Date.Month.DEC.days;
        System.out.println(Integer.toString(x));
    }
}