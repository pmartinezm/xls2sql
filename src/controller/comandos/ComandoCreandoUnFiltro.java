package controller.comandos;

import controller.filtros.Filtros;
import util.SQL.GeneradorSQL;

public class ComandoCreandoUnFiltro extends ComandoFiltro {
	
	public ComandoCreandoUnFiltro() {
		super();
		this.nombre = "Creando un filtro";
	}
	
	@Override
	public String ejecutar(Filtros filtro) {
		filtro.creandoUnFiltro();
		return GeneradorSQL.comentar("Creando un filtro");
	}

}