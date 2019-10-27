package individuos;

import controladores.Juego;

public class Pajaro extends Individuo {

	private boolean direcIzquierda;

	/*
	 * CONSTRUCTOR VACIO
	 */
	public Pajaro() {

	}

	/**
	 * CREA A UN PAJARO EN LAS POSICIONES DADAS
	 * 
	 * @param y
	 * @param v
	 */
	public Pajaro(int y, double v, boolean izq) {
		this.setPosY(y);
		this.setVelocidad(v);
		this.direcIzquierda = izq;
		System.out.println("Aparece un pájaro en la posición: [" + this.getPosY() + "]");
	}

	/*
	 * CREA A UN PAJARO EN LA POSICION DADA
	 */
	public Pajaro(int y, boolean izq) {
		this.setPosY(y);
		this.direcIzquierda = izq;
		System.out.println("Aparece un pájaro en la posición: [" + this.getPosY() + "]");
	}

	/*
	 * Actualiza el estado del pájaro dependiendo si va hacia la derecha o la
	 * izquierda
	 * 
	 */
	@Override
	public void actualizar() {
		if (this.direcIzquierda) {
			this.moverIzq();
		} else
			this.moverDer();
	}

	/*
	 * CUANDO EL PAJARO APARECE POR DERECHA
	 */
	public void moverIzq() {
		this.setPosX(this.getPosX() - 1);
	}

	/*
	 * CUANDO EL PAJARO APARECE POR IZQUIERDA
	 */
	public void moverDer() {
		this.setPosX(this.getPosX() + 1);
	}

	/*
	 * SIMULARÍA LA COLISIÓN ENTRE PÁJARO Y FELIX
	 */
	@Override
	public boolean colision() {
		if(this.getUbicacion().equals(Juego.getGame().ubicacionFelix()))
			return true;
		else 
			return false;
	}

}
