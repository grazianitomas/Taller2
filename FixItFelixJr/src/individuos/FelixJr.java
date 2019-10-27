package individuos;

import controladores.Juego;
import ventanas.*;

public class FelixJr extends Individuo {

	private boolean vivo;
	private boolean invulnerable;
	private static int vidas = 4;
	private static int puntaje = 0;

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

	public void setInvulnerabilidad(boolean b) {
		this.invulnerable = b;
	}

	public boolean getInvulnerabilidad() {
		return this.invulnerable;
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
	 * DEVUELVE EL PUNTAJE ACTUAL DE FELIX
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
		if (!direc.equals(null))

			switch (direc) {
			case ARRIBA: {
				if (getPosY() < 0)
					if (Juego.getGame().getNiceland().getSecciones().getVentana(getPosX(), getPosY())
							.puedeMoverse(direc)) {
						this.setPosX(this.getPosX() - 1);
						System.out.println("FelixJr se movio hacia arriba");
					}
			}
				break;
			case DERECHA: {
				if (getPosX() < 4)
					if (!((DosHojas) Juego.getGame().getNiceland().getSecciones().getVentana(getPosX(), getPosY()))
							.getAbierta().equals(OpenClose.ABIERTA_DERECHA)) {
						if (!((DosHojas) Juego.getGame().getNiceland().getSecciones().getVentana(getPosX() + 1,
								getPosY())).getAbierta().equals(OpenClose.ABIERTA_IZQUIERDA)) {
							this.setPosY(this.getPosY() + 1);
							System.out.println("FelixJr se movio hacia la derecha");
						}
					}
			}
				break;
			case ABAJO: {
				if (getPosY() < 3)
					if (Juego.getGame().getNiceland().getSecciones().getVentana(getPosX(), getPosY())
							.puedeMoverse(direc)) {
						this.setPosX(this.getPosX() + 1);
						System.out.println("FelixJr se movio hacia abajo");
					}
			}
				break;
			case IZQUIERDA: {
				if (getPosX() > 0)
					if (!((DosHojas) Juego.getGame().getNiceland().getSecciones().getVentana(getPosX(), getPosY()))
							.getAbierta().equals(OpenClose.ABIERTA_IZQUIERDA)) {
						if (!((DosHojas) Juego.getGame().getNiceland().getSecciones().getVentana(getPosX() + 1,
								getPosY())).getAbierta().equals(OpenClose.ABIERTA_DERECHA)) {
							this.setPosY(this.getPosY() - 1);
							System.out.println("FelixJr se movio hacia la izquierda");
						}
					}
			}
				break;
			}

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
		//this.mover(direc);

	}

}
