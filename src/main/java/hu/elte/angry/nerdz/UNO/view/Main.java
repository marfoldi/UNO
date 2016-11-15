package hu.elte.angry.nerdz.UNO.view;

import hu.elte.angry.nerdz.UNO.model.card.*;

<<<<<<< Upstream, based on master/master
<<<<<<< Upstream, based on master/master
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main extends JFrame {

	public Main() {
		super("UNO");
		setSize(800, 600);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// felül levő lap
		Card topCard = new Card(CardColor.BLUE, CardValue.SEVEN);

		// játékos kezdeti lapjai
		List<ICard> initCards = new ArrayList<ICard>();
		initCards.add(new Card(CardColor.YELLOW, CardValue.ONE));
		initCards.add(new Card(CardColor.RED, CardValue.FIVE));
		initCards.add(new Card(CardColor.GREEN, CardValue.TWO));

		add(new Desk(topCard, initCards));
		setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
=======
import java.awt.GridLayout;
=======
>>>>>>> e2b9b00 asztal tartalmazza a robotokat, a játékost, és a paklit
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main extends JFrame {

	public Main() {
		super("UNO");
		setSize(800, 600);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// felül levő lap
		Card topCard = new Card(CardColor.BLUE, CardValue.SEVEN);

		// játékos kezdeti lapjai
		List<ICard> initCards = new ArrayList<ICard>();
		initCards.add(new Card(CardColor.YELLOW, CardValue.ONE));
		initCards.add(new Card(CardColor.RED, CardValue.FIVE));
		initCards.add(new Card(CardColor.GREEN, CardValue.TWO));

		add(new Desk(topCard, initCards));
		setVisible(true);
	}

	public static void main(String[] args) {
<<<<<<< Upstream, based on master/master
		Main main = new Main("UNO");
		main.setLayout(new GridLayout(3, 1));

		rp1 = new RobotPanel("Robot1", 7);
		rp2 = new RobotPanel("Robot2", 7);
		JPanel ketRobot = new JPanel();
		ketRobot.setLayout(new GridLayout(1, 2));
		ketRobot.add(rp1);
		ketRobot.add(rp2);
		main.add(ketRobot);

		List<ICard> kezdetiLapok = new ArrayList<ICard>();
		kezdetiLapok.add(new Card(CardColor.YELLOW, CardValue.ONE));
		kezdetiLapok.add(new Card(CardColor.RED, CardValue.FIVE));
		kezdetiLapok.add(new Card(CardColor.GREEN, CardValue.TWO));

		jatekosPanel = new JatekosPanel();
		main.add(jatekosPanel);

		asztal = new Asztal(jatekosPanel, new Card(CardColor.BLUE, CardValue.SEVEN));
		main.add(asztal);

		jatekosPanel.asztaltBeallit(asztal);
		jatekosPanel.lapokatHozzaad(kezdetiLapok);
		main.setVisible(true);

		rp1.lapokSzama(10);

		jatekosPanel.lapotHozzaad(new Card(CardColor.RED, CardValue.SEVEN));

		jatekosPanel.lapotDob(1);
>>>>>>> fb7db68 Asztal.java: pakli, aktuális lap. JatekosPanel.java: játékos lapjai. RobotPanel.java: robot játékos.
=======
		new Main();
>>>>>>> e2b9b00 asztal tartalmazza a robotokat, a játékost, és a paklit
	}

}
