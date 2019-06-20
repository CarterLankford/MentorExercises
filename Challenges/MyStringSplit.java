import java.util.Arrays;
public class MyStringSplit{
    public static void main(String[] args){
        String[] myArray;

        myArray = "/".split("/");
        //Expected Result: []
        //Since only the delimiter is found, and since that's the end of the string, it gets dropped
        //Actual Result: []
        System.out.println(Arrays.toString(myArray));

        myArray = "/resource".split("/");
        //Expected Result: ["", resource]
        //Since delimiter is found and it's not the end of the string an empty string is added to the array
        //when no other delimiter is found the rest of the string is added to the array.
        //Actual Result: [, resource]
        System.out.println(Arrays.toString(myArray));

        myArray = "/resource/path".split("/");
        //Expected Result: [, resource, path]
        //finds first delimiter and addes blank string to array, when it finds the second delimiter it adds 
        //the before "resource" to the array and then checks for another delimiter. When it finds none, it 
        //adds "path" to the array. 
        //Actual Result:[, resource, path]
        System.out.println(Arrays.toString(myArray));

        myArray = "resource".split("/");
        //Expected Result: [resource]
        //Since no delimiter is found it just adds "resource" to the array.
        //Actual Result:[resource]
        System.out.println(Arrays.toString(myArray));
        
        //Wanted to try another just for fun
        myArray = "//resource//path//test/".split("/");
        //Expected Result: [, resource, , path, , test]
        //finds first delimiter and adds empty string, finds second delimiter and drops it, finds third and
        //adds "resource" to the array, finds next delimiter and adds blank string to array, finds next 
        //delimiter and drops it, finds next delimiter and adds "test" to array. 
        //Actual Result: [, resource, , path, , test]
        System.out.println(Arrays.toString(myArray) + " " + myArray.length);

        /*
        "/"
        "/resource"
        "/resource/path"
        "resource"
        */

    }
}