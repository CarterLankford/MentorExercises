package games.solo;
import games.lib.Game;
public class SoloGameFactory{
    public enum SoloGames{
        WORD_SEARCH, 
        SUDOKU, 
        SOLITAIRE
    }

    private SoloGameFactory(){

    }

    public static Game newGame(SoloGames soloGame){
        Game payload;
        switch(soloGame){
            case WORD_SEARCH:
                payload = new WordSearch();
                break;
            case SUDOKU:
                payload = new Sudoku();
                break;
            case SOLITAIRE:
                payload = new Solitaire();
                break;
            default:
                throw new UnsupportedOperationException(String.format("Game of type %s cannot be created", soloGame.toString()));
                //original version: throw new UnsupportedOperationException("Game of type " + soloGame + " cannot be created");
        }
        return payload;
    }
}