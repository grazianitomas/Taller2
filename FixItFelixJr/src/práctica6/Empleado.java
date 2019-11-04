package práctica6;

public class Empleado extends Persona {
	private long legajo;
	private double sueldo;

	public Empleado() {
	}

	public Empleado(long legajo, double sueldo) {
		super();
		this.legajo = legajo;
		this.sueldo = sueldo;
	}

	public Empleado(long legajo, double sueldo, String nombre, String apellido, int edad) {
		super(nombre, apellido, edad);
		this.legajo = legajo;
		this.sueldo = sueldo;
	}

	public long getLegajo() {
		return legajo;
	}

	public void setLegajo(long legajo) {
		this.legajo = legajo;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public int compare(Empleado e1, Empleado e2) {
		if (super.compare(e1, e2) != 0)
			return super.compare(e1, e2);
		else
			return super.compare(e1, e1) + (int) (e1.getSueldo() - e2.getSueldo());
	}

	public String toString() {
		return super.toString() + "Legajo: " + this.getLegajo() + ". Sueldo: " + this.getSueldo();
	}

}
