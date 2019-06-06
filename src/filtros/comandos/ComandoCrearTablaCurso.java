package filtros.comandos;

import filtros.Filtros;
import util.GeneradorSQL;

public class ComandoCrearTablaCurso extends ComandoFiltro {

	public ComandoCrearTablaCurso() {
		super();
		this.nombre = "Crear tabla cursos";
	}

	@Override
	public String ejecutar(Filtros filtro) {
		return GeneradorSQL.crearTablaCursos();
	}
}
