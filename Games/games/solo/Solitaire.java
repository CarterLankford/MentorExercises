package games.solo;
import games.lib.Game;
import games.lib.Movement;


class Solitaire implements Game{
    Solitaire(){
        
    }


    @Override
    public String instructions(){
        return "Unique instructions";
    }

    @Override
    public boolean move(Movement movement){
        // System.out.println(move.getClass().getName());
        return true;
    }
}