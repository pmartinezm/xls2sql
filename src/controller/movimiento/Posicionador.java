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
		this.d.title("Obtener siguiente fila (getSiguienteFila)");
		int max = this.sheet.getLastRowNum();
		this.d.entry("Max: " + max);
		r++;
		while (r <= max) {
			this.d.write("R: " + r + ". R <= Max?: " + (r<=max));
			Row row = this.sheet.getRow(r);
			if (row == null) {
				this.d.entry("Fila es null. Incrementando r.");
				r++;
			} else {
				this.d.entry("Fila no null. Obteniendo celda.");
				Cell cell = row.getCell(c);
				if (cell != null) {
					this.d.entry("Celda no null. Retornando r.");
					return r;
				} else {
					this.d.entry("Celda null. Incrementando r.");
					r++;
				}
			}
		}
		this.d.entry("R <= Max. Retornando -1.");
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
		this.d.title("GetSiguienteColumna");
		Row row = this.sheet.getRow(r);
		int max = row.getLastCellNum();
		this.d.write("Max: " + max);
		c++;
		while (c <= max) {
			this.d.write("C: " + c + ". C <= Max?: " + (c<=max));
			Cell cell = row.getCell(c);
			if (cell == null || cell.toString().length() == 0) {
				this.d.write("Cell is null or empty. Incrementing C.");
				c++;
			} else {
				this.d.write("Cell is not null or empty. Returning C.");
				return c;
			}
		}
		this.d.write("C <= Max. Returning -1.");
		this.d.title("End of GetSiguienteColumna");
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
