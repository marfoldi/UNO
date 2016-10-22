package hu.elte.angry.nerdz.UNO.model.player;

import hu.elte.angry.nerdz.UNO.model.card.ICard;

public interface IPlayer {
	
	public void step(ICard card, StepComplition comp);
	
	
}
