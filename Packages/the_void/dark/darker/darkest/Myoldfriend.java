package the_void.dark.darker.darkest;
import test.Greeter;

/**
 * Instructions to compile:
 * ## This might vary for other computers ##
 * Compile/Run from "c/MyJava/MentorExercises/"
 * Compile: javac -cp /c/MyJava/MentorExercises/Packages/the_void/dark/darker/darkest/:/c/MyJava/MentorExercises/Packages/:. /c/MyJava/MentorExercises/Packages/the_void/dark/darker/darkest/Myoldfriend.java
 * 
 */

public class Myoldfriend{
    public static void main(String args[]){
        Greeter gt = new Greeter();
        System.out.println(gt.greet("garfunckel"));
    }
}