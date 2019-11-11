package entidades;

import individuos.DireccionFelix;

public class Posicion {
	private int posX;
	private int posY;

	/**
	 * Constructor vacio de posicion
	 */
	public Posicion() {

	}
	
	/**
	 * Constructor de Posicion
	 * @param X
	 * @param Y
	 */
	public Posicion(int X, int Y) {
		posX = X;
		posY = Y;
	}

	/**
	 *  DEVUELVE LA POSICION EN X DEL OBJETO
	 * @return
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 *  SETEA LA POSICION EN X DEL OBJETO
	 * @param posX
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 *  DEVUELVE LA POSICION EN Y DEL OBJETO
	 * @return
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * SETEA LA POSICION EN X DEL OBJETO
	 * @param posY
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * Retorna si es válida la posición actual 
	 * @return
	 */
	public boolean esValida() {
		if (this.getPosX() < 5 || this.getPosX() > 0) {
			if (this.getPosY() < 4 || this.getPosY() > 0) {
				return true;
			}
			return false;
		} else
			return false;
	}
	
	/**
	 * Retorna la siguiente posición a la que se movería Felix
	 * @param direc
	 * @return
	 */
	public Posicion getNextPos(DireccionFelix direc) {
		Posicion pos = new Posicion();
		switch (direc) {
		case ARRIBA: {
			pos = new Posicion(this.getPosX(), this.getPosY() + 1);
		}
		case ABAJO: {
			pos = new Posicion(this.getPosX(), this.getPosY() - 1);
		}
		case DERECHA: {
			pos = new Posicion(this.getPosX() + 1, this.getPosY());
		}
		case IZQUIERDA: {
			pos = new Posicion(this.getPosX() - 1, this.getPosY());
		}
		case QUIETO: {
			pos = new Posicion(this.getPosX(), this.getPosY());
		}
		}
		return pos;
	}

}
