package controller.comandos;

import controller.database.DBController;
import controller.gestor.GestorArchivoXLS;
import controller.interfaces.IFiltros;
import util.SQL.GeneradorSQL;

public class ComandoCreandoUnFiltro extends ComandoFiltro {
	
	public ComandoCreandoUnFiltro() {
		super();
		this.nombre = "Creando un filtro";
	}
	
	@Override
	public String ejecutar(IFiltros filtro) {
		d.write("Ejecutando comando " + getClass().getSimpleName() + ".");
		String res = filtro.creandoUnFiltro();
		return GeneradorSQL.comentar(res);
	}

}
