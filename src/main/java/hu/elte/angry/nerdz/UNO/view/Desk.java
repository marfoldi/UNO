package hu.elte.angry.nerdz.UNO.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

import hu.elte.angry.nerdz.UNO.view.actionlistener.PlayerActionListener;

/**
 * Megjeleníti a két robot játékost a képernyő tetejének jobb és bal felső
 * sarkában; a paklit a képernyő közepén balra; a felül levő lapot a képernyő
 * közepén jobbra; a játékos lapjait a képernyő alján.
 * 
 * @author gp
 *
 */
public class Desk extends JPanel {
	private static final long serialVersionUID = 145727429985277184L;
	
	private DeckPanel deck;// ez a "húzó-pakli", erre kattintva lehet lapot húzni
	public CardPanel topOfDeck;// ez az "eldobó-pakli" tetején levő lap
	private RobotPanel rp1, rp2;// két robot
	private PlayerPanel playerPanel;// ezen vannak a játékos lapjai
	private JPanel deckPanel;// Ezen a panelen van a "húzó-pakli", illetve az
								// "eldobó-pakli", aminek a felső lapja látszik.

	public Desk(CardPanel topOfDeck, List<CardPanel> initCardList) {
		setLayout(new GridLayout(3, 1));

		rp1 = new RobotPanel("Robot1", 7);
		rp2 = new RobotPanel("Robot2", 7);
		JPanel opponentPanel = new JPanel();
		opponentPanel.setLayout(new GridLayout(1, 2));
		opponentPanel.add(rp1);
		opponentPanel.add(rp2);
		add(opponentPanel);

		playerPanel = new PlayerPanel(initCardList);

		deckPanel = new JPanel();
		deckPanel.setSize(new Dimension(300, 150));
		deck = new DeckPanel();
//		deck.addActionListener(new PlayerActionListener(this, playerPanel));
		deck.setPreferredSize(new Dimension(100, 150));
		deckPanel.add(deck);

		this.topOfDeck = topOfDeck;
		this.topOfDeck.setEnabled(false);
		this.topOfDeck.setPreferredSize(new Dimension(100, 150));
		deckPanel.add(topOfDeck);

		add(deckPanel);

		add(playerPanel);
	}

	/**
	 * Megjeleníti a "dobó-pakli" tetején a paraméterként kapott lapot.
	 * 
	 * @param card
	 */
	public void putOnTopOfDeck(CardPanel card) {
		setVisible(false);
		deckPanel.remove(topOfDeck);
		topOfDeck = card;
		topOfDeck.setEnabled(false);
		deckPanel.add(topOfDeck);
		setVisible(true);
	}
}
