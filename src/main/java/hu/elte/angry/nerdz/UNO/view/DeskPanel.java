package hu.elte.angry.nerdz.UNO.view;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

/**
 * Desk where the players, deck and top card is.
 * 
 * @author gp, Bárdi Zsolt
 *
 */
public class DeskPanel extends JPanel {
	private static final long serialVersionUID = 145727429985277184L;
	
	private DeckPanel deckPanel;
	private List<RobotPanel> robotPlayers;
	private PlayerPanel playerPanel;

	public DeskPanel(List<RobotPanel> robotPanels, PlayerPanel player, DeckPanel deckPanel) {
		setLayout(new GridLayout(3, 1));
		this.robotPlayers = robotPanels;
		this.playerPanel = player;
		this.deckPanel = deckPanel;
		JPanel opponentPanel = new JPanel();
		opponentPanel.setLayout(new GridLayout(1, 2));
		
		for (RobotPanel panel : robotPlayers){
			opponentPanel.add(panel);
		}
			
		add(opponentPanel);
		add(deckPanel);
		add(playerPanel);
	}

	/**
	 * @return the playerPanel
	 */
	public PlayerPanel getPlayerPanel() {
		return playerPanel;
	}

	/**
	 * @return the deckPanel
	 */
	public DeckPanel getDeckPanel() {
		return deckPanel;
	}
}
