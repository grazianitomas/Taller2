package niceland;

public enum EstadoSeccion {
	//CORRESPONDE A LAS SECCIONES DEL EDIFICIO
	SECCIÓN_INFERIOR, SECCIÓN_MEDIA, SECCIÓN_SUPERIOR;
	//TRANSFORMA LA SECCION DE ENUMERATIVO A ENTERO
	public int getSeccion(EstadoSeccion seccion) {
		if (seccion.equals(SECCIÓN_INFERIOR))
			return 0;
		else if (seccion.equals(SECCIÓN_MEDIA))
			return 1;
		else
			return 2;
	}
}
