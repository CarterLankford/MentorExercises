package priv.exercises.datetime;

public class TT {
    public static void main (String[] args){
        final DateTime base = new DateTime(2000, Date.Month.MAY, 15, 12, 30, 30);

        DateTime test1 = base.diff(base);
        System.out.println(test1.toString());
    }
}