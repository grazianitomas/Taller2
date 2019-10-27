package individuos;

import entidades.Posicion;

public abstract class Individuo {
	/**
	 * Corresponde a la velocidad del objetivo
	 */
	private double velocidad;
	
	private Posicion ubicacion;
	
	/**
	 * Retorna la ubicación del individuo
	 * @return
	 */
	public Posicion getUbicacion() {
		return ubicacion;
	}
	/**
	 * Setea la ubicación del individuo
	 * @param ubicacion
	 */
	public void setUbicacion(Posicion ubicacion) {
		this.ubicacion = ubicacion;
	}
	/**
	 * Constructor de individuo
	 */
	public Individuo() {
		this.ubicacion = new Posicion();
	}

	/*
	 * Constructor con posiciones
	 */
	public Individuo(int x, int y) {
		this.ubicacion = new Posicion(x, y);
	}

	/*
	 * Constructor con posiciones y velocidad
	 */
	public Individuo(int x, int y, double v) {
		this.ubicacion = new Posicion(x, y);
		velocidad = v;
	}

	/**
	 * Retorna la velocidad actual
	 * @return
	 */
	public double getVelocidad() {
		return velocidad;
	}

	/*
	 * Setea la velocidad del inviduo
	 */
	public void setVelocidad(double V) {
		velocidad = V;
	}
	
	/**
	 * Setea la posición en [X] del individuo
	 * @param x
	 */
	public void setPosX(int x) {
		this.ubicacion.setPosX(x);
	}
	
	/**
	 * Setea la posición en [Y] del individuo
	 * @param y
	 */
	public void setPosY(int y) {
		this.ubicacion.setPosY(y);
	}
	
	/**
	 * Retorna la posición en [x] de individuo
	 * @return
	 */
	public int getPosX() {
		return this.ubicacion.getPosX();
	}
	
	/**
	 * Retorna la posición en [y] de individuo
	 * @return
	 */
	public int getPosY() {
		return this.ubicacion.getPosY();
	}

	/**
	 *	Verifica si hay colisión entre Felix y el individuo 
	 * @return
	 */
	public abstract boolean colision();

	/**
	 * Actualiza el estado del individuo
	 */
	public abstract void actualizar();
}
