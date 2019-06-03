import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import controller.Buscador;
import controller.Posicionador;
import gestor.GestorArchivo;
import modelo.Coordenada;
import util.Debug;
import util.GeneradorSQL;

public class main {

    public static void main(String[] args) throws IOException {
        Debug debug = Debug.getDebug();
        //debug.disable();
        GestorArchivo gestor = new GestorArchivo("C:\fichero.xls");
        XSSFWorkbook libro = gestor.getLibros().get(0);

        int sheets = libro.getNumberOfSheets();

        ArrayList<String> a = new ArrayList<>();
        for (int i = 0; i < sheets; i++) {
            XSSFSheet sheet = libro.getSheetAt(i);
            debug.write("Nombre de la hoja: " + sheet.getSheetName());

            Buscador buscador = new Buscador(sheet);
            Coordenada coordenada = buscador.buscar("Enseñanza:", 5);

            if (coordenada != null) {
                Posicionador posicionador = new Posicionador(sheet);
                int col = posicionador.getSiguienteColumna(coordenada.r, coordenada.c);

                XSSFCell cell = sheet.getRow(coordenada.r).getCell(col);
                debug.write("Coordenada: " + coordenada);
                debug.write("Col: " + col);
                debug.write("[r:c] " + coordenada.r + "-" + col);
                debug.write("Contenido de la celda: " + cell.toString());
                a.add(cell.toString());
            }
        }

        debug.writeIgnoreAnon("SQL: " + GeneradorSQL.insertarCurso(a));
    }
}
