package controladores;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import entidades.Posicion;
import individuos.DireccionFelix;
import individuos.FelixJr;
import individuos.Individuo;
import individuos.Ladrillo;
import individuos.Pajaro;
import individuos.Ralph;
import niceland.Edificio;
import ventanas.Ventana;

public class Juego implements Runnable {

	private FelixJr felix;
	private Edificio niceland;
	private Nivel nivel;
	private int seccionActual;
	private CopyOnWriteArrayList<Ladrillo> ladrillos = new CopyOnWriteArrayList<Ladrillo>();
	private CopyOnWriteArrayList<Individuo> individuos = new CopyOnWriteArrayList<Individuo>();
	private CopyOnWriteArrayList<Pajaro> pajaros = new CopyOnWriteArrayList<Pajaro>();

	private static Juego game = new Juego();

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

	public CopyOnWriteArrayList<Individuo> getIndividuos() {
		return individuos;
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

	@Override
	public void run() {

	}

	/*
	 * Se ejecuta el juego, a cambiar por el loop cuando se implementen las teclas y
	 * demas
	 */
	private static void jugarFixItFelixJr() {
		while (getGame().felix.getVidas() > 0) {
			getGame().setSeccion(0);
			getGame().actualizar();
			martillazo();
			verificarPasajeDeNivel();
			moverDerecha();
			if (colisionar())
				continue;
			martillazo();
			verificarPasajeDeNivel();
			moverDerecha();
			getGame().actualizar();
			sacarLadrillos();
			if (colisionar())
				continue;
			martillazo();
			verificarPasajeDeNivel();
			moverArriba();
			getGame().actualizar();
			for (int i = 0; i < 4; i++) {
				moverIzquierda();
				martillazo();
				verificarPasajeDeNivel();
				sacarLadrillos();
				getGame().actualizar();
				if (colisionar())
					continue;
			}
			martillazo();
			verificarPasajeDeNivel();
			moverArriba();
			getGame().actualizar();
			sacarLadrillos();
			if (colisionar())
				continue;
			martillazo();
			verificarPasajeDeNivel();
			moverArriba();
			sacarLadrillos();
			getGame().setSeccion(1);
			getGame().felix.setPosX(2);
			getGame().felix.setPosY(0);
			if (colisionar())
				continue;
			for (int i = 0; i < 4; i++) {
				martillazo();
				verificarPasajeDeNivel();
				moverDerecha();
				getGame().actualizar();
				sacarLadrillos();
				sacarLadrillos();
				if (colisionar())
					continue;
			}
			martillazo();
			verificarPasajeDeNivel();
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
	private static void verificarPasajeDeNivel() {
		if (getGame().pasarSeccion()) {
			if (getGame().getSeccion() == 3) {
				getGame().nivel.pasarNivel();
				getGame().setSeccion(0);
				getGame().niceland.pasarDeSeccion(getGame().niceland.getSecciones().getSeccionActual().proxSeccion());
				System.out.println("Congratulaciones! Pasaste al nivel "
						+ getGame().nivel.getNivelActual().getNivelesNum(getGame().nivel.getNivelActual()));

			}
			getGame().niceland.pasarDeSeccion(getGame().niceland.getSecciones().getSeccionActual().proxSeccion());
			getGame().felix = new FelixJr(getGame().felix.getPosX(), getGame().felix.getPosY());
		}
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
		Ventana aReparar = getGame().getNiceland().getSecciones().getVentana(getGame().ubicacionFelix().getPosX(),
				getGame().ubicacionFelix().getPosY());
		getGame().felix.darMartillazo(aReparar);
	}

	/**
	 * VERIFICA LA COLISION ENTRE FELIX Y ALGO
	 * 
	 * @return
	 */
	public static boolean colisionar() {
		for (Individuo i : getGame().individuos) {
			if (i.colision(getGame().felix.getPosicion())) {
				if (getGame().felix.getVidas() > 0)
					getGame().felix = new FelixJr(2, 2);
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
		return getGame().felix.getPosicion();
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
	private boolean pasarSeccion() {
		Ventana[][] ventanas = getGame().niceland.getSecciones().getMatrizVentanas();
		for (int i = 0; i < ventanas.length; i++) {
			for (int j = 0; j < ventanas[i].length; j++)
				if (!ventanas[i][j].getSana())
					return false;
		}
		return true;
	}

	/**
	 * Iría a la animación de ganar
	 */
	public void ganar() {

	}

}
