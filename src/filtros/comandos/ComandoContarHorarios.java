package filtros.comandos;

import filtros.Filtros;
import util.GeneradorSQL;

public class ComandoContarHorarios extends ComandoFiltro {
	public ComandoContarHorarios(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public String ejecutar(Filtros filtro) {
		int res = filtro.contarHorarios();
		return GeneradorSQL.comentar(res + " horarios encontrados.");
	}

}
