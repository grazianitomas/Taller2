package niceland;

import java.util.Random;
import ventanas.*;

public class Seccion {
	private static EstadoSeccion seccionActual;
	private Ventana[][] ventanas;
	Random rand = new Random();

	/**
	 * CONFIGURA LA VENTANA EN LAS POSICIONES DADAS CON EL TIPO DE VENTANA PASADA
	 * 
	 * @param x    posicion en x
	 * @param y    posicion en y
	 * @param vent tipo de ventana a colocar
	 */
	public void setVentana(int x, int y, Ventana vent) {
		this.ventanas[x][y] = vent;
	}

	/**
	 * CONSTRUYE LAS SECCION CORRESPONDIENTE CON EL PARÁMETRO "K" CON LA
	 * CORRESPONDIENTE PROBABILIDAD DE PANELES ROTOS, PASADOS CON "PROBA"
	 * 
	 * @param proba
	 * @param k
	 */
	public Seccion(double proba) {
		this.ventanas = new Ventana[3][5];
		if (seccionActual.equals(null)) {
			for (int i = 0; i < 3; i++)
				for (int j = 0; j < 5; j++) {
					if (j == 2) {
						if (i == 0)
							this.setVentana(i, j, new Comun(proba));
						if (i == 1)
							this.setVentana(i, j, new Semicircular(proba));
						if (i == 2)
							this.setVentana(i, j, new Puerta(proba));
					} else
						this.setVentana(i, j, new Comun(proba));
				}
			this.setSeccionActual(EstadoSeccion.SECCION_INFERIOR);
			return;
		} else if (seccionActual.equals(EstadoSeccion.SECCION_INFERIOR)) {
			for (int i = 0; i < 3; i++)
				for (int j = 0; j < 5; j++) {
					if (rand.nextBoolean())
						this.setVentana(i, j, new Comun(proba));
					else
						this.setVentana(i, j, new DosHojas(proba));
				}
			this.pasarSeccion();
			return;
		} else {
			for (int i = 0; i < 3; i++)
				for (int j = 0; j < 5; j++) {
					if (rand.nextBoolean())
						this.setVentana(i, j, new Comun(proba));
					else
						this.setVentana(i, j, new DosHojas(proba));
				}
		}
	}

	/**
	 * RETORNA LA SECCION ACTUAL EN TIPO ENUMERATIVO
	 * 
	 * @return
	 */
	public static EstadoSeccion getSeccionActual() {
		return seccionActual;
	}

	public int getSeccionNum() {
		return getSeccionActual().getSeccion(seccionActual);
	}

	/**
	 * CONFIGURA LA SECCION ACTUAL CON LA PASADA POR PARÁMETRO
	 * 
	 * @param actual
	 */
	public void setSeccionActual(EstadoSeccion actual) {
		seccionActual = actual;
	}

	/**
	 * MODULA EL PASAJE DE SECCION
	 */
	public void pasarSeccion() {
		if (seccionActual.equals(EstadoSeccion.SECCION_INFERIOR))
			seccionActual = EstadoSeccion.SECCION_MEDIA;
		else
			seccionActual = EstadoSeccion.SECCION_SUPERIOR;
	}

	/**
	 * RETORNA LA VENTANA EN LAS POSICIONES DADAS
	 * 
	 * @param x posicion en x a buscar
	 * @param y posicion en y a buscar
	 * @return Retorna la matriz en la posicion pasada por parametro
	 */
	public Ventana getVentana(int x, int y) {
		return ventanas[x][y];
	}

	/**
	 * RETORNA LA MATRIZ COMPLETA DE VENTANAS
	 * 
	 * @return
	 */
	public Ventana[][] getMatrizVentanas() {
		return ventanas;
	}

}
