package vistas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import adapters.MiMouseJugar;
import adapters.MiMouseTop;;

public class Menu extends JPanel {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private JLabel jugar = new JLabel("¡JUGAR!");
	private JLabel top5 = new JLabel("¡TOP 5!");
	private JComboBox<String> selecNivel = new JComboBox<String>();
	private BufferedImage ladrillo;
	private BufferedImage ladrillo2;
	private BufferedImage menu;
	private BufferedImage opciones;
	private String nivel;
	private CopyOnWriteArrayList<BufferedImage> imagenes = new CopyOnWriteArrayList<BufferedImage>();

	public Menu() {
		setSize(480, 740);
		setLayout(null);
		this.buscarImagenes();
		jugar.setBounds(35, 650, 80, 40);
		jugar.addMouseListener(new MiMouseJugar());
		top5.setBounds(395, 650, 80, 40);
		top5.addMouseListener(new MiMouseTop());
		selecNivel.setBounds(405, 5, 75, 30);
		for (int i = 0; i < 10; i++)
			selecNivel.addItem("Nivel " + (i + 1));
		selecNivel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nivel = selecNivel.getSelectedItem().toString();
				super.mouseClicked(e);
			}
		});

		selecNivel.setForeground(Color.RED);
		selecNivel.setBackground(Color.getColor("TRANSLUCENT"));

		jugar.setForeground(Color.WHITE);
		top5.setForeground(Color.WHITE);

		add(jugar);
		add(top5);
		add(selecNivel);
		setVisible(true);
	}

	private void buscarImagenes() {
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
		try {
			ladrillo2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("ladrillootromenu.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void dibujar(Graphics g) {
		super.paintComponent(g);
		g.drawImage(menu, 0, 0, null);
		g.drawImage(opciones, 435, 3, null);
		g.drawImage(ladrillo, 20, 650, null);
		g.drawImage(ladrillo2, 380, 650, null);
	}

	@Override
	public void paintComponent(Graphics g) {
		dibujar(g);
	}

	/**
	 * @return the jugar
	 */
	public JLabel getJugar() {
		return jugar;
	}

	/**
	 * @param jugar the jugar to set
	 */
	public void setJugar(JLabel jugar) {
		this.jugar = jugar;
	}

	/**
	 * @return the top5
	 */
	public JLabel getTop5() {
		return top5;
	}

	/**
	 * @param top5 the top5 to set
	 */
	public void setTop5(JLabel top5) {
		this.top5 = top5;
	}

}
