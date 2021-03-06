package controller.comandos;

import java.util.ArrayList;

import controller.interfaces.IFiltros;
import modelo.horario.Horario;
import util.SQL.GeneradorSQL;

public class ComandoExtraerHorarios extends ComandoFiltro {

	public ComandoExtraerHorarios() {
		super();
		this.nombre = "Extraer horarios";
	}

	@Override
	public String ejecutar(IFiltros filtro) {
		d.write("Ejecutando comando " + getClass().getSimpleName() + ".");
		ArrayList<Horario> extraerHorarios = filtro.extraerHorarios();
		StringBuilder out = new StringBuilder();
		
		out.append(GeneradorSQL.comentar("Extracción de horarios"));
		out.append(GeneradorSQL.comentar(extraerHorarios.size() + " encontrados"));
		
		out.append(GeneradorSQL.insertarHorario(extraerHorarios));
		
		return out.toString();
	}

}
