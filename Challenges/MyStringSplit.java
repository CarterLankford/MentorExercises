import java.util.Arrays;
public class MyStringSplit{
    public static void main(String[] args){
        String[] myArray;

        myArray = "/".split("/");
        System.out.println(Arrays.toString(myArray));
        myArray = "/resource".split("/");
        System.out.println(Arrays.toString(myArray));
        myArray = "/resource/path".split("/");
        System.out.println(Arrays.toString(myArray));
        myArray = "resource".split("/");
        System.out.println(Arrays.toString(myArray));
        //Wanted to try another just for fun
        myArray = "//resource//path//test/".split("/");
        System.out.println(Arrays.toString(myArray) + " " + myArray.length);

        /*
        "/"
        "/resource"
        "/resource/path"
        "resource"
        */

    }
}