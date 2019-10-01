package games.lib;

public interface Game{
    String instructions();
    boolean move(Movement movement);    
}