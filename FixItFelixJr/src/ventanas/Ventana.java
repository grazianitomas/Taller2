package ventanas;

import entidades.Maceta;
import entidades.Moldura;
import individuos.DireccionFelix;

public abstract class Ventana {

	private Maceta maceta;
	private Moldura moldura;
	private double probabilidad;
	protected Panel[] paneles;

	/**
	 * CONSTRUCTOR VACÍO
	 */
	public Ventana() {

	}

	/**
	 * CONSTRUCTOR QUE SOLO INSTANCIA MACETAS Y TECHO
	 * 
	 * @param maceta
	 * @param techo
	 */
	public Ventana(Maceta maceta, Moldura moldura) {
		this.maceta = maceta;
		this.moldura = moldura;
	}

	/**
	 * CONSTRUCTOR QUE INSTANCIA TAMBIÉN LOS PANELES
	 * 
	 * @param maceta
	 * @param techo
	 * @param paneles panel a configurar
	 */
	public Ventana(Maceta maceta, Moldura moldura, Panel[] paneles) {
		this.maceta = maceta;
		this.moldura = moldura;
		this.paneles = paneles;
	}

	/**
	 * RETORNA VERDADERO SI HAY MACETA EN LA VENTANA
	 * 
	 * @return verdadero o falso
	 */
	public Maceta getMaceta() {
		return maceta;
	}

	/**
	 * CONFIGURA UNA MACETA EN LA VENTANA
	 * 
	 * @param maceta
	 */
	public void setMaceta(Maceta maceta) {
		this.maceta = maceta;
	}

	/**
	 * RETORNA VERDADERO SI HAY TECHO EN LA VENTANA
	 * 
	 * @return verdadero o falso
	 */
	public Moldura getMoldura() {
		return this.moldura;
	}

	/**
	 * CONFIGURA UN TECHO O MOLDURA EN LA VENTANA
	 * 
	 * @param techo
	 */
	public void setMoldura(Moldura moldura) {
		this.moldura = moldura;
	}

	/**
	 * REPARA LA VENTANA ACTUAL
	 * 
	 * @return retorna 100 si se reparó, o 0 si ya estaba reparada
	 */
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

	/**
	 * RETORNA VERDADERO SI LA VENTANA ACTUAL SE ENCUENTRA COMPLETAMENTE SANA
	 * 
	 * @return verdadero o falso
	 */
	public boolean getSana() {
		boolean noRoto = true;
		int i = 0;
		while ((noRoto) && (i < paneles.length)) {
			if (paneles[i].getEstado().equals(EstadoPanel.ROTO)) {
				noRoto = false;
			}
		}
		return noRoto;
	}

	/**
	 * CONFIGURA LA PROBABILIDAD DE QUE LOS PANELES ESTEN ROTOS
	 * 
	 * @param proba probabilidad de que los planeles esten rotos
	 */
	public void setProba(double proba) {
		this.probabilidad = proba;
	}

	/**
	 * RETORNA LA PROBABILIDAD DE QUE LOS PANELES ESTEN ROTOS
	 * 
	 * @return double
	 */
	public double getProba() {
		return this.probabilidad;
	}

	/**
	 * Retorna la ventana actual
	 * 
	 * @return
	 */
	public Ventana getVentana() {
		return this;
	}

	/**
	 * Verifica si Felix puede moverse en direcciones de arriba o abajo
	 * 
	 * @param direc direccion a la que se solicita moverse
	 * @return verdadero o falso
	 */
	public boolean puedeMoverse(DireccionFelix direc) {
		if (direc.equals(DireccionFelix.ARRIBA)) {
			if (!this.getMoldura().equals(null)) {
				return true;
			} else
				return false;
		} else {
			if (!this.getMaceta().equals(null)) {
				return true;
			} else
				return false;

		}
	}

}
