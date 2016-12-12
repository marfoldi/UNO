package hu.elte.angry.nerdz.UNO.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import hu.elte.angry.nerdz.UNO.view.card.CardButton;

public class DeckPanel extends JPanel {
	private static final long serialVersionUID = 1936620884021404951L;
	private CardButton topOfDeck;
	private JButton deckButton;

	/**
	 * 
	 * @param topOfDeck
	 */
	public DeckPanel(CardButton topOfDeck){
		this.setSize(new Dimension(300, 150));
		deckButton = new JButton("New Card");
		deckButton.setPreferredSize(new Dimension(100, 150));
		this.add(deckButton);
		
		this.topOfDeck = topOfDeck;
		topOfDeck.setEnabled(false);
		topOfDeck.setPreferredSize(new Dimension(100, 150));
		this.add(topOfDeck);
	}
	
	/**
	 * 
	 * @param topOfDeck
	 * @param actionListener
	 */
	public DeckPanel(CardButton topOfDeck, ActionListener actionListener){
		this(topOfDeck);
		deckButton.addActionListener(actionListener);
	}
	
	/**
	 * Adds an action listener to the deckButton
	 * @param actionListener
	 */
	public void addDeckButtonActionListener(ActionListener actionListener) {
		deckButton.addActionListener(actionListener);
	}

	/**
	 * @param topOfDeck the topOfDeck to set
	 */
	public void setTopOfDeck(CardButton topOfDeck) {
		this.topOfDeck.setText(topOfDeck.getText());
		this.topOfDeck.setBackground(topOfDeck.getBackground());
	}
}
