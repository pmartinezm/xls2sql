package controller.comandos;

import controller.interfaces.IFiltros;
import util.SQL.GeneradorSQL;

public class ComandoCrearTablaCurso extends ComandoFiltro {

	public ComandoCrearTablaCurso() {
		super();
		this.nombre = "Crear tabla cursos";
	}

	@Override
	public String ejecutar(IFiltros filtro) {
		d.write("Ejecutando comando " + getClass().getSimpleName() + ".");
		return GeneradorSQL.crearTablaCursos();
	}
}
