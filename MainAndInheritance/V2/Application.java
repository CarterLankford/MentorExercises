public class Application{
    public static void main(String[] args){
        Human vicente;
        Parent trish;
        Grandparent aman;

        vicente = new Human();
        trish = new Parent();
        aman = new Grandparent();

        System.out.println("Vicente Speak: " + vicente.speak() + "\nTrish Speak: " + trish.speak() + "\nAman Speak: " + aman.speak() + "\n");
        //3.F: Quote was shown as expected in all three cases. Aman get it's speak method from the People class. All three are considered people
        // since Human class implements from People interface and Grandparent class extends from Human class, Parent class from Grandparent class, 
        // and Child class from Parent class

        People persona;
        persona = vicente;
        //3.H It does compile since Human class implements from the People interface. 

        System.out.println("Persona Speak: " + persona.speak());
        //3.I Output is shown as expected. 

        //System.out.println("Persona Greet: " + persona.greet()); 
        //3.J: This will not complie since persona comes from People which only has a speak method.         
        

        persona = aman;
        //3.K: This code does compile. 
        System.out.println("Persona Speak: " + persona.speak());
        //3.L The output is what was expected.

        //Did some extra work for fun/exercise. 
        persona = trish;
        System.out.println("Persona Speak: " + persona.speak());


    }
}