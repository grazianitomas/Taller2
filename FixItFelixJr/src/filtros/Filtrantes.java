package filtros;

import catalogador.SitioWeb;

public interface Filtrantes <T>{

	public SitioWeb[] filtrar(SitioWeb[] elem, T cosa);

}
