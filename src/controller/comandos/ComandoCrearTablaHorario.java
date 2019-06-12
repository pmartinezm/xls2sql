package controller.comandos;

import controller.filtros.Filtros;
import util.SQL.GeneradorSQL;

public class ComandoCrearTablaHorario extends ComandoFiltro {

	public ComandoCrearTablaHorario() {
		super();
		this.nombre = "Crear tabla horario";
	}

	@Override
	public String ejecutar(Filtros filtro) {
		return GeneradorSQL.crearTablaHorario();
	}
}
