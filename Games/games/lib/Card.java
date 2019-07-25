package games.lib;

public class Card{
    protected int number;
    protected String color;

    public Card(int number, String color){
        setNumber(number);
        setColor(color);
    }

    protected Card(){

    }

    protected Card(String color){
        setColor(color);
    }

    public int getNumber(){
        return this.number;
    }

    public String getColor(){
        return this.color;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public void setColor(String color){
        this.color = color;
    }

    @Override
    public String toString(){
        return this.getClass().getName() + '@' + Integer.toHexString(this.hashCode()) + '[' + this.number + ',' + (this.color) + ']';
    }

    //The default Java implementation of toString() is roughly defined as follows:
    //return this.getClass().getName() + '@' + Integer.toHexString(this.hashCode())
    //Override the toString() method on the Card class to include the values of the card number and color to print something like this:
    //game.lib.Card@12ab56[3, “red”]
}