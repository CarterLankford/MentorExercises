package games.board;
import games.lib.Game;
import games.lib.Movement;


class Uno implements Game{

    Uno(){
        
    }

    @Override
    public String instructions(){
        return "Unique instructions to Uno";
    }

    @Override
    public boolean move(Movement movement){
        System.out.println(movement.getClass().getName());
        return true;
    } 

}