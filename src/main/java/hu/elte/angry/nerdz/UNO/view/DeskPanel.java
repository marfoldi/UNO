package hu.elte.angry.nerdz.UNO.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

import hu.elte.angry.nerdz.UNO.view.actionlistener.PlayerActionListener;
import hu.elte.angry.nerdz.UNO.view.card.CardButton;

/**
 * Desk where the players, deck and top card is.
 * 
 * @author gp, Bárdi Zsolt
 *
 */
public class DeskPanel extends JPanel {
	private static final long serialVersionUID = 145727429985277184L;
	
	private DeckPanel deck;
	public CardButton topOfDeck;
	private RobotPanel rp1, rp2;
	private PlayerPanel playerPanel;
	private JPanel deckPanel;

	public DeskPanel(CardButton topOfDeck, List<CardButton> initCardList) {
		setLayout(new GridLayout(3, 1));

		rp1 = new RobotPanel("Robot1");
		rp2 = new RobotPanel("Robot2");
		JPanel opponentPanel = new JPanel();
		opponentPanel.setLayout(new GridLayout(1, 2));
		opponentPanel.add(rp1);
		opponentPanel.add(rp2);
		add(opponentPanel);

		playerPanel = new PlayerPanel(initCardList);

		deckPanel = new JPanel();
		deckPanel.setSize(new Dimension(300, 150));
		deck = new DeckPanel();
		deck.addActionListener(new PlayerActionListener(this, playerPanel));
		deckPanel.add(deck);

		this.topOfDeck = topOfDeck;
		this.topOfDeck.setEnabled(false);
		this.topOfDeck.setPreferredSize(new Dimension(100, 150));
		deckPanel.add(topOfDeck);

		add(deckPanel);

		add(playerPanel);
	}
	
	/**
	 * Put the card from the parameter to the top of the desk.
	 * 
	 * @param card 
	 * 			Card to put on the top of the deck
	 */
	public void putOnTopOfDeck(CardButton card) {
		setVisible(false);
		deckPanel.remove(topOfDeck);
		topOfDeck = card;
		topOfDeck.setEnabled(false);
		deckPanel.add(topOfDeck);
		setVisible(true);
	}
}
