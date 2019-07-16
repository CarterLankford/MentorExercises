public class Application{
    public static void main(String[] args){
        Grandparent abuelo;
        Parent padre;
        Child hijo;

        abuelo = new Grandparent();
        padre = new Parent();
        hijo = new Child();

        System.out.println("Grandparent: " + abuelo.greet() + "\nParent: " + padre.greet() + "\nChild: " + hijo.greet());
        //1.C: greets shows "Hi! I'm a grandparent", "Hi! I'm a parent", "Hi! I'm a child", for abuelo, padre, hijo respectivly. Which was the expected result

        System.out.println("Grandparent: " + abuelo.waveOff() + "\nParent: " + padre.waveOff() + "\nChild: " + hijo.waveOff());
        //1.D: padre gets its waveOff method from the Grandparent class. Parent extends from the Grandparent class and inherits its mehods. 

        Human george;
        george = new Human();
        System.out.println("George greet: " + george.greet() + "\nGeorge waveOff: " + george.waveOff());
        //2.C: georges waveOff prints "See you later!" which is the expected result. 

        george = new Child();
        //2.D: The code does compile. Since george was declared the type Human and a new Child instance was created, george is able to be instantiated to the 
        //Child class since Child is a decendant of the Human class.
        System.out.println("George greet: " + george.greet() + "\nGeorge waveOff: " + george.waveOff());
        //2.E: The methods called are from the child class since george was instantiated to Child. 

        george = new Parent();
        //2.F: The code does compile. Since george was declared the type Human and a new Parent instance was created, george is able to be instantiated to the 
        //Parent class since Parent is a decendant of the Human class.
        System.out.println("George greet: " + george.greet() + "\nGeorge waveOff: " + george.waveOff());        
        //2.G: The greet method is from the Parent class since george was instantiated to Parent. But the waveOff method is from the Grandparent class since 
        //Parent inherits its methods from Grandparent class. The only reason greet doesn't do the same is because the method has been overriden. 

        Child ada;
        ada = new Child();
        System.out.println("Ada greet: " + ada.greet() + "\nAda waveOff: " + ada.waveOff());
        //2.J: The output is greet:"Hi! I'm a child", waveOff:"Ciao!" which is the expected result from the Child class. 

        //ada = new Parent();
        //2.K: This code will not compile, since ada was declared Child it is not able to be instantiated to an instance of a parent class. 
    }
}