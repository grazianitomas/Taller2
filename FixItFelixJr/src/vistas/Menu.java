package vistas;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel panel;
	private BufferedImage pasto;
	private BufferedImage edificio;
	private BufferedImage ladrillo;
	private BufferedImage menu;
	private BufferedImage opciones;
	private JLabel jugar;
	private JLabel top5;
	private CopyOnWriteArrayList<BufferedImage> imagenes = new CopyOnWriteArrayList<BufferedImage>();

	public static void main(String[] args) {
		MenuFrame gf = new MenuFrame();
	}

	public Menu() {

		this.buscarImagenes();
		

	}

	private void buscarImagenes() {
		try {
			pasto = ImageIO.read(getClass().getClassLoader().getResourceAsStream("pasto.png"));
			if (pasto != null)
				imagenes.add(pasto);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			edificio = ImageIO.read(getClass().getClassLoader().getResourceAsStream("edificio/edificio.png"));
			if (edificio != null)
				imagenes.add(edificio);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			opciones = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tuercas-png-4.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ladrillo = ImageIO.read(getClass().getClassLoader().getResourceAsStream("ladrillootromenu.png"));
			if (ladrillo != null)
				imagenes.add(ladrillo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			menu = ImageIO.read(getClass().getClassLoader().getResourceAsStream("fixitfelix2.png"));
			if (menu != null)
				imagenes.add(menu);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void dibujar(Graphics g) {
		super.paintComponent(g);
		// g.drawImage(edificio, 100, 0, null);
		g.drawImage(menu, 0, 0, null);
		// graficarPastos(g);
		g.drawImage(opciones, 435, 3, null);
		g.drawImage(ladrillo, 20, 650, null);
	}

	private void graficarPastos(Graphics g) {
		for (int i = 0; i < 20; i++)
			g.drawImage(pasto, i * 24, 695, null);
	}

	@Override
	public void paintComponent(Graphics g) {
		dibujar(g);
	}

}
