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

        // testMethods();

        Date dt6 = new Date(6000000);
        dt6.convFromDays();
        System.out.println(dt6.toString());
        
        //showing how math can be used to get the day count
        System.out.println(Integer.toString((Date.Month.values()[Date.Month.JAN.ordinal() + 5]).days));
        dt6.convToDays(1901, 2, 1);


    }

    private static void testMethods(){
        //Testing Date.isLeapYear(int year)
        for (int i = 1900; i <= 1950; i++) {
            System.out.println(String.format("%d %s:%s", i, "isLeap", Date.isLeapYear(i)));
        }

    }

    private static void howToDo(){
        int x = Date.Month.DEC.days;
        System.out.println(Integer.toString(x));
    }
}