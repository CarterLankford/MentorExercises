public class Application{
    public static void main(String[] args){
        Grandparent abuelo;
        Parent padre;
        Child hijo;

        abuelo = new Grandparent();
        padre = new Parent();
        hijo = new Child();

        System.out.println("Grandparent: " + abuelo.greet() + "\nParent: " + padre.greet() + "\nChild: " + hijo.greet());
        System.out.println("Grandparent: " + abuelo.waveOff() + "\nParent: " + padre.waveOff() + "\nChild: " + hijo.waveOff());

        Human george;
        george = new Human();
        System.out.println("George greet: " + george.greet() + "\nGeorge waveOff: " + george.waveOff());

        george = new Child();
        System.out.println("George greet: " + george.greet() + "\nGeorge waveOff: " + george.waveOff());

        george = new Parent();
        System.out.println("George greet: " + george.greet() + "\nGeorge waveOff: " + george.waveOff());        

        Child ada;
        ada = new Child();
        System.out.println("Ada greet: " + ada.greet() + "\nAda waveOff: " + ada.waveOff());

        //ada = new Parent();
    }
}