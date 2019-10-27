package ventanas;

public class Semicircular extends Ventana {

	/*
	 * CONSTRUCTOR QUE NO CONFIGURA PANELES
	 */
	public Semicircular() {
		super();
		this.paneles = new Panel[8];
	}

	/*
	 * CONSTRUCTOR QUE CONFIGURA PANELES
	 */
	public Semicircular(double proba) {
		this.paneles = new Panel[8];
		for (int i = 0; i < 8; i++)
			this.paneles[i] = new Panel(proba);
	}

	/*
	 * RETORNA LOS PANELES DE LA VENTANA
	 */
	public Panel[] getPaneles() {
		return paneles;
	}

	/*
	 * CONFIGURA LOS PANELES DE LA VENTANA
	 */
	public void setPaneles(Panel[] paneles) {
		this.paneles = paneles;
	}

}
