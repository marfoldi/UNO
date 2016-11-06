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
	private JLabel nev;
	private JLabel lapokSzama;

	private ImageIcon kep;

	public RobotPanel(String nev, int lapokSzama) {
		this.nev = new JLabel(nev);
		this.lapokSzama = new JLabel(Integer.toString(lapokSzama) + " lap");
		kep = new ImageIcon("src/main/resources/robot2.jpg");
		add(this.nev);
		add(this.lapokSzama);
		add(new JButton(kep));
	}

	public void lapokSzama(int lapokSzama) {
		this.lapokSzama.setText(Integer.toString(lapokSzama) + " lap");
	}
}
