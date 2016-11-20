package hu.elte.angry.nerdz.UNO.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import hu.elte.angry.nerdz.UNO.model.card.Card;
import hu.elte.angry.nerdz.UNO.model.card.CardColor;
import hu.elte.angry.nerdz.UNO.model.card.CardValue;
import hu.elte.angry.nerdz.UNO.model.card.ICard;

public class Main extends JFrame {
	JMenuItem newAction = new JMenuItem("New Game");
	JMenuItem exitAction = new JMenuItem("Exit");
	JMenuItem helpAction = new JMenuItem("Help");
	JMenuItem InfoAction = new JMenuItem("Info");

	JMenuBar menuBar = new JMenuBar();

	JMenu fileMenu = new JMenu("File");
	JMenu helpMenu = new JMenu("Help");

	public Main() {
		super("UNO");
		setSize(800, 600);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		setupMenu();
		setupMenuActions();

		add(mockDesk());
		setVisible(true);
	}

	private void setupMenuActions() {
		helpAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HelpBox();
			}
		});

		InfoAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AboutBox();
			}
		});

		exitAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		newAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	private Desk mockDesk() {
		// felül levő lap
		Card topCard = new Card(CardColor.BLUE, CardValue.SEVEN);

		// játékos kezdeti lapjai
		List<ICard> initCards = new ArrayList<ICard>();
		initCards.add(new Card(CardColor.YELLOW, CardValue.ONE));
		initCards.add(new Card(CardColor.RED, CardValue.FIVE));
		initCards.add(new Card(CardColor.GREEN, CardValue.TWO));
		return new Desk(topCard, initCards);
	}

	private void setupMenu() {
		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);

		helpMenu.add(helpAction);
		helpMenu.add(InfoAction);
		fileMenu.add(newAction);
		fileMenu.addSeparator();
		fileMenu.add(exitAction);
		fileMenu.addSeparator();
		fileMenu.add(InfoAction);
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
		new Main();
	}
}
