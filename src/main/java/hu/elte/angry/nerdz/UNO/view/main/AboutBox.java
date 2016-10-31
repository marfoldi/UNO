package hu.elte.angry.nerdz.UNO.view.main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import javax.swing.*;

public class AboutBox extends JFrame {

	private static final long serialVersionUID = 1L;

	public AboutBox ()
	{

	setLayout (new GridLayout());
    JFrame about= new JFrame();

    setTitle("AboutBox");
    about.setSize(400,400); 
    about.setTitle("About");
    about.setVisible(true);


TextArea textArea = new TextArea();
textArea.setText("Készitők:\r\n\r\nBónis Réka\r\nBárdi Zsolt\r\nGerencsér Péter\r\nOláh Róbert\r\nMérföldi Péter\r\nTörök Dániel");
textArea.setEditable(false);
about.getContentPane().add(textArea, BorderLayout.CENTER);
about.setVisible(true);
about.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    }
}

	
	


	


