package hu.elte.angry.nerdz.UNO.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Robot neve, lapjainak száma.
 * 
 * @author gp
 *
 */
public class RobotPanel extends JPanel {
	private JLabel name;
	private JLabel cardCount;

	private ImageIcon kep;

	public RobotPanel(String name, int cardCount) {
		this.name = new JLabel(name);
		this.cardCount = new JLabel(Integer.toString(cardCount) + " lap");
		kep = new ImageIcon("src/main/resources/robot2.jpg");
		add(this.name);
		add(this.cardCount);
		add(new JButton(kep));
	}
}
