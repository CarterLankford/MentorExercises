package games.board;
import games.lib.Movement;
import games.lib.Card;

public class UnoMovement implements Movement {
    private Card card;

    public UnoMovement(Card card){
        setCard(card);
    }

    public Card getCard(){
        return this.card ;
    }

    public void setCard(Card card){
        this.card = card;
    }
}