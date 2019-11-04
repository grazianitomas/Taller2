package catalogador;

public class Catalogo {

	private SitioWeb[] catalogo;

	public Catalogo(SitioWeb[] s) {
		this.catalogo = s;
	}

	public Catalogo() {

	}

	public void setCatalogo(SitioWeb[] s) {
		this.catalogo = s;
	}

	public SitioWeb[] getCatalogo() {
		return this.catalogo;
	}

}
