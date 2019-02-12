import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) throws IOException {
        GestorArchivo gestor = new GestorArchivo();
        XSSFWorkbook libro = gestor.getLibro();

        //Obtener la primera hoja
        XSSFSheet sheet = libro.getSheetAt(0);

        //Ver el horario
        Buscador buscador = new Buscador(sheet);
        ArrayList<ArrayList<String>> horario = buscador.extraerHorario();
        for (ArrayList<String> dia :
                horario) {
            System.out.println(dia.size());
        }

        libro.close();
    }
}
