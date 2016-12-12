package hu.elte.angry.nerdz.UNO.controller;

import java.awt.Color;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import hu.elte.angry.nerdz.UNO.App;
import hu.elte.angry.nerdz.UNO.model.card.CardColor;
import hu.elte.angry.nerdz.UNO.model.card.ICard;
import hu.elte.angry.nerdz.UNO.model.cardparser.DeckParser;
import hu.elte.angry.nerdz.UNO.model.deck.Deck;
import hu.elte.angry.nerdz.UNO.model.manager.GameManager;
import hu.elte.angry.nerdz.UNO.model.player.IPlayer;
import hu.elte.angry.nerdz.UNO.model.player.Player;
import hu.elte.angry.nerdz.UNO.model.player.RobotPlayer;
import hu.elte.angry.nerdz.UNO.view.card.CardButton;
import hu.elte.angry.nerdz.UNO.view.DeskPanel;
import hu.elte.angry.nerdz.UNO.view.PlayerPanel;
import hu.elte.angry.nerdz.UNO.view.RobotPanel;

/**
 * 
 * @author TheDago
 *
 */
public class GameController implements IGameController {
	private DeskPanel view;
	private GameManager model;
	private List<RobotPlayer> robotPlayers;
	private Player player;

	private final int startCardNum;
	
	public static void main(String[] args) {
		GameController c = new GameController(7, 3);
	}

	/**
	 * @param view
	 * @param model
	 */
	public GameController(int startCardNum, int opponentPlayerCount) {
		super();
		this.startCardNum = startCardNum;
		initPlayers(opponentPlayerCount);
		initModel();
		model.start(startCardNum);
		initView();
		new App(view);
	}

	private void initView() {
		CardButton topOfDeck = parseCard(model.getTopCard());
		List<RobotPanel> robotPanels = new ArrayList<>();
		for(int i=0;i<robotPlayers.size();i++){
			robotPanels.add(new RobotPanel("Robot"+i));
		}
		List<CardButton> panelCards = new ArrayList<>();
		for(ICard card : player.getCards()){
			panelCards.add(parseCard(card));
		}
			
		PlayerPanel playerPanel = new PlayerPanel(panelCards);
		view = new DeskPanel(topOfDeck, robotPanels, playerPanel);
	}

	private void initModel() {
		List<ICard> deckCards= new ArrayList<>();
		try {
			deckCards = getDeckCards();
		} catch (IOException | URISyntaxException e) {
			System.err.println("Couldn't parse cards from JSON!");
			System.exit(1);
		}
		List<IPlayer> allPlayers = new ArrayList<>();
		allPlayers.add(player);
		allPlayers.addAll(robotPlayers);
		model = new GameManager(allPlayers, new Deck(deckCards));
	}

	private List<ICard> getDeckCards() throws IOException, URISyntaxException {
		DeckParser parser = new DeckParser();
		return parser.parseJSON(parser.readFile(parser.PATH));
	}

	private void initPlayers(int opponentPlayerCount) {
		robotPlayers = new ArrayList<>();
		player = new Player();
		for(int i=0; i<opponentPlayerCount ; i++){
			robotPlayers.add(new RobotPlayer());
		}
	}

	private CardButton parseCard(ICard card) {
		return new CardButton(parseColor(card.getColor()),card.getValue().ordinal());
	}

	private Color parseColor(CardColor color) {
		switch (color) {
			case BLACK:
				return Color.BLACK;
			case BLUE:
				return Color.BLUE;
			case GREEN:
				return Color.GREEN;
			case RED:
				return Color.RED;
			case YELLOW:
				return Color.YELLOW;
			default:
				return Color.BLACK;
		}
	}
}
