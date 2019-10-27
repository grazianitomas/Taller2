package entidades;

public class Maceta extends Posicion {

	private boolean hay = false;

	/**
	 * Constructor vacío
	 */
	public Maceta() {
		super();
		this.hay = true;
	}

	/**
	 * Constructor de Maceta en la posición mandada
	 * 
	 * @param x
	 * @param y
	 */
	public Maceta(int x, int y) {
		super(x, y);
		this.hay = true;
	}
	
	/**
	 * Retorna si hay maceta
	 * @return
	 */
	public boolean getHay() {
		return this.hay;
	}
	
	/**
	 * Configura si hay maceta
	 * @param b
	 */
	public void setHay(boolean b) {
		this.hay = b;
	}

}
