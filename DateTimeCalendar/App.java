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
        System.out.println(dt1.getDays());

        Date dt2 = new Date(1999, 2, 3);
        System.out.println(dt2.getYear());
        System.out.println(dt2.getMonth());
        System.out.println(Date.Month.DEC.ordinal());
        System.out.println(Date.Month.DEC.shortName);
        System.out.println(Date.Month.DEC.longName);
        System.out.println(Date.Month.DEC.days);
        System.out.println(dt2.toString());

        Date dt3 = new Date(90);

        Date dt4 = dt1.add(dt3);
        System.out.println(dt4.getDays());
    }
}