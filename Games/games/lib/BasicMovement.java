package games.lib;

public class BasicMovement implements Movement{
    private Coord coord;
    private int value;

    public BasicMovement(Coord coord, int value){
        setCoord(coord);
        setValue(value);
    }

    public Coord getCoord(){
        return this.coord;
    }

    public int getValue(){
        return this.value;
    }

    public void setCoord(Coord coord){
        this.coord = coord;
    }

    public void setValue(int value){
        this.value = value;
    }    
}