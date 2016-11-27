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
	private static final long serialVersionUID = -4263179279756886584L;
	private JLabel name;
	private JLabel cardCount;
	private ImageIcon sprite;

	public RobotPanel(String name, int cardCount) {
		this.name = new JLabel(name);
		this.cardCount = new JLabel(Integer.toString(cardCount) + " cards");
		sprite = new ImageIcon("src/main/resources/robot2.jpg");
		add(this.name);
		add(this.cardCount);
		JButton wrapperButton = new JButton(sprite);
		wrapperButton.setEnabled(false);
		wrapperButton.setDisabledIcon(sprite);
		add(wrapperButton);
	}
}