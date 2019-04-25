package modelo.comando.filtros;

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
		filtro.extraerCursos();
		ArrayList<String> cursos = filtro.getCursos();
		this.resultados = GeneradorSQL.insertarCurso(cursos);
	}

}
