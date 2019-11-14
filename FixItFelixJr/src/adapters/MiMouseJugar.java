package adapters;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controladores.Juego;
import vistas.FrameMenu;

public class MiMouseJugar extends MouseAdapter {

	private FrameMenu frame = FrameMenu.instancia();
	private Juego game = Juego.getGame();
	
	
	public MiMouseJugar() {
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			frame.setCard("Juego");
			
		} catch (Exception d) {
			d.printStackTrace();
		}
		super.mouseClicked(e);
	}

}
