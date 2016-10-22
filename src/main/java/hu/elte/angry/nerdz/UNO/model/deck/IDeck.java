package hu.elte.angry.nerdz.UNO.model.deck;

import hu.elte.angry.nerdz.UNO.model.card.ICard;

import java.util.List;

public interface IDeck {
	public ICard drawCard();
	public List<ICard> drawCards(int amount);
	public void shuffle();
}
