package hu.elte.angry.nerdz.UNO.view.main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import javax.swing.*;
import java.awt.Font;

/**
 * 
 * @author Robert
 *
 */
public class AboutBox extends JFrame {

	private static final long serialVersionUID = 1L;

	public AboutBox() {

		setLayout(new GridLayout());
		JFrame about = new JFrame();
		// JPanel
		JPanel pnlButton = new JPanel();
		// Buttons

		setTitle("AboutBox");
		about.setSize(500, 600);
		about.setTitle("About");
		JButton Okbutton = new JButton("OK");

		// Adding to JFrame
		pnlButton.add(Okbutton);
		add(pnlButton);

		JPanel p2 = new JPanel();
		JButton ok = new JButton("Ok");
		p2.add(ok);
		getContentPane().add(p2, "South");

		TextArea textArea = new TextArea(10, 30);
		textArea.setEditable(false);

		/* textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12)); */

		textArea.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 12));

		textArea.setBounds(9, 20, 160, 203);
		textArea.setText(
				"Készitők:\r\n\r\nBónis Réka\r\nBárdi Zsolt\r\nGerencsér Péter\r\nOláh Róbert\r\nMérföldi Péter\r\nTörök Dániel");
		textArea.setEditable(false);

		about.getContentPane().add(textArea, BorderLayout.CENTER);
		about.setVisible(true);

		/* about.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE); */

	}
}
