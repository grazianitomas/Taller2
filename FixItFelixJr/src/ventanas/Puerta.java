package ventanas;

public class Puerta extends Ventana {
	
	//RETORNA LOS PANELES ACTUALES 
	public Panel[] getPaneles() {
		return paneles;
	}
	
	//CONFIGURA LOS PANELES 
	public void setPaneles(Panel[] paneles) {
		this.paneles = paneles;
	}

	//RETORNA TRUE SI LA VENTANA ESTA COMPLETAMENTE SANA
	public boolean getSana() {
		boolean es = false;
		for (int i = 0; i < 4; i++)
			if (!this.getPaneles()[i].getEstado().equals(EstadoPanel.SANO))
				es = false;
			else
				es = true;
		return es;
	}
	
	//CREA LA PUERTA CON LA PROBABILIDAD DE PANELES ROTOS PASADA POR PARÁMETRO
	public Puerta(double proba) {
		super();
		this.paneles = new Panel[4];
		for (int i = 0; i < 4; i++)
			this.paneles[i] = new Panel(proba);
	}
	
	//CREADOR DE PUERTA SIMPLE
	public Puerta(boolean maceta, boolean techo) {
		super(maceta, techo);
		this.paneles = new Panel[4];
	}
	
	@Override
	public int repararVentana() {
		if (!this.getSana()) {
			boolean roto = true;
			int i = 0;
			while ((roto) && (i < paneles.length)) {
				if (!paneles[i].getEstado().equals(EstadoPanel.SANO)) {
					roto = false;
				} else
					paneles[i].repararPanel();
				i++;
			}
			if (this.getSana())
				return 100;
		}
		return 0;
	}

}
