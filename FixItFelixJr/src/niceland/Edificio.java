package niceland;

import java.util.Random;

import controladores.Juego;

public class Edificio {
	private static Seccion secciones;
	private Random rand;
	private static double probabilidadSeccion = 0.0;

	/**
	 * RETORNA LA SECCION QUE SE PASA POR PARÁMETRO
	 * 
	 * @param i
	 * @return
	 */
	public Seccion getSecciones() {
		return secciones;
	}

	public void pasarDeSeccion() {
		secciones = new Seccion(this.calculoProbabilidad() + Juego.getGame().getSeccion());
	}

	/**
	 * CONFIGURA LAS SECCIONES CON LA PASADA POR PARÁMETRO
	 * 
	 * @param secciones
	 */
	public void setSecciones(Seccion seccion) {
		secciones = seccion;
	}

	/**
	 * CONSTRUCTOR DEL EDIFICIO
	 */
	public Edificio() {
		System.out.println("Se crea el edificio");
		secciones = new Seccion(this.calculoProbabilidad() + Juego.getGame().getSeccion());
	}
	
	/**
	 * calcula la probabilidad de ventanas rotas, semirotas y sanas
	 * @return retorna la probabildiad
	 */
	
	private double calculoProbabilidad() {
		this.rand = new Random();
		probabilidadSeccion += 0.02;
		int coef = rand.nextInt(10);
		double probabilidad;
		probabilidad = coef * probabilidadSeccion;
		return probabilidad;
	}

}
