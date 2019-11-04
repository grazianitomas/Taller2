package filtros;

import catalogador.SitioWeb;

public class FiltrarPorContenido implements Filtrantes<Integer> {

	@Override
	public SitioWeb[] filtrar(SitioWeb[] elem, Integer x) {
		String posicion = null;
		for (SitioWeb o : elem) {
			if (o.getEtiquetas().length >= x.intValue()) {

			}
		}
		return elem;
	}
}
