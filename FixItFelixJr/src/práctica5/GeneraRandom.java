package práctica5;

public final class GeneraRandom {
	private static final int MAXIMO_VALOR = Integer.MAX_VALUE;

	private GeneraRandom() {
	}

	public static double obtenerRandom() {
		double i = Math.random(); // DEVUELVE UN VALOR DOUBLE ENTRE 0 Y 1
		i = i * (MAXIMO_VALOR / 250);
		i = (int) i;
		while (!((i > 0) && (i < MAXIMO_VALOR)))
			i = (int) Math.random();
		return i;
	}

}
