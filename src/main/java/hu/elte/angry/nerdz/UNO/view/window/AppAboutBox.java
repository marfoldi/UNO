package hu.elte.angry.nerdz.UNO.view.window;

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

public class AppAboutBox extends JFrame {

	private static final long serialVersionUID = 1L;

	public AppAboutBox() {

		setLayout(new GridLayout());
		JFrame about = new JFrame();

		setTitle("AboutBox");
		about.setSize(500, 600);
		about.setTitle("About");

		TextArea textArea = new TextArea(10, 30);
		textArea.setEditable(false);

		textArea.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 12));

		textArea.setBounds(9, 20, 160, 203);
		textArea.setText("Készitők:\r\n\r\nBónis Réka\r\nBárdi Zsolt\r\nGerencsér Péter\r\nOláh Róbert\r\nMárföldi Péter\r\nTörök Dániel");
		textArea.setEditable(false);

		about.getContentPane().add(textArea, BorderLayout.CENTER);
		about.setVisible(true);

	}
}
