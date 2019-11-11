package entidades;

import entidades.Torta;
import individuos.Individuo;

public class NiceLander extends Individuo {
	private boolean listo;
	private boolean torta;

	/**
	 * @return retorna s hay torta
	 */
	public boolean isTorta() {
		return torta;
	}

	/**
	 * @param Torta a asignar
	 */
	public void setTorta(boolean torta) {
		this.torta = torta;
	}

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
	public boolean colision(Posicion p) {
		if (super.colision(p)) {
			this.setListo(false);
			return true;
		} else
			return false;
	}

	/**
	 * Actualiza el estado del Nicelander
	 */
	@Override
	public void actualizar() {

	}

}
