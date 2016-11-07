package hu.elte.angry.nerdz.UNO.Mock;

import hu.elte.angry.nerdz.UNO.model.card.ICard;
import hu.elte.angry.nerdz.UNO.model.player.IPlayer;
import hu.elte.angry.nerdz.UNO.model.player.StepCompletion;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Daniel Torok
 * 
 * Mock implementation for IPlayer. Used in UNIT tests.
 *
 */
public class PlayerMock implements IPlayer {
	
	public static enum action {
		DRAW, DROP, TIMEOUT
	}

	public List<String> activities;
	public List<ICard> cardsInSetCardsMethod;
	public ICard cardInStepMethod;
	public ICard cardToDrop;
	public action stepAction;
	
	public PlayerMock() {
		activities = new ArrayList<String>();
	}
	
	@Override
	public void step(ICard actCard, StepCompletion completionHandler) {
		activities.add("step");
		cardInStepMethod = actCard;
		
		switch (stepAction) {
		case DRAW: completionHandler.draw(); break;
		case DROP: completionHandler.drop(cardToDrop); break;
		default: break;
		}
	}

	@Override
	public void setCards(List<ICard> cards) {
		activities.add("setCards");
		cardsInSetCardsMethod = cards;
	}

	@Override
	public void onCardsChange() {
		activities.add("onCardsChange");
	}
	
	/*@Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
       return true;
    }*/

}
