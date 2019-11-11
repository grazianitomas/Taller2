package niceland;

public enum EstadoSeccion {
	/*
	 * CORRESPONDE A LAS SECCIONES DEL EDIFICIO
	 */
	SECCION_INFERIOR, SECCION_MEDIA, SECCION_SUPERIOR;

	/*
	 * TRANSFORMA LA SECCION DE ENUMERATIVO A UN NUMERO ENTERO
	 */
	public int getSeccionNum(EstadoSeccion seccion) {
		if (seccion.equals(SECCION_INFERIOR))
			return 0;
		else if (seccion.equals(SECCION_MEDIA))
			return 1;
		else
			return 2;
	}

	/**
	 * Retorna la seccion correspondiente al número pasado por parámetro
	 * 
	 * @param n sección pasada
	 * @return sección requerida
	 */
	public EstadoSeccion getSeccionEnum(int n) {
		if (n == 0) {
			return SECCION_INFERIOR;
		} else {
			if (n == 1)
				return SECCION_MEDIA;
			else if (n == 2)
				return SECCION_SUPERIOR;
		}
		return null;
	}

	/**
	 * Retorna la proxima sección
	 * 
	 * @return
	 */
	public EstadoSeccion proxSeccion() {
		if (this.equals(SECCION_INFERIOR)) {
			return SECCION_MEDIA;
		} else if (this.equals(SECCION_MEDIA))
			return SECCION_SUPERIOR;
		else
			return SECCION_INFERIOR;
	}

}
