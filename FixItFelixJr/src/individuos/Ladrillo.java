package individuos;

public class Ladrillo extends Individuo {
	
	//CONSTRUCTOR VACIO
	public Ladrillo() {

	}
	
	//CREA AL LADRILLO EN LAS POSICIONES DADAS
	public Ladrillo(int x, int y) {
		super(x, y);
		System.out.println("Cae un ladrillo desde: [" + 4 + "][" + this.getPosY() + "]");
	}
	
	//CREA AL LADRILLO EN LAS POSICIONES DADAS Y CON LA VELOCIDAD DADA
	public Ladrillo(int x, int y, double V) {
		super(x, y, V);
		System.out.println("Cae un ladrillo desde: [" + 4 + "][" + this.getPosY() + "]");
	}

	//MODIFICA LA POSICION DEL LADRILLO
	@Override
	public void actualizar() {
		this.setPosX(this.getPosX() + 1);
	}
	
	//CORRESPONDERÍA A LA COLISIÓN ENTRE FELIX Y EL LADRILLO
	//PERO SE VERIFICA EN EL JUEGO
	@Override
	public void colision() {
		
	}
}
