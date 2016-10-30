/**
 * 
 */
package hu.elte.angry.nerdz.UNO.model.card;

/**
 * @author Peter Gerencser
 *
 */
public class Card implements ICard {
	private CardColor color;
	private CardValue value;

	/**
	 * @param color
	 * @param value
	 */
	public Card(CardColor color, CardValue value) {
		super();
		this.color = color;
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see hu.elte.angry.nerdz.UNO.model.card.ICard#getColor()
	 */
	@Override
	public CardColor getColor() {
		return color;
	}
	
	/* (non-Javadoc)
	 * @see hu.elte.angry.nerdz.UNO.model.card.ICard#getValue()
	 */
	@Override
	public CardValue getValue() {
		return value;
	}
	
	/* (non-Javadoc)
	 * @see hu.elte.angry.nerdz.UNO.model.card.ICard#matchingCard()
	 */
	@Override
	public boolean matchingCard(ICard card) {
		if (!(card instanceof Card)) {
			return false;
		}
		
		boolean colorCheck = color.equals(card.getColor());
		boolean valueCheck = value.equals(card.getValue());
		
		return colorCheck || valueCheck;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Card [color=" + color + ", value=" + value + "]";
	}
	
	@Override
	public int hashCode() {
		String colorString;
		Integer valueInt;
		
		switch (color) {
		case RED: colorString = "red"; break;
		case YELLOW: colorString = "yellow"; break;
		case BLUE: colorString = "blue"; break;
		case GREEN: colorString = "green"; break;
		default: colorString = "wtf";
		}
		
		switch (value) {
		case ONE: valueInt = 1;
		case TWO: valueInt = 2;
		case THREE: valueInt = 3;
		case FOUR: valueInt = 4;
		case FIVE: valueInt = 5;
		case SIX: valueInt = 6;
		case SEVEN: valueInt = 7;
		case EIGHT: valueInt = 8;
		case NINE: valueInt = 9;
		default: valueInt = -1;
		}
		
		return colorString.hashCode() + valueInt.hashCode(); 
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Card)) {
			return false;
		}
		Card otherCard = (Card) other;
		return value.equals(otherCard.getValue()) && color.equals(otherCard.getColor());
	}
}
