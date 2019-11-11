package vistas;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Terreno extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BufferedImage pasto;

	public Terreno() {
		try {
			pasto = ImageIO.read(getClass().getClassLoader().getResourceAsStream("pasto.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
