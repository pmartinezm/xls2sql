package filtros.comandos;

import filtros.Filtros;
import util.SQL.GeneradorSQL;

public class ComandoContarHorarios extends ComandoFiltro {
	public ComandoContarHorarios() {
		super();
		this.nombre = "Contar horarios";
	}

	@Override
	public String ejecutar(Filtros filtro) {
		int res = filtro.contarHorarios();
		return GeneradorSQL.comentar(res + " horarios encontrados.");
	}

}
