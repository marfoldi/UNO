package hu.elte.angry.nerdz.UNO.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import hu.elte.angry.nerdz.UNO.model.card.ICard;

/**
 * Ezen a panelen láthatóak a játékos lapjai. A lapokat (amik JButton-ok) egy
 * listában tárolom. Mindegyik lapnak(JButton-nak) egyedi neve van: egy egész
 * szám, ami a listában a lap sorszáma 0-tól kezdve. Lap dobásakor a törlés
 * eszerint az index szerint történik.
 * 
 * @author gp
 *
 */
public class JatekosPanel extends JPanel {
	private List<JButton> lst = new ArrayList<>();// lapok listája
	private int i = 0;// lapok száma
	private JPanel panel = new JPanel();// ezen jelennek meg a lapok
	private Asztal asztal;

	public JatekosPanel() {
		i = 0;
		JScrollPane sp = new JScrollPane(panel);
		sp.setPreferredSize(new Dimension(600, 180));
		add(sp);
		// lapokatHozzaad(lst);
		lapokatMegjelenit();
	}

	public void asztaltBeallit(Asztal a) {
		asztal = a;
	}

	/**
	 * A paraméterként kapott lapot hozzáadja a játékos lapjaihoz.
	 * 
	 * @param lap
	 */
	public void lapotHozzaad(ICard lap) {
		JButton btn = new JButton(lap.getValue().toString());
		btn.setForeground(Color.DARK_GRAY);
		btn.setFont(new Font(getName(), Font.BOLD, 18));
		btn.setBackground(szin(lap));
		btn.setName("" + i);
		btn.setPreferredSize(new Dimension(100, 150));
		btn.addActionListener(new AkcioFigyelo(asztal, this));
		lst.add(btn);
		i++;
		lapokatMegjelenit();
	}

	/**
	 * A paraméterként kapott lap színét adja vissza.
	 * 
	 * @param lap
	 * @return
	 */
	// TODO A CardColor-ban a YELLOW helyett Color.YELLOW, RED helyett
	// Color.RED, stb. ?
	private Color szin(ICard lap) {
		Color szin = Color.BLACK;
		switch (lap.getColor().ordinal()) {
		case 0:
			szin = Color.YELLOW;
			break;
		case 1:
			szin = Color.RED;
			break;
		case 2:
			szin = Color.GREEN;
			break;
		case 3:
			szin = Color.BLUE;
			break;
		}
		return szin;
	}

	/**
	 * Megjeleníti a játékos lapjait.
	 */
	public void lapokatMegjelenit() {
		panel.setVisible(false);
		for (JButton lap : lst) {
			panel.add(lap);
		}
		panel.setVisible(true);
	}

	/**
	 * Eldobja a j. indexű lapot. Törli a listából, és a panelről is
	 * eltávolítja.
	 *
	 * @param j:
	 *            ezt az indexű lapot kell a listából törölni.
	 */
	public void lapotDob(int j) {
		panel.remove(lst.remove(j));
		for (int k = j; k < lst.size(); k++) {
			lst.get(k).setName("" + k);
		}
		i--;
	}

	/**
	 * A paraméterként kapott listában levő lapokat hozzáveszi a játékos
	 * lapjaihoz.
	 * 
	 * @param lst
	 */
	public void lapokatHozzaad(List<ICard> lst) {
		for (ICard lap : lst) {
			lapotHozzaad(lap);
		}
	}

}
