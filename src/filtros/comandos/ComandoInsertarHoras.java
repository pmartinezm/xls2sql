package filtros.comandos;

import java.util.ArrayList;

import filtros.Filtros;
import modelo.horario.Horario;
import util.SQL.GeneradorSQL;

public class ComandoInsertarHoras extends ComandoFiltro {

	public ComandoInsertarHoras() {
		super();
		this.nombre = "Insertar horas";
	}

	@Override
	public String ejecutar(Filtros filtro) {
		ArrayList<String> dias = new ArrayList<>();
		
		dias.add("Lunes");
		dias.add("Martes");
		dias.add("Miércoles");
		dias.add("Jueves");
		dias.add("Viernes");
		
		return GeneradorSQL.insertarDia(dias);
	}

}
