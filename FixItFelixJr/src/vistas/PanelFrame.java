package vistas;

import javax.swing.JFrame;

public class PanelFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelFrame() {
		setSize(680, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setContentPane(new Panel());
		setVisible(true);
	}
	
}
