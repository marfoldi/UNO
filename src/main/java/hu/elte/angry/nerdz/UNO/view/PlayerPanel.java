package hu.elte.angry.nerdz.UNO.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import hu.elte.angry.nerdz.UNO.view.card.CardButton;

/**
 * Player panel
 * 
 * @author gp, Bárdi Zsolt
 *
 */
public class PlayerPanel extends JPanel{
	private static final long serialVersionUID = 6328789247989590931L;
	private List<CardButton> cardList = new ArrayList<>();
	private JPanel panel;// Panel with the cards on
	private JScrollPane scrollPane;

	public PlayerPanel(List<CardButton> initCardList) {
		this.panel = new JPanel();
		scrollPane = new JScrollPane(panel);
		scrollPane.setPreferredSize(new Dimension(600, 180));
		add(scrollPane);
		addCards(initCardList);
	}

	/**
	 * Adds the card in the parameter to the player's cards.
	 * 
	 * @param card
	 */
	public void addCard(CardButton card, ActionListener actionListener) {
		card.addActionListener(actionListener);
		cardList.add(card);
		showCards();
	}

	/**
	 * Shows the cards of the player
	 */
	public void showCards() {
		panel.setVisible(false);
		for (JButton card : cardList) {
			panel.add(card);
		}
		panel.setVisible(true);
		panel.repaint();
		scrollPane.repaint();
	}

	/**
	 * Drops the i index card.
	 *
	 * @param i Index of the card to be deleted.
	 */
	public void dropCard(CardButton button) {
		panel.remove(cardList.indexOf(button));
		cardList.remove(button);
		showCards();
	}

	/**
	 * Adds all the cards in the parameter to the player's cards.
	 * 
	 * @param cardList
	 */
	private void addCards(List<CardButton> cardList) {
		this.cardList.addAll(cardList);
		showCards();
	}
}
