package individuos;

public enum DireccionFelix {
	/**
	 * Direcciones a los que Felix podria ir
	 */
	ARRIBA, DERECHA, ABAJO, IZQUIERDA, QUIETO;
	
	/**
	 * Retorna la direccion opuesta a la que quiere ir Felix
	 * @param direc direccion a la que quiere ir
	 * @return direccion opuesta
	 */
	public DireccionFelix direccionInvertida(DireccionFelix direc) {
		switch (direc) {
		case ARRIBA: {
			return DireccionFelix.ABAJO;
		}
		case ABAJO: {
			return DireccionFelix.ARRIBA;
		}
		case IZQUIERDA: {
			return DireccionFelix.DERECHA;
		}
		case DERECHA: {
			return DireccionFelix.IZQUIERDA;
		}
		case QUIETO:
		}
		return DireccionFelix.QUIETO;
	}
}
