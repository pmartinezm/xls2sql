package controller.comandos;

import controller.interfaces.IFiltros;
import util.SQL.GeneradorSQL;

public class ComandoCrearTablaDia extends ComandoFiltro {

	public ComandoCrearTablaDia() {
		super();
		this.nombre = "Crear tabla dia";
	}

	@Override
	public String ejecutar(IFiltros filtro) {
		d.write("Ejecutando comando " + getClass().getSimpleName() + ".");
		return GeneradorSQL.crearTablaDia();
	}
}
