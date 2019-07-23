package games.board;
import games.lib.Game;

public class BoardGameFactory{
    private BoardGameFactory(){

    }

    // public Game newGame(BoardGames boardGames){
    //     switch (boardGames)
    //     {
    //         case TIC_TAC_TOE:
    //             //return TIC_TAC_TOE;
    //             break;
    //         case CHUTES_LADDERS:
    //             //return CHUTES_LADDERS;
    //             break;
    //         case UNO:
    //             //return UNO;
    //             break;
    //     }
    // }

    enum BoardGames
    {
        TIC_TAC_TOE, CHUTES_LADDERS, UNO;
    }
}