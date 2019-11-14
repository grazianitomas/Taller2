package vistas;

import java.awt.CardLayout;

import javax.swing.JFrame;

public class FrameMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CardLayout card = new CardLayout();
	private Menu menu = new Menu();
	private Top5 top5 = new Top5();
	private GraficaJuego juego = new GraficaJuego();
	private static FrameMenu getInstance = new FrameMenu();

	public static FrameMenu instancia() {
		return getInstance;
	}

	public FrameMenu() {
		setSize(480, 740);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		card.addLayoutComponent(menu, "Menu");
		card.addLayoutComponent(top5, "Top5");
		card.addLayoutComponent(juego, "Juego");
		setLayout(card);
		setContentPane(menu);
		setResizable(false);
		setVisible(true);
	}

	public CardLayout getCard() {
		return this.card;
	}

	public void setCard(String name) {
		card.show(getContentPane(), name);
	}

	public static void main(String[] args) {

	}

}
