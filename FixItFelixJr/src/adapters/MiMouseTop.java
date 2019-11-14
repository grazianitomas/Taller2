package adapters;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import vistas.FrameMenu;

public class MiMouseTop extends MouseAdapter {

	private FrameMenu frame = FrameMenu.instancia();

	@Override
	public void mouseClicked(MouseEvent e) {
		try {
		} catch (Exception d) {
			frame.setCard("Top5");
			d.printStackTrace();
		}
		super.mouseClicked(e);
	}

}
