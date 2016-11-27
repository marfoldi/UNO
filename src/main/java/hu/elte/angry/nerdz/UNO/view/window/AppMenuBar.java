/**
 * 
 */
package hu.elte.angry.nerdz.UNO.view.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * @author marfoldi
 *
 */
public class AppMenuBar extends JMenuBar {
	private static final long serialVersionUID = -7052692850790442312L;
	private JMenu fileMenu = new JMenu("File");
	private JMenu helpMenu = new JMenu("Help");
	
	private JMenuItem newMenuItem = new JMenuItem("New Game");
	private JMenuItem exitMenuItem = new JMenuItem("Exit");
	private JMenuItem helpMenuItem = new JMenuItem("Help");
	private JMenuItem infoMenuItem = new JMenuItem("Info");
	
	public AppMenuBar() {
		this.add(fileMenu);
		this.add(helpMenu);

		helpMenu.add(helpMenuItem);
		helpMenu.add(infoMenuItem);
		fileMenu.add(newMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(infoMenuItem);
		
		setupMenuActions();
	}
	
	private void setupMenuActions() {
		helpMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AppHelpBox();
			}
		});
		infoMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AppAboutBox();
			}
		});
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int exit = JOptionPane.showConfirmDialog(AppMenuBar.this, "Are you sure exit ?");
				if (exit == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		newMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

}
