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
        r++;
        while (this.sheet.getRow(r).getCell(c).toString().isBlank()) {
            r++;
        }
        return r;
    }

    /**
     * Obtiene la siguiente columna no vacía según la posición actual.
     *
     * @param r fila actual.
     * @param c columna actual.
     * @return posición de la columna.
     */
    public int getSiguienteColumna(int r, int c) {
        c++;
        while (this.sheet.getRow(r).getCell(c).toString().isBlank()) {
            c++;
        }
        return c;
    }
}
