package filtros.comandos;

import filtros.Filtros;
import util.GeneradorSQL;

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
