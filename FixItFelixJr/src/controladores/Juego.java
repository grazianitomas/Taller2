package controladores;

import java.util.ArrayList;

import individuos.FelixJr;
import individuos.Ladrillo;
import individuos.Pajaro;
import individuos.Ralph;
import niceland.Edificio;

public class Juego {

	private FelixJr felix;
	private Edificio niceland;
	private Ralph ralf;
	private Pajaro bird;
	private static Niveles nivel;
	private int seccionActual;
	private static Juego game = new Juego();
	private ArrayList<Ladrillo> ladrillos = new ArrayList<Ladrillo>();

	public static Juego getGame() {
		return game;
	}

	// AGREGA UN LADRILLO A LA ARRAYLIST
	public void agregarLadrillo(Ladrillo L) {
		ladrillos.add(L);
	}

	// SE INSTANCIA EL JUEGO
	private Juego() {
		System.out.println("Se inicia el juego");
		this.bird = new Pajaro();
		this.nivel = Niveles.NIVEL1;
		this.niceland = new Edificio();
		this.seccionActual = 0;
		this.ralf = new Ralph();
		this.felix = new FelixJr(2, 2);
	}

	// INSTANCIA LA SECCIÓN ACTUAL
	public void setSeccion(int i) {
		this.seccionActual = i;
	}

	// DEVUELVE LA SECCIÓN ACTUAL
	/**
	 * 
	 * @return
	 */
	public int getSeccion() {
		return this.seccionActual;
	}

	// SE EJECUTA EL JUEGO
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Juego Juegaso = Juego.getGame();

		while (Juegaso.felix.getVidas() > 0) {
			Juegaso.setSeccion(0);
			for (int i = 0; i < 4; i++)
				martillazo(Juegaso);
			moverDerecha(Juegaso);
			Juegaso.ralf.actualizar();
			Juegaso.ralf.demoler();
			moverLadrillos(Juegaso);
			if (colisionar(Juegaso))
				continue;
			for (int i = 0; i < 4; i++)
				martillazo(Juegaso);
			Juegaso.ralf.actualizar();
			Juegaso.ralf.demoler();
			moverDerecha(Juegaso);
			moverLadrillos(Juegaso);
			if (colisionar(Juegaso))
				continue;
			for (int i = 0; i < 4; i++)
				martillazo(Juegaso);
			moverArriba(Juegaso);
			Juegaso.ralf.actualizar();
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++)
					martillazo(Juegaso);
				moverIzquierda(Juegaso);
				moverLadrillos(Juegaso);
				Juegaso.ralf.actualizar();
				if (colisionar(Juegaso))
					continue;
			}
			for (int i = 0; i < 4; i++)
				martillazo(Juegaso);
			Juegaso.ralf.actualizar();
			Juegaso.ralf.demoler();
			moverLadrillos(Juegaso);
			moverArriba(Juegaso);
			if (colisionar(Juegaso))
				continue;
			for (int i = 0; i < 4; i++)
				martillazo(Juegaso);
			moverArriba(Juegaso);
			moverLadrillos(Juegaso);
			Juegaso.setSeccion(1);
			Juegaso.felix.setPosX(2);
			Juegaso.felix.setPosY(0);
			if (colisionar(Juegaso))
				continue;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++)
					martillazo(Juegaso);
				Juegaso.ralf.actualizar();
				Juegaso.ralf.demoler();
				moverLadrillos(Juegaso);
				moverDerecha(Juegaso);
				moverLadrillos(Juegaso);
				if (colisionar(Juegaso))
					continue;
			}
			for (int i = 0; i < 4; i++)
				martillazo(Juegaso);
			Juegaso.ralf.actualizar();
			Juegaso.ralf.demoler();
			moverArriba(Juegaso);
			moverLadrillos(Juegaso);
			if (colisionar(Juegaso))
				continue;
			else {
				Juegaso.felix.setPosX(2);
				Juegaso.felix.setPosY(2);
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

	// CHEQUEA SI SE REALIZA UNA COLISION ENTRE UN LADRILLO Y FELIX
	private boolean colisionar() {
		if (this.simularColision(this)) {
			System.out.println("Un ladrillo ha colisionado con FelixJr");
			this.felix = new FelixJr(2, 2);
			if (this.felix.getVidas() > 0)
				System.out.println("Felix aparece en la posición: [0][2]");
			return true;
		} else
			return false;
	}

	// ORDENA A FELIX A MOVERSE A LA IZQUIERDA SI SE PUEDE
	private static void moverIzquierda(Juego Juegaso) {
		Juegaso.felix.mover(3);
		System.out.println("FelixJr se movio hacia la izquierda");
	}

	// ORDENA A FELIX A MOVERSE A LA ARRIBA SI SE PUEDE
	private static void moverArriba(Juego Juegaso) {
		Juegaso.felix.mover(0);
		System.out.println("FelixJr se movio hacia arriba");
	}

	// ORDENA A FELIX A MOVERSE A LA DERECHA SI SE PUEDE
	private static void moverDerecha(Juego Juegaso) {
		Juegaso.felix.mover(1);
		System.out.println("FelixJr se movio hacia la derecha");
	}

	// ORDENA A FELIX A MOVERSE A LA ABAJO SI SE PUEDE
	private static void moverAbajo(Juego Juegaso) {
		Juegaso.felix.mover(2);
		System.out.println("FelixJr se movio hacia abajo");
	}

	// ORDENA A FELIX A DAR UN MARTILLAZO EN SU POSICIÓN
	private static void martillazo(Juego Juegaso) {
		Juegaso.felix.darMartillazo(Juegaso.niceland.getSecciones(Juegaso.getSeccion())
				.getVentana(Juegaso.felix.getPosX(), Juegaso.felix.getPosY()));
		System.out.println("FelixJr dio un martillazo");
	}

	// VERIFICA LA COLISION ENTRE FELIX Y ALGÚN LADRILLO
	public boolean simularColision() {
		boolean choque = false;
		int i = 0;
		while ((!choque) && (i < this.ladrillos.size())) {
			if ((felix.getPosX() == game.ladrillos.get(i).getPosX())
					&& (felix.getPosY() == game.ladrillos.get(i).getPosY())) {
				choque = true;
			}
			i++;
		}
		return choque;
	}

	// MUEVE LOS LADRILLOS Y VERIFICA QUE SI ALGUNO SE SALE DE LA MATRIZ DEL
	// EDIFICIO, LOS ELIMINA
	private static void moverLadrillos(Juego juegaso) {
		int tamaño = juegaso.ladrillos.size();
		ArrayList<Ladrillo> temporal = new ArrayList<Ladrillo>();
		for (int i = 0; i < tamaño; i++) {
			if (!juegaso.ladrillos.isEmpty())
				juegaso.ladrillos.get(i).actualizar();
		}
		for (Ladrillo e : juegaso.ladrillos) {
			if ((e.getPosX() > 3) || (e.getPosX() < -1)) {
				temporal.add(e);
			}

		}
		juegaso.ladrillos.removeAll(temporal);
	}

}
