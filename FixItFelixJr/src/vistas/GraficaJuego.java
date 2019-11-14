package vistas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.concurrent.CopyOnWriteArrayList;
import java.io.*;
import javax.imageio.ImageIO;

import javax.swing.JLabel;

public class GraficaJuego extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FrameMenu frame = FrameMenu.instancia();

	private BufferedImage felix;
	private BufferedImage ladrillo;
	private BufferedImage pajaro;
	private BufferedImage ralph;
	private BufferedImage ventana;
	private BufferedImage panelSano;
	private BufferedImage panelRoto;
	private BufferedImage panelSemiRoto;
	private BufferedImage puerta;
	private BufferedImage semiCircular;
	private BufferedImage torta;
	private BufferedImage nube;
	private BufferedImage seccion1;
	private BufferedImage seccion2;
	private BufferedImage seccion3;
	private BufferedImage edificio;
	private CopyOnWriteArrayList<BufferedImage> movimientoRalph = new CopyOnWriteArrayList<BufferedImage>();

	public GraficaJuego() {
		setSize(480, 740);
		setBackground(Color.BLACK);
		setVisible(true);
	}

	private void buscarImagenes() {
		try {
			felix = ImageIO.read(getClass().getClassLoader().getResourceAsStream("felix/slice135_@.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ladrillo = ImageIO.read(getClass().getClassLoader().getResourceAsStream("rocas/slice10_10.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			pajaro = ImageIO.read(getClass().getClassLoader().getResourceAsStream("pajaro/slice09_09.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ralph = ImageIO.read(getClass().getClassLoader().getResourceAsStream("ralph/slice163_@.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ventana = ImageIO.read(getClass().getClassLoader().getResourceAsStream("ventanas_y_panel/slice102_@.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			panelSano = ImageIO
					.read(getClass().getClassLoader().getResourceAsStream("ventanas_y_panel/slice02_02.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			panelSemiRoto = ImageIO
					.read(getClass().getClassLoader().getResourceAsStream("ventanas_y_panel/slice04_04.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			puerta = ImageIO.read(getClass().getClassLoader().getResourceAsStream("semicirculares/slice42_42.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			semiCircular = ImageIO
					.read(getClass().getClassLoader().getResourceAsStream("semicirculares/slice605_@.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			torta = ImageIO.read(getClass().getClassLoader().getResourceAsStream("pastel/slice12_12.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			seccion1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("edificio/seccion1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			seccion2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("edificio/seccion2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			seccion3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("edificio/seccion3.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			edificio = ImageIO.read(getClass().getClassLoader().getResourceAsStream("edificio/edificio.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paintComponent(Graphics g) {

		dibujar(g);
	}

	private void dibujar(Graphics g) {
		super.paintComponent(g);
	}
}
