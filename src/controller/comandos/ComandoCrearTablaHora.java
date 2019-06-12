package controller.comandos;

import controller.filtros.Filtros;
import util.SQL.GeneradorSQL;

public class ComandoCrearTablaHora extends ComandoFiltro {

	public ComandoCrearTablaHora() {
		super();
		this.nombre = "Crear tabla hora";
	}

	@Override
	public String ejecutar(Filtros filtro) {
		return GeneradorSQL.crearTablaHora();
	}
}
