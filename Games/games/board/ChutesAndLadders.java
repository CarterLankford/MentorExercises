package games.board;
import games.lib.Game;
import games.lib.Movement;

/*
TODO:
[] Add Print and correct return for move()
*/

class ChutesAndLadders implements Game{
    @Override
    public String instructions(){
        return "Unique instructions";
    }

    @Override
    public boolean move(Movement movement){
        System.out.println(movement.getClass().getName());
        return true;
    }
}