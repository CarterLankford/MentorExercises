public class Application{
    public static void main(String[] args){
        Grandparent abuelo;
        Parent padre;
        Child hijo;

        abuelo = new Grandparent();
        padre = new Parent();
        hijo = new Child();

        System.out.println("Grandparent: " + abuelo.greet() + "\nParent: " + padre.greet() + "\nChild: " + hijo.greet());
        //1.C: Everything shown was expected

        System.out.println("Grandparent: " + abuelo.waveOff() + "\nParent: " + padre.waveOff() + "\nChild: " + hijo.waveOff());
        //1.D: padre's gets it's waveOff from the Grandparent class, since it extends the Grandparent class.

        Human george;
        george = new Human();
        System.out.println("George greet: " + george.greet() + "\nGeorge waveOff: " + george.waveOff());
        //2.C: Everything shown was expected

        george = new Child();
        //2.D: The code does compile. The code can compile since George was initialized as the Human class first.
        System.out.println("George greet: " + george.greet() + "\nGeorge waveOff: " + george.waveOff());
        //2.E: The methods called are from the Child class, since george was assigned to the child class

        george = new Parent();
        //2.F: The code does compile. Since the Human type is the highest point of inhertance we can assign it to the 
        //parent class because it extends from the Grandparent class, which extends from the Human class.
        System.out.println("George greet: " + george.greet() + "\nGeorge waveOff: " + george.waveOff());        
        //2.G The method greet is from the parent class, but the method waveOff is from the grandparent class because
        //it's inherited from the grandparent class

        Child ada;
        ada = new Child();
        System.out.println("Ada greet: " + ada.greet() + "\nAda waveOff: " + ada.waveOff());
        //2.J: The output is shown as expected.

        //ada = new Parent();
        //2.K: This code doesn't compile. This is because ada was initialized into the child class
        // and is lowest class in the chain and is unable to be assigned to the others. 
    }
}