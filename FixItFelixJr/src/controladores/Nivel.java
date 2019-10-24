package controladores;

public class Nivel {
	private Niveles nivelInicial = Niveles.NIVEL1;
	private Niveles nivelFinal = Niveles.NIVEL3;
	private Niveles nivelActual;
	private Niveles[] arregloNiveles;
	private int corredorNiveles = 0;
	
	
	//AUMENTA LA DIFICULTAD CUANDO SE IMPLEMENTE LA TOTALIDAD DEL JUEGO
	public void aumentarDificultad() {

	}
	
	
	//PASA DE NIVEL
	public void pasarNivel() {
		if (nivelActual.equals(nivelFinal)) {
			this.ganar();
		} else
			nivelActual = arregloNiveles[++corredorNiveles];
	}
	
	//REINICIA EL NIVEL EN CASO DE QUE SE PIERDA
	public void reiniciarNiveles() {
		nivelActual = nivelInicial;
	}
	
	//CONSTRUCTOR DE NIVEL
	public Nivel() {
		nivelActual = nivelInicial;
		
	}
	
	//A IMPLEMENTAR CON EL JUEGO COMPLETO
	//HARÍA LA SIMULACIÓN DE GANAR
	public void ganar() {

	}
}
