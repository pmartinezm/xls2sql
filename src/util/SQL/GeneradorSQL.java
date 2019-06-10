package util.SQL;

import java.util.ArrayList;

import modelo.horario.Asignatura;
import modelo.horario.Dia;
import modelo.horario.Hora;
import modelo.horario.Horario;

public class GeneradorSQL {
	public static String comentar(String msg) {
		return "/* " + msg + " */\n";
	}

	public static String crearTablaDia() {
		StringBuilder sql = new StringBuilder();
		sql.append("create table 'dia' (");

		sql.append("'id' integer primary key autoincrement,");
		sql.append("'nombre' VARCHAR(50)");

		sql.append(");");

		return sql.toString();
	}

	public static String insertarDia(ArrayList<String> dias) {
		StringBuilder out = new StringBuilder();
		int last = dias.size();
		
		out.append("insert into dia (nombre) values ('");
		
		int c = 0;
		for (String dia : dias) {
			out.append(dia);
			
			if(c != last) {
				out.append("'), ('");
			}
		}
		
		out.append("');");
		
		return out.toString();
	}
	
	public static String crearTablaHora() {
		StringBuilder sql = new StringBuilder();
		
		sql.append("create table 'hora' (");

		sql.append("'id' integer primary key autoincrement,");
		sql.append("'tramo' VARCHAR(50)");

		sql.append(");");
		
		return sql.toString();
	}
	
	public static String insertarHora(ArrayList<String> horas) {
		StringBuilder out = new StringBuilder();
		int last = horas.size();
		
		out.append("insert into hora (tramo) values ('");
		
		int c = 0;
		for (String hora : horas) {
			out.append(hora);
			
			if(c != last) {
				out.append("'), ('");
			}
		}
		
		out.append("');");
		
		return out.toString();
	}

	public static String crearTablaHorario() {
		StringBuilder sql = new StringBuilder();
		sql.append("CREATE TABLE horario (");

		sql.append("idDia INTEGER, ");
		sql.append("idHora INTEGER, ");
		sql.append("idCurso INTEGER, ");
		sql.append("asignatura VARCHAR (100)");

		sql.append(");");

		return sql.toString();
	}

	public static String insertarCurso(String nombre) {
		StringBuilder sql = new StringBuilder();

		sql.append("insert into curso (");
		sql.append("nombre) values ('");
		sql.append(nombre);
		sql.append("');");

		return sql.toString();
	}

	public static String insertarCurso(ArrayList<String> nombres) {
		StringBuilder sql = new StringBuilder();

		sql.append("insert into curso (");
		sql.append("nombre) values ");

		for (int i = 0; i < nombres.size(); i++) {
			String nombre = nombres.get(i);
			sql.append("('" + nombre + "')");

			if (i < nombres.size() - 1) {
				sql.append(", ");
			}
		}

		return sql.toString();
	}

	public static String crearTablaCursos() {
		StringBuilder sql = new StringBuilder();

		sql.append("create table if not exists curso (");

		sql.append("id integer primary key autoincrement not null, ");
		sql.append("nombre varchar not null default 'sin asignar'");

		sql.append(")");

		return sql.toString();
	}

	public static String insertarHorario(ArrayList<Horario> horarios) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into horario (idDia, idHora, idCurso, asignatura) values (");
		int cCurso = 0, cDia = 0, cHora = 0;
		for (Horario horario : horarios) {
			cDia = 0;
			cCurso++;
			for (Dia dia : horario.getDias()) {
				cHora = 0;
				cDia++;
				for (Hora hora : dia.getHoras()) {
					cHora++;
					for (Asignatura asignatura : hora.getAsignaturas()) {
						sql.append(cDia + ", " + cHora + ", " + cCurso + ", '" + asignatura);

						boolean last = isLastEntry(cCurso, cDia, cHora, horarios.size(), horario.getDias().size(),
								dia.getHoras().size());
						if (!last) {
							sql.append("'), (");
						}
					}
				}
			}
		}
		sql.append("');");
		return sql.toString();
	}

	private static boolean isLastEntry(int currentCurso, int currentDia, int currentHora, int lastCurso, int lastDia,
			int lastHora) {
		return currentCurso == lastCurso && currentDia == lastDia && currentHora == lastHora;
	}
}
