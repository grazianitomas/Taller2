package individuos;

import controladores.Juego;
import entidades.Posicion;
import ventanas.*;

public class FelixJr extends Individuo {

	private boolean vivo;
	private boolean invulnerable;
	private static int vidas = 4;
	private static int puntaje = 0;
	private int contadorInv;

	/**
	 * CREA A FELIX EN LAS POCICIONES DADAS
	 * 
	 * @param x
	 * @param y
	 */
	public FelixJr(int x, int y) {
		this.setPosX(x);
		this.setPosY(y);
		this.vivo = true;
		vidas -= 1;
		this.invulnerable = true;
	}

	/*
	 * CONFIGURA EL ESTADO DE VIDA DE FELIX
	 */
	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	/**
	 * DEVUELVE EL ESTADO DE VIDA DE FELIX
	 * 
	 * @return
	 */
	public boolean getVivo() {
		return this.vivo;
	}

	/**
	 * INSTANCIA LAS CANTIDADES DE VIDA QUE POSEE FELIX
	 * 
	 * @param vida
	 */
	public void setVidas(int vida) {
		vidas = vida;
	}

	/**
	 * DEVUELVE LA CANTIDAD DE VIDAS ACTUALES DE FELIX
	 * 
	 * @return
	 */
	public int getVidas() {
		return vidas;
	}

	/**
	 * CONFIGURA EL PUNTAJE QUE FELIX POSEE DEBERÍA SER APARTE EN UN MÉTODO GRÁFICO
	 * DEL MARCO JUNTO CON EL TIMER Y DEMAS
	 * 
	 * @param punt
	 */
	public void setPuntaje(int punt) {
		puntaje += punt;
	}

	/**
	 * 
	 * @return
	 */
	public int getPuntaje() {
		return puntaje;
	}

	/**
	 * MUEVE A FELIX DEPENDIENDO EL PARÁMETRO PASADO, SI ES POSIBLE
	 * 
	 * @param direc, indica hacia la dirección que se desea que Felix se mueva
	 */
	public void mover(DireccionFelix direc) {
		Ventana aux = Juego.getGame().getNiceland().getSecciones().getVentana(getPosX(), getPosY());
		Posicion siguiente = this.getPosicion().getNextPos(direc);
		Ventana nextVentana = Juego.getGame().getNiceland().getSecciones().getVentana(siguiente.getPosX(),
				siguiente.getPosY());
		DireccionFelix dirInver = direc.direccionInvertida(direc);
		if (aux.puedeMoverse(direc) && nextVentana.puedeMoverse(dirInver)) {
			this.setPosicion(siguiente);
			if (nextVentana.pastel) {
				this.setInvulnerable(true);
				this.setContadorInv(2000);
			}
		}

	}

	public boolean getInvulnerable() {
		return invulnerable;
	}

	public void setInvulnerable(boolean invulnerable) {
		this.invulnerable = invulnerable;
	}

	public int getContadorInv() {
		return contadorInv;
	}

	public void setContadorInv(int contadorInv) {
		this.contadorInv = contadorInv;
	}

	/**
	 * DA UN MARTILLAZO PARA REPARAR LA VENTANA PASADA POR PARÁMETRO
	 * 
	 * @param vent
	 */
	public void darMartillazo(Ventana vent) {
		this.setPuntaje(this.getPuntaje() + vent.repararVentana());
	}

	/*
	 * Actualiza el estado de Felix
	 * 
	 */
	@Override
	public void actualizar() {
		if (this.getInvulnerable()) {
			this.setContadorInv(this.getContadorInv() - 1);
		}
		
	}

}
