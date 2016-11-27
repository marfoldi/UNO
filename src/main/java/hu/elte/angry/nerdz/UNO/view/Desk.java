package hu.elte.angry.nerdz.UNO.view;

import hu.elte.angry.nerdz.UNO.model.card.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Megjeleníti a két robot játékost a képernyő tetejének jobb és bal felső
 * sarkában; a paklit a képernyő közepén balra; a felül levő lapot a képernyő
 * közepén jobbra; a játékos lapjait a képernyő alján.
 * 
 * @author gp
 *
 */
public class Desk extends JPanel {
	private JButton deck;// ez a "húzó-pakli", erre kattintva lehet lapot húzni
	JButton topOfDeck;// ez az "eldobó-pakli" tetején levő lap
	private RobotPanel rp1, rp2;// két robot
	private PlayerPanel playerPanel;// ezen vannak a játékos lapjai
	private JPanel deckPanel;// Ezen a panelen van a "húzó-pakli", illetve az
								// "eldobó-pakli", aminek a felső lapja látszik.

	public Desk(ICard lap, List<ICard> initCardList) {
		setLayout(new GridLayout(3, 1));

		rp1 = new RobotPanel("Robot1", 7);
		rp2 = new RobotPanel("Robot2", 7);
		JPanel opponentPanel = new JPanel();
		opponentPanel.setLayout(new GridLayout(1, 2));
		opponentPanel.add(rp1);
		opponentPanel.add(rp2);
		this.add(opponentPanel);

		playerPanel = new PlayerPanel(this, initCardList);

		deckPanel = new JPanel();
		deckPanel.setSize(new Dimension(300, 150));
		// deckPanel.setLayout(new GridLayout(1, 2));
		deck = new JButton("New card");
		deck.addActionListener(new PlayerActionListener(this, playerPanel));
		deck.setPreferredSize(new Dimension(100, 150));
		// pakli.setIcon(new ImageIcon("uno.jpg"));
		deckPanel.add(deck);

		topOfDeck = getJButtonFromCard(lap);
		topOfDeck.setEnabled(false);
		topOfDeck.setPreferredSize(new Dimension(100, 150));
		deckPanel.add(topOfDeck);

		add(deckPanel);

		add(playerPanel);
		playerPanel.addCard(new Card(CardColor.RED, CardValue.SEVEN));

		// rp1.lapokSzama(10);
		// jatekosPanel.lapotHozzaad(new Card(CardColor.RED, CardValue.SEVEN));
		// jatekosPanel.lapotDob(1);
	}

	/**
	 * Megjeleníti a "dobó-pakli" tetején a paraméterként kapott lapot.
	 * 
	 * @param card
	 */
	public void showTopOfDeck(ICard card) {
		setVisible(false);
		deckPanel.remove(topOfDeck);
		topOfDeck = getJButtonFromCard(card);
		topOfDeck.setEnabled(false);
		deckPanel.add(topOfDeck);
		setVisible(true);
	}

	/**
	 * A paraméterben kapott ICard színével és szimbólumával megegyező JButton-t
	 * ad vissza.
	 * 
	 * @param card
	 * @return
	 */
	private JButton getJButtonFromCard(ICard card) {
		JButton btn = new JButton();
		if(card.getValue().getIntegerRepresentation() >=0 && card.getValue().getIntegerRepresentation() <=9) {
			btn.setText(Integer.toString(card.getValue().getIntegerRepresentation()));
		} else {
			btn.setText(card.getValue().toString());
		}
		btn.setForeground(Color.DARK_GRAY);
		btn.setFont(new Font(getName(), Font.BOLD, 18));
		btn.setBackground(getColorOfCard(card));
		btn.setPreferredSize(new Dimension(100, 150));
		return btn;
	}

	private Color getColorOfCard(ICard card) {
		Color color = Color.BLACK;
		switch (card.getColor().ordinal()) {
		case 0:
			color = Color.YELLOW;
			break;
		case 1:
			color = Color.RED;
			break;
		case 2:
			color = Color.GREEN;
			break;
		case 3:
			color = Color.BLUE;
			break;
		}
		return color;
	}

}
