package util;

import java.util.ArrayList;

public class GeneradorSQL {
    public void crearTabla() {

    }

    public static String cursos() {
        StringBuilder sql = new StringBuilder();

        sql.append("create table if not exists curso (");

        sql.append("id integer primary key autoincrement not null, ");
        sql.append("nombre varchar not null default 'sin asignar'");

        sql.append(")");

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
}
