package controller;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import modelo.Coordenada;
import util.Debug;

public class Buscador {
	private XSSFSheet sheet;
	private Debug debug = Debug.getDebug();

	public Buscador(XSSFSheet sheet) {
		this.sheet = sheet;
	}

	/**
	 * Busca el texto dentro de un rango.
	 *
	 * @param texto
	 *            el texto a buscar.
	 * @param rango
	 *            el rango en el que se va a buscar.
	 * @return las coordenadas de la coincidencia, null si no se ha encontrado.
	 */
	public Coordenada buscar(String texto, int rango) {
		this.debug.title("Buscando '" + texto + "' dentro del rango " + rango);
		for (int c = 0; c < rango; c++) {
			for (int r = 0; r < rango; r++) {
				Row fila = this.sheet.getRow(r);
				if (fila != null) {
					Cell celda = fila.getCell(c);
					if (celda != null) {
						String valor = celda.toString();

						if (valor.equalsIgnoreCase(texto)) {
							this.debug.entry("Encontrado en " + r + "-" + c);
							return new Coordenada(r, c);
						}
					}
				}
			}
		}
		this.debug.entryError("No se ha encontrado '" + texto + "'");
		return null;
	}
}
