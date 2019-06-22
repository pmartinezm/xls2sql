package controller.comandos;

import controller.interfaces.IFiltros;
import util.SQL.GeneradorSQL;

public class ComandoCrearTablaHorario extends ComandoFiltro {

	public ComandoCrearTablaHorario() {
		super();
		this.nombre = "Crear tabla horario";
	}

	@Override
	public String ejecutar(IFiltros filtro) {
		d.write("Ejecutando comando " + getClass().getSimpleName() + ".");
		return GeneradorSQL.crearTablaHorario();
	}
}
