package games.board;
import games.lib.Game;
import games.lib.Movement;


class ChutesAndLadders implements Game{
    ChutesAndLadders(){
        
    }

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