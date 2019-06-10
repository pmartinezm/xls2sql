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

	public static String crearTablaCursos() {
		StringBuilder sql = new StringBuilder();

		sql.append("create table if not exists curso (");

		sql.append("id integer primary key autoincrement not null, ");
		sql.append("nombre varchar not null default 'sin asignar'");

		sql.append(")");

		return sql.toString();
	}
	
	public static String crearTablaDia() {
		return "CREATE TABLE 'dia' ('id' INT(11) NOT NULL AUTO_INCREMENT, 'nombre' VARCHAR(50));";
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

	public static String crearTablaHorario() {
		StringBuilder sql = new StringBuilder();
		sql.append("CREATE TABLE horario (");

		sql.append("idDia INTEGER (11),");
		sql.append(" idHora INTEGER (11),");
		sql.append("idCurso INTEGER (11),");
		sql.append("asignatura VARCHAR (100)");

		sql.append(");");

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
