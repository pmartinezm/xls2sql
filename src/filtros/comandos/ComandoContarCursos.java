package filtros.comandos;

import filtros.Filtros;
import util.GeneradorSQL;

public class ComandoContarCursos extends ComandoFiltro {

	public ComandoContarCursos(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public String ejecutar(Filtros filtro) {
		int res = filtro.contarCursos();
		String out = GeneradorSQL.comentar(res + " cursos encontrados.");
		return out;
	}
}
