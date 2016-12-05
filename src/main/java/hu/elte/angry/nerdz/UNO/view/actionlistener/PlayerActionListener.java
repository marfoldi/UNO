package hu.elte.angry.nerdz.UNO.view.actionlistener;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Random;

import hu.elte.angry.nerdz.UNO.view.CardPanel;
import hu.elte.angry.nerdz.UNO.view.Desk;
import hu.elte.angry.nerdz.UNO.view.PlayerPanel;

/**
 * JButton eseménykezelő. A kártya lapjait JButton-okkal jelenítem meg. Az
 * "Új lap" feliratú JButton jelenti a paklit, erre kattintva lehet lapot húzni.
 * A többi JButton a játékos kezében levő lapok, melyek közül a kattintással
 * kiválasztott lapot dobja el.
 * 
 * @author gp
 *
 */
public abstract class PlayerActionListener implements ActionListener {
	protected PlayerPanel playerPanel;
	protected Desk desk;

	public PlayerActionListener(Desk desk, PlayerPanel playerPanel) {
		this.desk = desk;
		this.playerPanel = playerPanel;
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
		return new CardPanel(cardValue,cardColor);
	}

}
