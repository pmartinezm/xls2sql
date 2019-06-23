package controller.movimiento;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import modelo.Coordenada;
import util.Debug;

public class Posicionador {
	private XSSFSheet sheet;
	private Debug d = Debug.getDebug();

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
		this.d.title("Obtener siguiente fila");
		int max = this.sheet.getLastRowNum();
		this.d.entry("Max: " + max);
		r++;
		while (r <= max) {
			this.d.write("R: " + r + ". R <= Max?: " + (r<=max));
			Row row = this.sheet.getRow(r);
			if (row == null) {
				this.d.entry("Fila null. Siguiente fila");
				r++;
			} else {
				this.d.entry("Obteniendo celda.");
				Cell cell = row.getCell(c);
				if (cell != null) {
					this.d.entry("Retornando fila.");
					return r;
				} else {
					this.d.entry("Siguiente fila.");
					r++;
				}
			}
		}
		this.d.entry("No hay siguiente fila");
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
		this.d.title("Obtener siguiente columna");
		Row row = this.sheet.getRow(r);
		int max = row.getLastCellNum();
		this.d.write("Max: " + max);
		c++;
		while (c <= max) {
			Cell cell = row.getCell(c);
			if (cell == null || cell.toString().length() == 0) {
				this.d.write("Siguiente columna");
				c++;
			} else {
				this.d.write("Retornando columna");
				return c;
			}
		}
		this.d.write("No hay siguiente columna");
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
