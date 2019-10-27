package entidades;

public class Moldura extends Posicion {

	private boolean hay = false;

	/**
	 * Constructor vacío
	 */
	public Moldura() {
		this.hay = true;
	}

	/**
	 * Constructor de moldura en la posición tal
	 * 
	 * @param x
	 * @param y
	 */
	public Moldura(int x, int y) {
		super(x, y);
		this.hay = true;
	}
	
	/**
	 * Retorna si hay moldura
	 * @return
	 */
	public boolean getHay() {
		return this.hay;
	}
	
	/**
	 * Configura si hay moldura
	 * @param b
	 */
	public void setHay(boolean b) {
		this.hay = b;
	}

}
