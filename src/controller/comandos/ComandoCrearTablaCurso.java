package controller.comandos;

import controller.filtros.Filtros;
import util.SQL.GeneradorSQL;

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
