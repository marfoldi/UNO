package hu.elte.angry.nerdz.UNO.Mock;

import hu.elte.angry.nerdz.UNO.model.card.ICard;
import hu.elte.angry.nerdz.UNO.model.deck.IDeck;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Daniel Torok
 * 
 * Mock implementation for IDeck. Used in UNIT tests.
 *
 */
public class DeckMock implements IDeck {

	public List<String> activities;
	public ICard mockCard;
	
	public DeckMock() {
		activities = new ArrayList<String>();
	}
	
	@Override
	public ICard drawCard() {
		activities.add("drawCard");
		
		return mockCard;
	}

	@Override
	public List<ICard> drawCards(int amount) {
		activities.add("drawCards");
		List<ICard> cards = new ArrayList<ICard>();
		
		for (int i=0; i<amount; i++) {
			cards.add(drawCard());
		}
		
		return cards;
	}

	@Override
	public void shuffle() {
		activities.add("shuffle");
	}

}
