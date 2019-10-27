package controladores;

import java.util.ArrayList;

import entidades.Posicion;
import entidades.Torta;
import individuos.DireccionFelix;
import individuos.FelixJr;
import individuos.Individuo;
import individuos.Ladrillo;
import individuos.Pajaro;
import individuos.Ralph;
import niceland.Edificio;
import ventanas.Ventana;

public class Juego {

	private FelixJr felix;
	private Edificio niceland;
	private Nivel nivel;
	private int seccionActual;
	private static Juego game = new Juego();
	private ArrayList<Ladrillo> ladrillos = new ArrayList<Ladrillo>();
	private ArrayList<Individuo> individuos = new ArrayList<Individuo>();
	private ArrayList<Pajaro> pajaros = new ArrayList<Pajaro>();

	public static Juego getGame() {
		return game;
	}

	/**
	 * AGREGA UN LADRILLO A LA ARRAYLIST
	 * 
	 * @param L
	 */
	public void agregarLadrillo(Ladrillo L) {
		ladrillos.add(L);
	}

	public Edificio getNiceland() {
		return this.niceland;
	}

	/**
	 * SE INSTANCIA EL JUEGO
	 */
	private Juego() {
		System.out.println("Se inicia el juego");
		this.nivel = new Nivel();
		this.seccionActual = 0;
		this.niceland = new Edificio();
		/**
		 * Al iniciar los individuos de ésta manera no necesito tener una instancia
		 */
		individuos.add(new Pajaro());
		individuos.add(new Ralph());
		this.felix = new FelixJr(2, 2);
	}

	/**
	 * INSTANCIA LA SECCIÓN ACTUAL
	 * 
	 * @param i
	 */
	public void setSeccion(int i) {
		this.seccionActual = i;

	}

	public void setIndividuo(Individuo I) {
		this.individuos.add(I);
	}

	// DEVUELVE LA SECCIÓN ACTUAL
	/**
	 * 
	 * @return
	 */
	public int getSeccion() {
		return this.seccionActual;
	}

	/**
	 * SE EJECUTA EL Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		jugarFixItFelixJr();
	}
	
	/*
	 *  Se ejecuta el juego, a cambiar por el loop cuando se implementen las teclas y demas
	 */
	private static void jugarFixItFelixJr() {
		while (getGame().felix.getVidas() > 0) {
			getGame().setSeccion(0);
			getGame().actualizar();
			martillazo();
			moverDerecha();
			if (colisionar())
				continue;
			martillazo();
			moverDerecha();
			getGame().actualizar();
			sacarLadrillos();
			if (colisionar())
				continue;
			martillazo();
			moverArriba();
			getGame().actualizar();
			for (int i = 0; i < 4; i++) {
				moverIzquierda();
				martillazo();
				sacarLadrillos();
				getGame().actualizar();
				if (colisionar())
					continue;
			}
			martillazo();
			moverArriba();
			getGame().actualizar();
			sacarLadrillos();
			if (colisionar())
				continue;
			martillazo();
			moverArriba();
			sacarLadrillos();
			getGame().setSeccion(1);
			getGame().felix.setPosX(2);
			getGame().felix.setPosY(0);
			if (colisionar())
				continue;
			for (int i = 0; i < 4; i++) {
				martillazo();
				moverDerecha();
				getGame().actualizar();
				sacarLadrillos();
				sacarLadrillos();
				if (colisionar())
					continue;
			}
			martillazo();
			moverArriba();
			getGame().actualizar();
			sacarLadrillos();
			if (colisionar())
				continue;
			else {
				getGame().felix.setPosX(2);
				getGame().felix.setPosY(2);
			}
		}
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("GAME...");
		try {
			Thread.sleep(1250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("OVER...");
	}

	/**
	 * Actualiza el estado de los objetos en cada instancia;
	 */
	private void actualizar() {
		for (Individuo I : getGame().individuos)
			I.actualizar();
	}
	
	/*
	 * Verifica si se puede pasar de nivel
	 */
	private void verificarPasajeDeNivel() {
		if (getGame().pasarNivel() && getGame().nivel.getNivelActual().equals(Niveles.NIVEL5)) {
			getGame().pasarSeccion();
		} else
			getGame().nivel.pasarNivel();
	}

	/**
	 * ORDENA A FELIX A MOVERSE A LA IZQUIERDA SI SE PUEDE
	 */
	private static void moverIzquierda() {
		getGame().felix.mover(DireccionFelix.IZQUIERDA);
	}

	/**
	 * ORDENA A FELIX A MOVERSE A LA ARRIBA SI SE PUEDE
	 */
	private static void moverArriba() {
		getGame().felix.mover(DireccionFelix.ARRIBA);
	}

	/**
	 * ORDENA A FELIX A MOVERSE A LA DERECHA SI SE PUEDE
	 */
	private static void moverDerecha() {
		getGame().felix.mover(DireccionFelix.DERECHA);
	}

	/**
	 * ORDENA A FELIX A MOVERSE A LA ABAJO SI SE PUEDE
	 */
	private static void moverAbajo() {
		getGame().felix.mover(DireccionFelix.ABAJO);
	}

	/**
	 * ORDENA A FELIX A DAR UN MARTILLAZO EN SU POSICIÓN
	 */
	private static void martillazo() {
		for (int i = 0; i < 4; i++)
			getGame().felix.darMartillazo(
					getGame().niceland.getSecciones().getVentana(getGame().felix.getPosX(), getGame().felix.getPosY()));
		System.out.println("FelixJr dio 4 martillazos");
	}

	/**
	 * VERIFICA LA COLISION ENTRE FELIX Y ALGO
	 * 
	 * @return
	 */
	public static boolean colisionar() {
		Torta cake = new Torta();
		for (Individuo i : getGame().individuos) {
			if (i.colision()) {
				if (i.equals(cake))
					getGame().felix.setInvulnerabilidad(true);
				else {
					if (getGame().felix.getVidas() > 0)
						getGame().felix = new FelixJr(2, 2);
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * Retorna la posición actual de Felix
	 * 
	 * @return
	 */
	public Posicion ubicacionFelix() {
		return getGame().felix.getUbicacion();
	}

	/**
	 * Elimina los ladrillos que se salgan del límite
	 * 
	 * @param juegaso
	 */
	private static void sacarLadrillos() {
		ArrayList<Ladrillo> temporal = new ArrayList<Ladrillo>();
		for (Ladrillo e : getGame().ladrillos) {
			if (e.getPosY() > 4) {
				temporal.add(e);
			}
		}
		getGame().ladrillos.removeAll(temporal);
	}

	/**
	 * Elimina los pajaros que se hayan salido del límite
	 */
	private static void sacarPajaros() {
		ArrayList<Pajaro> temporal = new ArrayList<Pajaro>();
		for (Pajaro p : getGame().pajaros) {
			if ((p.getPosX() > 3) || p.getPosX() < 0) {
				temporal.add(p);
			}
		}
		getGame().pajaros.removeAll(temporal);

	}

	/**
	 * Verifica si se puede pasar de nivel, es decir, si todas las ventanas están
	 * sanas
	 * 
	 * @return retorna verdadero si se puede pasar, y falso en caso contrario
	 */
	private boolean pasarNivel() {
		Ventana[][] ventanas = getGame().niceland.getSecciones().getMatrizVentanas();
		for (int i = 0; i < ventanas.length; i++) {
			for (int j = 0; j < ventanas[i].length; j++)
				if (!ventanas[i][j].getSana())
					return false;
		}
		return true;
	}

	/*
	 * Pasa a la sección siguiente
	 */
	private void pasarSeccion() {
		getGame().setSeccion(getGame().getSeccion() + 1);
		getGame().niceland.pasarDeSeccion();
		getGame().nivel.pasarNivel();
	}

	/**
	 * Iría a la animación de ganar
	 */
	public void ganar() {

	}
}
