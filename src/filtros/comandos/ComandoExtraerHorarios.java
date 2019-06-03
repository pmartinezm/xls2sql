package filtros.comandos;

import filtros.Filtros;

public class ComandoExtraerHorarios extends ComandoFiltro {

	public ComandoExtraerHorarios() {
		super();
		this.nombre = "Extraer horarios";
	}

	@Override
	public String ejecutar(Filtros filtro) {
		Object extraerHorarios = filtro.extraerHorarios();
		return "";
	}

}
