package controller.comandos;

import java.util.ArrayList;

import controller.interfaces.IFiltros;
import util.SQL.GeneradorSQL;

public class ComandoExtraerCursos extends ComandoFiltro {

	public ComandoExtraerCursos() {
		super();
		this.nombre = "Extraer cursos";
	}

	@Override
	public String ejecutar(IFiltros filtro) {
		ArrayList<String> cursos = filtro.extraerCursos();
		ArrayList<String> tutores = filtro.extraerTutores();
		StringBuilder out = new StringBuilder();

		out.append(GeneradorSQL.comentar("Extracción de cursos"));
		out.append(GeneradorSQL.insertarCurso(cursos, tutores));

		return out.toString();
	}
}
