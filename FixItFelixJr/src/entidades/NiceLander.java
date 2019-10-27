package entidades;

import controladores.Juego;
import entidades.Torta;
import individuos.Individuo;

public class NiceLander extends Individuo {
	private boolean listo;

	/**
	 * Constructor de Nicelander
	 */
	public NiceLander() {
		this.listo = true;
	}

	/**
	 * Retorna si está listo para dar paste
	 * 
	 * @return
	 */
	public boolean getListo() {
		return this.listo;
	}

	/**
	 * Instancia de que está listo para dar pastel
	 * 
	 * @param estado
	 */
	public void setListo(boolean estado) {
		this.listo = estado;
	}

	/**
	 * Instancia una torta
	 * 
	 * @return
	 */
	public Torta darPastel() {
		return new Torta();
	}

	/**
	 * Verifica si colisiona con Felix, en caso de hacerlo no deja el pastel
	 */
	@Override
	public boolean colision() {
		if (this.getUbicacion().equals(Juego.getGame().ubicacionFelix())) {
			this.setListo(false);
			return true;
		} else {
			this.setListo(true);
			return false;
		}
	}

	/**
	 * Actualiza el estado del Nicelander
	 */
	@Override
	public void actualizar() {
		// TODO Auto-generated method stub

	}

}
