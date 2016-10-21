package hu.elte.angry.nerdz.UNO.model.card;

public enum CardValue {
	// ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE;
	ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9);

	private final int value;

	CardValue(int value) {
		this.value = value;
	}

	private int value() {
		return value;
	}

	// public static void main(String[] args) {
	// System.out.println(CardValue.EIGHT.value());
	// for (CardValue v : CardValue.values()) {
	// System.out.println(v + ", " + v.value());
	// }
	// }
}
