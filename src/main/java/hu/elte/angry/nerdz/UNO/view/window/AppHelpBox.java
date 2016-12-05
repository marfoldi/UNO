package hu.elte.angry.nerdz.UNO.view.window;

import java.awt.BorderLayout;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import hu.elte.angry.nerdz.UNO.model.help.HelpReader;


public class AppHelpBox extends JFrame {
	private static final long serialVersionUID = 6053886643319617200L;

	public AppHelpBox() {
		JTextArea message = new JTextArea();
		message.setWrapStyleWord(true);
		message.setLineWrap(true);
		message.setEditable(false);
		message.setFocusable(false);
		message.setOpaque(false);

		try {
			message.setText(new HelpReader().getHelpContent());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// create a scrollpane, givin it the textarea as a constructor argument
		JScrollPane ScrollPane = new JScrollPane(message, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// now add the scrollpane to the jframe's content pane, specifically
		// placing it in the center of the jframe's borderlayout
		JFrame frame = new JFrame("UNO Help");
		/* frame.setBounds(200, 800,805, 932); */

		/* frame.setPreferredSize(new Dimension(900, 800)); */
		/* frame.setResizable(true); */

		frame.getContentPane().add(ScrollPane, BorderLayout.CENTER);

		frame.setSize(500, 500);

		ScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		ScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		// set the frame size (you'll usually want to call frame.pack())
		/* frame.setSize(new Dimension(240, 180)); */

		// center the frame
		frame.setLocationRelativeTo(null);

		// make it visible to the user
		frame.setVisible(true);
	}

}
