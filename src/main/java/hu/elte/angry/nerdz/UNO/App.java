package hu.elte.angry.nerdz.UNO;

import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import hu.elte.angry.nerdz.UNO.model.card.Card;
import hu.elte.angry.nerdz.UNO.model.card.CardColor;
import hu.elte.angry.nerdz.UNO.model.card.CardValue;
import hu.elte.angry.nerdz.UNO.model.card.ICard;
import hu.elte.angry.nerdz.UNO.view.Desk;
import hu.elte.angry.nerdz.UNO.view.window.AppMenuBar;

public class App extends JFrame {
	private static final long serialVersionUID = -5071602386904303971L;

	public App() {
		super("UNO");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setJMenuBar(new AppMenuBar());
		this.add(mockDesk());
		this.setVisible(true);
	}

	/**
	 * Initialize the desk
	 * @return
	 */
	private Desk mockDesk() {
		Card topCard = new Card(CardColor.BLUE, CardValue.SEVEN);
		
		List<ICard> initCards = new ArrayList<ICard>();
		initCards.add(new Card(CardColor.YELLOW, CardValue.ONE));
		initCards.add(new Card(CardColor.RED, CardValue.FIVE));
		initCards.add(new Card(CardColor.GREEN, CardValue.TWO));
		return new Desk(topCard, initCards);
	}

	@Override
	protected void processWindowEvent(WindowEvent e) {
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			int exit = JOptionPane.showConfirmDialog(this, "Are you sure exit ?");
			if (exit == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		} else {
			super.processWindowEvent(e);
		}
	}

	public static void main(String[] args) {
		new App();
	}
}
