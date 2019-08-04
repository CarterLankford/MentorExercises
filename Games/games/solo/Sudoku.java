package games.solo;
import games.lib.Game;
import games.lib.Movement;


class Sudoku implements Game{
    Sudoku(){

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