package games.solo;
import games.lib.Movement;
import games.lib.Card;

public class SolitaireMovement implements Movement {
    private Card card;

    public SolitaireMovement(Card card){
        setCard(card);
    }

    public Card getCard(){
        return this.card;
    }

    public void setCard(Card card){
        this.card = card;
    }
}