import gestor.GestorArchivo_new;
import modelo.Coordenada;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.Buscador;
import util.Debug;
import util.Posicionador;

import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {
        Debug debug = Debug.getDebug();
        GestorArchivo_new gestor = new GestorArchivo_new();
        XSSFWorkbook libro = gestor.getLibros().get(0);

        int sheets = libro.getNumberOfSheets();
        for (int i = 0; i < sheets; i++) {
            XSSFSheet sheet = libro.getSheetAt(i);
            debug.write(sheet.getSheetName());

            Buscador buscador = new Buscador(sheet);
            Coordenada coordenada = buscador.buscar("Enseñanza:", 5);

            if (coordenada != null) {
                Posicionador posicionador = new Posicionador(sheet);
                int col = posicionador.getSiguienteColumna(coordenada.r, coordenada.c);

                XSSFCell cell = sheet.getRow(coordenada.r).getCell(col);
                debug.write("Coordenada: " + coordenada);
                debug.write("Col: " + col);
                debug.write(cell.toString());
            }
        }
    }
}
