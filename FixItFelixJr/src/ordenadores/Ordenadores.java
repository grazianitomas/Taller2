package ordenadores;

import java.util.Comparator;

import catalogador.SitioWeb;

public class Ordenadores {

	public int porFecha(SitioWeb a, SitioWeb b) {
		return new OrdenPorFecha().compare(a, b);
	}

	private class OrdenPorFecha implements Comparator<SitioWeb> {
		public int compare(SitioWeb a, SitioWeb b) {
			return a.getFechaCreacion() - b.getFechaCreacion();
		}
	}

	public int porEtiqueta(SitioWeb a, SitioWeb b) {
		return new OrdenPorEtiquetas().compare(a, b);
	}

	private class OrdenPorEtiquetas implements Comparator<SitioWeb> {
		public int compare(SitioWeb a, SitioWeb b) {
			return a.getEtiquetas().length - b.getEtiquetas().length;
		}
	}

}
