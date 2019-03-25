package util;

import modelo.Coordenada;
import modelo.Horario;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.ArrayList;

public class Buscador {
    private XSSFSheet sheet;

    public Buscador(XSSFSheet sheet) {
        this.sheet = sheet;
    }

    /**
     * Busca el texto dentro de un rango.
     *
     * @param texto el texto a buscar.
     * @param rango el rango en el que se va a buscar.
     * @return las coordenadas de la coincidencia, null si no se ha encontrado.
     */
    public Coordenada buscar(String texto, int rango) {
        for (int c = 0; c < rango; c++) {
            for (int r = 0; r < rango; r++) {
                Row fila = this.sheet.getRow(r);
                if (fila != null) {
                    Cell celda = fila.getCell(c);
                    if (celda != null) {
                        String valor = celda.toString();

                        if (valor.equalsIgnoreCase(texto)) {
                            System.out.println("Encontrado en " + r + "-" + c);
                            return new Coordenada(r, c);
                        }
                    }
                }
            }
        }
        System.err.println("No se ha encontrado '" + texto + "'");
        return null;
    }

    public Horario extraerHorario() {
        Horario horario = new Horario();

        Coordenada posicionHorario = this.buscar("Tramo horario", 10);
        System.out.println("Inicio de horario encontrado en " + posicionHorario.toString());

        Posicionador posi = new Posicionador(this.sheet);

        int r = posicionHorario.r;
        int c = posicionHorario.c;

        for (int col = 0; col < 5; col++) {
            c = posicionHorario.c;
            c = posi.getSiguienteColumna(r, c);

            System.out.println(r + "-" + c);

            for (int fil = 0; fil < 6; fil++) {
                r = posi.getSiguienteFila(r, c);

                String valor = this.sheet.getRow(r).getCell(c).toString();
                System.out.print(valor + " ");
            }
            System.out.println();
        }

        return horario;
    }

    /**
     * Extrae un horario del xls.
     *
     * @return matriz con el horario por días.
     */
    public ArrayList<ArrayList<String>> extraerHorario2() {
        ArrayList<ArrayList<String>> horario = new ArrayList<>();

        //Buscar en la hoja
        Coordenada posHorario = this.buscar("Tramo horario", 15);

        //Posicionar el cursor
        Posicionador posicionador = new Posicionador(sheet);

        Coordenada actual = new Coordenada(posHorario.r, posHorario.c);
        int FILAS = 5, COLUMNAS = 6;
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

    public Coordenada buscarHorarioGrupo() {
        Coordenada coordenada = this.buscar("Tramo horario", 50);
        return coordenada;

    }
}
