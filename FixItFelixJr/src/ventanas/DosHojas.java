package ventanas;

import java.util.Random;

public class DosHojas extends Ventana {
	private OpenClose estado;

	private Random rand = new Random();

	// RETORNA SI ESTÁ ABIERTA O CERRADA
	public OpenClose isAbierta() {
		return estado;
	}

	// CONFIGURA SI ESTÁ ABIERTA O CERRADA
	public void setAbierta(OpenClose estado) {
		this.estado = estado;
	}

	// CONSTRUCTOR DE LA VENTANA CON HOJAS
	public DosHojas() {
		super();
		boolean i = rand.nextBoolean();
		generarEstado(rand.nextInt());
	}

	// CONTRUCTOR DE LAS VENTANA CON HOJAS TENIENDO EN CUENTA LA PROBABILIDAD DE
	// ROTO
	public DosHojas(double proba) {
		if (proba > 0.6) {
			if (proba > 0.8)
				this.setMaceta(true);
			this.setTecho(true);
		} else {
			this.setMaceta(false);
			this.setTecho(false);
		}
		this.paneles = new Panel[2];
		this.paneles[0] = new Panel(proba);
		this.paneles[1] = new Panel(proba);
		generarEstado(rand.nextInt());
	}

	// GENERA EL ESTADO DE LA VENTANA
	private void generarEstado(int i) {
		switch (i) {
		case 1:
			this.setAbierta(OpenClose.ABIERTA_DERECHA);
			break;
		case 2:
			this.setAbierta(OpenClose.ABIERTA_IZQUIERDA);
			break;
		case 3:
			this.setAbierta(OpenClose.CERRADA);
			break;
		}
	}

}
