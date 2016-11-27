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
public class PlayerPanel extends JPanel {
	private static final long serialVersionUID = 6328789247989590931L;
	private List<JButton> buttonList = new ArrayList<>();// lapok listája
	private int numOfCards = 0;// lapok száma
	private JPanel panel = new JPanel();// ezen jelennek meg a lapok
	private Desk desk;

	public PlayerPanel(Desk desk, List<ICard> initCardList) {
		numOfCards = 0;
		this.desk = desk;
		JScrollPane sp = new JScrollPane(panel);
		sp.setPreferredSize(new Dimension(600, 180));
		add(sp);
		addCards(initCardList);
	}

	/**
	 * A paraméterként kapott lapot hozzáadja a játékos lapjaihoz.
	 * 
	 * @param card
	 */
	public void addCard(ICard card) {
		JButton btn = new JButton(card.getValue().getPrimitiveValue());
		btn.setForeground(Color.DARK_GRAY);
		btn.setFont(new Font(getName(), Font.BOLD, 18));
		btn.setBackground(card.getColor().getAwtColor());
		btn.setName("" + numOfCards);
		btn.setPreferredSize(new Dimension(100, 150));
		btn.addActionListener(new PlayerActionListener(desk, this));
		buttonList.add(btn);
		numOfCards++;
		showCards();
	}

	/**
	 * Megjeleníti a játékos lapjait.
	 */
	public void showCards() {
		panel.setVisible(false);
		for (JButton card : buttonList) {
			panel.add(card);
		}
		panel.setVisible(true);
	}

	/**
	 * Eldobja a j. indexű lapot. Törli a listából, és a panelről is
	 * eltávolítja.
	 *
	 * @param j Ezt az indexű lapot kell a listából törölni.
	 */
	public void dropCard(int j) {
		panel.remove(buttonList.remove(j));
		for (int k = j; k < buttonList.size(); k++) {
			buttonList.get(k).setName("" + k);
		}
		numOfCards--;
	}

	/**
	 * A paraméterként kapott listában levő lapokat hozzáveszi a játékos
	 * lapjaihoz.
	 * 
	 * @param cardList
	 */
	private void addCards(List<ICard> cardList) {
		for (ICard card : cardList) {
			addCard(card);
		}
	}
}
