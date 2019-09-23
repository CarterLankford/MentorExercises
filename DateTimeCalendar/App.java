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
    }
}