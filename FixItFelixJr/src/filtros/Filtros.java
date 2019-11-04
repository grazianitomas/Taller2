package filtros;

import catalogador.SitioWeb;
import java.util.ArrayList;

public class Filtros implements Filtrantes {

	public SitioWeb[] porEtiqueta(SitioWeb[] elem, String x) {
		ArrayList<SitioWeb> aux = new ArrayList<SitioWeb>();
		for (SitioWeb o : elem) {
			for (int i = 0; i < o.getEtiquetas().length; i++)
				if (o.getEtiquetas()[i].equals(x))
					aux.add(o);
		}
		return (SitioWeb[]) aux.toArray();
	}

	@Override
	public SitioWeb[] porVisitas(SitioWeb[] elem, int x) {
		ArrayList<SitioWeb> aux = new ArrayList<SitioWeb>();
		for (SitioWeb o : elem) {
			if (o.getCantVisitas() >= x)
				aux.add(o);
		}
		return (SitioWeb[]) aux.toArray();
	}

	@Override
	public SitioWeb[] porContenido(SitioWeb[] elem, int x) {
		ArrayList<SitioWeb> aux = new ArrayList<SitioWeb>();
		for (SitioWeb o : elem) {
			if (o.getEtiquetas().length >= x)
				aux.add(o);
		}
		return (SitioWeb[]) aux.toArray();
	}

}
