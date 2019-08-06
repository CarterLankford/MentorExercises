public class App{
    public static void main(String[] args){
        System.out.println("hello world");
        Time tm = new Time(5, 23, 45, "AM");
        int sec = tm.convToSeconds(5, 23, 45);
        System.out.println(Integer.toString(sec));
        // int[] diff = tm.diffTime(3, 23, 45);
        // System.out.println("H:" + diff[0] + " M:" + diff[1] + " S:" + diff[2] );
        int j = 60/7; 
        System.out.println(Integer.toString(j));
        int minutes = 0;
        int hours = 0;
        while (sec > 60){
            System.out.println(Integer.toString(sec));
            sec-=60;
            minutes+=1;
        }

        while (minutes > 60){
            System.out.println(Integer.toString(minutes));
            minutes-=60;
            hours+=1;
        }

        System.out.println("h:" + hours + " m:" + minutes + " s:" + sec);

    }



    // //Below is a demonstration of how to return an array
    // static int[] getSumAndSub(int a, int b){ 
    //     int[] ans = new int[2]; 
    //     ans[0] = a + b; 
    //     ans[1] = a - b; 
  
    //     // returning array of elements 
    //     return ans; 
    // } 
  
    // // Driver method 
    // public static void main(String[] args){ 
    //     int[] ans = getSumAndSub(100, 50); 
    //     System.out.println("Sum = " + ans[0]); 
    //     System.out.println("Sub = " + ans[1]); 
    // } 
}