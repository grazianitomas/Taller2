package individuos;

import controladores.Juego;
import java.util.Random;

public class Ralph extends Individuo {
	private EstadoRalph modo;
	private int cantLadrillos;
	private Ladrillo[] ladrillos;
	private static final int posY = 4;
	private boolean limite;
	private int posX;
	private Random rand = new Random();
	
	
	
	// CONSTRUCTOR DE RALPH
	public Ralph() {
		this.limite = false;
		this.modo = EstadoRalph.NORMAL;
		this.ladrillos = new Ladrillo[3];
		this.cantLadrillos = 40;
		this.setPosY(3);
		System.out.println("Se inicializa Ralph en la posición: [4][" + this.getPosY() + "]");
	}

	// SIMULA LOS EFECTOS DE CUANDO RALPH DEMOLE
	public void demoler() {
		this.setEstado(EstadoRalph.DEMOLEDOR);
		System.out.println("Ralph está demoliendo.");
		int cont = 0;
		while ((cont < 3) && (this.cantLadrillos > 0)) {
			Juego.getGame().agregarLadrillo(new Ladrillo(0, rand.nextInt(4)));
			this.cantLadrillos -= 1;
			cont++;
		}
		this.setEstado(EstadoRalph.NORMAL);
	}

	// VERIFICA SI ESTÁ AL LÍMITE DERECHO DEL EDIFICIO
	public boolean isLimite() {
		return limite;
	}

	// SE HACE TRUE CUANDO SE ENCUENTRA EN EL LÍMITE DERECHO DEL EDIFICIO
	public void setLimite(boolean limite) {
		this.limite = limite;
	}

	// MUEVE A RALPH UNA POSICIÓN A LA VEZ
	@Override
	public void actualizar() {
		this.mover();
		
		this.demoler();
	}

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

	@Override
	public void colision() {

	}

	// NO CORRESPONDE A RALPH CONOCER EL ESTADO DE LOS LADRILLOS
	// DEVUELVE EL LADRILLO EN LA POSICION DADA
	public int getLadrilloY(int y) {
		return this.ladrillos[y].getPosY();
	}

	// DEVUELVE EL LADRILLO EN LA POSICIÓN DADA
	public int getLadrilloX(int x) {
		return this.ladrillos[x].getPosX();
	}

	// DEVUELVE LA POSICION DE RALPH ACTUAL
	public int getPosY() {
		return posY;
	}

	// CONFIGURA EL ESTADO ACTUAL DE RALPH
	private void setEstado(EstadoRalph estado) {
		this.modo = estado;
	}

	// DEVUELVE EL ESTADO ACTUAL DE RALPH
	private EstadoRalph getEstado() {
		return this.modo;
	}

}
