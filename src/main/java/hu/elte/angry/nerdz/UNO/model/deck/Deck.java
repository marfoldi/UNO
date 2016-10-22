package hu.elte.angry.nerdz.UNO.model.deck;

import hu.elte.angry.nerdz.UNO.model.card.ICard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck implements IDeck {

	private Stack<ICard> cards;
	private Stack<ICard> playedCards;
	
	Deck(List<ICard> cards) {
		this.cards = new Stack<ICard>();
		this.cards.addAll(cards);
		this.playedCards = new Stack<ICard>();
	}
	
	@Override
	public void shuffle() {
		Collections.shuffle(cards);
	}

	@Override
	public ICard drawCard() {
		restock(1);
		
		ICard drawnCard = cards.pop();
		// Note: We should not add it to the playedCards, because these cards are still in the player's hand.
		playedCards.push(drawnCard);
		
		return drawnCard;
	}

	@Override
	public List<ICard> drawCards(int amount) {
		restock(amount);
		
		ArrayList<ICard> drawnCards = new ArrayList<ICard>();
		for (int i = 0; i < amount; i++) {
			ICard drawnCard = cards.pop();
			drawnCards.add(drawnCard);
			// Note: We should not add it to the playedCards, because these cards are still in the player's hand.
			playedCards.push(drawnCard);
		}
		return null;
	}
	
	private void restock(int amount) {
		// Early error handling
		// We can not return a correct value if the deck does not contains enough number of cards.
		if (cards.size() + playedCards.size() < amount) {
			System.exit(1);
		}
		
		cards.addAll(playedCards);
		playedCards.clear();
		
		Collections.shuffle(cards);
	}

}

/*Eltávolítja a következő kártyát a fedélzet és vissza. Ez illegális
     * Hívni ezt a módszert, ha már nincs több kártya a pakliban. 
     * Ellenőrizze a kártyák száma fennmaradó meghívásával cardsLeft () függvény.
     * @return A kártyát eltávolítjuk a pakliból.
     * @throws IllegalStateException ha nincs kártya a pakliban */

 public Card dealCard() {
        if (cardsUsed == deck.length)
            throw new IllegalStateException("No cards are left in the deck.");
        cardsUsed++;
        return deck[cardsUsed - 1]; 
	 
 }
}


/**
     Teszt-e a pakliban joker.
     * @return Igaz, ha ez egy 54-kártyacsomag, amely két joker, vagy hamis, ha
     * Ez egy 52 lapos pakli, amely nem tartalmaz joker.*/

    public boolean hasJokers() {
        return (deck.length == 54);
    } 
