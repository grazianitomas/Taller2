package individuos;

import controladores.Juego;

public class Ladrillo extends Individuo {
	
	/*
	 * CONSTRUCTOR VACIO
	 */
	public Ladrillo() {

	}

	/*
	 * CREA AL LADRILLO EN LAS POSICIONES DADAS
	 */
	public Ladrillo(int x, int y) {
		super(x, y);
		System.out.println("Cae un ladrillo desde: [" + 4 + "][" + this.getPosY() + "]");
	}

	/*
	 * CREA AL LADRILLO EN LAS POSICIONES DADAS Y CON LA VELOCIDAD DADA
	 */
	public Ladrillo(int x, int y, double V) {
		super(x, y, V);
		System.out.println("Cae un ladrillo desde: [" + 4 + "][" + this.getPosY() + "]");
	}

	/**
	 * Actualiza la posición de ladrillo
	 */
	@Override
	public void actualizar() {
		this.setPosX(this.getPosX() + 1);
	}

	/**
	 * Verifica si colisiona con Felix
	 */
	@Override
	public boolean colision() {
		if (this.getUbicacion().equals(Juego.getGame().ubicacionFelix()))
			return true;
		else
			return false;
	}
}
