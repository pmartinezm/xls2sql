import gestor.GestorArchivo;
import modelo.Horario;
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
        GestorArchivo gestor = new GestorArchivo("/home/pablo/Escritorio/Todos los horarios.xlsx");
        XSSFWorkbook libro = gestor.getLibro();

        XSSFSheet sheet = libro.getSheetAt(0);

        Buscador b = new Buscador(sheet);

        Horario horario = b.extraerHorario();



//        ArrayList<ArrayList<String>> horario = b.extraerHorario();
//
//        System.out.println("Dias:");
//        for (ArrayList<String> dia :
//                horario) {
//            for (String hora :
//                    dia) {
//                System.out.print(hora + "-");
//            }
//            System.out.println();
//        }

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
//        ArrayList<ArrayList<String>> horario = buscador.extraerHorario();
//
//        for (ArrayList<String> dia :
//                horario) {
//            System.out.println(dia);
//            System.out.println(dia.size());
//        }

        System.out.println(buscador.buscarHorarioGrupo());

        libro.close();
    }
}
