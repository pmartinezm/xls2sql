package modelo.filtros;

import java.util.ArrayList;

import modelo.Filtro;
import util.GeneradorSQL;

public class ComandoExtraerCursos extends ComandoFiltro {

	public ComandoExtraerCursos(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public void ejecutar(Filtro filtro) {
		filtro.contarCursos();
		filtro.extraerCursos();
		int numeroCursos = filtro.getCursosCounter();
		ArrayList<String> cursos = filtro.getCursos();
		
		StringBuilder out = new StringBuilder();
		out.append("/* ");
		out.append("Exportación de cursos: ");
		out.append(numeroCursos + " cursos encontrados. ");
		out.append("*/\n\n");
		out.append(GeneradorSQL.insertarCurso(cursos));
		
		this.resultados = out.toString();
	}

}
