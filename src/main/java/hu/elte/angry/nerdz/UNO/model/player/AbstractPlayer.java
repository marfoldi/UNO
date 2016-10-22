package hu.elte.angry.nerdz.UNO.model.player;

import java.util.ArrayList;
import java.util.List;

import hu.elte.angry.nerdz.UNO.model.card.ICard;

public abstract class AbstractPlayer implements IPlayer {
 
	private List<ICard> playerCards;
	
	private ICard actCard;
	
	private StepComplition comp;
	
	private List<ICard> getValidCards(){
		List<ICard> resultCards = new ArrayList<ICard>();
		
		for(ICard card : playerCards){
			if(card.getColor().equals(this.actCard.getColor()) || card.getValue().equals(this.actCard.getValue())){
				resultCards.add(card);
			}
		}
		
		return resultCards;
	}
}
