package individuos;

import ventanas.*;

public class FelixJr extends Individuo {

	private boolean vivo;
	// private boolean invulnerable;
	private static int vidas = 4;
	private static int puntaje = 0;
	
	// CREA A FELIX EN LAS POCICIONES DADAS
	public FelixJr(int x, int y) {
		this.setPosX(x);
		this.setPosY(y);
		this.vivo = true;
		vidas -= 1;
		// this.invulnerable = true;
	}

	// CONFIGURA EL ESTADO DE VIDA DE FELIX
	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	// DEVUELVE EL ESTADO DE VIDA DE FELIX
	public boolean getVivo() {
		return this.vivo;
	}

	// INSTANCIA LAS CANTIDADES DE VIDA QUE POSEE FELIX
	public void setVidas(int vida) {
		vidas = vida;
	}

	// DEVUELVE LA CANTIDAD DE VIDAS ACTUALES DE FELIX
	public int getVidas() {
		return vidas;
	}

	// CONFIGURA EL PUNTAJE QUE FELIX POSEE
	// DEBERÍA SER APARTE EN UN MÉTODO GRÁFICO DEL MARCO
	// JUNTO CON EL TIMER Y DEMAS
	public void setPuntaje(int punt) {
		puntaje += punt;
	}

	// DEVUELVE EL PUNTAJE ACTUAL DE FELIX
	public int getPuntaje() {
		return puntaje;
	}

	// TEMPORAL
	// MUEVE A FELIX DEPENDIENDO EL PARÁMETRO PASADO, SI ES POSIBLE
	public void mover(DireccionFelix direc) {
		switch (direc) {
		case ARRIBA:{
			
		}
			break;
		case DERECHA:
			break;
		case ABAJO:
			break;
		case IZQUIERDA:
			break;
		}

	}

	// DA UN MARTILLAZO PARA REPARAR LA VENTANA PASADA POR PARÁMETRO
	public void darMartillazo(Ventana vent) {
		this.setPuntaje(vent.repararVentana());
		
	}

	// NO IMPLEMENTAN NADA
	public void colision() {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar() {
		this.mover(direc);

	}

}
