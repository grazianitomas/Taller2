package practica3;

import java.util.Scanner;

public class TestIMC {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		// float altura = Float.parseFloat(args[1]);
		// float peso = Float.parseFloat(args[0]);
		System.out.println("Ingrese su altura.");
		float altura = in.nextFloat();
		System.out.println("Ingrese su peso.");
		float peso = in.nextFloat();
		IMC cuenta = new IMC(peso, altura);
		if (cuenta.calculo() > 18) {
			if (cuenta.calculo() < 25) {
				System.out.println("Usted está saludable!");
			}
		} else {
			System.out.println("Usted no está saludable!");
		}

	}

}
