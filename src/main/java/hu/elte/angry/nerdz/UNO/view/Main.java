package hu.elte.angry.nerdz.UNO.view;

import hu.elte.angry.nerdz.UNO.model.card.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main extends JFrame {

	public Main() {
		super("UNO");
		setSize(800, 600);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// felül levő lap
		Card topCard = new Card(CardColor.BLUE, CardValue.SEVEN);

		// játékos kezdeti lapjai
		List<ICard> initCards = new ArrayList<ICard>();
		initCards.add(new Card(CardColor.YELLOW, CardValue.ONE));
		initCards.add(new Card(CardColor.RED, CardValue.FIVE));
		initCards.add(new Card(CardColor.GREEN, CardValue.TWO));

		add(new Desk(topCard, initCards));
		setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}

}
