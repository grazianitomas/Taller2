package práctica6;

import java.util.Comparator;

public class ComparadorNombre implements Comparator<Persona> {
	public int compare(Persona p1, Persona p2) {
		return p1.getNombre().compareTo(p2.getNombre());
	}
}
