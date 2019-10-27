package ventanas;

import entidades.Maceta;
import entidades.Moldura;

public class Comun extends Ventana {

	/*
	 * CONSTRUCTOR VACÍO
	 */
	public Comun() {
		super();
	}

	/*
	 * CONSTRUCTOR SIMPLE
	 */
	public Comun(Maceta maceta, Moldura moldura, Panel[] paneles) {
		super(maceta, moldura, paneles);
	}

	/*
	 * CONSTRUCTOR QUE TIENE EN CUENTA LAS PROBABILIDADES DE ROTO
	 */
	public Comun(double proba) {
		if (proba > 0.6) {
			if (proba > 0.8)
				this.setMaceta(new Maceta());
			this.setMoldura(new Moldura());
		}
		this.paneles = new Panel[2];
		this.paneles[0] = new Panel(proba);
		this.paneles[1] = new Panel(proba);
	}

}
