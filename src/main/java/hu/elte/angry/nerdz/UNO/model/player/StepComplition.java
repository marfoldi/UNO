package hu.elte.angry.nerdz.UNO.model.player;

import java.util.List;

import hu.elte.angry.nerdz.UNO.model.card.ICard;

public interface StepComplition {
	
	public List<ICard> drawCards(int amount);
	
	public boolean dropCard(ICard card);
}
