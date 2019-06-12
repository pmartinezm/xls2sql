package controller.comandos;

import java.util.ArrayList;

import controller.filtros.Filtros;
import modelo.horario.Horario;
import util.SQL.GeneradorSQL;

public class ComandoInsertarDias extends ComandoFiltro {

	public ComandoInsertarDias() {
		super();
		this.nombre = "Insertar días";
	}

	@Override
	public String ejecutar(Filtros filtro) {
		ArrayList<String> horas = new ArrayList<>();

		horas.add("8:10 - 9:05");
		horas.add("9:05 - 10:00");
		horas.add("10:00 - 10:55");
		horas.add("11:25 - 12:20");
		horas.add("12:20 - 13:15");
		horas.add("13:15 - 14:10");

		return GeneradorSQL.insertarHora(horas);
	}

}
