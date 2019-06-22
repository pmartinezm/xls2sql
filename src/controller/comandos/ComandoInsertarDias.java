package controller.comandos;

import java.util.ArrayList;

import controller.interfaces.IFiltros;
import util.SQL.GeneradorSQL;

public class ComandoInsertarDias extends ComandoFiltro {

	public ComandoInsertarDias() {
		super();
		this.nombre = "Insertar d�as";
	}

	@Override
	public String ejecutar(IFiltros filtro) {
		d.write("Ejecutando comando " + getClass().getSimpleName() + ".");
		ArrayList<String> dias = new ArrayList<>();
		
		dias.add("Lunes");
		dias.add("Martes");
		dias.add("Mi�rcoles");
		dias.add("Jueves");
		dias.add("Viernes");
		
		return GeneradorSQL.insertarDia(dias);
	}

}
