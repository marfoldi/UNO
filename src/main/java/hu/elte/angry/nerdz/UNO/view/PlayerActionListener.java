package hu.elte.angry.nerdz.UNO.view;

import hu.elte.angry.nerdz.UNO.model.card.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;

/**
 * JButton eseménykezelő. A kártya lapjait JButton-okkal jelenítem meg. Az
 * "Új lap" feliratú JButton jelenti a paklit, erre kattintva lehet lapot húzni.
 * A többi JButton a játékos kezében levő lapok, melyek közül a kattintással
 * kiválasztott lapot dobja el.
 * 
 * @author gp
 *
 */
public class PlayerActionListener implements ActionListener {
	private PlayerPanel playerPanel;
	private Desk desk;

	public PlayerActionListener(Desk desk, PlayerPanel playerPanel) {
		this.desk = desk;
		this.playerPanel = playerPanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String label = arg0.getActionCommand();
		if (label.equals("New card")) {
			playerPanel.addCard(randomCard());
		} else if (desk.topOfDeck.getText().equals(((JButton) arg0.getSource()).getText())
				|| desk.topOfDeck.getBackground().equals(((JButton) arg0.getSource()).getBackground())) {
			playerPanel.dropCard(Integer.parseInt(((JButton) arg0.getSource()).getName()));
			CardColor cardColor = CardColor.YELLOW;
			if (((JButton) arg0.getSource()).getBackground() == Color.YELLOW) {
				cardColor = CardColor.YELLOW;
			} else if (((JButton) arg0.getSource()).getBackground() == Color.RED) {
				cardColor = CardColor.RED;
			} else if (((JButton) arg0.getSource()).getBackground() == Color.GREEN) {
				cardColor = CardColor.GREEN;
			} else if (((JButton) arg0.getSource()).getBackground() == Color.BLUE) {
				cardColor = CardColor.BLUE;
			}
			CardValue cardValue = CardValue.EIGHT;
			for (CardValue cv : CardValue.values()) {
				if (cv.toString().equals(((JButton) arg0.getSource()).getText())) {
					cardValue = cv;
				}
			}
			desk.showTopOfDeck(new Card(cardColor, cardValue));
		}
		playerPanel.showCards();
	}

	/**
	 * Véletlenszámok alapján egy lapot ad vissza. Nem végez ellenőrzést,
	 * ugyanazt a lapot többször is visszaadhatja. Csak a teszteléshez
	 * használom.
	 *
	 * @return
	 */
	private ICard randomCard() {
		Random rnd = new Random();
		CardColor cardColor = null;
		switch (rnd.nextInt(4)) {
		case 0:
			cardColor = CardColor.YELLOW;
			break;
		case 1:
			cardColor = CardColor.RED;
			break;
		case 2:
			cardColor = CardColor.GREEN;
			break;
		case 3:
			cardColor = CardColor.BLUE;
			break;
		}
		int cardValue = rnd.nextInt(10);
		return new Card(cardColor, CardValue.fromInt(cardValue));
	}

}
