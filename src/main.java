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
    }

    public static void main2(String[] args) throws Exception {
        File file = new File("/home/pablo/Escritorio/Copia_de_Horario_de_clase_por_grupos.xls");

        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);

            XSSFSheet sheet = wb.getSheetAt(0);

            int BUSCOL = 10;
            int BUSROW = 10;

            int horStartCol = -1, horStartRow = -1;

            for (int i = 0; i < BUSCOL; i++) {
                for (int j = 0; j < BUSROW; j++) {
                    Row row = sheet.getRow(j);
                    Cell col = row.getCell(i);
                    if (col.toString().equalsIgnoreCase("tramo horario")) {
                        horStartCol = i;
                        horStartRow = j;
                        break;
                    }
                }
            }

            System.out.println(horStartCol + " : " + horStartRow);

            ArrayList<ArrayList<String>> horario = new ArrayList<>();

            int rc = 0, cc = 0;
            for (int c = 1; cc < 5; ) {
                while (sheet.getRow(horStartRow + 1).getCell(c).toString().isBlank()) {
                    System.out.println("Empty column. Skipping...");
                    c++;
                }
                horario.add(new ArrayList<>());
                for (int r = 1; rc < 6; ) {
                    while (sheet.getRow(horStartRow + r).getCell(horStartCol + c).toString().isBlank()) {
                        System.out.println("Empty row. Skipping...");
                        r++;
                    }
                    System.out.println(c + ":" + cc + " - " + r + ":" + rc);
                    Row row = sheet.getRow(r + horStartRow);
                    Cell cell = row.getCell(c + horStartCol);
                    horario.get(cc).add(cell.toString());
                    rc++;
                }
                cc++;
            }

            for (ArrayList dia :
                    horario) {
                System.out.println(dia);
            }

            wb.close();
            fis.close();

        } else {
            System.err.println("El archivo no existe.");
        }
    }
}
