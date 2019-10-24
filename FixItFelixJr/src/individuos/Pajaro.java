package individuos;

public class Pajaro extends Individuo {
	
	//CONSTRUCTOR VACIO
	public Pajaro() {

	}
	
	//CREA A UN PAJARO EN LAS POSICIONES DADAS
	public Pajaro(int y, double v) {
		this.setPosY(y);
		this.setVelocidad(v);
		System.out.println("Aparece un pájaro en la posición: [" + this.getPosY() + "]");
	}
	
	//CREA A UN PAJARO EN LA POSICION DADA
	public Pajaro(int y) {
		this.setPosY(y);
		System.out.println("Aparece un pájaro en la posición: [" + this.getPosY() + "]");
	}
	
	//MODIFICA LA POSICIÓN DEL PÁJARO
	@Override
	public void actualizar() {

	}
	
	//CUANDO EL PAJARO APARECE POR DERECHA
	public void moverIzq() {
		this.setPosX(this.getPosX() - 1);
	}
	
	//CUANDO EL PAJARO APARECE POR IZQUIERDA
	public void moverDer() {
		this.setPosX(this.getPosX() + 1);
	}
	
	//SIMULARÍA LA COLISIÓN ENTRE PÁJARO Y FELIX
	@Override
	public void colision() {

	}

}
