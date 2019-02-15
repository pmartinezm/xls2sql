import gestor.GestorArchivo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.Buscador;
import util.Posicionador;

import java.io.IOException;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) throws IOException {
        GestorArchivo gestor = new GestorArchivo("/home/pablo/Escritorio/archivoe.xlsx");
        XSSFWorkbook libro = gestor.getLibro();

        //Obtener la primera hoja
        XSSFSheet sheet = libro.getSheetAt(0);
        //System.out.println(libro.getNumberOfSheets());

        //Ver el horario
        Buscador buscador = new Buscador(sheet);
        //buscador.buscar("uno", 10);
        //buscador.buscar("dos", 10);
        //buscador.buscar("tres", 10);
//        Posicionador pos = new Posicionador(sheet);
//        int c = pos.getSiguienteColumna(2, 1);
//        Row row = sheet.getRow(2);
//        Cell cell = row.getCell(c);
//        System.out.println(cell);

        Posicionador pos = new Posicionador(sheet);

        System.out.println(pos.getSiguienteColumna(5, 0));
        //System.out.println(sheet.getRow(5).getCell(2));

        libro.close();
    }

    public static void main2(String[] args) throws IOException {
        GestorArchivo gestor = new GestorArchivo();
        XSSFWorkbook libro = gestor.getLibro();

        //Obtener la primera hoja
        XSSFSheet sheet = libro.getSheetAt(0);
        libro.getNumberOfSheets();

        //Ver el horario
        Buscador buscador = new Buscador(sheet);
        ArrayList<ArrayList<String>> horario = buscador.extraerHorario();
        for (ArrayList<String> dia :
                horario) {
            System.out.println(dia);
            System.out.println(dia.size());
        }

        System.out.println(buscador.buscarHorarioGrupo());

        libro.close();
    }
}
