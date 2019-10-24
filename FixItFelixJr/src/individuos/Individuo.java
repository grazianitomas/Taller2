package individuos;

import entidades.Posicion;

public abstract class Individuo {
	private double velocidad;

	private Posicion ubicacion;

	public Posicion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Posicion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Individuo() {
		this.ubicacion = new Posicion();
	}

	// INSTANCIA AL INDIVIDUO EN LAS POSICIONES DADAS
	public Individuo(int x, int y) {
		this.ubicacion = new Posicion(x, y);
	}

	// INSTANCIA AL INDIVIDUO EN LAS POSICIONES DADAS Y CON LA VELOCIDAD DADA
	public Individuo(int x, int y, double v) {
		this.ubicacion = new Posicion(x, y);
		velocidad = v;
	}

	// RETORNA LA VELOCIDAD ACTUAL
	public double getVelocidad() {
		return velocidad;
	}

	// CONFIGURA LA VELOCIDAD ACTUAL
	public void setVelocidad(double V) {
		velocidad = V;
	}

	public void setPosX(int x) {
		this.ubicacion.setPosX(x);
	}

	public void setPosY(int y) {
		this.ubicacion.setPosY(y);
	}

	public int getPosX() {
		return this.ubicacion.getPosX();
	}

	public int getPosY() {
		return this.ubicacion.getPosY();
	}

	// AUMENTARÍA LA VELOCIDAD AL PASAR DE NIVEL
	public void aumentarVel() {
	}

	// A REEMPLAZAR CON LAS COLISIONES CORRESPONDIENTES
	public abstract void colision();

	// A REEMPLAZAR CON LOS MOVIMIENTOS CORRESPONDIENTES

	public abstract void actualizar();
}
