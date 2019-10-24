package entidades;

public class Posicion {
	private int posX;
	private int posY;

	
	public Posicion() {

	}
	
	public Posicion(int X, int Y) {
		posX = X;
		posY = Y;
	}
	
	//DEVUELVE LA POSICION EN X DEL OBJETO
	public int getPosX() {
		return posX;
	}
	
	//SETEA LA POSICION EN X DEL OBJETO
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	//DEVUELVE LA POSICION EN Y DEL OBJETO
	public int getPosY() {
		return posY;
	}
	
	//SETEA LA POSICION EN X DEL OBJETO
	public void setPosY(int posY) {
		this.posY = posY;
	}

}
