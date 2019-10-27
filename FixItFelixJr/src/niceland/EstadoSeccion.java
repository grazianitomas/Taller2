package niceland;

public enum EstadoSeccion {
	//CORRESPONDE A LAS SECCIONES DEL EDIFICIO
	SECCION_INFERIOR, SECCION_MEDIA, SECCION_SUPERIOR;
	//TRANSFORMA LA SECCION DE ENUMERATIVO A ENTERO
	public int getSeccion(EstadoSeccion seccion) {
		if (seccion.equals(SECCION_INFERIOR))
			return 0;
		else if (seccion.equals(SECCION_MEDIA))
			return 1;
		else
			return 2;
	}
}
