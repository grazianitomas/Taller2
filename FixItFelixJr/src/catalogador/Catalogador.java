package catalogador;

import catalogador.SitioWeb;
import filtros.Filtrantes;
import filtros.Filtros;
import ordenadores.Ordenadores;

public class Catalogador {

	public Catalogo obtenerCatalogo(SitioWeb[] sitios, Filtrantes filtro, Ordenadores orden) {
		
		
				
		
		return null;
	}

	private SitioWeb[] filtrar(SitioWeb[] s, Filtros f) {
		return f.porContenido(s, 2);
	}

}
