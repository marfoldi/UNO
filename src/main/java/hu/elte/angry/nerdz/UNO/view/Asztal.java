package hu.elte.angry.nerdz.UNO.view;

import hu.elte.angry.nerdz.UNO.model.card.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Ezen a panelen van a "húzó-pakli", illetve az "eldobó-pakli", aminek a felső
 * lapja látszik.
 * 
 * @author gp
 *
 */
public class Asztal extends JPanel {
	private JButton pakli = new JButton("Új lap");// ez a "húzó-pakli", erre
													// kattintva lehet lapot
													// húzni
	JButton felsoLap;// ez az "eldobó-pakli" tetején levő lap

	public Asztal(JatekosPanel jatekosPanel, ICard lap) {
		pakli.addActionListener(new AkcioFigyelo(this, jatekosPanel));
		pakli.setPreferredSize(new Dimension(100, 150));
		// pakli.setIcon(new ImageIcon("uno.jpg"));
		add(pakli);

		felsoLap = fromCardtoJButton(lap);
		felsoLap.setEnabled(false);
		add(felsoLap);
	}

	/**
	 * Megjeleníti a "dobó-pakli" tetején a paraméterként kapott lapot.
	 * 
	 * @param lap
	 */
	public void felsoLap(ICard lap) {
		setVisible(false);
		remove(felsoLap);
		felsoLap = fromCardtoJButton(lap);
		felsoLap.setEnabled(false);
		add(felsoLap);
		setVisible(true);
	}

	/**
	 * A paraméterben kapott ICard színével és szimbólumával megegyező JButton-t
	 * ad vissza.
	 * 
	 * @param lap
	 * @return
	 */
	private JButton fromCardtoJButton(ICard lap) {
		JButton btn = new JButton(lap.getValue().toString());
		btn.setForeground(Color.DARK_GRAY);
		btn.setFont(new Font(getName(), Font.BOLD, 18));
		btn.setBackground(szin(lap));
		btn.setPreferredSize(new Dimension(100, 150));
		return btn;
	}

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

}
