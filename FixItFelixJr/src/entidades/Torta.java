package entidades;

import controladores.Juego;
import individuos.Individuo;

public class Torta extends Individuo {
	private boolean torta;

	/*
	 * Constructor de Torta
	 */
	public Torta() {
		this.torta = true;
	}

	/*
	 * Retorna si hay torta
	 */
	public boolean getTorta() {
		return this.torta;
	}

	/*
	 * Configura si hay torta
	 */
	public void setTorta(boolean torta) {
		this.torta = torta;
	}

	/*
	 * Verifica si colisiona con Felix
	 */
	@Override
	public boolean colision() {
		if (this.getUbicacion().equals(Juego.getGame().ubicacionFelix()))
			return true;
		else
			return false;
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
	}

}
