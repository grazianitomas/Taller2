package ventanas;

import entidades.NiceLander;

public abstract class Ventana {

	private boolean maceta;
	private boolean techo;
	private double probabilidad;
	private NiceLander nicelander;
	protected Panel[] paneles;

	// CONSTRUCTOR VACÍO
	public Ventana() {

	}

	// CONSTRUCTOR QUE SOLO INSTANCIA MACETAS Y TECHO
	public Ventana(boolean maceta, boolean techo) {
		this.maceta = maceta;
		this.techo = techo;
	}

	// CONSTRUCTOR QUE INSTANCIA TAMBIÉN LOS PANELES
	public Ventana(boolean maceta, boolean techo, Panel[] paneles) {
		this.maceta = maceta;
		this.techo = techo;
		this.paneles = new Panel[2];
	}

	// RETORNA VERDADERO SI HAY MACETA EN LA VENTANA
	public boolean isMaceta() {
		return maceta;
	}

	// CONFIGURA UNA MACETA EN LA VENTANA
	public void setMaceta(boolean maceta) {
		this.maceta = maceta;
	}

	// RETORNA VERDADERO SI HAY TECHO EN LA VENTANA
	public boolean isTecho() {
		return techo;
	}

	// CONFIGURA UN TECHO O MOLDURA EN LA VENTANA
	public void setTecho(boolean techo) {
		this.techo = techo;
	}

	// A REEMPLAZAR, REPARA LA VENTANA ACTUAL
	public int repararVentana() {
		if (!this.getSana()) {
			boolean roto = true;
			int i = 0;
			while ((roto) && (i < paneles.length)) {
				if (!paneles[i].getEstado().equals(EstadoPanel.SANO)) {
					paneles[i].repararPanel();
					roto = false;
				}
				i++;
			}
			if (roto)
				return 100;
		}
		return 0;
	}

	// RETORNA VERDADERO SI LA VENTANA ACTUAL SE ENCUENTRA COMPLETAMENTE SANA
	public boolean getSana() {
		boolean noRoto = true;
		int i = 0;
		while ((noRoto) && (i < paneles.length)) {
			if (paneles[i].getEstado().equals(EstadoPanel.ROTO)) {
				noRoto=false;
			}
		}
		return noRoto;
	}

	// A REEMPLAZAR, INSTANCIA TORTA EN LA VENTANA
	public boolean darTorta() {

		return false;
	}

	// CONFIGURA LA PROBABILIDAD DE QUE LOS PANELES ESTEN ROTOS
	public void setProba(double proba) {
		this.probabilidad = proba;
	}

	// RETORNA LA PROBABILIDAD DE QUE LOS PANELES ESTEN ROTOS
	public double getProba() {
		return this.probabilidad;
	}

}
