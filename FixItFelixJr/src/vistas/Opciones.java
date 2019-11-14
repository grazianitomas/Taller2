package vistas;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Opciones extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private BufferedImage construccion;

	public Opciones() {
		
	}

	public void buscarImagenes() {
		try {
			construccion = ImageIO.read(getClass().getClassLoader().getResourceAsStream("under-construction-a9.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
