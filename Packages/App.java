/**
 * Instructions to compile:
 * ## This might vary for other computers ##
 * Compile/Run from "c/MyJava/MentorExercises/Packages"
 * Compile: javac -cp /c/MyJava/MentorExercises/Geometry/:/c/MyJava/MentorExercises/DataStructures/DynamicStacks:. App.java
 * Run: java -cp /c/MyJava/MentorExercises/Geometry/:/c/MyJava/MentorExercises/DataStructures/DynamicStacks:. App
 * 
 */
import test.Greeter;

public class App{
    public static void main(String args[]){
        Greeter gt = new Greeter();
        Circle cr = new Circle(1f);
        DynamicStack ds = new DynamicStack();

        System.out.println(gt.greet("world"));
        System.out.println(deep.deeper.deepest.Math.sum(1, 5));
        System.out.println(cr.getArea());

    }
}