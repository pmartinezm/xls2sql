import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Posicionador {
    private XSSFSheet sheet;

    public Posicionador(XSSFSheet sheet) {
        this.sheet = sheet;
    }

    public int getSiguienteFila(int r, int c){
        r++;
        while(this.sheet.getRow(r).getCell(c).toString().isBlank()) {
            r++;
        }
        //System.out.println("Siguiente fila: " + r);
        return r;
    }


    public int getSiguienteColumna(int r, int c) {
        c++;
        while(this.sheet.getRow(r).getCell(c).toString().isBlank()) {
            c++;
        }
        //System.out.println("Siguiente columna: " + c);
        return c;
    }
}
