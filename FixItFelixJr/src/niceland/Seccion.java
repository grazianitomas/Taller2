package niceland;

import java.util.Random;
import ventanas.*;

public class Seccion {
	private EstadoSeccion seccionFinal = EstadoSeccion.SECCIÓN_SUPERIOR;
	private static EstadoSeccion secciónActual;
	private Ventana[][] ventanas;
	Random rand = new Random();

	// CONFIGURA LA VENTANA EN LAS POSICIONES DADAS CON EL TIPO DE VENTANA PASADA
	public void setVentana(int x, int y, Ventana vent) {
		this.ventanas[x][y] = vent;
	}

	// CONSTRUYE LAS SECCION CORRESPONDIENTE CON EL PARÁMETRO "K"
	// CON LA CORRESPONDIENTE PROBABILIDAD DE PANELES ROTOS, PASADOS CON "PROBA"
	public Seccion(double proba, int k) {
		this.ventanas = new Ventana[3][5];
		if (k == 0) {
			this.setSeccionActual(EstadoSeccion.SECCIÓN_INFERIOR);
			for (int i = 0; i < 3; i++)
				for (int j = 0; j < 5; j++) {
					if (j == 2) {
						if (i == 0)
							this.setVentana(i, j, new Comun(proba));
						if (i == 1)
							this.setVentana(i, j, new Semicircular(proba));
						if (i == 2)
							this.setVentana(i, j, new Puerta(proba));
					} else
						this.setVentana(i, j, new Comun(proba));
				}
		}
		if (k == 1) {
			this.pasarSeccion();
			for (int i = 0; i < 3; i++)
				for (int j = 0; j < 5; j++) {
					if (rand.nextBoolean())
						this.setVentana(i, j, new Comun(proba));
					else
						this.setVentana(i, j, new DosHojas(proba));
				}
		}
		if (k == 2) {
			this.pasarSeccion();
			for (int i = 0; i < 3; i++)
				for (int j = 0; j < 5; j++) {
					if (rand.nextBoolean())
						this.setVentana(i, j, new Comun(proba));
					else
						this.setVentana(i, j, new DosHojas(proba));
				}
		}
	}

	// VERSION MAS INEFICIENTE DE CONSTRUCTOR
	public Seccion(double probabilidad) {
		this.ventanas = new Ventana[3][5];
		if (getSeccionActual() == null) {
			this.setSeccionActual(EstadoSeccion.SECCIÓN_INFERIOR);
			for (int i = 0; i < 3; i++)
				for (int j = 0; j < 5; j++) {
					if ((i == 2) && (j == 2))
						this.setVentana(i, j, new Puerta(probabilidad));
					if ((i == 1) && (j == 2))
						this.setVentana(i, j, new Semicircular(probabilidad));
					else
						this.setVentana(i, j, new Comun(probabilidad));

				}
			this.pasarSeccion();
		} else {
			if (getSeccionActual().equals(EstadoSeccion.SECCIÓN_MEDIA)) {
				this.setSeccionActual(EstadoSeccion.SECCIÓN_MEDIA);
				// CONSTRUIR NORMAL
				Comun com = new Comun(probabilidad);
				for (int i = 0; i < 3; i++)
					for (int j = 0; j < 5; j++) {
						this.setVentana(i, j, com);
						com = new Comun(probabilidad);
					}
				this.pasarSeccion();
			} else {
				Comun com = new Comun(probabilidad);
				DosHojas dos = new DosHojas(probabilidad);
				for (int i = 0; i < 3; i++)
					for (int j = 0; j < 5; j++) {
						if (rand.nextBoolean())
							this.setVentana(i, j, com);
						else
							this.setVentana(i, j, dos);
						com = new Comun(probabilidad);
						dos = new DosHojas(probabilidad);
					}
				// DEFINIR NORMAL LA ULTIMA
			}
		}

	}

	// RETORNA LA SECCION ACTUAL EN TIPO ENUMERATIVO
	public static EstadoSeccion getSeccionActual() {
		return secciónActual;
	}

	public int getSeccionNum() {
		return getSeccionActual().getSeccion(secciónActual);
	}

	// CONFIGURA LA SECCION ACTUAL CON LA PASADA POR PARÁMETRO
	public void setSeccionActual(EstadoSeccion actual) {
		secciónActual = actual;
	}

	// MODULA EL PASAJE DE SECCION
	public EstadoSeccion pasarSeccion() {
		if (secciónActual.equals(EstadoSeccion.SECCIÓN_INFERIOR))
			secciónActual = EstadoSeccion.SECCIÓN_MEDIA;
		else if (secciónActual.equals(EstadoSeccion.SECCIÓN_MEDIA))
			secciónActual = this.seccionFinal;
		return secciónActual;
	}

	// RETORNA LA VENTANA EN LAS POSICIONES DADAS
	public Ventana getVentana(int x, int y) {
		return ventanas[x][y];
	}

	// RETORNA LA MATRIZ COMPLETA DE VENTANAS
	public Ventana[][] getMatrizVentanas() {
		return ventanas;
	}

}
