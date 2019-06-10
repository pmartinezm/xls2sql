package filtros.comandos;

import filtros.Filtros;
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
