package hu.elte.angry.nerdz.UNO.view;

import hu.elte.angry.nerdz.UNO.model.card.*;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Main extends JFrame {
	private static JatekosPanel jatekosPanel;// ezen vannak a játékos lapjai
	private static Asztal asztal;// ezen látszik a "húzó-pakli", és az
									// "eldobó-pakli" tetején levő lap
	private static RobotPanel rp1, rp2;// két robot

	public Main(String string) {
		super(string);
		setSize(800, 600);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
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
	}

}
