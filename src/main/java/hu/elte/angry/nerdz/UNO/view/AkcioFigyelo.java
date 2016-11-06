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
public class AkcioFigyelo implements ActionListener {
	private JatekosPanel jatekosPanel;
	private Asztal asztal;

	public AkcioFigyelo(Asztal a, JatekosPanel jp) {
		asztal = a;
		jatekosPanel = jp;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String label = arg0.getActionCommand();
		if (label.equals("Új lap")) {
			jatekosPanel.lapotHozzaad(veletlenLap());
		} else if (asztal.felsoLap.getText().equals(((JButton) arg0.getSource()).getText())
				|| asztal.felsoLap.getBackground().equals(((JButton) arg0.getSource()).getBackground())) {
			jatekosPanel.lapotDob(Integer.parseInt(((JButton) arg0.getSource()).getName()));
			CardColor szin = CardColor.YELLOW;
			if (((JButton) arg0.getSource()).getBackground() == Color.YELLOW) {
				szin = CardColor.YELLOW;
			} else if (((JButton) arg0.getSource()).getBackground() == Color.RED) {
				szin = CardColor.RED;
			} else if (((JButton) arg0.getSource()).getBackground() == Color.GREEN) {
				szin = CardColor.GREEN;
			} else if (((JButton) arg0.getSource()).getBackground() == Color.BLUE) {
				szin = CardColor.BLUE;
			}
			CardValue szam = CardValue.EIGHT;
			for (CardValue cv : CardValue.values()) {
				if (cv.toString().equals(((JButton) arg0.getSource()).getText())) {
					szam = cv;
				}
			}
			asztal.felsoLap(new Card(szin, szam));
		}
		jatekosPanel.lapokatMegjelenit();
	}

	/**
	 * Véletlenszámok alapján egy lapot ad vissza. Nem végez ellenőrzést,
	 * ugyanazt a lapot többször is visszaadhatja. Csak a teszteléshez
	 * használom.
	 *
	 * @return
	 */
	private ICard veletlenLap() {
		Random gen = new Random();
		CardColor szin = null;
		switch (gen.nextInt(4)) {
		case 0:
			szin = CardColor.YELLOW;
			break;
		case 1:
			szin = CardColor.RED;
			break;
		case 2:
			szin = CardColor.GREEN;
			break;
		case 3:
			szin = CardColor.BLUE;
			break;
		}
		int szam = gen.nextInt(10);
		return new Card(szin, CardValue.fromInt(szam));
	}

}
