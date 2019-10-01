package games;
import games.lib.Game;
import games.board.BoardGameFactory;
import games.solo.SoloGameFactory;
import games.board.UnoCard;
import games.lib.Card;
// import games.board.BoardGameFactory.BoardGames;
// import games.solo.SoloGameFactory.SoloGames;

public class App{
    public static void main(String[] args){
        Game uno;
        Game sudoku;

        uno = BoardGameFactory.newGame(BoardGameFactory.BoardGames.UNO);
        sudoku = SoloGameFactory.newGame(SoloGameFactory.SoloGames.SUDOKU);

        // Game uno = BoardGameFactory.newGame(BoardGames.UNO);
        // Game sudoku = SoloGameFactory.newGame(SoloGames.SUDOKU);

        // uno = new Uno();
        // sudoku = new Sudoku();

        System.out.println(uno.instructions());
        System.out.println(sudoku.instructions());

        // UnoCard uc;
        // uc = new UnoCard(UnoCard.UnoFeature.SKIP);
        // System.out.println(uc.toString());

        // Card card1 = new Card(3, "clubs");
        // UnoCard card2 = new UnoCard(4, "red");
        // // UnoCard card3 = new UnoCard(REVERSE, "blue");
        // // UnoCard card4 = new UnoCard(WILD);

        // Card card5 = new Card();
        // Card card6 = new Card("red");



    }
}