package controladores;

public interface Mapa {
	//SOLO INSTANCIA LOS LÍMITES DEL JUEGO, NECESARIO SOLO EN LA IMPLEMENTACION GRÁFICA
	int LIMITE_X = 480;
	int LIMITE_Y = 600;
	
	
	//CREA UN PAJARO EN EL MAPA
	void crearPajaro();

	//CREA UNA NUBE EN EL MAPA
	void crearNube();

}
