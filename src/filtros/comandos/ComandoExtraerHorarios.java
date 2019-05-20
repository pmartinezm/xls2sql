package filtros.comandos;

import filtros.Filtros;
import util.GeneradorSQL;

public class ComandoExtraerHorarios extends ComandoFiltro {

	public ComandoExtraerHorarios(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public String ejecutar(Filtros filtro) {
		Object extraerHorarios = filtro.extraerHorarios();
		return "";
	}

}
