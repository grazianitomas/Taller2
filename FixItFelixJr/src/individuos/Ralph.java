package individuos;

import controladores.Juego;
import java.util.Random;

public class Ralph extends Individuo {
	private EstadoRalph modo;
	private int cantLadrillos;
	private int tirar;
	private static final int posY = 4;
	private boolean limite;
	private int posX;
	private Random rand = new Random();

	/**
	 * CONSTRUCTOR DE RALPH
	 */
	public Ralph() {
		this.tirar = 0;
		this.limite = false;
		this.modo = EstadoRalph.NORMAL;
		this.cantLadrillos = 40;
		this.setPosY(3);
		System.out.println("Se inicializa Ralph en la posición: [4][" + this.getPosY() + "]");
	}

	/**
	 * Retorna si puede tirar
	 * 
	 * @return
	 */
	public int getTirar() {
		return this.tirar;
	}

	/**
	 * Configura el parametro tirar para saber cuando tirar
	 * 
	 * @param i
	 */
	public void setTirar(int i) {
		this.tirar = i;
	}

	/**
	 * SIMULA LOS EFECTOS DE CUANDO RALPH DEMOLE
	 */
	public void demoler() {
		this.setEstado(EstadoRalph.DEMOLEDOR);
		System.out.println("Ralph está demoliendo.");
		int cont = 0;
		while ((cont < 3) && (this.cantLadrillos > 0)) {
			Juego.getGame().setIndividuo(new Ladrillo(0, rand.nextInt(4)));
			this.cantLadrillos -= 1;
			cont++;
		}
		this.setEstado(EstadoRalph.NORMAL);
	}

	/**
	 * VERIFICA SI ESTÁ AL LÍMITE DERECHO DEL EDIFICIO
	 * 
	 * @return
	 */
	public boolean isLimite() {
		return limite;
	}

	/**
	 * SE HACE TRUE CUANDO SE ENCUENTRA EN EL LÍMITE DERECHO DEL EDIFICIO
	 * 
	 * @param limite
	 */
	public void setLimite(boolean limite) {
		this.limite = limite;
	}

	// Actualiza el estado de Ralph y demole si le toca
	@Override
	public void actualizar() {
		if (this.getTirar() == 0) {
			this.demoler();
		} else if (this.getTirar() == 2)
			this.setTirar(0);
		this.setTirar(this.getTirar() + 1);
		this.mover();
	}

	/**
	 * Movimiento de Ralph
	 */
	private void mover() {
		if (!this.isLimite())
			if (this.getPosY() < 4) {
				this.setPosY(++posX);
			} else {
				this.setLimite(true);
			}
		else if (this.getPosY() > 0) {
			this.setPosY(--posX);
		} else
			this.setLimite(false);

	}

	/*
	 * DEVUELVE LA POSICION DE RALPH ACTUAL
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * CONFIGURA EL ESTADO ACTUAL DE RALPH
	 * 
	 * @param estado
	 */
	private void setEstado(EstadoRalph estado) {
		this.modo = estado;
	}

	/**
	 * DEVUELVE EL ESTADO ACTUAL DE RALPH
	 * 
	 * @return
	 */
	private EstadoRalph getEstado() {
		return this.modo;
	}

}
