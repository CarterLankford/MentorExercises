public class Application{
    public static void main(String[] args){
        Human vicente;
        Parent trish;
        Grandparent aman;

        vicente = new Human();
        trish = new Parent();
        aman = new Grandparent();

        System.out.println("Vicente Speak: " + vicente.speak() + "\nTrish Speak: " + trish.speak() + "\nAman Speak: " + aman.speak() + "\n");
        //3.F: speak methods print "I, a human, was asked to be creative", "I, a parent, was asked to be creative", "I, a human, was asked to be creative" for
        //vicente, trish, aman respectivly; which is the output I was expecting. aman has the speak method from the human class. aman was declared with the 
        //type Grandparent, Grandparent's speak method is inherited from the Human class since it doesn't have one of it's own to override.  All three are 
        //considered people since they all were initialized in classes that are decendants of the People interface.

        People persona;
        persona = vicente;
        //3.H: This code does compile. vicente is declared as Human which implements from the People interface which allows it to be instantiated.

        System.out.println("Persona Speak: " + persona.speak());
        //3.I: This code does compile. vicente is declared as Human and then instantiated as the type People. Since People is an interface the speak method is
        //abstract and will come from the Human class. 

        //System.out.println("Persona Greet: " + persona.greet()); 
        //3.J: This code does not complie since People doesn't have a method for greet. 
        

        persona = aman;
        //3.K: This code does compile. aman was declared as Grandparent, which extends Human that implements People. 
        System.out.println("Persona Speak: " + persona.speak());
        //3.L: The speak method prints "I, a human, was asked to be creative", which is the expected result. Since Grandparent doesn't have a method to 
        //override speak it uses the method provided by the parent Human class.

        //Did some extra work for fun/exercise. 
        persona = trish;
        System.out.println("Persona Speak: " + persona.speak());


    }
}