package games.solo;
import games.lib.Game;
import games.lib.Movement;

/*
TODO:
[] Add Print and correct return for move()
*/

class Solitaire implements Game{
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