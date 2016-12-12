package hu.elte.angry.nerdz.UNO.view;

import java.text.ParseException;

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
public class RobotPanel extends JPanel{
	private static final long serialVersionUID = -4263179279756886584L;
	private JLabel robotName;
	private JLabel cardCount;
	private ImageIcon sprite;

	public RobotPanel(String name) {
		this.robotName = new JLabel(name);
		this.cardCount = new JLabel("0 cards");
		sprite = new ImageIcon("src/main/resources/robot2.jpg");
		add(this.robotName);
		add(this.cardCount);
		JButton wrapperButton = new JButton(sprite);
		wrapperButton.setEnabled(false);
		wrapperButton.setDisabledIcon(sprite);
		add(wrapperButton);
	}
	
	public int getCardCount() throws ParseException{
		final String ccAsSTring = cardCount.getText();
		return Integer.parseInt(ccAsSTring.substring(ccAsSTring.length()-7, ccAsSTring.length()-1));
	}

	public void setCardCount(int cardCount) {
		this.cardCount.setText(cardCount+" cards");;
	}
}
