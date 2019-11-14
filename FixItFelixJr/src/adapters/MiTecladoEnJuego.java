package adapters;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import controladores.Juego;
import vistas.FrameMenu;

public class MiTecladoEnJuego extends KeyAdapter {

	private FrameMenu frame = FrameMenu.instancia();
	private Juego juego = Juego.getGame();

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			juego.moverIzquierda();
			break;
		case KeyEvent.VK_RIGHT:
			juego.moverDerecha();
			break;
		case KeyEvent.VK_DOWN:
			juego.moverAbajo();
			break;
		case KeyEvent.VK_UP:
			juego.moverArriba();
			break;
		case KeyEvent.VK_SPACE:
			
			break;
		case KeyEvent.VK_ESCAPE:

			break;
		default:
			System.out.println("Ésa tecla no la conozco");
			break;
		}
		super.keyPressed(e);
	}
}
