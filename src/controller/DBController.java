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

	private void checkFile() {
		File file = new File(this.path);
		if (!file.exists()) {
			this.d.write("DB file not found. Atempting to create it...");
			try {
				if (file.createNewFile()) {
					this.d.write("DB file created.");
				}
			} catch (IOException e) {
				this.d.error("Error creating DB file.");
				e.printStackTrace();
			}
		} else {
			this.d.write("DB file found.");
		}
	}

	public void sendQuery(String query) {
		try {
			getConnection();
			Statement s = this.connection.createStatement();
			s.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	private void testConnection() {
		this.d.write("Testing connection " + this.url);
		getConnection();
	}

	private void getConnection() {
		try {
			this.connection = DriverManager.getConnection(this.url);
			this.d.write("JDBC connection: ok.");

		} catch (SQLException e) {
			d.error("JDBC connection: error.");
		}
	}

	private void closeConnection() {
		if (this.connection != null) {
			try {
				this.connection.close();
				this.d.write("Connection closed.");
			} catch (SQLException e) {
				this.d.error("Error closing connection.");
				e.printStackTrace();
			}
		}
	}
}
