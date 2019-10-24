package niceland;

import entidades.Posicion;
import java.util.Random;

public class Edificio extends Posicion {
	private Seccion[] secciones;
	private Random rand;

	// RETORNA LA SECCION QUE SE PASA POR PARÁMETRO
	public Seccion getSecciones(int i) {
		return secciones[i];
	}

	// CONFIGURA LAS SECCIONES CON LA PASADA POR PARÁMETRO
	public void setSecciones(Seccion[] secciones) {
		this.secciones = secciones;
	}

	// CONSTRUCTOR DEL EDIFICIO
	public Edificio() {
		super();
		this.rand = new Random();
		double[] coefs = new double[3];
		coefs[0] = 0.02;
		coefs[1] = 0.04;
		coefs[2] = 0.08;
		System.out.println("Se crea el edificio");
		int coef = rand.nextInt(10);
		double probabilidad;
		this.secciones = new Seccion[3];
		for (int i = 0; i < 3; i++) {
			probabilidad = coef * coefs[i];
			secciones[i] = new Seccion(probabilidad + i, i);

		}
	}

}
