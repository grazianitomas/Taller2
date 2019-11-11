package individuos;

import entidades.Posicion;

public abstract class Individuo {
	
	/**
	 * Corresponde a la velocidad del objetivo
	 */
	private double velocidad;

	private Posicion posicion;

	/**
	 * Retorna la ubicación del individuo
	 * 
	 * @return
	 */
	public Posicion getPosicion() {
		return posicion;
	}

	/**
	 * Setea la ubicación del individuo
	 * 
	 * @param posicion
	 */
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	/**
	 * Constructor de individuo
	 */
	public Individuo() {
		this.posicion = new Posicion();
	}

	/*
	 * Constructor con posiciones
	 */
	public Individuo(int x, int y) {
		this.posicion = new Posicion(x, y);
	}

	/*
	 * Constructor con posiciones y velocidad
	 */
	public Individuo(int x, int y, double v) {
		this.posicion = new Posicion(x, y);
		velocidad = v;
	}

	/**
	 * Retorna la velocidad actual
	 * 
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
	 * 
	 * @param x
	 */
	public void setPosX(int x) {
		this.posicion.setPosX(x);
	}

	/**
	 * Setea la posición en [Y] del individuo
	 * 
	 * @param y
	 */
	public void setPosY(int y) {
		this.posicion.setPosY(y);
	}

	/**
	 * Retorna la posición en [x] de individuo
	 * 
	 * @return
	 */
	public int getPosX() {
		return this.posicion.getPosX();
	}

	/**
	 * Retorna la posición en [y] de individuo
	 * 
	 * @return
	 */
	public int getPosY() {
		return this.posicion.getPosY();
	}

	/**
	 * Verifica si hay colisión entre Felix y el individuo
	 * 
	 * @return
	 */
	public boolean colision(Posicion p) {
		if (this.getPosicion().equals(p))
			return true;
		else
			return false;
	}

	/**
	 * Actualiza el estado del individuo
	 */
	public abstract void actualizar();
}
