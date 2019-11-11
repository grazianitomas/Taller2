package vistas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jugar;
	private JLabel top5;

	public MenuFrame() {
		setSize(480, 740);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setContentPane(new Menu());
		jugar = new JLabel();
		jugar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ladrillootromenu.png")));
		jugar.setLocation(100, 100);
		jugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Click");
				super.mouseClicked(e);
			}
		});
		setVisible(true);
		getContentPane().add(jugar);
	}

}
