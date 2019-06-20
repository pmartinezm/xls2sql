package controller.comandos;

import controller.interfaces.IFiltros;
import util.SQL.GeneradorSQL;

public class ComandoCrearTablaHora extends ComandoFiltro {

	public ComandoCrearTablaHora() {
		super();
		this.nombre = "Crear tabla hora";
	}

	@Override
	public String ejecutar(IFiltros filtro) {
		return GeneradorSQL.crearTablaHora();
	}
}
