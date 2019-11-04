package práctica6;

import java.util.Comparator;

public class Persona implements Comparator<Persona> {
	private String nombre;
	private String apellido;
	private Integer edad;

	public Persona() {

	}

	public Persona(String nombre, String apellido, int edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String toString() {
		return " " + this.nombre + ", " + this.apellido + ". " + this.edad + " años. ";
	}

	public int compare(Persona p1, Persona p2) {
		if (!(p1.getApellido().equals(p2.getApellido())))
			return p1.getApellido().compareTo(p2.getApellido());
		else
			return (p1.getNombre().compareTo(p2.getNombre()) + p1.getEdad().compareTo(p2.getEdad()));
	}

}
