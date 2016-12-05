package hu.elte.angry.nerdz.UNO.view.actionlistener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import hu.elte.angry.nerdz.UNO.view.CardPanel;
import hu.elte.angry.nerdz.UNO.view.DeskPanel;
import hu.elte.angry.nerdz.UNO.view.PlayerPanel;

/**
 * New card and player cards action.
 * 
 * @author gp
 *
 */
public class PlayerActionListener implements ActionListener {
	protected PlayerPanel playerPanel;
	protected DeskPanel desk;

	public PlayerActionListener(DeskPanel desk, PlayerPanel playerPanel) {
		this.desk = desk;
		this.playerPanel = playerPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO: add controller
		System.out.println(e.toString());
		
//		String label = e.getActionCommand();
//		JButton button = (JButton) e.getSource();
//		System.out.println(e.toString());
//		if (label.equals("New card")) {
//			playerPanel.addCard(randomCard(), this);
//		} else if (desk.topOfDeck.getText().equals(button.getText())
//				|| desk.topOfDeck.getBackground().equals(button.getBackground())) {
//			playerPanel.dropCard(Integer.parseInt(((JButton) e.getSource()).getName()));
//			Color cardColor = ((JButton) e.getSource()).getBackground();
//			int cardValue = Integer.parseInt(((JButton) e.getSource()).getText());
//			desk.showTopOfDeck(new CardPanel(cardValue, cardColor));
//		}
//
//		playerPanel.showCards();
	}

	/**
	 * Véletlenszámok alapján egy lapot ad vissza. Nem végez ellenőrzést,
	 * ugyanazt a lapot többször is visszaadhatja. Csak a teszteléshez
	 * használom.
	 *
	 * @return
	 */
	protected CardPanel randomCard() {
		Random rnd = new Random();
		Color cardColor = null;
		switch (rnd.nextInt(4)) {
		case 0:
			cardColor = Color.YELLOW;
			break;
		case 1:
			cardColor = Color.RED;
			break;
		case 2:
			cardColor = Color.GREEN;
			break;
		case 3:
			cardColor = Color.BLUE;
			break;
		}
		int cardValue = rnd.nextInt(10);
		return new CardPanel(cardValue, cardColor);
	}

}
