package filtros;

import catalogador.SitioWeb;

public class FiltrarPorVisitas implements Filtrantes<Integer> {

	@Override
	public SitioWeb[] filtrar(SitioWeb[] s, Integer x) {
		int cantOcurrencias = 0;
		String posicion = null;
		for (int i = 0; i < s.length; i++) {
			if (s[i].getCantVisitas() >= x) {
				cantOcurrencias++;
				Integer num = i;
				posicion = posicion.concat(num.toString());
			}
		}

		SitioWeb[] sitios = new SitioWeb[cantOcurrencias];
		for (int i = 0; i < cantOcurrencias; i++) {
			sitios[i] = s[posicion.indexOf(i)];
		}

		return sitios;
	}

}
