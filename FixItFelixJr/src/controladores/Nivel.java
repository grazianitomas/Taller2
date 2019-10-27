package controladores;

public class Nivel {
	private Niveles nivelInicial = Niveles.NIVEL1;
	private Niveles nivelFinal = Niveles.NIVEL5;
	private Niveles nivelActual;
	private Niveles[] arregloNiveles = { Niveles.NIVEL1, Niveles.NIVEL2, Niveles.NIVEL3, Niveles.NIVEL4,
			Niveles.NIVEL5 };
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
	public void pasarNivel() {
		if (nivelActual.equals(nivelFinal) && Juego.getGame().getSeccion() == 2) {
			this.ganar();
		} else {
			nivelActual = arregloNiveles[++corredorNiveles];
			
		}
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
