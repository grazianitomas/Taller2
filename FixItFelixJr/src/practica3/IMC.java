package practica3;

public class IMC {
	private float peso;
	private float altura;

	public IMC(float peso, float altura) {
		super();
		this.peso = peso;
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float calculo() {
		return (peso / (altura * altura));
	}
	
	public float calculo(long altura, long peso) {
		return (peso / (altura * altura));	
	}
	
}
