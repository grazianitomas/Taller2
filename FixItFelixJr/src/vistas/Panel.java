package vistas;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage img = null;

	public Panel() {
		try {
			img = ImageIO.read(getClass().getClassLoader().getResourceAsStream("ventanas_y_panel/slice02_02.png"));
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
