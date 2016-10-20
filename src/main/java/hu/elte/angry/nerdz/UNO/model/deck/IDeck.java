package hu.elte.angry.nerdz.UNO.model.deck;

public interface IDeck {

  
  ArrayList<Card> pile;
	ArrayList<Card> cards;

	public Deck(ArrayList<Card> c) {
		cards = c;
	}

	public Deck() {
		cards = new ArrayList<Card>(108);
	}

	public void addCard(Card c) {
		cards.add(c);
	}

	public Card drawCard() {
		if (cards.size() == 0) {
			Uno.makeDeck();
		}
		return cards.remove(0);
	}

	public Card peek() {
		return cards.get(0);
	}

	public void split() {
		split((int) ((Math.random() * (cards.size() - 10)) + 10));
	}

	public void split(int c) {
		ArrayList<Card> temp = (ArrayList) cards.subList(0, c);
		cards.removeAll(temp);
		cards.addAll(temp);
	}

	public void played(Card c) {
		pile.add(c);
	}

	public boolean canHave(Card c) {
		return cards.contains(c);
	}
  
  
}
