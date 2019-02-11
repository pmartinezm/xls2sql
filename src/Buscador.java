import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Buscador {
    private XSSFSheet sheet;

    public Buscador(XSSFSheet sheet) {
        this.sheet = sheet;
    }

    public Coordenada buscar(String texto, int rango) {
        for (int c = 0; c < rango; c++) {
            for (int r = 0; r < rango; r++) {
                Row fila = this.sheet.getRow(r);
                Cell celda = fila.getCell(c);
                String valor = celda.toString();

                if (valor.equalsIgnoreCase(texto)) {
                    System.out.println("Encontrado en " + r + ":" + c);
                    return new Coordenada(r, c);
                }
            }
        }
        System.err.println("No se ha encontrado '" + texto + "'");
        return null;
    }

    public ArrayList<ArrayList<String>> extraerHorario() {
        ArrayList<ArrayList<String>> horario = new ArrayList<>();

        //Buscar en la hoja
        Coordenada posHorario = new Buscador(sheet).buscar("tramo horario", 15);

        //Posicionar el cursor
        Posicionador posicionador = new Posicionador(sheet);

        Coordenada actual = new Coordenada(posHorario.r, posHorario.c);
        int FILAS = 6, COLUMNAS = 5;
        for (int c = 0; c < COLUMNAS; c++) {
            ArrayList<String> dia = new ArrayList<>();
            actual.c = posicionador.getSiguienteColumna(actual.r, actual.c);

            for (int r = 0; r < FILAS; r++) {
                actual.r = posicionador.getSiguienteFila(actual.r, actual.c);
                dia.add(this.sheet.getRow(actual.r).getCell(actual.c).toString());
            }

            horario.add(dia);
            actual.r = posHorario.r;
        }

        return horario;
    }
}
