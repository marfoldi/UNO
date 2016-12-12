package hu.elte.angry.nerdz.UNO;

import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import hu.elte.angry.nerdz.UNO.controller.GameController;
import hu.elte.angry.nerdz.UNO.model.manager.DeckManager;
import hu.elte.angry.nerdz.UNO.model.manager.GameManager;
import hu.elte.angry.nerdz.UNO.model.manager.PlayerManager;
import hu.elte.angry.nerdz.UNO.view.DeckPanel;
import hu.elte.angry.nerdz.UNO.view.DeskPanel;
import hu.elte.angry.nerdz.UNO.view.PlayerPanel;
import hu.elte.angry.nerdz.UNO.view.window.AppMenuBar;

public class App extends JFrame {
	private static final long serialVersionUID = -5071602386904303971L;

	public App() {
		super("UNO");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setJMenuBar(new AppMenuBar());
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		GameController controller = new GameController();
		PlayerManager playerManager = new PlayerManager(2, controller);
		DeckManager deckManager = new DeckManager();
		GameManager model = new GameManager(playerManager.getPlayers(), deckManager.getDeck());
		model.start(7);
		DeskPanel view = new DeskPanel(controller.mapModelRobotsToViewRobots(playerManager.getRobotPlayers()), new PlayerPanel(controller.mapModelCardsToViewCards(playerManager.getPlayer().getCards())), new DeckPanel(controller.mapModelCardToViewCard(model.getTopCard())));
		controller.setModel(model);
		controller.setView(view);
		controller.addDeckActionListener();
		new App().add(view);
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
}
