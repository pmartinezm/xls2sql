package filtros.comandos;

import java.util.ArrayList;

import filtros.Filtros;
import modelo.horario.Horario;
import util.GeneradorSQL;

public class ComandoExtraerHorarios extends ComandoFiltro {

	public ComandoExtraerHorarios() {
		super();
		this.nombre = "Extraer horarios";
	}

	@Override
	public String ejecutar(Filtros filtro) {
		ArrayList<Horario> extraerHorarios = filtro.extraerHorarios();
		StringBuilder out = new StringBuilder();
		
		out.append(GeneradorSQL.comentar("Extracción de horarios"));
		out.append(GeneradorSQL.comentar(extraerHorarios.size() + " encontrados"));
		
		out.append(GeneradorSQL.insertarHorario(extraerHorarios));
		
		return out.toString();
	}

}
