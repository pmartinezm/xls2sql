package filtros.comandos;

import filtros.Filtros;
import util.SQL.GeneradorSQL;

public class ComandoContarCursos extends ComandoFiltro {

	public ComandoContarCursos() {
		super();
		this.nombre = "Contar cursos";
	}

	@Override
	public String ejecutar(Filtros filtro) {
		int res = filtro.contarCursos();
		String out = GeneradorSQL.comentar(res + " cursos encontrados.");
		return out;
	}
}
