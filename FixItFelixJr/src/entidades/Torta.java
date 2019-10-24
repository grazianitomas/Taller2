package entidades;

public class Torta extends Posicion {
	private boolean torta;

	public Torta() {
		this.torta = true;
	}

	public boolean getTorta() {
		return this.torta;
	}

	public void setTorta(boolean torta) {
		this.torta = torta;
	}

	// INSTANCIARÍA LA COLISION ENTRE FELIX Y LA TORTA, ES DECIR, CUANDO ÉSTE LA
	// TOME
	public int colisionar() {

		return 0;
	}

}
