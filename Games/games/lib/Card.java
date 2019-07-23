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
    
}