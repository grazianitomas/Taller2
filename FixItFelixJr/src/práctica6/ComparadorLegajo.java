package práctica6;

import java.util.Comparator;

public class ComparadorLegajo implements Comparator<Empleado> {
	public int compare(Empleado e1, Empleado e2) {
		return (int) (e1.getLegajo() - e2.getLegajo());
	}
}
