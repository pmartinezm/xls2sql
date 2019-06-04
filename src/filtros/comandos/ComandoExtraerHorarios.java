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
		GeneradorSQL g = new GeneradorSQL();
		StringBuilder out = new StringBuilder();
		
		out.append(g.comentar("Extracción de horarios"));
		
		
		
		return out.toString();
	}

}
