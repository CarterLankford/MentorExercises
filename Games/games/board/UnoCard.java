package games.board;
import games.lib.Card;

public class UnoCard extends Card{
    private UnoFeature feature;
    private String color;

    public enum UnoFeature{
        SKIP, 
        REVERSE, 
        WILD, 
        DRAW_TWO, 
        DRAW_FOUR
    }

    public UnoCard(int number, String color){
        setNumber(number);
        setColor(color);
    }

    public UnoCard(UnoFeature feature){
        setFeature(feature);
    }

    public UnoCard(String color, UnoFeature feature){
        setColor(color);
        setFeature(feature);
    }

    public UnoFeature getFeature(){
        return this.feature;
    }

    public void setFeature(UnoFeature feature){
        this.feature = feature;
    }

    public void setColor(String color){
        this.color = color;
    }

    @Override
    public String toString(){
        return this.getClass().getName() + '@' + Integer.toHexString(this.hashCode()) + '[' + this.feature + ',' + (this.color) + ']';
    }
    
}