package práctica5;

public class TestRandom {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++)
				System.out.print("Nro " + i + j + " " + GeneraRandom.obtenerRandom() + " || ");
			System.out.println("");
		}
	}

}
