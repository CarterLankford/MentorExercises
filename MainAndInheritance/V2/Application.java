public class Application{
    public static void main(String[] args){
        Human vicente;
        Parent trish;
        Grandparent aman;

        vicente = new Human();
        trish = new Parent();
        aman = new Grandparent();

        System.out.println("Vicente Speak: " + vicente.speak() + "\nTrish Speak: " + trish.speak() + "\nAman Speak: " + aman.speak() + "\n");

        People persona;
        persona = vicente;
        System.out.println("Persona Speak: " + persona.speak());
        //System.out.println("Persona Greet: " + persona.greet()); // Won't work because it's People, and people only has speak.
        persona = aman;
        System.out.println("Persona Speak: " + persona.speak());
        persona = trish;
        System.out.println("Persona Speak: " + persona.speak());


    }
}