package games.board;
import games.lib.Game;


public class BoardGameFactory{
    public enum BoardGames{
        TIC_TAC_TOE, 
        CHUTES_LADDERS, 
        UNO
    }

    private BoardGameFactory(){

    }

    public static Game newGame(BoardGames boardGame){
        Game payload;
        switch (boardGame){
            case TIC_TAC_TOE:
                payload = new TicTacToe();
                break;
                // return new TicTacToe();
            case CHUTES_LADDERS:
                payload = new ChutesAndLadders();
                break;
                // return new ChutesAndLadders();
            case UNO:
                payload = new Uno();
                // return new Uno();
                break;
            default:
                throw new UnsupportedOperationException(String.format("Game of type %s cannot be created", boardGame.toString()));
        }
        return payload;
    }

    
}