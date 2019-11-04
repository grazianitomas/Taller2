package práctica6;

import java.util.Comparator;

public class ComparadorSueldo implements Comparator<Empleado> {

	public int compare(Empleado e1, Empleado e2) {
		return (int) (e1.getSueldo() - e2.getSueldo());
	}
}
