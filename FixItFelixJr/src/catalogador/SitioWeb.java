package catalogador;

public class SitioWeb {

	public SitioWeb(String direccionWeb, int cantVisitas, int fechaCreacion, String[] etiquetas) {
		super();
		this.direccionWeb = direccionWeb;
		this.cantVisitas = cantVisitas;
		this.fechaCreacion = fechaCreacion;
		this.etiquetas = etiquetas;
	}

	public SitioWeb() {

	}

	private String direccionWeb;
	private int cantVisitas;
	private int fechaCreacion;
	private String[] etiquetas;

	public String getDireccionWeb() {
		return direccionWeb;
	}

	public void setDireccionWeb(String direccionWeb) {
		this.direccionWeb = direccionWeb;
	}

	public int getCantVisitas() {
		return cantVisitas;
	}

	public void setCantVisitas(int cantVisitas) {
		this.cantVisitas = cantVisitas;
	}

	public int getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(int fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String[] getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(String[] etiquetas) {
		this.etiquetas = etiquetas;
	}

}
