package controller.filtros.comandos;

import java.util.ArrayList;

import controller.filtros.Filtros;
import util.SQL.GeneradorSQL;

public class ComandoExtraerCursos extends ComandoFiltro {

	public ComandoExtraerCursos() {
		super();
		this.nombre = "Extraer cursos";
	}

	@Override
	public String ejecutar(Filtros filtro) {
		ArrayList<String> cursos = filtro.extraerCursos();
		StringBuilder out = new StringBuilder();

		out.append(GeneradorSQL.comentar("Extracción de cursos"));
		out.append(GeneradorSQL.insertarCurso(cursos));

		return out.toString();
	}
}
