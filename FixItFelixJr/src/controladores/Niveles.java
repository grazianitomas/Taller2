package controladores;

public enum Niveles {
	NIVEL1, NIVEL2, NIVEL3, NIVEL4, NIVEL5, NIVEL6, NIVEL7, NIVEL8, NIVEL9, NIVEL10;
	/**
	 * ENUMERATIVO PARA LAS INSTANCIAS DE NIVELES
	 */

	public int getNivelesNum(Niveles nivel) {
		switch (nivel) {
		case NIVEL1:
			return 1;
		case NIVEL2:
			return 2;
		case NIVEL3:
			return 3;
		case NIVEL4:
			return 4;
		case NIVEL5:
			return 5;
		case NIVEL6:
			return 6;
		case NIVEL7:
			return 7;
		case NIVEL8:
			return 8;
		case NIVEL9:
			return 9;
		case NIVEL10:
			return 10;
		}
		return 0;
	}
}
