package práctica6;

import java.util.Arrays;

public class TestOrdenado {

	public static void main(String[] args) {
		Persona[] personajes = { new Persona("carlos", "menem", 99), new Persona("fefe", "estefen", 22),
				new Persona("fafafa", "libre", 21) };

		System.out.println("Arreglo original:");

		for (Persona p : personajes)
			System.out.println(p.toString());

//		System.out
//				.println("--------------------------------Ordenado por default--------------------------------------");
//
//		Arrays.sort(personajes);
//
//		for (Persona p : personajes)
//			System.out.println(p.toString());

		System.out.println("--------------------------------Ordenado por edad--------------------------------------");

		Arrays.sort(personajes, new ComparadorEdad());

		for (Persona p : personajes)
			System.out.println(p.toString());

		System.out.println("--------------------------------Ordenado por apellido------------------------------------");

		Arrays.sort(personajes, new ComparadorApellido());

		for (Persona p : personajes)
			System.out.println(p.toString());

		System.out.println("--------------------------------Ordenado por nombre--------------------------------------");

		Arrays.sort(personajes, new ComparadorNombre());

		for (Persona p : personajes)
			System.out.println(p.toString());

		System.out.println("-----------------------------------------------------------------------------------------");

		System.out.println("--------------------------------EMPLEADOS------------------------------------------------");

		System.out.println("-----------------------------------------------------------------------------------------");

		Empleado[] empleados = { new Empleado(1128123, 2222.2, "carlos", "menem", 99),
				new Empleado(001, 0.2222, "fefe", "estefen", 22), new Empleado(007, 4206.9, "fafafa", "libre", 21) };

		System.out.println("Arreglo original");

		for (Empleado e : empleados)
			System.out.println(e.toString());

		System.out.println("--------------------------------Ordenado por edad--------------------------------------");

		Arrays.sort(empleados, new ComparadorEdad());

		for (Empleado p : empleados)
			System.out.println(p.toString());

		System.out.println("--------------------------------Ordenado por apellido------------------------------------");

		Arrays.sort(empleados, new ComparadorApellido());

		for (Empleado p : empleados)
			System.out.println(p.toString());

		System.out.println("--------------------------------Ordenado por nombre--------------------------------------");

		Arrays.sort(empleados, new ComparadorNombre());

		for (Empleado p : empleados)
			System.out.println(p.toString());

		System.out.println("--------------------------------Ordenado por sueldo--------------------------------------");

		Arrays.sort(empleados, new ComparadorSueldo());

		for (Empleado p : empleados)
			System.out.println(p.toString());

		System.out.println("--------------------------------Ordenado por legajo--------------------------------------");

		Arrays.sort(empleados, new ComparadorLegajo());

		for (Empleado p : empleados)
			System.out.println(p.toString());

	}

}
