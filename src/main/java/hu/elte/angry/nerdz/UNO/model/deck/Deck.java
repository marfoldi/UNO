package hu.elte.angry.nerdz.UNO.model.deck;


import hu.elte.angry.nerdz.UNO.model.card.Card;
import hu.elte.angry.nerdz.UNO.model.card.ICard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck implements IDeck {

	private Stack<ICard> cards;
	private Stack<ICard> playedCards;
	
	public Deck(List<ICard> cards) {
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

/*Robert*/
	/* insertCard(): This inserts a card in the deck*/

	
	public void insertCard(Card card) {
		cards.add(0, card);
	}
	
	public void insertCardAtLast(Card card) {
		cards.add(card);
	}
	
	public boolean isEmpty() {
		return cards.isEmpty();
	}
	
	public boolean exists(Card card) {
		
		boolean sameColor = false;
		boolean sameValue = false;
		boolean isOnlyValue = card.getColor() == Card.NULL; //this tests if the method only wants a value withour regarding about the color
		
		for (int i = 0; i != cards.size(); i += 1) {
			sameColor = isOnlyValue? true: card.getColor() == showCard(i).getColor();
			sameValue = card.getValue() == showCard(i).getValue();
			
			if (sameColor && sameValue) return true;
		}
		
		return false;
	}

	private Card showCard(int i) {
		// TODO Auto-generated method stub
		return (Card)cards.elementAt(i);

			
	}

		
		
		
	}
	

 
