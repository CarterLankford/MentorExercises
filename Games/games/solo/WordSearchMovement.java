package games.solo;
import games.lib.Movement;
import games.lib.Coord;

public class WordSearchMovement implements Movement {
    private Coord st;
    private Coord et;

    public WordSearchMovement(Coord st, Coord et){
        setSt(st);
        setEt(et);
    }

    public Coord getSt(){
        return this.st;
    }

    public Coord getEt(){
        return this.et;
    }

    public void setSt(Coord st){
        this.st = st;
    }

    public void setEt(Coord et){
        this.et = et;
    }
}