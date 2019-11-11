package vistas;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Edificio extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage img = null;

	public Edificio() {
		try {
			img = ImageIO.read(getClass().getClassLoader().getResourceAsStream("edificio/edificio.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void dibujar(Graphics g) {
		g.drawImage(img, 350, 250, null);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		dibujar(g);
	}

	public static void main(String[] args) {
		PanelFrame vent = new PanelFrame();

	}

}
