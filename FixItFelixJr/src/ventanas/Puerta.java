package ventanas;

public class Puerta extends Ventana {

	/*
	 * RETORNA LOS PANELES ACTUALES
	 */
	public Panel[] getPaneles() {
		return paneles;
	}

	/*
	 * CONFIGURA LOS PANELES
	 */
	public void setPaneles(Panel[] paneles) {
		this.paneles = paneles;
	}

	/*
	 * CREA LA PUERTA CON LA PROBABILIDAD DE PANELES ROTOS PASADA POR PARÁMETRO
	 */
	public Puerta(double proba) {
		super();
		this.paneles = new Panel[4];
		for (int i = 0; i < 4; i++)
			this.paneles[i] = new Panel(proba);
	}

}
