package hu.elte.angry.nerdz.UNO.Mock;

import hu.elte.angry.nerdz.UNO.model.card.CardColor;
import hu.elte.angry.nerdz.UNO.model.card.CardValue;
import hu.elte.angry.nerdz.UNO.model.card.ICard;

public class CardMock implements ICard {
	
	public String identifier;
	
	public CardMock() {
		
	}

	@Override
	public CardValue getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CardColor getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean matchingCard(ICard card) {
		// TODO Auto-generated method stub
		return false;
	}

}
