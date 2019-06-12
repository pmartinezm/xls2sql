package controller.filtros.comandos;

import controller.filtros.Filtros;
import util.SQL.GeneradorSQL;

public class ComandoCrearTablaDia extends ComandoFiltro {

	public ComandoCrearTablaDia() {
		super();
		this.nombre = "Crear tabla dia";
	}

	@Override
	public String ejecutar(Filtros filtro) {
		return GeneradorSQL.crearTablaDia();
	}
}
