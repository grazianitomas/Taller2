package controladores;

import individuos.Individuo;

public class Nivel {
	private Niveles nivelInicial = Niveles.NIVEL1;
	private Niveles nivelFinal = Niveles.NIVEL10;
	private Niveles nivelActual;
	private Niveles[] arregloNiveles = { Niveles.NIVEL1, Niveles.NIVEL2, Niveles.NIVEL3, Niveles.NIVEL4, Niveles.NIVEL5,
			Niveles.NIVEL6, Niveles.NIVEL7, Niveles.NIVEL8, Niveles.NIVEL9, Niveles.NIVEL10 };
	private int corredorNiveles = 0;

	/**
	 * AUMENTA LA DIFICULTAD
	 */
	public void aumentarDificultad() {

	}

	/**
	 * Devuelve el nivel actual
	 * 
	 * @return Niveles en enumerativo
	 */
	public Niveles getNivelActual() {
		return this.nivelActual;
	}

	/**
	 * Setea el nivel actual
	 * 
	 * @param N
	 */
	public void setNivelActual(Niveles N) {
		this.nivelActual = N;
	}

	/**
	 * PASA DE NIVEL
	 */
	public boolean pasarNivel() {
		if (nivelActual.equals(nivelFinal)) {
			this.ganar();
			return false;
		} else {
			for (Individuo I : Juego.getGame().getIndividuos())
				I.setVelocidad(I.getVelocidad() + 0.1);
			nivelActual = arregloNiveles[++corredorNiveles];
		}
		return true;
	}

	/**
	 * REINICIA EL NIVEL EN CASO DE QUE SE PIERDA
	 */
	public void reiniciarNiveles() {
		nivelActual = nivelInicial;
	}

	/**
	 * CONSTRUCTOR DE NIVEL
	 */
	public Nivel() {
		nivelActual = nivelInicial;
	}

	/**
	 * A IMPLEMENTAR CON EL JUEGO COMPLETO HARÍA LA SIMULACIÓN DE GANAR
	 */
	public void ganar() {

	}
}
