package games.solo;
import games.lib.Game;
public class SoloGameFactory{


    // public Game newGame(SoloGames soloGame){
    //     switch (soloGame)
    //     {
    //         case WORD_SEARCH:
    //             return WORD_SEARCH;
    //             break;
    //         case SUDOKU:
    //             return SUDOKU;
    //             break;
    //         case SOLITAIRE:
    //             return SOLITAIRE;
    //             break;
    //     }
    // }

    enum SoloGames
    {
        WORD_SEARCH, SUDOKU, SOLITAIRE;
    }
}