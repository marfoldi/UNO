package hu.elte.angry.nerdz.UNO.card;

public class Card implements ICard {
	private CardValue value;
	private CardColor color;

	public Card(CardValue v, CardColor c) {
		this.value = v;
		this.color = c;
	}

	@Override
	public CardValue getValue() {
		return value;
	}

	@Override
	public CardColor getColor() {
		return color;
	}

}
