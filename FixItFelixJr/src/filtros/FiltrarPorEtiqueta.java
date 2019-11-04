package filtros;

import java.util.ArrayList;

import catalogador.SitioWeb;

public class FiltrarPorEtiqueta implements Filtrantes{
	
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
	public SitioWeb[] porContenido(SitioWeb[] elem, int x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SitioWeb[] porVisitas(SitioWeb[] elem, int x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SitioWeb[] filtrar(SitioWeb[] elem, Object cosa) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
