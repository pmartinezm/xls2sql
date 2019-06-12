package controller;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import util.Debug;

public class DBController {
	private String path;
	private String base = "jdbc:sqlite:";
	private String url;
	private Connection connection;
	Debug d = Debug.getDebug();

	public DBController(String path) {
		this.path = path;
		this.url = this.base + this.path;
		checkFile();
		testConnection();
	}

	/**
	 * Comprueba si el fichero de salida para la base de datos de SQLite (*.db)
	 * existe. Si no existe, intentará crearlo.
	 */
	private void checkFile() {
		File file = new File(this.path);
		if (!file.exists()) {
			this.d.write("Arhivo de DB no encontrado. Intentando crearlo...");
			try {
				if (file.createNewFile()) {
					this.d.write("Archivo de DB creado");
				}
			} catch (IOException e) {
				this.d.error("Error creando el archivo de BD");
				e.printStackTrace();
			}
		} else {
			this.d.write("Archivo de BD encontrado");
		}
	}

	/**
	 * Envía una query a la base de datos.
	 * @param query
	 */
	public void sendQuery(String query) {
		try {
			getConnection();
			Statement s = this.connection.createStatement();
			s.execute(query);
		} catch (SQLException e) {
			this.d.error("Error de SQL.");
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	/**
	 * Comprueba la conexión con la base de datos.
	 */
	private void testConnection() {
		this.d.write("Probando la conexión: " + this.url);
		getConnection();
	}

	/**
	 * Obtiene la conexión con la base de datos.
	 */
	private void getConnection() {
		try {
			this.connection = DriverManager.getConnection(this.url);
			this.d.write("Conexión JDBC: ok.");

		} catch (SQLException e) {
			d.error("Conexión JDBC: error");
		}
	}

	/**
	 * Cierra la conexión con la base de datos.
	 */
	private void closeConnection() {
		if (this.connection != null) {
			try {
				this.connection.close();
				this.d.write("Conexión cerrada");
			} catch (SQLException e) {
				this.d.error("Error al cerrar la conexión");
				e.printStackTrace();
			}
		}
	}
}
