package util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Posicionador {
    private XSSFSheet sheet;

    public Posicionador(XSSFSheet sheet) {
        this.sheet = sheet;
    }

    /**
     * Obtiene la siguiente fila no vacía según la posición actual.
     *
     * @param r fila actual.
     * @param c columna actual.
     * @return la siguiente fila.
     */
    public int getSiguienteFila(int r, int c) {
        int max = this.sheet.getLastRowNum();
        r++;
        while (r <= max) {
            Row row = this.sheet.getRow(r);
            if (row == null) {
                r++;
            } else {
                Cell cell = row.getCell(c);
                if (cell != null) {
                    return r;
                } else {
                    r++;
                }
            }
        }
        return -1;
    }

    /**
     * Obtiene la siguiente columna no vacía según la posición actual.
     *
     * @param r fila actual.
     * @param c columna actual.
     * @return posición de la columna.
     */
    public int getSiguienteColumna(int r, int c) {
        Row row = this.sheet.getRow(r);
        int max = row.getLastCellNum();
        c++;
        while (c <= max) {
            Cell cell = row.getCell(c);
            if(cell == null) {
                c++;
            } else {
                return c;
            }
        }
        return -1;
    }
}
