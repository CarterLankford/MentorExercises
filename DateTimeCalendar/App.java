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

// TODO: Make the below line compile and run :)
        System.out.println(Date.Month.JUN.diff(Date.Month.AUG));
    }
}