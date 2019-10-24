package ventanas;

public class Comun extends Ventana {

	//CONSTRUCTOR VACÍO
	public Comun() {
		super();
	}
	
	//CONSTRUCTOR SIMPLE
	public Comun(boolean maceta, boolean techo, Panel[] paneles) {
		super(maceta, techo, paneles);
	}
	
	//CONSTRUCTOR QUE TIENE EN CUENTA LAS PROBABILIDADES DE ROTO
	public Comun(double proba) {
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
	}
	

}
