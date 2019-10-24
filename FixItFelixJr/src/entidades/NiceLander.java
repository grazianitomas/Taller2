package entidades;

import entidades.Torta;

public class NiceLander {
	private boolean listo;// CUANDO ESTÁ LISTO PARA DAR PASTEL

	// INSTANCIA EL NICELANDER
	public NiceLander() {
		this.listo = true;
	}

	public boolean getListo() {
		return this.listo;
	}

	public void setListo(boolean estado) {
		this.listo = estado;
	}
	
	// DA UN PASTEL
	public Torta darPastel() {
		Torta cake = new Torta();
		return cake;
	}

}
