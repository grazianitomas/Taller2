package adapters;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import vistas.FrameMenu;

public class MiMouseOpciones extends MouseAdapter{
	
	private FrameMenu frame = FrameMenu.instancia();
	
	@Override
	public void mouseClicked(MouseEvent e) {
		frame.setCard("Opciones");
		super.mouseClicked(e);
	}
	
}
