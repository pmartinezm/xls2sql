package controller.movimiento;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import modelo.Coordenada;
import util.Debug;

public class Posicionador {
	private XSSFSheet sheet;
	private Debug debug = Debug.getDebug();

	public Posicionador(XSSFSheet sheet) {
		this.sheet = sheet;
	}

	/**
	 * Obtiene la siguiente fila no vacía según la posición actual.
	 *
	 * @param r
	 *            fila actual.
	 * @param c
	 *            columna actual.
	 * @return la siguiente fila.
	 */
	public int getSiguienteFila(int r, int c) {
		this.debug.title("Obtener siguiente fila (getSiguienteFila)");
		int max = this.sheet.getLastRowNum();
		this.debug.entry("Max: " + max);
		r++;
		while (r <= max) {
			this.debug.write("R: " + r + ". R <= Max?: " + (r<=max));
			Row row = this.sheet.getRow(r);
			if (row == null) {
				this.debug.entry("Fila es null. Incrementando r.");
				r++;
			} else {
				this.debug.entry("Fila no null. Obteniendo celda.");
				Cell cell = row.getCell(c);
				if (cell != null) {
					this.debug.entry("Celda no null. Retornando r.");
					return r;
				} else {
					this.debug.entry("Celda null. Incrementando r.");
					r++;
				}
			}
		}
		this.debug.entry("R <= Max. Retornando -1.");
		return -1;
	}

	/**
	 * Obtiene la siguiente fila no vacía según la posición actual.
	 * @param coordenadas
	 * @return coordenadas de la siguiente fila
	 */
	public Coordenada getSiguienteFila(Coordenada coordenadas) {
		int r = this.getSiguienteFila(coordenadas.r, coordenadas.c);
		return new Coordenada(r, coordenadas.c);
	}

	/**
	 * Obtiene la siguiente columna no vacía según la posición actual.
	 *
	 * @param r
	 *            fila actual.
	 * @param c
	 *            columna actual.
	 * @return posición de la columna.
	 */
	public int getSiguienteColumna(int r, int c) {
		this.debug.title("GetSiguienteColumna");
		Row row = this.sheet.getRow(r);
		int max = row.getLastCellNum();
		this.debug.write("Max: " + max);
		c++;
		while (c <= max) {
			this.debug.write("C: " + c + ". C <= Max?: " + (c<=max));
			Cell cell = row.getCell(c);
			if (cell == null || cell.toString().length() == 0) {
				this.debug.write("Cell is null or empty. Incrementing C.");
				c++;
			} else {
				this.debug.write("Cell is not null or empty. Returning C.");
				return c;
			}
		}
		this.debug.write("C <= Max. Returning -1.");
		this.debug.title("End of GetSiguienteColumna");
		return -1;
	}

	/**
	 * Obtiene la siguiente columna no vacía según la posición actual.
	 * @param coordenadas
	 * @return coordenadas de la siguiente columna
	 */
	public Coordenada getSiguienteColumna(Coordenada coordenadas) {
		int c = this.getSiguienteColumna(coordenadas.r, coordenadas.c);
		return new Coordenada(coordenadas.r, c);
	}
}
