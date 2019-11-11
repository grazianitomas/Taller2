package niceland;

import java.util.Random;

import controladores.Juego;

public class Edificio {
	private Seccion secciones;
	private Random rand;
	private static double probabilidadSeccion = 0.0;

	/**
	 * RETORNA LA SECCION QUE SE PASA POR PARÁMETRO
	 * 
	 * @param i
	 * @return
	 */
	public Seccion getSecciones() {
		return this.secciones;
	}

	/**
	 * Simula el pasaje de sección
	 */
	public void pasarDeSeccion(EstadoSeccion ES) {
		this.secciones = new Seccion(ES, this.calculoProbabilidad() + Juego.getGame().getSeccion());
	}

	/**
	 * CONFIGURA LAS SECCIONES CON LA PASADA POR PARÁMETRO
	 * 
	 * @param secciones
	 */
	public void setSecciones(Seccion seccion) {
		this.secciones = seccion;
	}

	/**
	 * CONSTRUCTOR DEL EDIFICIO
	 */
	public Edificio() {
		System.out.println("Se crea el edificio");
		this.secciones = new Seccion(EstadoSeccion.SECCION_INFERIOR, this.calculoProbabilidad());
	}

	/**
	 * calcula la probabilidad de ventanas rotas, semirotas y sanas
	 * 
	 * @return retorna la probabildiad
	 */

	private double calculoProbabilidad() {
		this.rand = new Random();
		probabilidadSeccion += 0.02;
		int coef = rand.nextInt(10);
		return (coef * probabilidadSeccion);
	}

	public void nuevaSeccion(EstadoSeccion ES) {
		this.rand = new Random();
		int coef = rand.nextInt(10);
		double probabilidad;
		probabilidad = coef * probabilidadSeccion;
		this.secciones = new Seccion(ES, probabilidad);
	}

}
